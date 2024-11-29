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
public class AddSchedule extends javax.swing.JFrame {
      private static final String DB_URL = "jdbc:mysql://localhost:3306/crms";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private int loggedInteachers_id;
    private int selectedClassId;
    private JFrame homeFrame;
    private Teach teachFrame; // Reference to the Teach frame

    // New combo box for class selection
    private javax.swing.JComboBox<String> classComboBox;
    private java.util.Map<String, Integer> classNameToIdMap = new java.util.HashMap<>();

    public AddSchedule(int teacherId, JFrame homeFrame, int selectedClassId, Teach teachFrame) {
    this();  // This calls initComponents()
    this.loggedInteachers_id = teacherId;
    this.homeFrame = homeFrame;
    this.selectedClassId = selectedClassId;
    this.teachFrame = teachFrame;
    SwingUtilities.invokeLater(() -> {  // Ensure UI is ready
        populateClassComboBox();
    });
}

    public AddSchedule() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setupKeyNavigation();
    }

    private void setupKeyNavigation() {
        // Set up focus traversal using Enter key
        Subject1.addActionListener(evt -> Subject2.requestFocus());
        Subject2.addActionListener(evt -> Room.requestFocus());
        Room.addActionListener(evt -> jComboBox1.requestFocus());
        
        // Add action listener for Cancel button
        CancelButton.addActionListener(evt -> dispose());
        
        // Add action listener for Create button
        CreateButton.addActionListener(evt -> CreateButtonActionPerformed(null));

        // Set default button (responds to Enter key when form has focus)
        getRootPane().setDefaultButton(CreateButton);

        // Add ESC key listener to close the window
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });
        
        // Make sure the frame can receive key events
        setFocusable(true);
    }

    private void populateClassComboBox() {
     try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT class_id, class_name FROM classes WHERE teachers_id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, loggedInteachers_id);

                try (ResultSet rs = pstmt.executeQuery()) {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    classNameToIdMap.clear();

                    while (rs.next()) {
                        String className = rs.getString("class_name");
                        int classId = rs.getInt("class_id");
                        model.addElement(className);
                        classNameToIdMap.put(className, classId);
                    }

                    classComboBox.setModel(model);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
     private String getSubjectByClassId(int classId) throws SQLException {
        String subject = null;
        String query = "SELECT subject FROM classes WHERE class_id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                subject = rs.getString("subject");
            }
        }
        
        return subject;
    }
     
     private String getClassNameById(int classId) throws SQLException {
        String className = null;
        String query = "SELECT class_name FROM classes WHERE class_id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                className = rs.getString("class_name");
            }
        }
        
        return className;
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
        Room = new app.bolivia.swing.JCTextField();
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

        Room.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Room", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

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
                            .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    Integer selectedClassId = this.selectedClassId; // Already passed to the constructor

    String roomText = Room.getText().trim();
    String startTimeText = Subject1.getText().trim();
    String endTimeText = Subject2.getText().trim();
    String dayOfWeek = (String) jComboBox1.getSelectedItem();

    // Validate inputs
    if (roomText.isEmpty() || startTimeText.isEmpty() || endTimeText.isEmpty() || dayOfWeek == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convert room text to room_id
    int roomId;
    try {
        roomId = getRoomId(roomText);
        if (roomId == -1) {
            JOptionPane.showMessageDialog(this, "Invalid room specified.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error validating room: " +
                ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validate and parse time format
    Time startTime, endTime;
    try {
        startTime = validateAndParseTime(startTimeText);
        endTime = validateAndParseTime(endTimeText);

        if (startTime.after(endTime)) {
            JOptionPane.showMessageDialog(this, "Start time must be before end time.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Invalid time format. Please use HH:mm format (e.g., 09:30)",
                "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check for schedule conflicts
    if (hasScheduleConflict(roomId, dayOfWeek, startTime, endTime)) {
        JOptionPane.showMessageDialog(this, "Schedule conflict detected. Please choose a different time.",
                "Conflict Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Insert the schedule
    String insertSQL = "INSERT INTO schedules (class_id, room_id, day_of_week, start_time, end_time) " +
            "VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

        pstmt.setInt(1, selectedClassId);
        pstmt.setInt(2, roomId);
        pstmt.setString(3, dayOfWeek);
        pstmt.setTime(4, startTime);
        pstmt.setTime(5, endTime);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Schedule added successfully!");

            // Retrieve the subject and class name for the newly added schedule
            String subject = getSubjectByClassId(selectedClassId);
            String className = getClassNameById(selectedClassId);
            String roomName = getRoomNameById(roomId);

            // Update the ClassTable in the Teach class
            teachFrame.addScheduleToTable(dayOfWeek, subject, className, startTime, endTime, roomName);

            // // Clear the fields
            Room.setText("");
            Subject1.setText("");
            Subject2.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add schedule.",
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error adding schedule: " +
                ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_CreateButtonActionPerformed

    private Time validateAndParseTime(String timeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        java.util.Date date = sdf.parse(timeStr);
        return new Time(date.getTime());
    }
    private int getRoomId(String roomText) throws SQLException {
       String query = "SELECT room_id FROM rooms WHERE room_name = ? OR room_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, roomText);
            try {
                pstmt.setInt(2, Integer.parseInt(roomText));
            } catch (NumberFormatException e) {
                pstmt.setInt(2, -1);
            }

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("room_id");
            }
        }
        return -1;
    }

    private boolean hasScheduleConflict(int roomId, String dayOfWeek, Time startTime, Time endTime) {
        String query = "SELECT 1 FROM schedules WHERE room_id = ? AND day_of_week = ? " +
                "AND ((start_time < ? AND end_time > ?) OR (start_time < ? AND end_time > ?))";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, roomId);
            pstmt.setString(2, dayOfWeek);
            pstmt.setTime(3, endTime);
            pstmt.setTime(4, startTime);
            pstmt.setTime(5, endTime);
            pstmt.setTime(6, startTime);

            ResultSet rs = pstmt.executeQuery();
            return rs.next();  // Returns true if there's a conflict
        } catch (SQLException ex) {
            ex.printStackTrace();
            return true;  // Assume conflict in case of error
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
            java.util.logging.Logger.getLogger(AddSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private app.bolivia.swing.JCTextField Room;
    private app.bolivia.swing.JCTextField Subject1;
    private app.bolivia.swing.JCTextField Subject2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
