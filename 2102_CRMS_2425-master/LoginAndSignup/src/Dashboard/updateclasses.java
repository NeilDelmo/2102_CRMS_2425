package Dashboard;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author L E N O V O
 */
public class updateclasses extends javax.swing.JFrame {

    private Home homeFrame;
    private int loggedInTeachers_id; // Store the ID of the logged-in teacher
    private List<Integer> selectedClassIds;
    private JTable classesTable; // Add this variable

    public updateclasses(Home homeFrame, int teachers_Id, List<Integer> selectedClassIds, JTable classesTable) {
        this.homeFrame = homeFrame;
        this.loggedInTeachers_id = teachers_Id;
        this.selectedClassIds = selectedClassIds;
        this.classesTable = classesTable; // Assign the passed JTable
        initComponents();
        setButtonStyles();
        setupKeyNavigation();
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(Update);

        // Load the selected classes for updating (if needed)
        loadSelectedClasses();
    }

    private void loadSelectedClasses() {
        // Logic to load class details based on selectedClassIds
        // You can query the database for class details using the selected IDs
        String url = "jdbc:mysql://localhost:3306/crms";
        String user = "root";
        String password = "";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, user, password);

            // Prepare the query to get class details for the selected IDs
            StringBuilder queryBuilder = new StringBuilder("SELECT class_name, section, subject, room FROM classes WHERE class_id IN (");
            for (int i = 0; i < selectedClassIds.size(); i++) {
                queryBuilder.append("?");
                if (i < selectedClassIds.size() - 1) {
                    queryBuilder.append(",");
                }
            }
            queryBuilder.append(")");

            pstmt = conn.prepareStatement(queryBuilder.toString());

            // Set the parameters for the prepared statement
            for (int i = 0; i < selectedClassIds.size(); i++) {
                pstmt.setInt(i + 1, selectedClassIds.get(i));
            }

            rs = pstmt.executeQuery();

            // Assuming you have text fields to display the class details
            while (rs.next()) {
                String className = rs.getString("class_name");
                String section = rs.getString("section");
                String subject = rs.getString("subject");
                String room = rs.getString("room");

                // Set the values in the respective fields
                ClassName.setText(className);
                Section.setText(section);
                Subject.setText(subject);
                Room.setText(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading class details: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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

    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms"; // Change to your database name
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASS = ""; // Change to your MySQL password

    public updateclasses() {
        initComponents();
        setButtonStyles();
        setupKeyNavigation(); // Call to set up key navigation
        this.setLocationRelativeTo(null);

        // Set default button
        getRootPane().setDefaultButton(Update);
    }

    private void setupKeyNavigation() {
        ClassName.addActionListener(evt -> Section.requestFocusInWindow());
        Section.addActionListener(evt -> Subject.requestFocusInWindow());
        Subject.addActionListener(evt -> Room.requestFocusInWindow());
        Room.addActionListener(evt -> UpdateActionPerformed(null)); // Call update action on Enter

        // Add action listener for Cancel button
        CancelButton.addActionListener(evt -> dispose());

        // Add action listener for Update button only once
        Update.addActionListener(evt -> UpdateActionPerformed(evt));

        // Global key listener for ESC to close the window
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
                    dispose();
                }
            }
        });
    }

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
        ClassName = new app.bolivia.swing.JCTextField();
        Section = new app.bolivia.swing.JCTextField();
        Subject = new app.bolivia.swing.JCTextField();
        Room = new app.bolivia.swing.JCTextField();
        Update = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Update Classses");

        ClassName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Class Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        ClassName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClassNameActionPerformed(evt);
            }
        });

        Section.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        Subject.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        Room.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Room", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(Update))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ClassName, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addComponent(Section, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Subject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Room, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Section, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Room, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(CancelButton))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setButtonStyles() {
        // Create button style
        Update.setBackground(new Color(255, 255, 255, 0)); // Transparent background
        Update.setForeground(Color.BLACK); // Black text
        Update.setBorder(BorderFactory.createEmptyBorder()); // No border
        Update.setFocusPainted(false); // Remove focus outline
        Update.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
        Update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

        // Cancel button style
        CancelButton.setBackground(new Color(255, 255, 255, 0)); // Transparent background
        CancelButton.setForeground(Color.BLACK); // Black text
        CancelButton.setBorder(BorderFactory.createEmptyBorder()); // No border
        CancelButton.setFocusPainted(false); // Remove focus outline
        CancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
        CancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

        // Add mouse listeners for hover effects
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Update.setForeground(new Color(0, 120, 60)); // Change text color on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Update.setForeground(Color.BLACK); // Original text color
            }
        });

        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CancelButton.setForeground(new Color(200, 0, 0)); // Change text color on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CancelButton.setForeground(Color.BLACK); // Original text color
            }
        });
    }
    private void ClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClassNameActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        String className = ClassName.getText().trim();
        String section = Section.getText().trim();
        String subject = Subject.getText().trim();
        String room = Room.getText().trim();

        // Assuming you have a way to get the class ID to update
        int classId = getClassIdToUpdate(); // Implement this method to retrieve the class ID

        if (classId < 0) {
            JOptionPane.showMessageDialog(this, "No class selected for update.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (className.isEmpty() || section.isEmpty() || subject.isEmpty() || room.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        

        // Update the SQL statement with the correct column name
        String updateSQL = "UPDATE classes SET class_name = ?, section = ?, subject = ?, room = ? WHERE class_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setString(1, className);
            pstmt.setString(2, section);
            pstmt.setString(3, subject);
            pstmt.setString(4, room);
            pstmt.setInt(5, classId); // Use the class ID to identify the record to update

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Class updated successfully!");

                // Refresh classes in the Home frame
                if (homeFrame != null) {
                    homeFrame.loadClasses(); // Call loadClasses to refresh the table
                }

                // Optionally clear the fields
                ClassName.setText("");
                Section.setText("");
                Subject.setText("");
                Room.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update class.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating class: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private int getClassIdToUpdate() {
        // Logic to retrieve the selected class ID from your JTable or another source
        int selectedRow = classesTable.getSelectedRow();
        if (selectedRow >= 0) {
            return (int) classesTable.getValueAt(selectedRow, 1); // Assuming the Class ID is in the second column (index 1)
        }
        return -1; // Indicate no selection
    }

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
            java.util.logging.Logger.getLogger(updateclasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateclasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateclasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateclasses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateclasses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private app.bolivia.swing.JCTextField ClassName;
    private app.bolivia.swing.JCTextField Room;
    private app.bolivia.swing.JCTextField Section;
    private app.bolivia.swing.JCTextField Subject;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
