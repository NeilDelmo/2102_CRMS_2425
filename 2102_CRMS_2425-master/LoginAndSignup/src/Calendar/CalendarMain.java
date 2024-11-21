package Calendar;

import Dashboard.addclasses;
import Dashboard.Home;
import Dashboard.Teach;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CalendarMain extends javax.swing.JFrame {

    public CalendarMain() {
        initComponents();
         this.setExtendedState(CalendarMain.MAXIMIZED_BOTH);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUser_Calendar = new rojeru_san.complementos.RSButtonHover();
        btnMenu_Calendar = new rojeru_san.complementos.RSButtonHover();
        btnAddClass_Calendar = new rojeru_san.complementos.RSButtonHover();
        jPanel1 = new javax.swing.JPanel();
        btnHome_Calendar = new rojeru_san.complementos.RSButtonHover();
        btnCalendar_Calendar = new rojeru_san.complementos.RSButtonHover();
        btnTeach_Calendar = new rojeru_san.complementos.RSButtonHover();
        jPanel2 = new javax.swing.JPanel();
        Sun = new Calendar.Cell();
        Mon = new Calendar.Cell();
        Tues = new Calendar.Cell();
        Wed = new Calendar.Cell();
        Thurs = new Calendar.Cell();
        Fri = new Calendar.Cell();
        Sat = new Calendar.Cell();
        cell8 = new Calendar.Cell();
        cell9 = new Calendar.Cell();
        cell10 = new Calendar.Cell();
        cell11 = new Calendar.Cell();
        cell12 = new Calendar.Cell();
        cell13 = new Calendar.Cell();
        cell14 = new Calendar.Cell();
        cell15 = new Calendar.Cell();
        cell16 = new Calendar.Cell();
        cell17 = new Calendar.Cell();
        cell18 = new Calendar.Cell();
        cell19 = new Calendar.Cell();
        cell20 = new Calendar.Cell();
        cell21 = new Calendar.Cell();
        cell22 = new Calendar.Cell();
        cell23 = new Calendar.Cell();
        cell24 = new Calendar.Cell();
        cell25 = new Calendar.Cell();
        cell26 = new Calendar.Cell();
        cell27 = new Calendar.Cell();
        cell28 = new Calendar.Cell();
        cell29 = new Calendar.Cell();
        cell30 = new Calendar.Cell();
        cell31 = new Calendar.Cell();
        cell32 = new Calendar.Cell();
        cell33 = new Calendar.Cell();
        cell34 = new Calendar.Cell();
        cell35 = new Calendar.Cell();
        cell36 = new Calendar.Cell();
        cell37 = new Calendar.Cell();
        cell38 = new Calendar.Cell();
        cell39 = new Calendar.Cell();
        cell40 = new Calendar.Cell();
        cell41 = new Calendar.Cell();
        cell42 = new Calendar.Cell();
        cell43 = new Calendar.Cell();
        cell44 = new Calendar.Cell();
        cell45 = new Calendar.Cell();
        cell46 = new Calendar.Cell();
        cell47 = new Calendar.Cell();
        cell48 = new Calendar.Cell();
        cell49 = new Calendar.Cell();

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/pngwing.com (1).png"))); // NOI18N
        jLabel1.setText("Classroom");

        btnUser_Calendar.setBackground(new java.awt.Color(0, 102, 102));
        btnUser_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/user.png"))); // NOI18N

        btnMenu_Calendar.setBackground(new java.awt.Color(0, 102, 102));
        btnMenu_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/menu.png"))); // NOI18N

        btnAddClass_Calendar.setBackground(new java.awt.Color(0, 102, 102));
        btnAddClass_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/plus (1).png"))); // NOI18N
        btnAddClass_Calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClass_CalendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMenu_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddClass_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUser_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUser_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddClass_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnMenu_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(16, 16, 16))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome_Calendar.setBackground(new java.awt.Color(255, 255, 255));
        btnHome_Calendar.setForeground(new java.awt.Color(0, 0, 0));
        btnHome_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/Home.png"))); // NOI18N
        btnHome_Calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome_CalendarActionPerformed(evt);
            }
        });

        btnCalendar_Calendar.setBackground(new java.awt.Color(255, 255, 255));
        btnCalendar_Calendar.setForeground(new java.awt.Color(0, 0, 0));
        btnCalendar_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/calendar.png"))); // NOI18N
        btnCalendar_Calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendar_CalendarActionPerformed(evt);
            }
        });

        btnTeach_Calendar.setBackground(new java.awt.Color(255, 255, 255));
        btnTeach_Calendar.setForeground(new java.awt.Color(0, 0, 0));
        btnTeach_Calendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dashboard/classespng.png"))); // NOI18N
        btnTeach_Calendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeach_CalendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalendar_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTeach_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCalendar_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTeach_Calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridLayout(7, 7));

        Sun.setText("Sunday");
        Sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SunActionPerformed(evt);
            }
        });
        jPanel2.add(Sun);

        Mon.setText("Monday");
        Mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonActionPerformed(evt);
            }
        });
        jPanel2.add(Mon);

        Tues.setText("Tuesday");
        Tues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TuesActionPerformed(evt);
            }
        });
        jPanel2.add(Tues);

        Wed.setText("Wednesday");
        jPanel2.add(Wed);

        Thurs.setText("Thursday");
        jPanel2.add(Thurs);

        Fri.setText("Friday");
        jPanel2.add(Fri);

        Sat.setText("Saturday");
        jPanel2.add(Sat);

        cell8.setText("cell8");
        jPanel2.add(cell8);

        cell9.setText("cell9");
        jPanel2.add(cell9);

        cell10.setText("cell1");
        jPanel2.add(cell10);

        cell11.setText("cell1");
        jPanel2.add(cell11);

        cell12.setText("cell1");
        jPanel2.add(cell12);

        cell13.setText("cell1");
        jPanel2.add(cell13);

        cell14.setText("cell1");
        jPanel2.add(cell14);

        cell15.setText("cell1");
        jPanel2.add(cell15);

        cell16.setText("cell1");
        jPanel2.add(cell16);

        cell17.setText("cell1");
        jPanel2.add(cell17);

        cell18.setText("cell1");
        jPanel2.add(cell18);

        cell19.setText("cell1");
        jPanel2.add(cell19);

        cell20.setText("cell1");
        jPanel2.add(cell20);

        cell21.setText("cell1");
        jPanel2.add(cell21);

        cell22.setText("cell1");
        jPanel2.add(cell22);

        cell23.setText("cell1");
        jPanel2.add(cell23);

        cell24.setText("cell1");
        jPanel2.add(cell24);

        cell25.setText("cell1");
        jPanel2.add(cell25);

        cell26.setText("cell1");
        jPanel2.add(cell26);

        cell27.setText("cell1");
        jPanel2.add(cell27);

        cell28.setText("cell1");
        jPanel2.add(cell28);

        cell29.setText("cell1");
        jPanel2.add(cell29);

        cell30.setText("cell1");
        jPanel2.add(cell30);

        cell31.setText("cell1");
        jPanel2.add(cell31);

        cell32.setText("cell1");
        jPanel2.add(cell32);

        cell33.setText("cell1");
        jPanel2.add(cell33);

        cell34.setText("cell1");
        jPanel2.add(cell34);

        cell35.setText("cell1");
        jPanel2.add(cell35);

        cell36.setText("cell1");
        jPanel2.add(cell36);

        cell37.setText("cell1");
        jPanel2.add(cell37);

        cell38.setText("cell1");
        jPanel2.add(cell38);

        cell39.setText("cell1");
        jPanel2.add(cell39);

        cell40.setText("cell1");
        jPanel2.add(cell40);

        cell41.setText("cell1");
        jPanel2.add(cell41);

        cell42.setText("cell1");
        jPanel2.add(cell42);

        cell43.setText("cell1");
        jPanel2.add(cell43);

        cell44.setText("cell1");
        jPanel2.add(cell44);

        cell45.setText("cell1");
        jPanel2.add(cell45);

        cell46.setText("cell1");
        jPanel2.add(cell46);

        cell47.setText("cell1");
        jPanel2.add(cell47);

        cell48.setText("cell1");
        jPanel2.add(cell48);

        cell49.setText("cell1");
        jPanel2.add(cell49);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btnHome_CalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome_CalendarActionPerformed
    Home homeFrame = new Home();
    homeFrame.setExtendedState(Home.MAXIMIZED_BOTH); // Set full screen
    homeFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnHome_CalendarActionPerformed

    private void btnCalendar_CalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendar_CalendarActionPerformed
     JOptionPane.showMessageDialog(new JFrame(), "You are already in the calendar window.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnCalendar_CalendarActionPerformed

    private void btnTeach_CalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeach_CalendarActionPerformed
    Teach teachFrame = new Teach();
    teachFrame.setExtendedState(Teach.MAXIMIZED_BOTH); // Set full screen
    teachFrame.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnTeach_CalendarActionPerformed

    private void SunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SunActionPerformed

    private void MonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonActionPerformed

    private void TuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TuesActionPerformed

    private void btnAddClass_CalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClass_CalendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddClass_CalendarActionPerformed

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
            java.util.logging.Logger.getLogger(CalendarMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalendarMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalendarMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalendarMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CalendarMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Calendar.Cell Fri;
    private Calendar.Cell Mon;
    private Calendar.Cell Sat;
    private Calendar.Cell Sun;
    private Calendar.Cell Thurs;
    private Calendar.Cell Tues;
    private Calendar.Cell Wed;
    private rojeru_san.complementos.RSButtonHover btnAddClass_Calendar;
    private rojeru_san.complementos.RSButtonHover btnCalendar_Calendar;
    private rojeru_san.complementos.RSButtonHover btnHome_Calendar;
    private rojeru_san.complementos.RSButtonHover btnMenu_Calendar;
    private rojeru_san.complementos.RSButtonHover btnTeach_Calendar;
    private rojeru_san.complementos.RSButtonHover btnUser_Calendar;
    private Calendar.Cell cell10;
    private Calendar.Cell cell11;
    private Calendar.Cell cell12;
    private Calendar.Cell cell13;
    private Calendar.Cell cell14;
    private Calendar.Cell cell15;
    private Calendar.Cell cell16;
    private Calendar.Cell cell17;
    private Calendar.Cell cell18;
    private Calendar.Cell cell19;
    private Calendar.Cell cell20;
    private Calendar.Cell cell21;
    private Calendar.Cell cell22;
    private Calendar.Cell cell23;
    private Calendar.Cell cell24;
    private Calendar.Cell cell25;
    private Calendar.Cell cell26;
    private Calendar.Cell cell27;
    private Calendar.Cell cell28;
    private Calendar.Cell cell29;
    private Calendar.Cell cell30;
    private Calendar.Cell cell31;
    private Calendar.Cell cell32;
    private Calendar.Cell cell33;
    private Calendar.Cell cell34;
    private Calendar.Cell cell35;
    private Calendar.Cell cell36;
    private Calendar.Cell cell37;
    private Calendar.Cell cell38;
    private Calendar.Cell cell39;
    private Calendar.Cell cell40;
    private Calendar.Cell cell41;
    private Calendar.Cell cell42;
    private Calendar.Cell cell43;
    private Calendar.Cell cell44;
    private Calendar.Cell cell45;
    private Calendar.Cell cell46;
    private Calendar.Cell cell47;
    private Calendar.Cell cell48;
    private Calendar.Cell cell49;
    private Calendar.Cell cell8;
    private Calendar.Cell cell9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    // End of variables declaration//GEN-END:variables
}
