package loginandsignup;

import java.sql.*;
import javax.swing.JOptionPane;

public class StudentSignupHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms";
    private static final String USER = "root";
    private static final String PASS = "";

    public static boolean createStudentAccount(String fullName, String email, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // First check if this student already exists in the students table
            String checkStudentQuery = "SELECT * FROM students WHERE CONCAT(student_firstname, ' ', student_lastname) = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkStudentQuery)) {
                checkStmt.setString(1, fullName);
                ResultSet rs = checkStmt.executeQuery();
                
                // Start transaction
                conn.setAutoCommit(false);
                try {
                    // Create the student account
                    String insertAccountQuery = "INSERT INTO student_accounts (full_name, email, password) VALUES (?, ?, ?)";
                    PreparedStatement accountStmt = conn.prepareStatement(insertAccountQuery, Statement.RETURN_GENERATED_KEYS);
                    accountStmt.setString(1, fullName);
                    accountStmt.setString(2, email);
                    accountStmt.setString(3, password);
                    accountStmt.executeUpdate();
                    
                    // Get the generated account ID
                    ResultSet generatedKeys = accountStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int accountId = generatedKeys.getInt(1);
                        
                        // If student record exists, update it with the account ID
                        if (rs.next()) {
                            String updateStudentQuery = "UPDATE students SET student_account_id = ? WHERE student_id = ?";
                            PreparedStatement updateStmt = conn.prepareStatement(updateStudentQuery);
                            updateStmt.setInt(1, accountId);
                            updateStmt.setInt(2, rs.getInt("student_id"));
                            updateStmt.executeUpdate();
                            
                            JOptionPane.showMessageDialog(null, 
                                "Account created and linked to existing student record!", 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            // No existing student record - that's okay, teacher will create it later
                            JOptionPane.showMessageDialog(null, 
                                "Account created! Please wait for a teacher to add you to a class.", 
                                "Success", 
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    
                    conn.commit();
                    return true;
                    
                } catch (SQLException e) {
                    conn.rollback();
                    throw e;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Error creating account: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public static void linkStudentToAccount(int studentId, String fullName) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Find matching student account
            String findAccountQuery = "SELECT student_account_id FROM student_accounts WHERE full_name = ?";
            PreparedStatement findStmt = conn.prepareStatement(findAccountQuery);
            findStmt.setString(1, fullName);
            ResultSet rs = findStmt.executeQuery();
            
            if (rs.next()) {
                // Update student record with account ID
                String updateQuery = "UPDATE students SET student_account_id = ? WHERE student_id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setInt(1, rs.getInt("student_account_id"));
                updateStmt.setInt(2, studentId);
                updateStmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, 
                    "Student record linked to existing account!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                "Error linking student to account: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
