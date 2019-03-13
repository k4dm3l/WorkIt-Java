package GUI;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.util.Set;
import javax.swing.JOptionPane;
/**
 *
 * @author Camilo
 */
public class Login extends javax.swing.JFrame {
    
    int xx = 0;
    int xy = 0;
    
    public Login() {
        initComponents();
        Shape form = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 10, 10);
        AWTUtilities.setWindowShape(this, form);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogo = new javax.swing.JPanel();
        lbl_Logo = new javax.swing.JLabel();
        lbl_Title = new javax.swing.JLabel();
        panelLoguin = new javax.swing.JPanel();
        lbl_LoginTitle = new javax.swing.JLabel();
        btn_Ingresar = new javax.swing.JButton();
        lbl_User = new javax.swing.JLabel();
        lbl_Pass = new javax.swing.JLabel();
        txt_User = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_UserIcon = new javax.swing.JLabel();
        lbl_PassIcon = new javax.swing.JLabel();
        lbl_Exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogo.setBackground(new java.awt.Color(244, 67, 54));

        lbl_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Turtle.png"))); // NOI18N

        lbl_Title.setFont(lbl_Title.getFont().deriveFont(lbl_Title.getFont().getStyle() | java.awt.Font.BOLD, lbl_Title.getFont().getSize()+42));
        lbl_Title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("WorkIt");

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lbl_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLogoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogoLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbl_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
        );

        getContentPane().add(panelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, -1));

        panelLoguin.setBackground(new java.awt.Color(211, 47, 47));
        panelLoguin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLoguinMousePressed(evt);
            }
        });

        lbl_LoginTitle.setFont(lbl_LoginTitle.getFont().deriveFont(lbl_LoginTitle.getFont().getStyle() | java.awt.Font.BOLD, lbl_LoginTitle.getFont().getSize()+25));
        lbl_LoginTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbl_LoginTitle.setText("Iniciar Sesion");

        btn_Ingresar.setBackground(new java.awt.Color(244, 67, 54));
        btn_Ingresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Ingresar.setText("INGRESAR");
        btn_Ingresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Ingresar.setBorderPainted(false);
        btn_Ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Ingresar.setFocusPainted(false);
        btn_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IngresarActionPerformed(evt);
            }
        });

        lbl_User.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_User.setForeground(new java.awt.Color(255, 255, 255));
        lbl_User.setText("USUARIO");

        lbl_Pass.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Pass.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Pass.setText("CONTRASEÑA");

        txt_User.setBackground(new java.awt.Color(211, 47, 47));
        txt_User.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        txt_User.setForeground(new java.awt.Color(255, 255, 255));
        txt_User.setBorder(null);
        txt_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_UserKeyTyped(evt);
            }
        });

        txt_Password.setBackground(new java.awt.Color(211, 47, 47));
        txt_Password.setFont(new java.awt.Font("Segoe UI Light", 1, 16)); // NOI18N
        txt_Password.setForeground(new java.awt.Color(255, 255, 255));
        txt_Password.setBorder(null);

        lbl_UserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/User.png"))); // NOI18N

        lbl_PassIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_PassIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Lock.png"))); // NOI18N

        lbl_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exit.png"))); // NOI18N
        lbl_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLoguinLayout = new javax.swing.GroupLayout(panelLoguin);
        panelLoguin.setLayout(panelLoguinLayout);
        panelLoguinLayout.setHorizontalGroup(
            panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoguinLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelLoguinLayout.createSequentialGroup()
                            .addComponent(lbl_UserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_User, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelLoguinLayout.createSequentialGroup()
                            .addComponent(lbl_PassIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLoguinLayout.createSequentialGroup()
                .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoguinLayout.createSequentialGroup()
                        .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLoguinLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btn_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLoguinLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_User, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Pass)
                                    .addComponent(lbl_LoginTitle))))
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoguinLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLoguinLayout.setVerticalGroup(
            panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoguinLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbl_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_LoginTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lbl_User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_User)
                    .addComponent(lbl_UserIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbl_Pass)
                .addGap(11, 11, 11)
                .addGroup(panelLoguinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_Password)
                    .addComponent(lbl_PassIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btn_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        getContentPane().add(panelLoguin, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 0, -1, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IngresarActionPerformed
        // TODO add your handling code here:
        if(txt_User.getText().equals("PRUEBA")){
            Principal p = new Principal();
            p.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_IngresarActionPerformed

    private void lbl_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ExitMouseClicked
        // TODO add your handling code here:
        int dialogOption = JOptionPane.YES_NO_OPTION;
        
        JOptionPane.showConfirmDialog(null, "Desas salir?", "Salir del Sistema",dialogOption);
        
        if(dialogOption == JOptionPane.YES_OPTION){
            System.exit(0);
        } else {
            if(dialogOption == JOptionPane.NO_OPTION){
                remove(dialogOption);
            }
        }
    }//GEN-LAST:event_lbl_ExitMouseClicked

    private void txt_UserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_UserKeyTyped
        // TODO add your handling code here:
        char keyChar = evt.getKeyChar();
        if(Character.isLowerCase(keyChar)){
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txt_UserKeyTyped

    private void panelLoguinMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLoguinMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelLoguinMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Exit;
    private javax.swing.JLabel lbl_LoginTitle;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_Pass;
    private javax.swing.JLabel lbl_PassIcon;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_User;
    private javax.swing.JLabel lbl_UserIcon;
    private javax.swing.JPanel panelLogo;
    private javax.swing.JPanel panelLoguin;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_User;
    // End of variables declaration//GEN-END:variables
}
