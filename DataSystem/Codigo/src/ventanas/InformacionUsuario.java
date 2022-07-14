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

public class InformacionUsuario extends javax.swing.JFrame {

    String user = "", user_update = "";
    int ID;

    public InformacionUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        user = Login.user;
        user_update = GestionarUsuarios.user_update;

        setSize(630, 450);
        setResizable(false);
        setTitle("Informacion del usuario " + user_update + " - Sesion de " + user);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        jLabel_titulo.setText("Informacion del usuario " + user_update);

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from usuarios where username = '" + user_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                ID = rs.getInt("id_usuario");

                txt_nombre.setText(rs.getString("nombre_usuario"));
                txt_mail.setText(rs.getString("email"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_username.setText(rs.getString("username"));
                txt_registradoPor.setText(rs.getString("registro_por"));

                cmb_niveles.setSelectedItem(rs.getString("tipo_nivel"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en cargar el usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al cargar");
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_registradoPor = new javax.swing.JTextField();
        cmb_niveles = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jButton_Actualizar = new javax.swing.JButton();
        jButton_Restaurarpwd = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del usuario");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Email");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Telefono:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Permisos de:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Username:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Estatus:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Registrado por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 210, -1));

        txt_registradoPor.setBackground(new java.awt.Color(153, 153, 255));
        txt_registradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_registradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txt_registradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_registradoPor.setEnabled(false);
        getContentPane().add(txt_registradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        cmb_niveles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico", " " }));
        cmb_niveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nivelesActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_niveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo", " " }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, -1));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Actualizar Usuario");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 210, 35));

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
        getContentPane().add(jButton_Restaurarpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 210, 35));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_nivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nivelesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_nivelesActionPerformed

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        int permisos_cmb, estatus_cmb, validacion = 0;
        String nombre, mail, telefono, username, pass, permisos_string = "", estatus_string = "";

        mail = txt_mail.getText().trim();
        username = txt_username.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();
        permisos_cmb = cmb_niveles.getSelectedIndex() + 1;
        estatus_cmb = cmb_estatus.getSelectedIndex() + 1;

        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion++;
        }
        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }

        if (validacion == 0) {
            if (permisos_cmb == 1) {
                permisos_string = "Administrador";
            } else if (permisos_cmb == 2) {
                permisos_string = "Capturista";
            } else if (permisos_cmb == 3) {
                permisos_string = "Tecnico";
            }

            if (estatus_cmb == 1) {
                estatus_string = "Activo";
            } else if (estatus_cmb == 2) {
                estatus_string = "Inactivo";
            }

            try {
                Connection cn2 = Conexion.conectar();
                PreparedStatement pst2 = cn2.prepareStatement(
                        "select username from usuarios where username ='" + username + "' and not id_usuario = '" + ID + "'");
                ResultSet rs = pst2.executeQuery();
                if (rs.next()) {
                    txt_username.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                    cn2.close();
                    txt_mail.setBackground(new Color(153, 153, 255));
                    txt_nombre.setBackground(new Color(153, 153, 255));
                    txt_telefono.setBackground(new Color(153, 153, 255));
                    txt_username.setBackground(new Color(153, 153, 255));
                    txt_username.setText("");
                } else {
                    Connection cn = Conexion.conectar();
                    PreparedStatement pst = cn.prepareStatement(
                            "update usuarios set nombre_usuario=?, email=?,telefono=?, username=?, tipo_nivel=?, estatus=? where id_usuario = '" + ID + "'");
                    pst.setString(1, nombre);
                    pst.setString(2, mail);
                    pst.setString(3, telefono);
                    pst.setString(4, username);
                    pst.setString(5, permisos_string);
                    pst.setString(6, estatus_string);

                    pst.executeUpdate();
                    cn.close();
                    JOptionPane.showMessageDialog(null, "Modificacion correcta");
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            txt_mail.setBackground(new Color(153, 153, 255));
            txt_nombre.setBackground(new Color(153, 153, 255));
            txt_telefono.setBackground(new Color(153, 153, 255));
            txt_username.setBackground(new Color(153, 153, 255));
        }


    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    private void jButton_RestaurarpwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RestaurarpwdActionPerformed

        RestaurarPassword restaurarpassword =new RestaurarPassword();
        restaurarpassword.setVisible(true);

    }//GEN-LAST:event_jButton_RestaurarpwdActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_niveles;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JButton jButton_Restaurarpwd;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_registradoPor;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
