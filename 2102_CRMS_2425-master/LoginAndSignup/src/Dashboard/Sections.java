package Dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loginandsignup.Login;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.sql.PreparedStatement;


public class Sections extends javax.swing.JFrame {
    private JComboBox<String> sectionFilterComboBox;
    
    public void setupSectionFilter() {
    sectionFilterComboBox = new JComboBox<>();
    sectionFilterComboBox.addItem("All Sections");
    
    // Load section codes
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT DISTINCT section_code FROM sections ORDER BY section_code")) {
        
        while (rs.next()) {
            sectionFilterComboBox.addItem(rs.getString("section_code"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    jPanel1.add(sectionFilterComboBox);
    sectionFilterComboBox.setBounds(30, 15, 150, 25);
    sectionFilterComboBox.addActionListener(e -> LoadSections());
}

    public Sections() {
    initComponents();
    this.setExtendedState(Sections.MAXIMIZED_BOTH);
    setupSectionFilter();  // Add this line
    LoadSections();
}
    
    
public void LoadSections() { 
   DefaultTableModel model = (DefaultTableModel) Sections_Table.getModel();
   model.setRowCount(0);

   String selectedSection = (String) sectionFilterComboBox.getSelectedItem();
   String query = "SELECT s.section_name, s.section_code, COUNT(st.student_id) AS student_count " +
               "FROM sections s " +
               "LEFT JOIN students st ON st.section_id = s.section_id " +
               (!"All Sections".equals(selectedSection) ? "WHERE s.section_code = ? " : "") +
               "GROUP BY s.section_name, s.section_code " +
               "ORDER BY s.section_code";

   try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
        PreparedStatement pstmt = con.prepareStatement(query)) {
       
       if (!"All Sections".equals(selectedSection)) {
           // Assuming section_code is an integer, parse it from the selectedSection
           int sectionCode = Integer.parseInt(selectedSection);
           pstmt.setInt(1, sectionCode); // Use setInt for section_code
       }
       
       ResultSet rs = pstmt.executeQuery();
       while (rs.next()) {
           model.addRow(new Object[]{
               rs.getString("section_name"),
               rs.getInt("section_code"), // Assuming section_code is an int in the database
               rs.getInt("student_count")
           });
       }
   } catch (SQLException e) {
       e.printStackTrace();
       JOptionPane.showMessageDialog(this, "Error loading Sections: " + e.getMessage(),
               "Error", JOptionPane.ERROR_MESSAGE);
   } catch (NumberFormatException e) {
       e.printStackTrace();
       JOptionPane.showMessageDialog(this, "Invalid section code format: " + e.getMessage(),
               "Error", JOptionPane.ERROR_MESSAGE);
   }
}

// Method to count the number of students in a specific section
public int countStudentsInSection(int section_code) {
   String URL = "jdbc:mysql://localhost:3306/crms"; 
    String USER = "root"; 
    String PASS = ""; 
    int studentCount = 0;

    String query = "SELECT COUNT(students_id) AS student_count FROM students WHERE section_code = ?"; // Ensure consistency

    try (Connection con = DriverManager.getConnection(URL, USER, PASS);
         PreparedStatement pstmt = con.prepareStatement(query)) {
        
        pstmt.setInt(1, section_code); // Use setInt for section_code
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                studentCount = rs.getInt("student_count");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return studentCount;
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Subjects = new rojeru_san.complementos.RSButtonHover();
        btnAddSections_Sections = new rojeru_san.complementos.RSButtonHover();
        btnRemoveSection_Sections = new rojeru_san.complementos.RSButtonHover();
        updatesection = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Subjects = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Subjects = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Subjects = new rojeru_san.complementos.RSButtonHover();
        btnSections_Sections = new rojeru_san.complementos.RSButtonHover();
        btnRooms_Sections = new rojeru_san.complementos.RSButtonHover();
        btnClasswork_Subjects = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sections_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classlogo.png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnMenu_Subjects.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Subjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        btnMenu_Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_SubjectsActionPerformed(evt);
            }
        });

        btnAddSections_Sections.setBackground(new java.awt.Color(0, 102, 102));
        btnAddSections_Sections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnAddSections_Sections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSections_SectionsActionPerformed(evt);
            }
        });

        btnRemoveSection_Sections.setBackground(new java.awt.Color(0, 102, 102));
        btnRemoveSection_Sections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        btnRemoveSection_Sections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSection_SectionsActionPerformed(evt);
            }
        });

        updatesection.setBackground(new java.awt.Color(0, 102, 102));
        updatesection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        updatesection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatesectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoveSection_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(updatesection, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddSections_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatesection, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveSection_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddSections_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Subjects.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Subjects.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Subjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome_Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_SubjectsActionPerformed(evt);
            }
        });

        btnLogout_Subjects.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout_Subjects.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout_Subjects.setText("Logout");
        btnLogout_Subjects.setColorHover(new java.awt.Color(204, 204, 204));
        btnLogout_Subjects.setColorText(new java.awt.Color(0, 0, 0));
        btnLogout_Subjects.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnLogout_Subjects.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout_Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout_SubjectsActionPerformed(evt);
            }
        });

        btnStudents_Subjects.setBackground(new java.awt.Color(255, 255, 255));
        btnStudents_Subjects.setForeground(new java.awt.Color(0, 0, 0));
        btnStudents_Subjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Students.png"))); // NOI18N
        btnStudents_Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudents_SubjectsActionPerformed(evt);
            }
        });

        btnSections_Sections.setBackground(new java.awt.Color(255, 255, 255));
        btnSections_Sections.setForeground(new java.awt.Color(0, 0, 0));
        btnSections_Sections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/section.png"))); // NOI18N
        btnSections_Sections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSections_SectionsActionPerformed(evt);
            }
        });

        btnRooms_Sections.setBackground(new java.awt.Color(255, 255, 255));
        btnRooms_Sections.setForeground(new java.awt.Color(0, 0, 0));
        btnRooms_Sections.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/classroom.png"))); // NOI18N
        btnRooms_Sections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRooms_SectionsActionPerformed(evt);
            }
        });

        btnClasswork_Subjects.setBackground(new java.awt.Color(255, 255, 255));
        btnClasswork_Subjects.setForeground(new java.awt.Color(0, 0, 0));
        btnClasswork_Subjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classwork.png"))); // NOI18N
        btnClasswork_Subjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasswork_SubjectsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome_Subjects, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnLogout_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStudents_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSections_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRooms_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnClasswork_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnHome_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnClasswork_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudents_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSections_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRooms_Sections, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout_Subjects, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Sections_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Program", "Section_Code", "Student_Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Sections_Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSections_SectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSections_SectionsActionPerformed
        // TODO add your handling code here:
         AddSection addsectionFrame = new AddSection();
         addsectionFrame.setVisible(true);
    }//GEN-LAST:event_btnAddSections_SectionsActionPerformed

    private void btnMenu_SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_SubjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_SubjectsActionPerformed

    private void btnLogout_SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout_SubjectsActionPerformed
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

    }//GEN-LAST:event_btnLogout_SubjectsActionPerformed

    private void btnStudents_SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudents_SubjectsActionPerformed
        Students studentsFrame = new Students();
         studentsFrame.setExtendedState(Students.MAXIMIZED_BOTH); // Set full screen
         studentsFrame.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnStudents_SubjectsActionPerformed

    private void btnSections_SectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSections_SectionsActionPerformed
         JOptionPane.showMessageDialog(new JFrame(), "You are already in the Sections window.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSections_SectionsActionPerformed

    private void btnRemoveSection_SectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSection_SectionsActionPerformed
        // TODO add your handling code here:\
        RemoveSection removesectionFrame  = new RemoveSection();
        removesectionFrame.setVisible(true);
    }//GEN-LAST:event_btnRemoveSection_SectionsActionPerformed

    private void btnRooms_SectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRooms_SectionsActionPerformed
        // TODO add your handling code here:
        Rooms roomsFrame = new Rooms();
        roomsFrame.setExtendedState(Rooms.MAXIMIZED_BOTH);
        roomsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRooms_SectionsActionPerformed

    private void btnClasswork_SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasswork_SubjectsActionPerformed
        // TODO add your handling code here:
        Classwork classworkFrame = new Classwork();
        classworkFrame.setExtendedState(Classwork.MAXIMIZED_BOTH);
        classworkFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClasswork_SubjectsActionPerformed

    private void btnHome_SubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_SubjectsActionPerformed
        Home homeFrame = new Home();
        homeFrame.setExtendedState(Home.MAXIMIZED_BOTH); // Set full screen
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome_SubjectsActionPerformed

    private void updatesectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatesectionActionPerformed
         // Get selected row from table
   int selectedRow = Sections_Table.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, 
            "Please select a section to update.", 
            "Selection Required", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Get section details from selected row
    String sectionName = Sections_Table.getValueAt(selectedRow, 0).toString();
    String sectionCode = Sections_Table.getValueAt(selectedRow, 1).toString();
    int sectionId = (int) Sections_Table.getValueAt(selectedRow, 2); // Assuming section ID is in the third column
    
    // Open update form with section details
    UpdateSection updateFrame = new UpdateSection(sectionId, sectionName, sectionCode, this);
    updateFrame.setLocationRelativeTo(this);
    updateFrame.setVisible(true);
    }//GEN-LAST:event_updatesectionActionPerformed

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
            java.util.logging.Logger.getLogger(Sections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Sections().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Sections_Table;
    private rojeru_san.complementos.RSButtonHover btnAddSections_Sections;
    private rojeru_san.complementos.RSButtonHover btnClasswork_Subjects;
    private rojeru_san.complementos.RSButtonHover btnHome_Subjects;
    private rojeru_san.complementos.RSButtonHover btnLogout_Subjects;
    private rojeru_san.complementos.RSButtonHover btnMenu_Subjects;
    private rojeru_san.complementos.RSButtonHover btnRemoveSection_Sections;
    private rojeru_san.complementos.RSButtonHover btnRooms_Sections;
    private rojeru_san.complementos.RSButtonHover btnSections_Sections;
    private rojeru_san.complementos.RSButtonHover btnStudents_Subjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSButtonHover updatesection;
    // End of variables declaration//GEN-END:variables

}
