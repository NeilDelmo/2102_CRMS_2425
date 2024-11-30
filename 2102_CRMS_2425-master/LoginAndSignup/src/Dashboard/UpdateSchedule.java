/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import app.bolivia.swing.JCTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author john Emjay
 */
public class UpdateSchedule extends javax.swing.JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Teach teachFrame;
    private int loggedInteachers_id;
    private int selectedClassId;
    private int selectedScheduleId;
    private java.util.Map<String, Integer> roomNameToIdMap = new java.util.HashMap<>();


  public UpdateSchedule(int teacherId, Teach teachFrame, int classId, int scheduleId) {
        this.loggedInteachers_id = teacherId;
        this.teachFrame = teachFrame;
        this.selectedClassId = classId;
        this.selectedScheduleId = scheduleId;
        initComponents();
        setupRoomComboBox();
        populateRoomComboBox();
        populateFields();
    }

    private void setupRoomComboBox() {
        roomComboBox = new javax.swing.JComboBox<>();
        roomComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14));
        roomComboBox.setBorder(javax.swing.BorderFactory.createTitledBorder(
            new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true),
            "Room",
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
            javax.swing.border.TitledBorder.TOP,
            new java.awt.Font("Segoe UI", 2, 14)
        ));
        
        // Add the combo box to your form's panel
        jPanel1.add(roomComboBox);
        roomComboBox.setBounds(10, 200, 467, 50); // Set explicit bounds
    }

    private void populateRoomComboBox() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT room_id, room_name FROM rooms";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    roomNameToIdMap.clear();
                    roomComboBox.removeAllItems();

                    while (rs.next()) {
                        String roomName = rs.getString("room_name");
                        int roomId = rs.getInt("room_id");
                        roomComboBox.addItem(roomName);
                        roomNameToIdMap.put(roomName, roomId);
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading rooms: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateFields() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT s.day_of_week, s.start_time, s.end_time, r.room_name " +
                          "FROM schedules s " +
                          "INNER JOIN rooms r ON s.room_id = r.room_id " +
                          "WHERE s.schedule_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, selectedScheduleId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        jComboBox1.setSelectedItem(rs.getString("day_of_week"));
                        Subject1.setText(new SimpleDateFormat("HH:mm").format(rs.getTime("start_time")));
                        Subject2.setText(new SimpleDateFormat("HH:mm").format(rs.getTime("end_time")));
                        roomComboBox.setSelectedItem(rs.getString("room_name"));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading schedule: " + ex.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private String getRoomNameById(int roomId) throws SQLException {
        String roomName = null;
        String query = "SELECT room_name FROM rooms WHERE room_id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                roomName = rs.getString("room_name");
            }
        }
        
        return roomName;
    }

        
        // In the layout, replace Section with classComboBox
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CreateButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        Subject1 = new app.bolivia.swing.JCTextField();
        Subject2 = new app.bolivia.swing.JCTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Schedule");

        CreateButton.setText("Create");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        Subject1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Start of Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        Subject2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "End of Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subject1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Subject2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CancelButton)
                .addGap(34, 34, 34)
                .addComponent(CreateButton)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Subject1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Subject2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(CreateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        System.out.println("Updating schedule with ID: " + selectedScheduleId);
        if (!validateInputs()) {
            return;
        }

        try {
            String selectedRoom = (String) roomComboBox.getSelectedItem();
            if (selectedRoom == null || !roomNameToIdMap.containsKey(selectedRoom)) {
                JOptionPane.showMessageDialog(this, "Please select a valid room.");
                return;
            }

            int roomId = roomNameToIdMap.get(selectedRoom);
            String dayOfWeek = (String) jComboBox1.getSelectedItem();
            Time startTime = parseTime(Subject1.getText().trim());
            Time endTime = parseTime(Subject2.getText().trim());

            // Check for schedule conflicts
            if (hasScheduleConflict(roomId, dayOfWeek, startTime, endTime)) {
                JOptionPane.showMessageDialog(this, "Schedule conflict detected. Please choose a different time or room.");
                return;
            }

            // Update the schedule
            String updateQuery = "UPDATE schedules SET day_of_week = ?, start_time = ?, end_time = ?, room_id = ? " +
                    "WHERE schedule_id = ? AND class_id = ?";
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                
                pstmt.setString(1, dayOfWeek);
                pstmt.setTime(2, startTime);
                pstmt.setTime(3, endTime);
                pstmt.setInt(4, roomId);
                pstmt.setInt(5, selectedScheduleId);
                pstmt.setInt(6, selectedClassId);  // Add the missing class_id parameter

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Schedule updated successfully!");
                    teachFrame.loadClassData(); // Refresh the parent frame's table
                    this.dispose(); // Close the update window
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update schedule.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_CreateButtonActionPerformed

    private boolean validateInputs() {
        if (roomComboBox.getSelectedItem() == null || 
            Subject1.getText().trim().isEmpty() || 
            Subject2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private Time parseTime(String timeStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            java.util.Date date = sdf.parse(timeStr);
            return new Time(date.getTime());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:mm format (e.g., 14:30)");
        }
    }

    private boolean hasScheduleConflict(int roomId, String dayOfWeek, Time startTime, Time endTime) throws SQLException {
        String query = "SELECT 1 FROM schedules WHERE room_id = ? AND day_of_week = ? " +
                      "AND schedule_id != ? " +  // Exclude current schedule
                      "AND ((? BETWEEN start_time AND end_time) OR " +  // New start time falls within existing schedule
                      "(? BETWEEN start_time AND end_time) OR " +      // New end time falls within existing schedule
                      "(start_time BETWEEN ? AND ?))";                 // Existing schedule falls within new time range

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, roomId);
            pstmt.setString(2, dayOfWeek);
            pstmt.setInt(3, selectedScheduleId);
            pstmt.setTime(4, startTime);
            pstmt.setTime(5, endTime);
            pstmt.setTime(6, startTime);
            pstmt.setTime(7, endTime);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Returns true if there's a conflict
            }
        }
    }
    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       SwingUtilities.invokeLater(() -> {
    UpdateSchedule frame = new UpdateSchedule(1, new Teach(), 1, 1); // Pass the required parameters
    frame.setVisible(true);
});
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private app.bolivia.swing.JCTextField Subject1;
    private app.bolivia.swing.JCTextField Subject2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> roomComboBox;
    // End of variables declaration//GEN-END:variables
}
