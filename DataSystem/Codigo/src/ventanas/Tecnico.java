package ventanas;

import clases.Conexion;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

public class Tecnico extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;

    public Tecnico() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesionUsuario;

        setSize(550, 300);
        setResizable(false);
        setTitle("Tecnico - Sesion de " + user);
        setLocationRelativeTo(null);

        if (sesion_usuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nombre_usuario = rs.getString("nombre_usuario");
                jLabel_nombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
        } catch (SQLException e) {
            System.err.println("Error en consultar nombre de Tecnico");
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

        jLabel_nombreUsuario = new javax.swing.JLabel();
        jButton_GestionarEquipos = new javax.swing.JButton();
        jButton_GraficaEstatus = new javax.swing.JButton();
        jButton_GraficaMarcas = new javax.swing.JButton();
        jLabel_registrarCliente = new javax.swing.JLabel();
        jLabel_GestionarCliente = new javax.swing.JLabel();
        jLabel_Imprimr = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_nombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel_nombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_nombreUsuario.setText("jLabel1");
        getContentPane().add(jLabel_nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton_GestionarEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/apoyo-tecnico.png"))); // NOI18N
        jButton_GestionarEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GestionarEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GestionarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, 100));

        jButton_GraficaEstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_GraficaEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficaEstatusActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GraficaEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 100));

        jButton_GraficaMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafica.png"))); // NOI18N
        jButton_GraficaMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GraficaMarcasActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GraficaMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 100));

        jLabel_registrarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_registrarCliente.setText("Gestion de equipo");
        getContentPane().add(jLabel_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel_GestionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_GestionarCliente.setText("Grafica de estatus");
        getContentPane().add(jLabel_GestionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel_Imprimr.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Imprimr.setText("Grafica de marcas");
        getContentPane().add(jLabel_Imprimr, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel7.setText("Creado por Uri");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GestionarEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GestionarEquiposActionPerformed

        GestionarEquipos gestionar = new GestionarEquipos();
        gestionar.setVisible(true);

    }//GEN-LAST:event_jButton_GestionarEquiposActionPerformed

    private void jButton_GraficaEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficaEstatusActionPerformed

        GraficarEstatus graficarEstatus = new GraficarEstatus();
        graficarEstatus.setVisible(true);

    }//GEN-LAST:event_jButton_GraficaEstatusActionPerformed

    private void jButton_GraficaMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GraficaMarcasActionPerformed

        GraficarMarcas graficar = new GraficarMarcas();
        graficar.setVisible(true);

    }//GEN-LAST:event_jButton_GraficaMarcasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GestionarEquipos;
    private javax.swing.JButton jButton_GraficaEstatus;
    private javax.swing.JButton jButton_GraficaMarcas;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_GestionarCliente;
    private javax.swing.JLabel jLabel_Imprimr;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_nombreUsuario;
    private javax.swing.JLabel jLabel_registrarCliente;
    // End of variables declaration//GEN-END:variables
}
