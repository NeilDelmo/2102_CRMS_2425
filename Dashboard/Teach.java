package Dashboard;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import loginandsignup.Login;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Teach extends javax.swing.JFrame {
     private static Teach instance; // The single instance
     private static int loggedInteachers_id;
    private int classId; // Store the class ID
    private JTable scheduleTable;
    private JComboBox<String> dayFilterComboBox;

    
    public Teach(int teacherId) {
    this.loggedInteachers_id = teacherId;
    initComponents();
    setupDayFilter();  // Add this line
    loadClassData();
    scheduleTable = new JTable(new DefaultTableModel(
        new Object[]{"Day", "Subject", "Class Name", "Start Time", "End Time", "Room"}, 0
    ));
}
    
    public static void setTeacherId(int teacherId) {
    loggedInteachers_id = teacherId;
}

public static int getTeacherId() {
    return loggedInteachers_id;
}
     public Teach() {
    initComponents();
    this.setExtendedState(Teach.MAXIMIZED_BOTH); 
    setupDayFilter();
    loadClassData();
}
     void loadClassData() {
        // Logic to load data into ClassTable based on the classId
    DefaultTableModel model = (DefaultTableModel) ClassTable.getModel();
    model.setRowCount(0); // Clear existing data

    String selectedDay = (String) dayFilterComboBox.getSelectedItem();
    
    String query = "SELECT s.schedule_id, s.day_of_week, c.subject, c.class_name, s.start_time, s.end_time, r.room_name "
    + "FROM schedules s "
    + "INNER JOIN classes c ON s.class_id = c.class_id "
    + "INNER JOIN rooms r ON s.room_id = r.room_id "
    + "WHERE c.teachers_id = ? ";

// Add day filter if needed
if (!"All Days".equals(selectedDay)) {
    query += "AND s.day_of_week = ? ";
}

// Add ordering
query += "ORDER BY CASE s.day_of_week "
    + "WHEN 'Monday' THEN 1 "
    + "WHEN 'Tuesday' THEN 2 "
    + "WHEN 'Wednesday' THEN 3 "
    + "WHEN 'Thursday' THEN 4 "
    + "WHEN 'Friday' THEN 5 "
    + "WHEN 'Saturday' THEN 6 "
    + "WHEN 'Sunday' THEN 7 "
    + "END, s.start_time";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
         PreparedStatement pstmt = conn.prepareStatement(query)) {
   
        pstmt.setInt(1, loggedInteachers_id);
        if (!"All Days".equals(selectedDay)) {
            pstmt.setString(2, selectedDay);
        }

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("day_of_week"),
                rs.getString("subject"),
                rs.getString("class_name"),
                rs.getTime("start_time"),
                rs.getTime("end_time"),
                rs.getString("room_name")
            });
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, 
            "Error loading schedule data: " + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE);
    }
    }
      public static Teach getInstance(int teacherId) {
    if (instance == null) {
        instance = new Teach(teacherId);
    }
    return instance;
}
    public void updateClass(int classId) {
    this.classId = classId;
    // Update the UI or perform any other necessary actions
}
   
    public int getClassId() {
    return classId;
}

