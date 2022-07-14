package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RestaurarPassword extends javax.swing.JFrame {

    String user = "", user_update = "";

    public RestaurarPassword() {
        initComponents();
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setSize(360, 260);
        setResizable(false);
        setTitle("cambio de password para " + user_update);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_pswd = new javax.swing.JPasswordField();
        txt_pswdconfirmacion = new javax.swing.JPasswordField();
        jButton_Restaurarpwd = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cambio de password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nuevo Password: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirmar Password: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_pswd.setBackground(new java.awt.Color(153, 153, 255));
        txt_pswd.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_pswd.setForeground(new java.awt.Color(255, 255, 255));
        txt_pswd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pswd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pswdActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_pswdconfirmacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_pswdconfirmacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_pswdconfirmacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_pswdconfirmacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pswdconfirmacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pswdconfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jButton_Restaurarpwd.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Restaurarpwd.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Restaurarpwd.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Restaurarpwd.setText("Restaurar Password");
        jButton_Restaurarpwd.setBorder(null);
        jButton_Restaurarpwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RestaurarpwdActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Restaurarpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pswdActionPerformed


    }//GEN-LAST:event_txt_pswdActionPerformed

    private void jButton_RestaurarpwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarpwdActionPerformed

        String password;
        String confPassword;

        password = txt_pswd.getText().trim();
        confPassword = txt_pswdconfirmacion.getText().trim();

        if (!password.equals("") && !confPassword.equals("")) {
            if (password.equals(confPassword)) {
                try {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set password=? where username = '" + user_update + "'");
                    pst.setString(1, password);
                    pst.executeUpdate();
                    cn.close();
                    
                    txt_pswd.setBackground(Color.green);
                    txt_pswdconfirmacion.setBackground(Color.green);
                    JOptionPane.showMessageDialog(null, "Contrasenia cambiada correctamente");
                    this.dispose();
                } catch (SQLException e) {
                    System.err.println("Error en restaurar password " + e);
                }
                
            } else {
                txt_pswdconfirmacion.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Las contrasenias no coinciden");
            }
        } else {
             txt_pswd.setBackground(Color.red);
             txt_pswdconfirmacion.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Tenes que llenar todos los campos");
            txt_pswdconfirmacion.setBackground(new Color(153, 153, 255));
            txt_pswd.setBackground(new Color(153, 153, 255));
        }
        

    }//GEN-LAST:event_jButton_RestaurarpwdActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurarPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Restaurarpwd;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_pswd;
    private javax.swing.JPasswordField txt_pswdconfirmacion;
    // End of variables declaration//GEN-END:variables
}
