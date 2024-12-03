package Dashboard;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import loginandsignup.Login;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Grades extends JFrame {

    private DefaultTableModel model;

    public Grades() {
        initComponents();  // Initialize UI components
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadGrades();
        setupTableModelListener();
    }

    private void loadGrades() {
        String URL = "jdbc:mysql://localhost:3306/crms";
        String USER = "root";
        String PASS = "";

        // Initialize model
        model = (DefaultTableModel) GradesTable.getModel();
        model.setRowCount(0);

        // Combined SQL query to get student and grades info
        String query = "SELECT students.student_id, students.student_firstname, students.student_lastname, students.section_code, "
                + "grades.activity1, grades.activity2, grades.activity3, grades.activity4, grades.activity5, "
                + "grades.midterms, grades.finals, grades.project "
                + "FROM students "
                + "LEFT JOIN grades ON students.student_id = grades.student_id";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Retrieve student info
                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("student_firstname");
                String lastName = rs.getString("student_lastname");
                String sectionCode = rs.getString("section_code");

                // Retrieve each activity grade and handle potential nulls
                Double activity1 = rs.getObject("activity1") != null ? rs.getDouble("activity1") : 0;
                Double activity2 = rs.getObject("activity2") != null ? rs.getDouble("activity2") : 0;
                Double activity3 = rs.getObject("activity3") != null ? rs.getDouble("activity3") : 0;
                Double activity4 = rs.getObject("activity4") != null ? rs.getDouble("activity4") : 0;
                Double activity5 = rs.getObject("activity5") != null ? rs.getDouble("activity5") : 0;
                Double midterms = rs.getObject("midterms") != null ? rs.getDouble("midterms") : 0;
                Double finals = rs.getObject("finals") != null ? rs.getDouble("finals") : 0;
                Double project = rs.getObject("project") != null ? rs.getDouble("project") : 0;

                // Calculate average of grades
                double average = 0;
                int numGrades = 0;

                // List of grades
                List<Double> grades = Arrays.asList(
                        activity1, activity2, activity3, activity4, activity5,
                        midterms, finals, project
                );

                // Count non-null grades and calculate total for the average
                for (Double grade : grades) {
                    if (grade != null && grade != 0) { // Check if the grade is not null or zero
                        average += grade;
                        numGrades++;
                    }
                }

                // Calculate the average if there are valid grades
                if (numGrades > 0) {
                    average /= numGrades; // Avoid division by zero
                } else {
                    average = 0; // Set average to 0 if no valid grades are found
                }

                // Add the row to the model
                model.addRow(new Object[]{
                    studentId,
                    firstName,
                    lastName,
                    sectionCode,
                    activity1,
                    activity2,
                    activity3,
                    activity4,
                    activity5,
                    midterms,
                    finals,
                    project,
                    average
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading students and grades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupTableModelListener() {
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Check if the change is due to a cell update
                if (e.getType() == TableModelEvent.UPDATE) { // Use EventType.UPDATE
                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    // Ensure row and column are valid
                    if (row >= 0 && column >= 0) { // Check if indices are valid
                        int studentId = (int) model.getValueAt(row, 0); // Assuming student ID is in the first column
                        String activityName = getActivityNameByColumn(column); // Get the name or index of the activity based on the column index
                        String newGrade = model.getValueAt(row, column).toString();

                        // Call the method to update the database
                        updateDatabase(studentId, activityName, newGrade);
                    } else {
                        System.out.println("Invalid row or column. Row: " + row + ", Column: " + column); // Log invalid indices
                    }
                } else {
                    System.out.println("Event type is not UPDATE. Event type: " + e.getType()); // Log unexpected event types
                }
            }
        });
    }

    private String getActivityNameByColumn(int column) {
        switch (column) {
            case 4:
                return "activity1";
            case 5:
                return "activity2";
            case 6:
                return "activity3";
            case 7:
                return "activity4";
            case 8:
                return "activity5";
            case 9:
                return "midterms";
            case 10:
                return "finals";
            case 11:
                return "project";
            default:
                return "";
        }
    }

    private void updateDatabase(int studentId, String activityName, String newGrade) {
        String URL = "jdbc:mysql://localhost:3306/crms";
        String USER = "root";
        String PASS = "";

        String updateQuery = "UPDATE grades SET " + activityName + " = ? WHERE student_id = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement pstmt = con.prepareStatement(updateQuery)) {

            pstmt.setDouble(1, Double.parseDouble(newGrade)); // Set the new grade
            pstmt.setInt(2, studentId); // Set the student ID

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Grade updated successfully for Student ID: " + studentId);
            } else {
                System.out.println("No records updated. Check if Student ID exists: " + studentId);
            }

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating grades: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        btnTeach_Students = new rojeru_san.complementos.RSButtonHover();
        btnUser_Students = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Students = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Students = new rojeru_san.complementos.RSButtonHover();
        btnSections_Students = new rojeru_san.complementos.RSButtonHover();
        btnRooms_Students = new rojeru_san.complementos.RSButtonHover();
        btnClasswork_Students = new rojeru_san.complementos.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        GradesTable = new javax.swing.JTable();
        btnUpdateGrades = new rojeru_san.complementos.RSButtonHover();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, Short.MAX_VALUE)
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

        btnTeach_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnTeach_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnTeach_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Teach.png"))); // NOI18N
        btnTeach_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeach_StudentsActionPerformed(evt);
            }
        });

        btnUser_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnUser_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        btnUser_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUser_StudentsActionPerformed(evt);
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

        btnStudents_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnStudents_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnStudents_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Students.png"))); // NOI18N
        btnStudents_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudents_StudentsActionPerformed(evt);
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

        btnRooms_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnRooms_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnRooms_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/classroom.png"))); // NOI18N
        btnRooms_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRooms_StudentsActionPerformed(evt);
            }
        });

        btnClasswork_Students.setBackground(new java.awt.Color(255, 255, 255));
        btnClasswork_Students.setForeground(new java.awt.Color(0, 0, 0));
        btnClasswork_Students.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classwork.png"))); // NOI18N
        btnClasswork_Students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasswork_StudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnUser_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addComponent(btnHome_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTeach_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSections_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStudents_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRooms_Students, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnClasswork_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUser_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTeach_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClasswork_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudents_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSections_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRooms_Students, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout_Students, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        GradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student_id", "Last Name", "First Name", "section", "Activity 1", "Activity 2", "Activity 3", "Activity 4", "Activity 5", "Midterms", "Finals", "Project", "Ave_Grades"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GradesTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(GradesTable);
        GradesTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnUpdateGrades.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdateGrades.setText("Update");
        btnUpdateGrades.setColorHover(new java.awt.Color(204, 204, 204));
        btnUpdateGrades.setColorText(new java.awt.Color(0, 0, 0));
        btnUpdateGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateGradesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(btnUpdateGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btnTeach_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_StudentsActionPerformed
        Teach teachFrame = new Teach();
        teachFrame.setExtendedState(Teach.MAXIMIZED_BOTH); // Set full screen
        teachFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTeach_StudentsActionPerformed

    private void btnRemoveStudent_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveStudent_StudentsActionPerformed
        // TODO add your handling code here:
        RemoveStudent removestudentsFrame = new RemoveStudent();
        removestudentsFrame.setVisible(true);
    }//GEN-LAST:event_btnRemoveStudent_StudentsActionPerformed

    private void btnMenu_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_StudentsActionPerformed

    }//GEN-LAST:event_btnMenu_StudentsActionPerformed

    private void btnUser_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUser_StudentsActionPerformed
        // TODO add your handling code here:
        AccountManagement AccManageFrame = new AccountManagement();
        AccManageFrame.setExtendedState(AccountManagement.MAXIMIZED_BOTH); // Set full screen
        AccManageFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUser_StudentsActionPerformed

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


    private void btnStudents_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudents_StudentsActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(new JFrame(), "You are already in the Students window.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnStudents_StudentsActionPerformed

    private void btnSections_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSections_StudentsActionPerformed
        Sections sectionsFrame = new Sections();
        sectionsFrame.setExtendedState(Sections.MAXIMIZED_BOTH);
        sectionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSections_StudentsActionPerformed

    private void btnAddStudent_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudent_StudentsActionPerformed

    }//GEN-LAST:event_btnAddStudent_StudentsActionPerformed

    private void btnRooms_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRooms_StudentsActionPerformed
        // TODO add your handling code here
        Rooms roomsFrame = new Rooms();
        roomsFrame.setExtendedState(Rooms.MAXIMIZED_BOTH);
        roomsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRooms_StudentsActionPerformed

    private void btnClasswork_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasswork_StudentsActionPerformed
        // TODO add your handling code here:
        Classwork classworkFrame = new Classwork();
        classworkFrame.setExtendedState(Classwork.MAXIMIZED_BOTH);
        classworkFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnClasswork_StudentsActionPerformed

    private void btnRefresh_StudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh_StudentsActionPerformed
        // TODO add your handling code here:
        loadGrades();

    }//GEN-LAST:event_btnRefresh_StudentsActionPerformed

    private void btnUpdateGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateGradesActionPerformed
        // Ensure a row is selected
        int selectedRow = GradesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get student details for display
        String firstName = (String) model.getValueAt(selectedRow, 2); // Assuming First Name is in column index 2
        String lastName = (String) model.getValueAt(selectedRow, 1); // Assuming Last Name is in column index 1

        // Prepare input fields for grades
        JTextField activity1Field = new JTextField(model.getValueAt(selectedRow, 4).toString());
        JTextField activity2Field = new JTextField(model.getValueAt(selectedRow, 5).toString());
        JTextField activity3Field = new JTextField(model.getValueAt(selectedRow, 6).toString());
        JTextField activity4Field = new JTextField(model.getValueAt(selectedRow, 7).toString());
        JTextField activity5Field = new JTextField(model.getValueAt(selectedRow, 8).toString());
        JTextField midtermsField = new JTextField(model.getValueAt(selectedRow, 9).toString());
        JTextField finalsField = new JTextField(model.getValueAt(selectedRow, 10).toString());
        JTextField projectField = new JTextField(model.getValueAt(selectedRow, 11).toString());

        // Panel to hold input fields
        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Activity 1:"));
        panel.add(activity1Field);
        panel.add(new JLabel("Activity 2:"));
        panel.add(activity2Field);
        panel.add(new JLabel("Activity 3:"));
        panel.add(activity3Field);
        panel.add(new JLabel("Activity 4:"));
        panel.add(activity4Field);
        panel.add(new JLabel("Activity 5:"));
        panel.add(activity5Field);
        panel.add(new JLabel("Midterms:"));
        panel.add(midtermsField);
        panel.add(new JLabel("Finals:"));
        panel.add(finalsField);
        panel.add(new JLabel("Project:"));
        panel.add(projectField);

        // Show input dialog
        int result = JOptionPane.showConfirmDialog(this, panel, "Update Grades for " + firstName + " " + lastName,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result != JOptionPane.OK_OPTION) {
            return; // User cancelled
        }

        // Validate and parse the inputs
        try {
            Double activity1 = Double.valueOf(activity1Field.getText());
            Double activity2 = Double.valueOf(activity2Field.getText());
            Double activity3 = Double.valueOf(activity3Field.getText());
            Double activity4 = Double.valueOf(activity4Field.getText());
            Double activity5 = Double.valueOf(activity5Field.getText());
            Double midterms = Double.valueOf(midtermsField.getText());
            Double finals = Double.valueOf(finalsField.getText());
            Double project = Double.valueOf(projectField.getText());

            // Calculate average
            double average = (activity1 + activity2 + activity3 + activity4 + activity5 + midterms + finals + project) / 8;

            // Update the database (the part you had mostly correct)
            String URL = "jdbc:mysql://localhost:3306/crms";
            String USER = "root";
            String PASS = "";
            String updateQuery = "UPDATE grades SET activity1 = ?, activity2 = ?, activity3 = ?, activity4 = ?, activity5 = ?, "
                    + "midterms = ?, finals = ?, project = ?, ave_grade = ? WHERE student_id = ?";

            int studentId = (int) model.getValueAt(selectedRow, 0); // Get student ID

            try (Connection con = DriverManager.getConnection(URL, USER, PASS); PreparedStatement stmt = con.prepareStatement(updateQuery)) {

                stmt.setDouble(1, activity1);
                stmt.setDouble(2, activity2);
                stmt.setDouble(3, activity3);
                stmt.setDouble(4, activity4);
                stmt.setDouble(5, activity5);
                stmt.setDouble(6, midterms);
                stmt.setDouble(7, finals);
                stmt.setDouble(8, project);
                stmt.setDouble(9, average);
                stmt.setInt(10, studentId);

                // Execute update
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    // Update the table model
                    model.setValueAt(activity1, selectedRow, 4);
                    model.setValueAt(activity2, selectedRow, 5);
                    model.setValueAt(activity3, selectedRow, 6);
                    model.setValueAt(activity4, selectedRow, 7);
                    model.setValueAt(activity5, selectedRow, 8);
                    model.setValueAt(midterms, selectedRow, 9);
                    model.setValueAt(finals, selectedRow, 10);
                    model.setValueAt(project, selectedRow, 11);
                    model.setValueAt(average, selectedRow, 12); // Update the average in the table too

                    JOptionPane.showMessageDialog(this, "Grades updated successfully!", "Update Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update grades. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating grades: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for grades.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateGradesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GradesTable;
    private rojeru_san.complementos.RSButtonHover btnAddStudent_Students;
    private rojeru_san.complementos.RSButtonHover btnClasswork_Students;
    private rojeru_san.complementos.RSButtonHover btnHome_Students;
    private rojeru_san.complementos.RSButtonHover btnLogout_Students;
    private rojeru_san.complementos.RSButtonHover btnMenu_Students;
    private rojeru_san.complementos.RSButtonHover btnRefresh_Students;
    private rojeru_san.complementos.RSButtonHover btnRemoveStudent_Students;
    private rojeru_san.complementos.RSButtonHover btnRooms_Students;
    private rojeru_san.complementos.RSButtonHover btnSections_Students;
    private rojeru_san.complementos.RSButtonHover btnStudents_Students;
    private rojeru_san.complementos.RSButtonHover btnTeach_Students;
    private rojeru_san.complementos.RSButtonHover btnUpdateGrades;
    private rojeru_san.complementos.RSButtonHover btnUser_Students;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