public void setClassId(int classId) {
    this.classId = classId;
    loadClassData(); // Automatically load data when classId is set
}
     public void updateScheduleInTable(String dayOfWeek, String subject, String className, Time startTime, Time endTime, String roomName, int scheduleId) {
        // Logic to update the schedule in the table
        // For example, find the row with the given scheduleId and update its values.
        
        // Assuming you have a JTable named scheduleTable
        DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            // Assuming the first column contains the scheduleId
            if ((int) model.getValueAt(i, 0) == scheduleId) {
                model.setValueAt(dayOfWeek, i, 1); // Update day of week
                model.setValueAt(subject, i, 2); // Update subject
                model.setValueAt(className, i, 3); // Update class name
                model.setValueAt(startTime, i, 4); // Update start time
                model.setValueAt(endTime, i, 5); // Update end time
                model.setValueAt(roomName, i, 6); // Update room name
                break;
            }
            
            
        }
    }
     
     private int getSelectedScheduleId() {
    int selectedRow = ClassTable.getSelectedRow();
    if (selectedRow != -1) {
        // Get the data from the selected row
        // Since your table doesn't have a schedule ID column visible,
        // you'll need to either:
        // 1. Add a hidden column for schedule ID, or
        // 2. Query the database using the visible data to get the schedule ID
        
        // For now, let's query the database using the visible data
        String day = (String) ClassTable.getValueAt(selectedRow, 0);
        String subject = (String) ClassTable.getValueAt(selectedRow, 1);
        String className = (String) ClassTable.getValueAt(selectedRow, 2);
        String startTime = (String) ClassTable.getValueAt(selectedRow, 3);
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "")) {
            String query = "SELECT s.schedule_id FROM schedules s " +
                          "INNER JOIN classes c ON s.class_id = c.class_id " +
                          "WHERE s.day_of_week = ? " +
                          "AND c.subject = ? " +
                          "AND c.class_name = ? " +
                          "AND s.start_time = ?";
                          
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, day);
            pstmt.setString(2, subject);
            pstmt.setString(3, className);
            pstmt.setString(4, startTime);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("schedule_id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving schedule ID: " + e.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
    return -1;
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Teach = new rojeru_san.complementos.RSButtonHover();
        btnAddClass_Teach = new rojeru_san.complementos.RSButtonHover();
        jButton1 = new javax.swing.JButton();
        btnUpdateclass_Home = new rojeru_san.complementos.RSButtonHover();
        btnRemoveClass_Home = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Teach = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Teach = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classlogo.png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnMenu_Teach.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Teach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        btnMenu_Teach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_TeachActionPerformed(evt);
            }
        });

        btnAddClass_Teach.setBackground(new java.awt.Color(0, 102, 102));
        btnAddClass_Teach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnAddClass_Teach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClass_TeachActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnUpdateclass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdateclass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        btnUpdateclass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateclass_HomeActionPerformed(evt);
            }
        });

        btnRemoveClass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnRemoveClass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        btnRemoveClass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveClass_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(64, 64, 64)
                .addComponent(btnRemoveClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateclass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddClass_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateclass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClass_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRemoveClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Teach.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Teach.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Teach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome_Teach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_TeachActionPerformed(evt);
            }
        });

        btnLogout_Teach.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout_Teach.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout_Teach.setText("Logout");
        btnLogout_Teach.setColorHover(new java.awt.Color(204, 204, 204));
        btnLogout_Teach.setColorText(new java.awt.Color(0, 0, 0));
        btnLogout_Teach.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnLogout_Teach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout_Teach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout_TeachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome_Teach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnLogout_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnHome_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout_Teach, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClassTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Day          ", "Subject", "Class Name", "Start Time", "End Time", "Room"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ClassTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ClassTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome_TeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_TeachActionPerformed
        Home homeFrame = new Home();
        homeFrame.setExtendedState(Home.MAXIMIZED_BOTH); // Set full screen
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome_TeachActionPerformed

    private void btnAddClass_TeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClass_TeachActionPerformed
     AddSchedule addScheduleFrame = new AddSchedule(loggedInteachers_id, this, classId, this);
    addScheduleFrame.setVisible(true);
    
        
    }//GEN-LAST:event_btnAddClass_TeachActionPerformed

   public void addScheduleToTable(String dayOfWeek, String subject, String className, Time startTime, Time endTime, String roomName) {
    // Assuming you have a JTable named scheduleTable
    DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
    model.addRow(new Object[]{dayOfWeek, subject, className, startTime, endTime, roomName});
}
    private void btnMenu_TeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_TeachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_TeachActionPerformed

    private void btnLogout_TeachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout_TeachActionPerformed
        // TODO add your handling code here:                                    
             int response = JOptionPane.showConfirmDialog(
                       this, 
                       "Do you really want to log out?", 
                       "Confirm Logout", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.QUESTION_MESSAGE
             );
    
              if (response == JOptionPane.YES_OPTION) {
                    // User chose to log out
                        Login l = new Login();
                        l.setVisible(true);
                        this.dispose();
               } else {

    }

    }//GEN-LAST:event_btnLogout_TeachActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadClassData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdateclass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateclass_HomeActionPerformed
   int selectedScheduleId = getSelectedScheduleId(); // Get the selected schedule ID
    System.out.println("Selected Schedule ID: " + selectedScheduleId); // Debugging line
    if (selectedScheduleId != -1) { // Check if a valid schedule ID is selected
        // Ensure classId is set correctly
        if (classId == 0) {
            JOptionPane.showMessageDialog(this, "Class ID is not set. Please select a class first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        UpdateSchedule updateScheduleFrame = new UpdateSchedule(loggedInteachers_id, this, classId, selectedScheduleId);
        updateScheduleFrame.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a schedule to update.", "Selection Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateclass_HomeActionPerformed

    private void btnRemoveClass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveClass_HomeActionPerformed
       int selectedScheduleId = getSelectedScheduleId(); // Get the selected schedule ID
    System.out.println("Selected Schedule ID for deletion: " + selectedScheduleId); // Debugging line

    if (selectedScheduleId != -1) { // Check if a valid schedule ID is selected
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this schedule?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deleteSchedule(selectedScheduleId); // Call the delete method
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a schedule to delete.", "Selection Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRemoveClass_HomeActionPerformed

    private void setupDayFilter() {
    String[] days = {"All Days", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    dayFilterComboBox = new JComboBox<>(days);
    dayFilterComboBox.setPreferredSize(new java.awt.Dimension(150, 25));
    
    jPanel1.add(dayFilterComboBox);
    dayFilterComboBox.setBounds(30, 15, 150, 25);
    
    dayFilterComboBox.addActionListener(e -> loadClassData());
}
    private void deleteSchedule(int scheduleId) {
    String sql = "DELETE FROM schedules WHERE schedule_id = ?";
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, scheduleId);
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Schedule deleted successfully.");
            loadClassData(); // Refresh the table data
        } else {
            JOptionPane.showMessageDialog(this, "No schedule found with the given ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error deleting schedule: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}
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
            java.util.logging.Logger.getLogger(Teach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClassTable;
    private rojeru_san.complementos.RSButtonHover btnAddClass_Teach;
    private rojeru_san.complementos.RSButtonHover btnHome_Teach;
    private rojeru_san.complementos.RSButtonHover btnLogout_Teach;
    private rojeru_san.complementos.RSButtonHover btnMenu_Teach;
    private rojeru_san.complementos.RSButtonHover btnRemoveClass_Home;
    private rojeru_san.complementos.RSButtonHover btnUpdateclass_Home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
