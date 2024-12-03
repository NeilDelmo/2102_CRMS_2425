
package Dashboard;

import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loginandsignup.Login;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;


public class ArchiveClasses extends javax.swing.JFrame {

    private static int currentTeachers_Id;

    // Static method to set the current teacher ID
    public static void setCurrentTeacherId(int teachers_id) {
        currentTeachers_Id = teachers_id;
    }

    // Static method to get the current teacher ID (optional, but can be useful)
    public static int getCurrentTeacherId() {
        return currentTeachers_Id;
    }

    public ArchiveClasses() {
        initComponents();
        setupTableWithCheckboxes();
      this.setVisible(true);
    }

    public ArchiveClasses(int teachers_id) {
        currentTeachers_Id = teachers_id;
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Home = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Home = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Home = new rojeru_san.complementos.RSButtonHover();
        btnUser_Home = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Home = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Home = new rojeru_san.complementos.RSButtonHover();
        btnRooms_Home = new rojeru_san.complementos.RSButtonHover();
        btnClasswork_Home = new rojeru_san.complementos.RSButtonHover();
        btnSections_Home = new rojeru_san.complementos.RSButtonHover();
        archiveClasses = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        ArchiveClasses = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classlogo.png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnMenu_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu.png"))); // NOI18N
        btnMenu_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenu_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Home.png"))); // NOI18N
        btnHome_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_HomeActionPerformed(evt);
            }
        });

        btnTeach_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnTeach_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnTeach_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Teach.png"))); // NOI18N
        btnTeach_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeach_HomeActionPerformed(evt);
            }
        });

        btnUser_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnUser_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        btnUser_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUser_HomeActionPerformed(evt);
            }
        });

        btnLogout_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout_Home.setText("Logout");
        btnLogout_Home.setColorHover(new java.awt.Color(204, 204, 204));
        btnLogout_Home.setColorText(new java.awt.Color(0, 0, 0));
        btnLogout_Home.setColorTextHover(new java.awt.Color(0, 0, 0));
        btnLogout_Home.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogout_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout_HomeActionPerformed(evt);
            }
        });

        btnStudents_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnStudents_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnStudents_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Students.png"))); // NOI18N
        btnStudents_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudents_HomeActionPerformed(evt);
            }
        });

        btnRooms_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnRooms_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnRooms_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/classroom.png"))); // NOI18N
        btnRooms_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRooms_HomeActionPerformed(evt);
            }
        });

        btnClasswork_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnClasswork_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnClasswork_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Classwork.png"))); // NOI18N
        btnClasswork_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasswork_HomeActionPerformed(evt);
            }
        });

        btnSections_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnSections_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnSections_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/section.png"))); // NOI18N
        btnSections_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSections_HomeActionPerformed(evt);
            }
        });

        archiveClasses.setBackground(new java.awt.Color(255, 255, 255));
        archiveClasses.setBorder(null);
        archiveClasses.setText("Archive");
        archiveClasses.setColorHover(new java.awt.Color(204, 204, 204));
        archiveClasses.setColorText(new java.awt.Color(0, 0, 0));
        archiveClasses.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        archiveClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveClassesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnHome_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnClasswork_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnSections_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnRooms_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnUser_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(archiveClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUser_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClasswork_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSections_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRooms_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(archiveClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ArchiveClasses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ArchiveClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ClassID", "Class Name", "Section", "Subject", "Time Deleted"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ArchiveClasses.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ArchiveClasses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 828, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_HomeActionPerformed
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHome_HomeActionPerformed
    private void setupTableWithCheckboxes() {
        CheckboxTableModel model = new CheckboxTableModel(); // No need for rows and columns in constructor
        ArchiveClasses.setModel(model);
        ArchiveClasses.getColumnModel().getColumn(0).setCellRenderer(new CheckboxRenderer());
    }

    public static class CheckboxTableModel extends AbstractTableModel {

        private Vector<Vector<Object>> data;
        private String[] columnNames = {"Selected", "Class ID", "Class Name", "Section", "Subject"};
        private Vector<Boolean> selection;

        public CheckboxTableModel() {
            data = new Vector<>();
            selection = new Vector<>();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Class<?> getColumnClass(int column) {
            if (column == 0) {
                return Boolean.class; // Checkbox column
            } else if (column == 1) {
                return Integer.class; // Class ID
            } else {
                return String.class; // Other columns
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 0; // Only checkbox column is editable
        }

        @Override
        public Object getValueAt(int row, int column) {
            if (column == 0) {
                return selection.get(row);
            }
            // Adjust column index for data Vector (subtract 1 because column 0 is checkbox)
            return data.get(row).get(column - 1);
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            if (column == 0) {
                selection.set(row, (Boolean) value);
                fireTableCellUpdated(row, column);
            } else {
                // Adjust column index for data Vector
                data.get(row).set(column - 1, value);
                fireTableCellUpdated(row, column);
            }
        }

        public void addRow(Object[] rowData) {
            Vector<Object> row = new Vector<>();
            // Skip the first element (checkbox state) when adding to data vector
            for (int i = 1; i < rowData.length; i++) {
                row.add(rowData[i]);
            }
            data.add(row);
            // Add checkbox state to selection vector
            selection.add((Boolean) rowData[0]);
            fireTableRowsInserted(data.size() - 1, data.size() - 1);
        }

        public void clear() {
            data.clear();
            selection.clear();
            fireTableDataChanged();
        }
    }

    public static class CheckboxRenderer extends JCheckBox implements TableCellRenderer {

        public CheckboxRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setSelected((Boolean) value);
            return this;
        }
    }

    public void loadClasses() {
        System.out.println("Current Teacher ID: " + currentTeachers_Id);
        String url = "jdbc:mysql://localhost:3306/crms";
        String user = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            // Modify query to filter classes by teacher ID and exclude room
            String query = "SELECT class_id, class_name, section_code, subject "
                    + "FROM classes "
                    + "WHERE teachers_id = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, currentTeachers_Id);

            rs = pstmt.executeQuery();

            CheckboxTableModel model = (CheckboxTableModel) ArchiveClasses.getModel();
            model.clear(); // Clear existing rows

            while (rs.next()) {
                Boolean checkboxState = false; // Initialize checkbox state to false
                Integer classId = rs.getInt("class_id");
                String className = rs.getString("class_name");
                int sectionCode = rs.getInt("section_code");
                String subject = rs.getString("subject");

                Object[] rowData = {
                    checkboxState, // Checkbox initially unchecked
                    classId, // Class ID
                    className, // Class Name
                    sectionCode, // Section
                    subject // Subject
                // Room is excluded
                };
                model.addRow(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Database error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadArchiveClasses() {
        System.out.println("Current Teacher ID: " + currentTeachers_Id); // Check if this is valid
        String url = "jdbc:mysql://localhost:3306/crms";
        String user = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            // Modify query to filter classes by teacher ID and exclude room
            String query = "SELECT class_id, class_name, section_code, subject, time_deleted "
                    + "FROM archiveclasses "
                    + "WHERE class_id = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, currentTeachers_Id); // Bind the current teacher's ID to the query

            rs = pstmt.executeQuery();

            // Ensure ClassTable is a JTable and CheckboxTableModel is assigned correctly
            CheckboxTableModel model = (CheckboxTableModel) ArchiveClasses.getModel();

            if (model == null) {
                System.out.println("ClassTable model is null. Make sure it's set correctly.");
                return; // Exit if model is not initialized
            }

            model.clear(); // Clear existing rows in the table before adding new ones

            // Check if results are returned
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No archived classes found for this teacher.",
                        "No Data", JOptionPane.INFORMATION_MESSAGE);
                return; // No data found
            }

            // Add rows from the result set to the table model
            while (rs.next()) {
                Boolean checkboxState = false; // Initialize checkbox state to false
                Integer classId = rs.getInt("class_id");
                String className = rs.getString("class_name");
                String sectionCode = rs.getString("section_code"); // Assuming it's a string, adjust if necessary
                String subject = rs.getString("subject");

                // Row data to add to the model
                Object[] rowData = {
                    checkboxState, // Checkbox initially unchecked
                    classId, // Class ID
                    className, // Class Name
                    sectionCode, // Section
                    subject // Subject
                };

                model.addRow(rowData); // Add the row to the model
            }

            // Optionally, auto resize the columns to fit content
            ArchiveClasses.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Database error: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Properly close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

    private Teach teachFrame; // Add a reference to the Teach frame
    private void btnTeach_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_HomeActionPerformed
        int selectedRow = ArchiveClasses.getSelectedRow();

        if (selectedRow != -1) {
            Integer classId = (Integer) ArchiveClasses.getValueAt(selectedRow, 1); // Assuming Class ID is in the second column
            Teach teachFrame = Teach.getInstance(currentTeachers_Id, classId); // Use the Singleton method
            teachFrame.setVisible(true); // Show the Teach frame
        } else {
            JOptionPane.showMessageDialog(this, "Please select a class to teach.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTeach_HomeActionPerformed

    private void btnMenu_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_HomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_HomeActionPerformed

    private void btnUser_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUser_HomeActionPerformed
        // TODO add your handling code here:
        AccountManagement AccManageFrame = new AccountManagement();
        AccManageFrame.setExtendedState(AccountManagement.MAXIMIZED_BOTH); // Set full screen
        AccManageFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUser_HomeActionPerformed

    private void btnLogout_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout_HomeActionPerformed
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

    }//GEN-LAST:event_btnLogout_HomeActionPerformed

    private void btnStudents_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudents_HomeActionPerformed
        Students studentsFrame = new Students();
        studentsFrame.setExtendedState(Students.MAXIMIZED_BOTH); // Set full screen
        studentsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStudents_HomeActionPerformed

    private void btnSubjects_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjects_HomeActionPerformed
        Sections sectionsFrame = new Sections();
        sectionsFrame.setExtendedState(Students.MAXIMIZED_BOTH);
        sectionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSubjects_HomeActionPerformed

    private void btnSections_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSections_HomeActionPerformed
        // TODO add your handling code here:
        Sections sectionsFrame = new Sections();
        sectionsFrame.setExtendedState(Sections.MAXIMIZED_BOTH);
        sectionsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSections_HomeActionPerformed

    private void archiveClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveClassesActionPerformed

        String url = "jdbc:mysql://localhost:3306/crms";
        String user = "root";
        String password = "";

        // Query to fetch data from archiveclasses table
        String query = "SELECT class_id, class_name, section_code, subject, time_deleted FROM archiveclasses";

        // Create a JFrame for displaying the table
        JFrame frame = new JFrame("Archived Classes");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a DefaultTableModel to hold the data
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{"Class ID", "Class Name", "Section Code", "Subject", "Time Deleted"});

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            // Loop through the result set and add rows to the table model
            while (rs.next()) {
                int classId = rs.getInt("class_id");
                String className = rs.getString("class_name");
                String sectionCode = rs.getString("section_code");
                String subject = rs.getString("subject");
                Timestamp timeDeleted = rs.getTimestamp("time_deleted");

                tableModel.addRow(new Object[]{classId, className, sectionCode, subject, timeDeleted});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error fetching archived classes: " + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a JTable with the model
        JTable table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Set the frame visible
        frame.setVisible(true);
    }//GEN-LAST:event_archiveClassesActionPerformed

    private void btnClasswork_HomeActionPerformed(java.awt.event.ActionEvent evt) {
    Classwork classworkFrame = new Classwork();
    classworkFrame.setExtendedState(Classwork.MAXIMIZED_BOTH);
    classworkFrame.setVisible(true);
}

    private void btnRooms_HomeActionPerformed(java.awt.event.ActionEvent evt) {
    Rooms roomsFrame = new Rooms();
    roomsFrame.setExtendedState(Rooms.MAXIMIZED_BOTH);
    roomsFrame.setVisible(true);
    this.dispose();

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
        java.util.logging.Logger.getLogger(ArchiveClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(ArchiveClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(ArchiveClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ArchiveClasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    //
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
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
            new ArchiveClasses().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ArchiveClasses;
    private rojeru_san.complementos.RSButtonHover archiveClasses;
    private rojeru_san.complementos.RSButtonHover btnClasswork_Home;
    private rojeru_san.complementos.RSButtonHover btnHome_Home;
    private rojeru_san.complementos.RSButtonHover btnLogout_Home;
    private rojeru_san.complementos.RSButtonHover btnMenu_Home;
    private rojeru_san.complementos.RSButtonHover btnRooms_Home;
    private rojeru_san.complementos.RSButtonHover btnSections_Home;
    private rojeru_san.complementos.RSButtonHover btnStudents_Home;
    private rojeru_san.complementos.RSButtonHover btnTeach_Home;
    private rojeru_san.complementos.RSButtonHover btnUser_Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
