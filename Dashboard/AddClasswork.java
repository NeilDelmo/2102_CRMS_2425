package Dashboard;

import java.awt.Color;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author L E N O V O
 */
public class AddClasswork extends javax.swing.JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms"; // Change to your database name
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASS = ""; // Change to your MySQL password

    public AddClasswork() {
        initComponents();
        setButtonStyles();
        this.setLocationRelativeTo(null); //to make it centralized
        setupEnterKeyNavigation();
        loadSections();
    }

    private void loadSections() {
    String query = "SELECT section_code FROM sections";
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        sectionsComboBox.removeAllItems(); // Clear existing items
        sectionsComboBox.addItem("Select a Section"); // Add a default prompt

        while (rs.next()) {
            sectionsComboBox.addItem(rs.getString("section_code"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading sections: " + ex.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void setupEnterKeyNavigation() {
    firstName.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                lastName.requestFocus();
            }
        }
    });

    lastName.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                sectionsComboBox.requestFocus();
            }
        }
    });

    sectionsComboBox.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                validateAndCreateStudent();
            }
        }
    });
}

    private void validateAndCreateStudent() {
        String firstNameText = firstName.getText().trim();
        String lastNameText = lastName.getText().trim();
        String selectedSection = (String) sectionsComboBox.getSelectedItem();

        if (firstNameText.isEmpty() || lastNameText.isEmpty() || selectedSection == null) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields and select a section.", 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

        // If validation passes, proceed with creating the student
        createStudent(firstNameText, lastNameText, selectedSection);
    }

 private void createStudent(String firstNameText, String lastNameText, String sectionCode) {
    String insertStudentSQL = "INSERT INTO students (student_firstname, student_lastname) VALUES (?, ?)";
    String getLastInsertedStudentSQL = "SELECT LAST_INSERT_ID() AS student_id";
    String updateSectionSQL = "UPDATE sections SET student_id = ? WHERE section_code = ?"; // Ensure section_code matches the type in the database

    Connection conn = null;
    try {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        conn.setAutoCommit(false); // Start transaction

        // Insert student
        int studentId = 0; // Initialize studentId
        try (PreparedStatement pstmtStudent = conn.prepareStatement(insertStudentSQL)) {
            pstmtStudent.setString(1, firstNameText);
            pstmtStudent.setString(2, lastNameText);
            
            int rowsAffected = pstmtStudent.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Creating student failed, no rows affected.");
            }

            // Get the last inserted student ID
            try (PreparedStatement pstmtLastId = conn.prepareStatement(getLastInsertedStudentSQL);
                 ResultSet rs = pstmtLastId.executeQuery()) {
                
                if (rs.next()) {
                    studentId = rs.getInt("student_id");
                } else {
                    throw new SQLException("Failed to retrieve last inserted student ID");
                }
            }
        }

        // Update section with student ID
        try (PreparedStatement pstmtSection = conn.prepareStatement(updateSectionSQL)) {
            pstmtSection.setInt(1, studentId);
            pstmtSection.setString(2, sectionCode); // Use sectionCode as is, without parsing
            
            int sectionRowsAffected = pstmtSection.executeUpdate();
            if (sectionRowsAffected == 0) {
                throw new SQLException("Updating section failed, no rows affected. Check if section code is valid.");
            }
        }

        conn.commit(); // Commit transaction
        JOptionPane.showMessageDialog(this, "Student added successfully!");
        clearFields();

    } catch (SQLException ex) {
        // Rollback transaction in case of error
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error adding student: " + ex.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Restore auto-commit and close connection
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
    
    
    public class PopulateComboBox {

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
        firstName = new app.bolivia.swing.JCTextField();
        lastName = new app.bolivia.swing.JCTextField();
        CancelButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        sectionsComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Student");

        firstName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        lastName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Add");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        sectionsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sections" }));
        sectionsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addComponent(lastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sectionsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CreateButton)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton)
                    .addComponent(CreateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setButtonStyles() {
        // Create button style
        CreateButton.setBackground(new Color(255, 255, 255, 0)); // Transparent background
        CreateButton.setForeground(Color.BLACK); // Black text
        CreateButton.setBorder(BorderFactory.createEmptyBorder()); // No border
        CreateButton.setFocusPainted(false); // Remove focus outline
        CreateButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
        CreateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

        // Cancel button style
        CancelButton.setBackground(new Color(255, 255, 255, 0)); // Transparent background
        CancelButton.setForeground(Color.BLACK); // Black text
        CancelButton.setBorder(BorderFactory.createEmptyBorder()); // No border
        CancelButton.setFocusPainted(false); // Remove focus outline
        CancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Regular font
        CancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Hand cursor on hover

        // Add mouse listeners for hover effects
        CreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CreateButton.setForeground(new Color(0, 120, 60)); // Change text color on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CreateButton.setForeground(Color.BLACK); // Original text color
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
    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        validateAndCreateStudent();

    }//GEN-LAST:event_CreateButtonActionPerformed

    private void sectionsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionsComboBoxActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_sectionsComboBoxActionPerformed

    public String getSection() {
        String section = (String) sectionsComboBox.getSelectedItem();
        return section;
    }

    private void clearFields() {
        firstName.setText("");
        lastName.setText("");
        firstName.requestFocus(); // Set focus back to first name field
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
            java.util.logging.Logger.getLogger(AddClasswork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClasswork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClasswork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClasswork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AddClasswork().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private app.bolivia.swing.JCTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private app.bolivia.swing.JCTextField lastName;
    private javax.swing.JComboBox<String> sectionsComboBox;
    // End of variables declaration//GEN-END:variables
}
