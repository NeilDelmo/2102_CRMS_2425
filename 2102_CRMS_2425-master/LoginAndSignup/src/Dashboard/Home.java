package Dashboard;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loginandsignup.Login;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import loginandsignup.Login;



public class Home extends javax.swing.JFrame {
   private static int currentTeachers_Id;

    // Static method to set the current teacher ID
    public static void setCurrentTeacherId(int teachers_id) {
        currentTeachers_Id = teachers_id;
    }

    // Static method to get the current teacher ID (optional, but can be useful)
    public static int getCurrentTeacherId() {
        return currentTeachers_Id;
    }
    
    public Home(){
        initComponents();
        setupTableWithCheckboxes();
        loadClasses();
        logResourcePaths();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
    }
    
public Home(int teachers_id) {
    currentTeachers_Id = teachers_id;
    initComponents();
    setupTableWithCheckboxes();
    loadClasses();
    logResourcePaths();
    this.setExtendedState(Home.MAXIMIZED_BOTH);
}
    

    private void logResourcePaths() {
    String[] imagePaths = {
        "/Dashboard/Home.png",
        "/Dashboard/menu.png",
        "/Dashboard/Classlogo.png",
        "/Dashboard/classespng.png",
        "/Dashboard/user.png",
        "/Dashboard/plus (1).png",
        "/Dashboard/Students.png"
    };

    for (String path : imagePaths) {
        java.net.URL url = getClass().getResource(path);
        System.out.println("Resource Path: " + path + " -> " + (url != null ? url.toString() : "NOT FOUND"));
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Home = new rojeru_san.complementos.RSButtonHover();
        btnAddClass_Home = new rojeru_san.complementos.RSButtonHover();
        btnRemoveClass_Home = new rojeru_san.complementos.RSButtonHover();
        btnUpdateclass_Home = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Home = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Home = new rojeru_san.complementos.RSButtonHover();
        btnUser_Home = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Home = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Home = new rojeru_san.complementos.RSButtonHover();
        btnSubjects_Home = new rojeru_san.complementos.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClassTable = new javax.swing.JTable();

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

        btnAddClass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnAddClass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnAddClass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClass_HomeActionPerformed(evt);
            }
        });

        btnRemoveClass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnRemoveClass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minus.png"))); // NOI18N
        btnRemoveClass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveClass_HomeActionPerformed(evt);
            }
        });

        btnUpdateclass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnUpdateclass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.png"))); // NOI18N
        btnUpdateclass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateclass_HomeActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                .addComponent(btnRemoveClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(btnUpdateclass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateclass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnSubjects_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnSubjects_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnSubjects_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Subjects.png"))); // NOI18N
        btnSubjects_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjects_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnUser_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnHome_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSubjects_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUser_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(btnHome_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubjects_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ClassTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ClassTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ClassID", "Class Name", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ClassTable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2)
                .addGap(7, 7, 7))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_HomeActionPerformed
        
        JOptionPane.showMessageDialog(new JFrame(), "You are already in the home window.", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnHome_HomeActionPerformed
    private void setupTableWithCheckboxes() {
        CheckboxTableModel model = new CheckboxTableModel(); // No need for rows and columns in constructor
        ClassTable.setModel(model);
        ClassTable.getColumnModel().getColumn(0).setCellRenderer(new CheckboxRenderer());
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
        public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int column) {
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
            String query = "SELECT class_id, class_name, section, subject " +
                           "FROM classes " +
                           "WHERE teachers_id = ?";
    
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, currentTeachers_Id);
    
            rs = pstmt.executeQuery();
    
            CheckboxTableModel model = (CheckboxTableModel) ClassTable.getModel();
            model.clear(); // Clear existing rows

            while (rs.next()) {
                Boolean checkboxState = false; // Initialize checkbox state to false
                Integer classId = rs.getInt("class_id");
                String className = rs.getString("class_name");
                String section = rs.getString("section");
                String subject = rs.getString("subject");

                Object[] rowData = {
                    checkboxState, // Checkbox initially unchecked
                    classId,       // Class ID
                    className,     // Class Name
                    section,       // Section
                    subject        // Subject
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
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   
}

private Teach teachFrame; // Add a reference to the Teach frame
    private void btnTeach_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_HomeActionPerformed
      int selectedRow = ClassTable.getSelectedRow();

    if (selectedRow != -1) {
        Integer classId = (Integer) ClassTable.getValueAt(selectedRow, 1); // Assuming Class ID is in the second column
        Teach teachFrame = Teach.getInstance(currentTeachers_Id, classId); // Use the Singleton method
        teachFrame.setVisible(true); // Show the Teach frame
    } else {
        JOptionPane.showMessageDialog(this, "Please select a class to teach.", "No Selection", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnTeach_HomeActionPerformed

    private void btnAddClass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClass_HomeActionPerformed
        // TODO add your handling code here:
     // Pass the current teacher ID to the addclasses frame
    addclasses addClassesFrame = new addclasses(this,currentTeachers_Id);
    addClassesFrame.setVisible(true);
    }//GEN-LAST:event_btnAddClass_HomeActionPerformed

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
        Subjects subjectsFrame = new Subjects();
        subjectsFrame.setExtendedState(Students.MAXIMIZED_BOTH);
        subjectsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSubjects_HomeActionPerformed

    private void btnRemoveClass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveClass_HomeActionPerformed
    CheckboxTableModel model = (CheckboxTableModel) ClassTable.getModel();
    List<Integer> classIdsToDelete = new ArrayList<>();
    List<String> classNamesToDelete = new ArrayList<>();
    
    // Collect selected classes
    for (int i = 0; i < model.getRowCount(); i++) {
        Boolean isSelected = (Boolean) model.getValueAt(i, 0);
        if (Boolean.TRUE.equals(isSelected)) {
            Integer classId = (Integer) model.getValueAt(i, 1);
            String className = (String) model.getValueAt(i, 2);
            
            classIdsToDelete.add(classId);
            classNamesToDelete.add(className);
        }
    }
    
    // Check if any classes are selected
    if (classIdsToDelete.isEmpty()) {
        JOptionPane.showMessageDialog(this, 
            "Please select at least one class to delete.", 
            "No Selection", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Confirm deletion
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete " + classIdsToDelete.size() + " class(es)?", 
        "Confirm Delete", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirm != JOptionPane.YES_OPTION) {
        return; // User cancelled
    }
    
    // Prepare for deletion
    Connection conn = null;
    PreparedStatement pstmt = null;
    int successfulDeletes = 0;
    List<String> failedDeletes = new ArrayList<>();
    
    try {
        // Establish database connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crms", "root", "");
        
        // Prepare delete statement
        String deleteQuery = "DELETE FROM classes WHERE class_id = ?";
        pstmt = conn.prepareStatement(deleteQuery);
        
        // Disable auto-commit for transaction support
        conn.setAutoCommit(false);
        
        // Delete each selected class
        for (int i = 0; i < classIdsToDelete.size(); i++) {
            try {
                pstmt.setInt(1, classIdsToDelete.get(i));
                int rowsAffected = pstmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    successfulDeletes++;
                } else {
                    failedDeletes.add(classNamesToDelete.get(i));
                }
            } catch (SQLException e) {
                failedDeletes.add(classNamesToDelete.get(i));
                System.err.println("Error deleting class " + classNamesToDelete.get(i) + ": " + e.getMessage());
            }
        }
        
        // Commit the transaction
        conn.commit();
        
    } catch (SQLException e) {
        // Rollback in case of any unexpected errors
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        
        JOptionPane.showMessageDialog(this, 
            "Database error: " + e.getMessage(), 
            "Database Error", 
            JOptionPane.ERROR_MESSAGE);
        return;
        
    } finally {
        // Close resources
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) {
                conn.setAutoCommit(true);
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Provide feedback to the user
    if (successfulDeletes > 0) {
        StringBuilder message = new StringBuilder();
        message.append(successfulDeletes).append(" class(es) deleted successfully");
        
        if (!failedDeletes.isEmpty()) {
            message.append("\n\nFailed to delete:").append(failedDeletes);
        }
        
        JOptionPane.showMessageDialog(this, 
            message.toString(), 
            "Deletion Result", 
            JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, 
            "No classes were deleted. Please check your selection.", 
            "Deletion Failed", 
            JOptionPane.WARNING_MESSAGE);
    }
    
    // Refresh the table

    }//GEN-LAST:event_btnRemoveClass_HomeActionPerformed

    private void btnUpdateclass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateclass_HomeActionPerformed
          CheckboxTableModel model = (CheckboxTableModel) ClassTable.getModel();
    List<Integer> selectedClassIds = new ArrayList<>();

    // Collect selected classes
    for (int i = 0; i < model.getRowCount(); i++) {
        Boolean isSelected = (Boolean) model.getValueAt(i, 0);
        if (Boolean.TRUE.equals(isSelected)) {
            Integer classId = (Integer) model.getValueAt(i, 1);
            selectedClassIds.add(classId);
        }
    }

    // Check if any classes are selected
    if (selectedClassIds.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select at least one class to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Pass the selected class IDs and the JTable to the updateclasses frame
    updateclasses updateClassesFrame = new updateclasses(this, currentTeachers_Id, selectedClassIds, ClassTable);
    updateClassesFrame.setVisible(true);
    //GEN-LAST:event_btnUpdateclass_HomeActionPerformed
    }//GEN-LAST:event_btnUpdateclass_HomeActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClassTable;
    private rojeru_san.complementos.RSButtonHover btnAddClass_Home;
    private rojeru_san.complementos.RSButtonHover btnHome_Home;
    private rojeru_san.complementos.RSButtonHover btnLogout_Home;
    private rojeru_san.complementos.RSButtonHover btnMenu_Home;
    private rojeru_san.complementos.RSButtonHover btnRemoveClass_Home;
    private rojeru_san.complementos.RSButtonHover btnStudents_Home;
    private rojeru_san.complementos.RSButtonHover btnSubjects_Home;
    private rojeru_san.complementos.RSButtonHover btnTeach_Home;
    private rojeru_san.complementos.RSButtonHover btnUpdateclass_Home;
    private rojeru_san.complementos.RSButtonHover btnUser_Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
