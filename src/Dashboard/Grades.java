package Dashboard;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import loginandsignup.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Grades extends javax.swing.JFrame {

    public Grades() {
        initComponents();
         this.setExtendedState(Grades.MAXIMIZED_BOTH);
         LoadGrades();
    }
private void LoadGrades() {
    String URL = "jdbc:mysql://localhost:3306/crms";
    String USER = "root";
    String PASS = "";
    DefaultTableModel model = (DefaultTableModel) Grades_Table.getModel();
    model.setRowCount(0); 

    // Corrected SQL query to include class_name and average_grade from the grades table
    String query = "SELECT students.student_id, students.student_lastname, students.student_firstname, "
                 + "sections.section_code, grades.class_name, grades.average_grade " +
                 "FROM students " +
                 "LEFT JOIN sections ON students.section_code = sections.section_code " +
                 "LEFT JOIN grades ON sections.section_code = grades.section_code"; // Adjust join conditions as needed

    try (Connection con = DriverManager.getConnection(URL, USER, PASS)) { 
        PreparedStatement stmt = con.prepareStatement(query); 
        ResultSet rs = stmt.executeQuery(); 

        while (rs.next()) {
            int id = rs.getInt("student_id");
            String lastName = rs.getString("student_lastname");
            String firstName = rs.getString("student_firstname");
            String section_code = rs.getString("section_code");
            String className = rs.getString("class_name");
            Double aveGrade = rs.getDouble("average_grade");

            // Handle null values
            if (section_code == null) {
                section_code = "Unassigned"; // Placeholder for students without a section
            }
            if (className == null) {
                className = "N/A"; // Placeholder for cases without a class
            }
            if (aveGrade == 0) {
                aveGrade = null; // Handle potential null for average grades
            }

            model.addRow(new Object[]{id, lastName, firstName, section_code, className, aveGrade});
        }

    } catch (SQLException e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Students = new rojeru_san.complementos.RSButtonHover();
        btnRemoveGrades__Grades = new rojeru_san.complementos.RSButtonHover();
        btnAddGrades_Grades = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Grades = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Grades = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Students = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Grades = new rojeru_san.complementos.RSButtonHover();
        btnSections_Grades = new rojeru_san.complementos.RSButtonHover();
        btnClasswork_Grades = new rojeru_san.complementos.RSButtonHover();
        btnGrades_Grades = new rojeru_san.complementos.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        Grades_Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classlogo.png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnMenu_Students.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        btnMenu_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_StudentsActionPerformed(evt);
            }
        });

        btnRemoveGrades__Grades.setBackground(new java.awt.Color(0, 102, 102));
        btnRemoveGrades__Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        btnRemoveGrades__Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGrades__GradesActionPerformed(evt);
            }
        });

        btnAddGrades_Grades.setBackground(new java.awt.Color(0, 102, 102));
        btnAddGrades_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnAddGrades_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGrades_GradesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemoveGrades__Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddGrades_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveGrades__Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAddGrades_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_GradesActionPerformed(evt);
            }
        });

        btnTeach_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnTeach_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnTeach_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Teach.png"))); // NOI18N
        btnTeach_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeach_GradesActionPerformed(evt);
            }
        });

        btnLogout_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout_Students.setText("Logout");
        btnLogout_Students.setColorHover(new java.awt.Color(204, 204, 204));
        btnLogout_Students.setColorText(new java.awt.Color(0, 0, 0));
        btnLogout_Students.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnLogout_Students.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout_StudentsActionPerformed(evt);
            }
        });

        btnStudents_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnStudents_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnStudents_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Students.png"))); // NOI18N
        btnStudents_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudents_GradesActionPerformed(evt);
            }
        });

        btnSections_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnSections_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnSections_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/section.png"))); // NOI18N
        btnSections_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSections_GradesActionPerformed(evt);
            }
        });

        btnClasswork_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnClasswork_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnClasswork_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classwork.png"))); // NOI18N
        btnClasswork_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasswork_GradesActionPerformed(evt);
            }
        });

        btnGrades_Grades.setBackground(new java.awt.Color(255, 255, 255));
        btnGrades_Grades.setForeground(new java.awt.Color(0, 0, 0));
        btnGrades_Grades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/grades.png"))); // NOI18N
        btnGrades_Grades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrades_GradesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome_Grades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTeach_Grades, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSections_Grades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStudents_Grades, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnClasswork_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnGrades_Grades, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnHome_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTeach_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGrades_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClasswork_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudents_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSections_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Grades_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Last_Name", "First_Name", "Section", "class_name", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Grades_Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_GradesActionPerformed
        Home homeFrame = new Home();
        homeFrame.setExtendedState(Home.MAXIMIZED_BOTH); // Set full screen
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome_GradesActionPerformed

    private void btnTeach_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_GradesActionPerformed
    Teach teachFrame = new Teach();
    teachFrame.setExtendedState(Teach.MAXIMIZED_BOTH); // Set full screen
    teachFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnTeach_GradesActionPerformed

    private void btnRemoveGrades__GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGrades__GradesActionPerformed
        // TODO add your handling code here:
         RemoveStudent removestudentsFrame = new RemoveStudent();
         removestudentsFrame.setVisible(true);
    }//GEN-LAST:event_btnRemoveGrades__GradesActionPerformed

    private void btnMenu_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_StudentsActionPerformed

    }//GEN-LAST:event_btnMenu_StudentsActionPerformed

    private void btnLogout_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout_StudentsActionPerformed
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

    }//GEN-LAST:event_btnLogout_StudentsActionPerformed

    
    
    private void btnStudents_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudents_GradesActionPerformed
        // TODO add your handling code here:
          JOptionPane.showMessageDialog(new JFrame(), "You are already in the Students window.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnStudents_GradesActionPerformed

    private void btnSections_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSections_GradesActionPerformed
        Sections sectionsFrame = new Sections();
        sectionsFrame.setExtendedState(Sections.MAXIMIZED_BOTH);
        sectionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSections_GradesActionPerformed

    private void btnAddGrades_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGrades_GradesActionPerformed
        // TODO add your handling code here:
         AddStudents addstudentsFrame = new AddStudents();
         addstudentsFrame.setVisible(true);
        
    }//GEN-LAST:event_btnAddGrades_GradesActionPerformed

    private void btnClasswork_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasswork_GradesActionPerformed
        // TODO add your handling code here:
        Classwork classworkFrame = new Classwork();
        classworkFrame.setExtendedState(Classwork.MAXIMIZED_BOTH);
        classworkFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClasswork_GradesActionPerformed

    private void btnGrades_GradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrades_GradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGrades_GradesActionPerformed

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
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Grades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Grades_Table;
    private rojeru_san.complementos.RSButtonHover btnAddGrades_Grades;
    private rojeru_san.complementos.RSButtonHover btnClasswork_Grades;
    private rojeru_san.complementos.RSButtonHover btnGrades_Grades;
    private rojeru_san.complementos.RSButtonHover btnHome_Grades;
    private rojeru_san.complementos.RSButtonHover btnLogout_Students;
    private rojeru_san.complementos.RSButtonHover btnMenu_Students;
    private rojeru_san.complementos.RSButtonHover btnRemoveGrades__Grades;
    private rojeru_san.complementos.RSButtonHover btnSections_Grades;
    private rojeru_san.complementos.RSButtonHover btnStudents_Grades;
    private rojeru_san.complementos.RSButtonHover btnTeach_Grades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
