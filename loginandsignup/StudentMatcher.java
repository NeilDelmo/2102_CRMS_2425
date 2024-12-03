package loginandsignup;

import java.sql.*;

public class StudentMatcher {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms";
    private static final String USER = "root";
    private static final String PASS = "";

    // Check if a student account has a matching student record
    public static boolean hasMatchingStudent(String fullName) {
        String query = "SELECT * FROM unmatched_students WHERE full_name = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, fullName);
            ResultSet rs = pstmt.executeQuery();
            
            // If there's no record in unmatched_students, it means they're matched
            return !rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all unmatched students in a specific section
    public static ResultSet getUnmatchedInSection(String sectionCode) {
        String query = "SELECT * FROM unmatched_students WHERE section_code = ?";
        
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, sectionCode);
            return pstmt.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Display unmatched students (example usage)
    public static void displayUnmatchedStudents() {
        String query = "SELECT * FROM unmatched_students";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                System.out.println("Student: " + 
                    rs.getString("student_firstname") + " " + 
                    rs.getString("student_lastname") + 
                    ", Section: " + rs.getString("section_code") +
                    (rs.getString("email") != null ? 
                        ", Email: " + rs.getString("email") : 
                        ", No account yet"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
