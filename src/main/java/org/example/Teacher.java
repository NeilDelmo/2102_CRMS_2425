package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teacher extends User {
    private String userName;

    public Teacher(int userID, String email, String password, String userName) {
        super(userID, email, password);
        this.userName = userName;
    }

    public Teacher(String email, String password, String userName) {
        super(email, password);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    // Save Teacher to Database
    public void saveTeacherToDatabase() {
        String sql = "INSERT INTO teachers(email, password, userName) VALUES(?, ?, ?)";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, getEmail());
            pstmt.setString(2, getPassword());
            pstmt.setString(3, userName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}