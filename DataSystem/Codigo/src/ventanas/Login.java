package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.sql.*;
import clases.Conexion;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";

    public Login() {
        initComponents();
        setSize(400, 550);
        setResizable(false);
        setTitle("Acceso al sistema");
        setLocationRelativeTo(null);
        //Imagen de fondo
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        //imagen DS icono
        ImageIcon wallpaperLogo = new ImageIcon("src/images/DS.png");
        Icon logo = new ImageIcon(wallpaperLogo.getImage().getScaledInstance(
                jLabel_Logo.getWidth(), jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(logo);
        this.repaint();

    }

    //imagen icono de la barra superior izq
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Logo = new javax.swing.JLabel();
        txt_pwsd = new javax.swing.JPasswordField();
        txt_user = new javax.swing.JTextField();
        jButton_Acceder = new javax.swing.JButton();
        jLabel_Footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 270, 270));

        txt_pwsd.setBackground(new java.awt.Color(153, 153, 255));
        txt_pwsd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_pwsd.setForeground(new java.awt.Color(255, 255, 255));
        txt_pwsd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pwsd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pwsd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pwsdActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pwsd, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 380, 210, -1));

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 330, 210, -1));

        jButton_Acceder.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Acceder.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jButton_Acceder.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Acceder.setText("Acceder");
        jButton_Acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AccederActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 420, 210, 32));

        jLabel_Footer.setText("Creado por Uriel Rodriguez");
        getContentPane().add(jLabel_Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jLabel_Wallpaper.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_AccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AccederActionPerformed

        user = txt_user.getText().trim();
        pass = txt_pwsd.getText().trim();

        if (!user.equals("") || !pass.equals("")) {

            try {
                Connection cn = Conexion.conectar();
                /*PreparedStatement pst = cn.prepareStatement(
                        "select tipo_nivel, estatus from usuarios where"
                                + "username = '" + user + "' and password = '"
                                + pass + "'");*/
                PreparedStatement pst = cn.prepareStatement("select tipo_nivel, estatus from usuarios where username = '" + user + "' and password = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");

                    if (tipo_nivel.equalsIgnoreCase("Administrador") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Administrador().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Capturista") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Capturista().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("Tecnico") && estatus.equalsIgnoreCase("Activo")) {
                        dispose();
                        new Tecnico().setVisible(true);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                    txt_user.setText("");
                    txt_pwsd.setText("");
                }

            } catch (SQLException e) {
                System.err.println("Error en el boton Acceder." + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Tenes que llenar todos los campos");
        }

    }//GEN-LAST:event_jButton_AccederActionPerformed

    private void txt_pwsdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pwsdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pwsdActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Acceder;
    private javax.swing.JLabel jLabel_Footer;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPasswordField txt_pwsd;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
