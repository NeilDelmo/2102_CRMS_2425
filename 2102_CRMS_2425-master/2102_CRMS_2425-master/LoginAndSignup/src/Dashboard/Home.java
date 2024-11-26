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
   private static int currentTeacherId;

    // Static method to set the current teacher ID
    public static void setCurrentTeacherId(int teacherId) {
        currentTeacherId = teacherId;
    }

    // Static method to get the current teacher ID (optional, but can be useful)
    public static int getCurrentTeacherId() {
        return currentTeacherId;
    }
    
    public Home(){
        initComponents();
        setupTableWithCheckboxes();
        loadClasses();
        setButtonStyles();
        logResourcePaths();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
    }
    
public Home(int teacherId) {
    currentTeacherId = teacherId;
    initComponents();
    setupTableWithCheckboxes();
    loadClasses();
    setButtonStyles();
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
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Home = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Home = new rojeru_san.complementos.RSButtonHover();
        btnUser_Home = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Home = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Home = new rojeru_san.complementos.RSButtonHover();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/Classlogo.png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnMenu_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/menu.png"))); // NOI18N
        btnMenu_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu_HomeActionPerformed(evt);
            }
        });

        btnAddClass_Home.setBackground(new java.awt.Color(0, 102, 102));
        btnAddClass_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/plus (1).png"))); // NOI18N
        btnAddClass_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClass_HomeActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 102, 102));
        Update.setText("UPDATE");
        Update.setMaximumSize(new java.awt.Dimension(75, 30));
        Update.setMinimumSize(new java.awt.Dimension(75, 30));
        Update.setPreferredSize(new java.awt.Dimension(75, 30));

        Delete.setBackground(new java.awt.Color(0, 102, 102));
        Delete.setText("DELETE");
        Delete.setPreferredSize(new java.awt.Dimension(75, 30));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
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
                .addGap(486, 486, 486)
                .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/Home.png"))); // NOI18N
        btnHome_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_HomeActionPerformed(evt);
            }
        });

        btnTeach_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnTeach_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnTeach_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/classespng.png"))); // NOI18N
        btnTeach_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeach_HomeActionPerformed(evt);
            }
        });

        btnUser_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnUser_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/user.png"))); // NOI18N
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
        btnStudents_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/Students.png"))); // NOI18N
        btnStudents_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudents_HomeActionPerformed(evt);
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
                    .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUser_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(btnHome_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ClassID", "Class Name", "Section", "Room", "TeacherID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        JOptionPane.showMessageDialog(new JFrame(), "You are already in the home window.", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnHome_HomeActionPerformed
    private void setupTableWithCheckboxes() {
        CheckboxTableModel model = new CheckboxTableModel(); // No need for rows and columns in constructor
        jTable1.setModel(model);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(new CheckboxRenderer());
    }

    public static class CheckboxTableModel extends AbstractTableModel {
     private Vector<Vector<Object>> data;
    private String[] columnNames = {"Selected", "Class ID", "Class Name", "Section", "Subject", "Room"};
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

   private void setButtonStyles() {
    // Update button style
    Update.setBackground(new Color(255, 255, 255, 0)); // Transparent background
    Update.setForeground(Color.WHITE); // Black text
    Update.setBorder(BorderFactory.createEmptyBorder()); // No border
    Update.setFocusPainted(false); // Remove focus outline
    Update.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
    Update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

    // Delete button style
    Delete.setBackground(new Color(255, 255, 255, 0)); // Transparent background
    Delete.setForeground(Color.WHITE); // Black text
    Delete.setBorder(BorderFactory.createEmptyBorder()); // No border
    Delete.setFocusPainted(false); // Remove focus outline
    Delete.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
    Delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

    // Add mouse listeners for hover 
    Update.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Update.setForeground(new Color(255, 165, 0)); // Change text color on hover
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            Update.setForeground(Color.BLACK); // Original text color
        }
    });

    Delete.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            Delete.setForeground(new Color(200, 0, 0)); // Change text color on hover
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent evt) {
            Delete.setForeground(Color.BLACK); // Original text color
        }
    });
}

public void loadClasses() {
    System.out.println("Current Teacher ID: " + currentTeacherId);
    String url = "jdbc:mysql://localhost:3306/crms";
    String user = "root";
    String password = "";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DriverManager.getConnection(url, user, password);
    
        // Modify query to filter classes by teacher ID
        String query = "SELECT class_id, class_name, section, subject, room " +
                       "FROM classes " +
                       "WHERE teacher_id = ?";
    
        pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, currentTeacherId);
    
        rs = pstmt.executeQuery();
    
        CheckboxTableModel model = (CheckboxTableModel) jTable1.getModel();
        model.clear(); // Clear existing rows

        while (rs.next()) {
            Boolean checkboxState = false; // Initialize checkbox state to false
            Integer classId = rs.getInt("class_id");
            String className = rs.getString("class_name");
            String section = rs.getString("section");
            String subject = rs.getString("subject");
            String room = rs.getString("room");

            System.out.println("Adding row: " + checkboxState + ", " + classId + ", " + className + ", " + section + ", " + subject + ", " + room);

            Object[] rowData = {
                checkboxState, // Checkbox initially unchecked
                classId,       // Class ID
                className,     // Class Name
                section,       // Section
                subject,       // Subject
                room           // Room
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

    private void btnTeach_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_HomeActionPerformed
    Teach teachFrame = new Teach();
    teachFrame.setExtendedState(Teach.MAXIMIZED_BOTH); // Set full screen
    teachFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnTeach_HomeActionPerformed

    private void btnAddClass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClass_HomeActionPerformed
        // TODO add your handling code here:
     // Pass the current teacher ID to the addclasses frame
    addclasses addClassesFrame = new addclasses(this,currentTeacherId);
    addClassesFrame.setVisible(true);
    }//GEN-LAST:event_btnAddClass_HomeActionPerformed

    private void btnMenu_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu_HomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenu_HomeActionPerformed

    private void btnUser_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUser_HomeActionPerformed
        // TODO add your handling code here:
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

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
     CheckboxTableModel model = (CheckboxTableModel) jTable1.getModel();
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
    loadClasses();

    }//GEN-LAST:event_DeleteActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton Update;
    private rojeru_san.complementos.RSButtonHover btnAddClass_Home;
    private rojeru_san.complementos.RSButtonHover btnHome_Home;
    private rojeru_san.complementos.RSButtonHover btnLogout_Home;
    private rojeru_san.complementos.RSButtonHover btnMenu_Home;
    private rojeru_san.complementos.RSButtonHover btnStudents_Home;
    private rojeru_san.complementos.RSButtonHover btnTeach_Home;
    private rojeru_san.complementos.RSButtonHover btnUser_Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
