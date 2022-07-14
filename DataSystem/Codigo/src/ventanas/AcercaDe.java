package ventanas;

import clases.Conexion;
import java.sql.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class AcercaDe extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;

    public AcercaDe() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesionUsuario;

        setSize(400, 300);
        setResizable(false);
        setTitle("Acerca De - Sesion de " + user);
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

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_1 = new javax.swing.JLabel();
        jLabel_2 = new javax.swing.JLabel();
        jLabel_3 = new javax.swing.JLabel();
        jLabel_4 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_1.setText("Sistema creado por:");
        getContentPane().add(jLabel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel_2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_2.setText("URIEL Capo");
        getContentPane().add(jLabel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel_3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_3.setText("Con mucho gusto: Para todos sus believers");
        getContentPane().add(jLabel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel_4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_4.setText("Facebook / Twitter / Instagram");
        getContentPane().add(jLabel_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcercaDe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_1;
    private javax.swing.JLabel jLabel_2;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JLabel jLabel_4;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
