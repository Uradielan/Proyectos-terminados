package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class GraficarEstatus extends javax.swing.JFrame {

    String user;
    int NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado;

    String[] vector_estatus_nombre = new String[5];
    int[] vector_estatus_cantidad = new int[5];

    public GraficarEstatus() {
        initComponents();

        user = Login.user;

        setSize(550, 450);
        setResizable(false);
        setTitle("Tecnico - Sesion de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select estatus, count(estatus) as Cantidad from equipos group by estatus");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_estatus_nombre[posicion] = rs.getString(1);
                    vector_estatus_cantidad[posicion] = rs.getInt(2);

                    if (vector_estatus_nombre[posicion].equalsIgnoreCase("En revision")) {
                        EnRevision = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Entregado")) {
                        Entregado = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("No reparado")) {
                        NoReparado = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Nuevo ingreso")) {
                        NuevoIngreso = vector_estatus_cantidad[posicion];
                    } else if (vector_estatus_nombre[posicion].equalsIgnoreCase("Reparado")) {
                        Reparado = vector_estatus_cantidad[posicion];
                    }

                    posicion++;
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Error en conectar con la Base de datos");
            JOptionPane.showMessageDialog(null, "Error en conectar a la base de datos");
        }

        repaint();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Grafica de estatus");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficarEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    // End of variables declaration//GEN-END:variables

    public int EstatusMasRepetido(int NuevoIngreso, int NoReparado, int EnRevision, int Reparado, int Entregado) {
        if (NuevoIngreso > NoReparado && NuevoIngreso > EnRevision && NuevoIngreso > Reparado && NuevoIngreso > Entregado) {
            return NuevoIngreso;
        } else if (NoReparado > EnRevision && NoReparado > Reparado && NoReparado > Entregado) {
            return NoReparado;
        } else if (EnRevision > Reparado && EnRevision > Entregado) {
            return EnRevision;
        } else if (Reparado > Entregado) {
            return Reparado;
        } else {
            return Entregado;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int Estatus_mas_repetido = EstatusMasRepetido(NuevoIngreso, NoReparado, EnRevision, Reparado, Entregado);

        int Largo_nuevoIngreso = NuevoIngreso * 400 / Estatus_mas_repetido;
        int Largo_NoReparado = NoReparado * 400 / Estatus_mas_repetido;
        int Largo_EnRevision = EnRevision * 400 / Estatus_mas_repetido;
        int Largo_Reparado = Reparado * 400 / Estatus_mas_repetido;
        int Largo_Entregado = Entregado * 400 / Estatus_mas_repetido;

        g.setColor(new Color(240, 248, 0));
        g.fillRect(100, 100, Largo_nuevoIngreso, 40);
        g.drawString("Nuevo Ingreso", 10, 118);
        g.drawString("Cantidad: " + NuevoIngreso, 10, 133);

        g.setColor(new Color(255, 0, 0));
        g.fillRect(100, 150, Largo_NoReparado, 40);
        g.drawString("No Reparado", 10, 168);
        g.drawString("Cantidad: " + NoReparado, 10, 183);

        g.setColor(new Color(0, 0, 0));
        g.fillRect(100, 200, Largo_EnRevision, 40);
        g.drawString("En Revision", 10, 218);
        g.drawString("Cantidad: " + EnRevision, 10, 233);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(100, 250, Largo_Reparado, 40);
        g.drawString("Reparado", 10, 268);
        g.drawString("Cantidad: " + Reparado, 10, 283);

        g.setColor(new Color(0, 85, 0));
        g.fillRect(100, 300, Largo_Entregado, 40);
        g.drawString("Entregado", 10, 318);
        g.drawString("Cantidad: " + Entregado, 10, 333);

    }

}
