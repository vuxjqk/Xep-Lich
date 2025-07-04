/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dto.User;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class pnlDashboard extends javax.swing.JPanel {

    JFrame frm;
    JPanel pnlLogin;
    User user;

    private void setLayout(JPanel pnl) {
        pnlContent.removeAll();
        pnlContent.setLayout(new BorderLayout());
        pnlContent.add(pnl, BorderLayout.CENTER);
        pnlContent.revalidate();
        pnlContent.repaint();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        lblUsername.setText(user.username());
        if (user.role().equals("admin")) {
            btnProfile.setVisible(false);
            btnDaysOff.setVisible(false);
            btnWeeklySchedule.setVisible(false);
        } else {
            btnDoctor.setVisible(false);
            btnRoom.setVisible(false);
            btnSchedule.setVisible(false);
        }
    }

    /**
     * Creates new form pnlDashboard
     *
     * @param frm
     * @param pnlLogin
     * @param user
     */
    public pnlDashboard(JFrame frm, JPanel pnlLogin, User user) {
        initComponents();
        this.frm = frm;
        this.pnlLogin = pnlLogin;
        this.user = user;
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
        lblUsername = new javax.swing.JLabel();
        btnSchedule = new javax.swing.JButton();
        btnDoctor = new javax.swing.JButton();
        btnRoom = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnDaysOff = new javax.swing.JButton();
        btnWeeklySchedule = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();

        setBackground(new java.awt.Color(240, 248, 255));

        jPanel1.setBackground(new java.awt.Color(240, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(8, 1));

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("username");
        jPanel1.add(lblUsername);

        btnSchedule.setBackground(new java.awt.Color(100, 149, 237));
        btnSchedule.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/plus-solid.png"))); // NOI18N
        btnSchedule.setText("Tạo & chạy lịch");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });
        jPanel1.add(btnSchedule);

        btnDoctor.setBackground(new java.awt.Color(100, 149, 237));
        btnDoctor.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnDoctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/user-doctor-solid.png"))); // NOI18N
        btnDoctor.setText("Quản lý bác sĩ");
        btnDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoctor);

        btnRoom.setBackground(new java.awt.Color(100, 149, 237));
        btnRoom.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/hospital-solid.png"))); // NOI18N
        btnRoom.setText("Quản lý phòng");
        btnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomActionPerformed(evt);
            }
        });
        jPanel1.add(btnRoom);

        btnProfile.setBackground(new java.awt.Color(100, 149, 237));
        btnProfile.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/address-card-solid.png"))); // NOI18N
        btnProfile.setText("Hồ sơ bác sĩ");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });
        jPanel1.add(btnProfile);

        btnDaysOff.setBackground(new java.awt.Color(100, 149, 237));
        btnDaysOff.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDaysOff.setForeground(new java.awt.Color(255, 255, 255));
        btnDaysOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/power-off-solid.png"))); // NOI18N
        btnDaysOff.setText("Chọn ngày nghỉ");
        btnDaysOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaysOffActionPerformed(evt);
            }
        });
        jPanel1.add(btnDaysOff);

        btnWeeklySchedule.setBackground(new java.awt.Color(100, 149, 237));
        btnWeeklySchedule.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnWeeklySchedule.setForeground(new java.awt.Color(255, 255, 255));
        btnWeeklySchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/calendar-solid.png"))); // NOI18N
        btnWeeklySchedule.setText("Xem lịch tuần");
        btnWeeklySchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWeeklyScheduleActionPerformed(evt);
            }
        });
        jPanel1.add(btnWeeklySchedule);

        btnLogout.setBackground(new java.awt.Color(220, 20, 60));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/right-from-bracket-solid.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout);

        pnlContent.setBackground(new java.awt.Color(240, 248, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        // TODO add your handling code here:
        pnlSchedule pnl = new pnlSchedule();
        setLayout(pnl);
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void btnDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoctorActionPerformed
        // TODO add your handling code here:
        pnlDoctors pnl = new pnlDoctors();
        setLayout(pnl);
    }//GEN-LAST:event_btnDoctorActionPerformed

    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomActionPerformed
        // TODO add your handling code here:
        pnlRooms pnl = new pnlRooms();
        setLayout(pnl);
    }//GEN-LAST:event_btnRoomActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        pnlProfile pnl = new pnlProfile(user);
        setLayout(pnl);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnDaysOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaysOffActionPerformed
        // TODO add your handling code here:
        pnlDaysOff pnl = new pnlDaysOff(user.doctor());
        setLayout(pnl);
    }//GEN-LAST:event_btnDaysOffActionPerformed

    private void btnWeeklyScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWeeklyScheduleActionPerformed
        // TODO add your handling code here:
        pnlWeeklySchedule pnl = new pnlWeeklySchedule(user.doctor());
        setLayout(pnl);
    }//GEN-LAST:event_btnWeeklyScheduleActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Xác nhận đăng xuất",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.YES_OPTION) {
            frm.setContentPane(pnlLogin);
            revalidate();
            repaint();
            frm.pack();
            frm.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaysOff;
    private javax.swing.JButton btnDoctor;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnRoom;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JButton btnWeeklySchedule;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}
