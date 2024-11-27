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

/**
 *
 * @author L E N O V O
 */
public class updateclasses extends javax.swing.JFrame {
    private Home homeFrame;
    private int loggedInTeacherId; // Store the ID of the logged-in teacher

    updateclasses(Home aThis, int currentTeacherId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    // Add setter/getter
    public void setLoggedInTeacherId(int teacherId) {
        this.loggedInTeacherId = teacherId;
    }
    
    public int getLoggedInTeacherId() {
        return this.loggedInTeacherId;
    }
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crms"; // Change to your database name
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASS = ""; // Change to your MySQL password
    
     public updateclasses(int teacherId) {
        this.homeFrame = homeFrame; // Store reference to Home frame
        this.loggedInTeacherId = teacherId; // Store teacher ID
        initComponents();
        setButtonStyles();
        setupKeyNavigation();
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(CreateButton);
    }

     public updateclasses() {
        initComponents();
        setButtonStyles();
        setupKeyNavigation(); // Call to set up key navigation
        this.setLocationRelativeTo(null);
        
        // Set default button
        getRootPane().setDefaultButton(CreateButton);
    }
     
      private void setupKeyNavigation() {
        // Set up focus traversal
        // Add key listener to allow moving between text fields using Enter key
        ClassName.addActionListener(evt -> Section.requestFocusInWindow());
        Section.addActionListener(evt -> Subject.requestFocusInWindow());
        Subject.addActionListener(evt -> Room.requestFocusInWindow());
        Room.addActionListener(evt -> CreateButtonActionPerformed(null));

        // Add action listener for Cancel button
        CancelButton.addActionListener(evt -> dispose());
        
        // Add action listener for Create button
        CreateButton.addActionListener(evt -> CreateButtonActionPerformed(null));

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
        CreateButton = new javax.swing.JButton();
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

        CreateButton.setText("Update");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
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
                        .addComponent(CreateButton))
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
                    .addComponent(CreateButton)
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
    private void ClassNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClassNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClassNameActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        String className = ClassName.getText().trim();
        String section = Section.getText().trim();
        String subject = Subject.getText().trim();
        String room = Room.getText().trim();
        
        if (className.isEmpty() || section.isEmpty() || subject.isEmpty() || room.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String insertSQL = "INSERT INTO classes(class_name, section, subject, room, teacher_id) VALUES(?, ?, ?, ?, ?)"; 
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
         
            pstmt.setString(1, className);
            pstmt.setString(2, section);
            pstmt.setString(3, subject);
            pstmt.setString(4, room);
            pstmt.setInt(5, loggedInTeacherId); // Use the stored teacher ID
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Class added successfully!");
                
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
                JOptionPane.showMessageDialog(this, "Failed to add class.", "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding class: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CreateButtonActionPerformed

   
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
    private javax.swing.JButton CreateButton;
    private app.bolivia.swing.JCTextField Room;
    private app.bolivia.swing.JCTextField Section;
    private app.bolivia.swing.JCTextField Subject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
