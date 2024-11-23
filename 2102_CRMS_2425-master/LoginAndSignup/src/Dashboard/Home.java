package Dashboard;

import javax.swing.JOptionPane;
import Calendar.CalendarMain;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loginandsignup.Login;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
         this.setExtendedState(Home.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        jLabel3 = new javax.swing.JLabel();
        rSCalendarBeanInfo1 = new rojeru_san.componentes.RSCalendarBeanInfo();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnMenu_Home = new rojeru_san.complementos.RSButtonHover();
        btnAddClass_Home = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Home = new rojeru_san.complementos.RSButtonHover();
        btnCalendar_Home = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Home = new rojeru_san.complementos.RSButtonHover();
        btnUser_Home = new rojeru_san.complementos.RSButtonHover();
        btnLogout_Home = new rojeru_san.complementos.RSButtonHover();
        btnStudents_Home = new rojeru_san.complementos.RSButtonHover();
        jLabel5 = new javax.swing.JLabel();

        rSButtonHover1.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover1.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/Home.png"))); // NOI18N
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });

        rSButtonHover2.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover2.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonHover2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/calendar.png"))); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });

        rSButtonHover3.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover3.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonHover3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/classespng.png"))); // NOI18N
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/plus (1).png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddClass_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMenu_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16))
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

        btnCalendar_Home.setBackground(new java.awt.Color(255, 255, 255));
        btnCalendar_Home.setForeground(new java.awt.Color(0, 0, 0));
        btnCalendar_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/calendar.png"))); // NOI18N
        btnCalendar_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendar_HomeActionPerformed(evt);
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
                    .addComponent(btnCalendar_Home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalendar_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTeach_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStudents_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setText("Home");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346)
                .addComponent(jLabel5)
                .addContainerGap(450, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385)
                .addComponent(jLabel5)
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void btnHome_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_HomeActionPerformed
    JOptionPane.showMessageDialog(new JFrame(), "You are already in the home window.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnHome_HomeActionPerformed

    private void btnCalendar_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendar_HomeActionPerformed
    CalendarMain calendarFrame = new CalendarMain();
    calendarFrame.setExtendedState(CalendarMain.MAXIMIZED_BOTH); // Set full screen
    calendarFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCalendar_HomeActionPerformed

    private void btnTeach_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_HomeActionPerformed
    Teach teachFrame = new Teach();
    teachFrame.setExtendedState(Teach.MAXIMIZED_BOTH); // Set full screen
    teachFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnTeach_HomeActionPerformed

    private void btnAddClass_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClass_HomeActionPerformed
        // TODO add your handling code here:
         addclasses addclassesFrame = new addclasses();
         addclassesFrame.setVisible(true);
         this.dispose();
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
    private rojeru_san.complementos.RSButtonHover btnAddClass_Home;
    private rojeru_san.complementos.RSButtonHover btnCalendar_Home;
    private rojeru_san.complementos.RSButtonHover btnHome_Home;
    private rojeru_san.complementos.RSButtonHover btnLogout_Home;
    private rojeru_san.complementos.RSButtonHover btnMenu_Home;
    private rojeru_san.complementos.RSButtonHover btnStudents_Home;
    private rojeru_san.complementos.RSButtonHover btnTeach_Home;
    private rojeru_san.complementos.RSButtonHover btnUser_Home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.componentes.RSCalendarBeanInfo rSCalendarBeanInfo1;
    // End of variables declaration//GEN-END:variables
}
