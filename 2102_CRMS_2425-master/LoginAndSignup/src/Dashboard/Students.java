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

public class Students extends javax.swing.JFrame {
      private int currentSectionId = -1;

    // Default constructor for viewing all students
    public Students() {
        initComponents();
        this.setExtendedState(Students.MAXIMIZED_BOTH);
        setupTableSorting();
        LoadStudents();
    }

    // Constructor for section-specific view
    public Students(int sectionId) {
        this.currentSectionId = sectionId;
        initComponents();
        this.setExtendedState(Students.MAXIMIZED_BOTH);
        setupTableSorting();
        LoadStudentsBySection();
    }

    public void LoadStudentsBySection() {
        DefaultTableModel model = (DefaultTableModel) Students_Table.getModel();
        model.setRowCount(0);

        String query = "SELECT s.student_id, s.student_lastname, s.student_firstname, sec.section_code " +
                      "FROM students s " +
                      "INNER JOIN sections sec ON s.section_id = sec.section_id " +
                      "WHERE s.section_id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, currentSectionId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("student_id"),
                    rs.getString("student_lastname"),
                    rs.getString("student_firstname"),
                    rs.getString("section_code")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading students: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void LoadStudents() {
        DefaultTableModel model = (DefaultTableModel) Students_Table.getModel();
        model.setRowCount(0);

        String query = "SELECT s.student_id, s.student_lastname, s.student_firstname, " +
                      "COALESCE(sec.section_code, 'Unassigned') as section_code " +
                      "FROM students s " +
                      "LEFT JOIN sections sec ON s.section_id = sec.section_id";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
             PreparedStatement stmt = con.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("student_id"),
                    rs.getString("student_lastname"),
                    rs.getString("student_firstname"),
                    rs.getString("section_code")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
                "Error loading students: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupTableSorting() {
        Students_Table.setAutoCreateRowSorter(true);
        Students_Table.getTableHeader().setReorderingAllowed(false);
        
        // Add mouse listener for double-click deletion
        Students_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Double click
                    int selectedRow = Students_Table.getSelectedRow();
                    if (selectedRow != -1) {
                        int studentId = (int) Students_Table.getValueAt(selectedRow, 0);
                        String studentName = Students_Table.getValueAt(selectedRow, 2) + " " + 
                                          Students_Table.getValueAt(selectedRow, 1);

                        int response = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to remove " + studentName + "?",
                            "Confirm Deletion",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            deleteStudent(studentId);
                        }
                    }
                }
            }
        });
    }

    private void deleteStudent(int studentId) {
        String query = "DELETE FROM students WHERE student_id = ?";
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, studentId);
            int result = stmt.executeUpdate();
            
            if (result > 0) {
                JOptionPane.showMessageDialog(this,
                    "Student successfully deleted!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                // Refresh the table
                if (currentSectionId == -1) {
                    LoadStudents();
                } else {
                    LoadStudentsBySection();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "No student found with that ID",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Error deleting student: " + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnRemoveStudent_StudentsActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = Students_Table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Please select a student to remove",
                "No Selection",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int studentId = (int) Students_Table.getValueAt(selectedRow, 0);
        String studentName = Students_Table.getValueAt(selectedRow, 2) + " " + 
                           Students_Table.getValueAt(selectedRow, 1);

        int response = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to remove " + studentName + "?",
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            deleteStudent(studentId);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Students = new rojeru_san.complementos.RSButtonHover();
        btnRemoveStudent_Students = new rojeru_san.complementos.RSButtonHover();
        btnAddStudent_Students = new rojeru_san.complementos.RSButtonHover();
        btnRefresh_Students = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Students = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Students = new rojeru_san.complementos.RSButtonHover();
        btnSections_Students = new rojeru_san.complementos.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        Students_Table = new javax.swing.JTable();

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

        btnRemoveStudent_Students.setBackground(new java.awt.Color(0, 102, 102));
        btnRemoveStudent_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        btnRemoveStudent_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveStudent_StudentsActionPerformed(evt);
            }
        });

        btnAddStudent_Students.setBackground(new java.awt.Color(0, 102, 102));
        btnAddStudent_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnAddStudent_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudent_StudentsActionPerformed(evt);
            }
        });

        btnRefresh_Students.setBackground(new java.awt.Color(0, 102, 102));
        btnRefresh_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        btnRefresh_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh_StudentsActionPerformed(evt);
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
                .addComponent(btnRefresh_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveStudent_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddStudent_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveStudent_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAddStudent_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_StudentsActionPerformed(evt);
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

        btnSections_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnSections_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnSections_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/section.png"))); // NOI18N
        btnSections_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSections_StudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnSections_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnHome_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSections_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Students_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Last_Name", "First_Name", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Students_Table);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_StudentsActionPerformed
        Home homeFrame = new Home();
        homeFrame.setExtendedState(Home.MAXIMIZED_BOTH); // Set full screen
        homeFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome_StudentsActionPerformed

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

    
    
    private void btnSections_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSections_StudentsActionPerformed
        Sections sectionsFrame = new Sections();
        sectionsFrame.setExtendedState(Sections.MAXIMIZED_BOTH);
        sectionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSections_StudentsActionPerformed

    private void btnAddStudent_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudent_StudentsActionPerformed
        // TODO add your handling code here:
         AddStudents addstudentsFrame = new AddStudents(currentSectionId);
         addstudentsFrame.setVisible(true);
        
    }//GEN-LAST:event_btnAddStudent_StudentsActionPerformed

    private void btnRefresh_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh_StudentsActionPerformed
        if (currentSectionId == -1) {
            LoadStudents();
        } else {
            LoadStudentsBySection();
        }
        JOptionPane.showMessageDialog(this, 
            "Student list refreshed successfully!", 
            "Refresh Complete", 
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefresh_StudentsActionPerformed

    private void btnMenu_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_StudentsActionPerformed

    }//GEN-LAST:event_btnMenu_StudentsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Students().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Students_Table;
    private rojeru_san.complementos.RSButtonHover btnAddStudent_Students;
    private rojeru_san.complementos.RSButtonHover btnHome_Students;
    private rojeru_san.complementos.RSButtonHover btnLogout_Students;
    private rojeru_san.complementos.RSButtonHover btnMenu_Students;
    private rojeru_san.complementos.RSButtonHover btnRefresh_Students;
    private rojeru_san.complementos.RSButtonHover btnRemoveStudent_Students;
    private rojeru_san.complementos.RSButtonHover btnSections_Students;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
