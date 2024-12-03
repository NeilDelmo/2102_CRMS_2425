package Dashboard;

import java.awt.Color;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

/**
 *
 * @author L E N O V O
 */
public class AddSection extends javax.swing.JFrame {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms"; // Change to your database name
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASS = ""; // Change to your MySQL password

    public AddSection() {
        initComponents();
        setButtonStyles();
        this.setLocationRelativeTo(null); //to make it centralized
        setupEnterKeyNavigation();
        CreateButton.setText("Create"); // Fix button text
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fix close operation
    }
    private void setupEnterKeyNavigation() {
     // Add key listeners to each text field
        sectionName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sectionCode.requestFocus();
                }
            }
        });

        sectionCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    validateAndCreateSection();
                }
            }
        });
}
private void validateAndCreateSection() {
    String sectionNameText = sectionName.getText().trim();
    String sectionCodeText = sectionCode.getText().trim();

    // Validate input fields
    if (sectionNameText.isEmpty() || sectionCodeText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Ensure section code is a valid integer
    int section_code; 
    try {
        section_code = Integer.parseInt(sectionCodeText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Section code must be a number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the section code already exists before proceeding
    if (sectionCodeExists(section_code)) {
        JOptionPane.showMessageDialog(this, "Section code already exists. Please use a unique code.",
                "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // If validation passes, proceed with creating the section
    CreateSection(sectionNameText, section_code);
}

private boolean sectionCodeExists(int section_code) {
    String query = "SELECT COUNT(*) FROM sections WHERE section_code = ?";

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, section_code); // Move this up before executing query
        try (ResultSet rs = pstmt.executeQuery()) { // Use try-with-resources for ResultSet
            if (rs.next()) {
                return rs.getInt(1) > 0; // If count is greater than 0, it exists
            }
        }
    } catch (SQLException e) {
        System.err.println("SQL Error: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Database query error: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
    }
    return false; // Return false if no existing section or an error occurred
}
     
  private void CreateSection(String sectionNameText, int sectionCode) {
    // SQL insert statement for the sections table
    String insertSQL = "INSERT INTO sections (section_name, section_code, student_count) VALUES (?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

        pstmt.setString(1, sectionNameText);
        pstmt.setInt(2, sectionCode);
        pstmt.setInt(3, 0); // Initialize student_count to 0

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Section created successfully!");
            clearFields();
 
            // Load the sections after insertion
            for (java.awt.Window window : java.awt.Window.getWindows()) {
                if (window instanceof Sections && window.isVisible()) {
                    ((Sections) window).LoadSections(); // Ensure this method fetches current DB state
                    break;
                }
            }

            dispose(); // Close the add section window
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create section.",
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
    // Try to log or print the error
        System.err.println("SQL Exception: Code: " + ex.getErrorCode() + ", State: " + ex.getSQLState());

        // User-friendly error message
        if ("23000".equals(ex.getSQLState()) || ex.getMessage().contains("Duplicate")) {
            JOptionPane.showMessageDialog(this, "Section code already exists. Please use a unique code.",
                    "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error creating section. Please try again later.",
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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
        sectionName = new app.bolivia.swing.JCTextField();
        sectionCode = new app.bolivia.swing.JCTextField();
        CancelButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Section ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 18, -1, -1));

        sectionName.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Section Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        sectionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionNameActionPerformed(evt);
            }
        });
        jPanel1.add(sectionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 61, 467, 50));

        sectionCode.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Section Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 2, 14))); // NOI18N
        jPanel1.add(sectionCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 129, 467, 50));

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 191, -1, -1));

        CreateButton.setText("Add");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CreateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 191, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private void sectionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionNameActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        validateAndCreateSection();
        
    }//GEN-LAST:event_CreateButtonActionPerformed
private void clearFields() {
    sectionName.setText("");
    sectionCode.setText("");
    sectionName.requestFocus(); // Set focus back to first name field
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
            java.util.logging.Logger.getLogger(AddSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private app.bolivia.swing.JCTextField sectionCode;
    private app.bolivia.swing.JCTextField sectionName;
    // End of variables declaration//GEN-END:variables
}
