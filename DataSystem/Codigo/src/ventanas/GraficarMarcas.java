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

public class GraficarMarcas extends javax.swing.JFrame {

    /*Acer
Apple
Asus
Dell
HP
Lenovo
Samsung
Toshiba*/
    String user;
    int[] vector_marcas_cantdad = new int[8];
    String[] vector_marcas_nombre = new String[8];
    int Acer, Apple, Asus, Dell, HP, Lenovo, Samsung, Toshiba;

    public GraficarMarcas() {
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
                    "select marca, count(marca) as Marcas from equipos group by marca");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int posicion = 0;
                do {
                    vector_marcas_nombre[posicion] = rs.getString(1);
                    vector_marcas_cantdad[posicion] = rs.getInt(2);

                    if (vector_marcas_nombre[posicion].equalsIgnoreCase("Acer")) {
                        Acer = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Apple")) {
                        Apple = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Asus")) {
                        Asus = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Dell")) {
                        Dell = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("HP")) {
                        HP = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Lenovo")) {
                        Lenovo = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Samsung")) {
                        Samsung = vector_marcas_cantdad[posicion];
                    } else if (vector_marcas_nombre[posicion].equalsIgnoreCase("Toshiba")) {
                        Toshiba = vector_marcas_cantdad[posicion];
                    }
                    posicion++;
                } while (rs.next());

            }

        } catch (SQLException e) {
            System.err.println("Error en la consulta " + e);
            JOptionPane.showMessageDialog(null, "Error en consultar datos");
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
        jLabel1.setText("Grafica de marcas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraficarMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int total_marcas = Acer + Apple + Asus + Dell + HP + Lenovo + Samsung + Toshiba;

        int grados_accer = Acer * 360 / total_marcas;
        int grados_apple = Apple * 360 / total_marcas;
        int grados_asus = Asus * 360 / total_marcas;
        int grados_dell = Dell * 360 / total_marcas;
        int grados_hp = HP * 360 / total_marcas;
        int grados_lenovo = Lenovo * 360 / total_marcas;
        int grados_samsung = Samsung * 360 / total_marcas;
        int grados_toshiba = Toshiba * 360 / total_marcas;

        g.setColor(new Color(175, 122, 197));
        g.fillArc(25, 100, 270, 270, 0, grados_accer);
        g.fillRect(310, 120, 20, 20);
        g.drawString(Acer + " de Acer", 340, 135);

        g.setColor(new Color(0, 122, 0));
        g.fillArc(25, 100, 270, 270, grados_accer, grados_apple);
        g.fillRect(310, 150, 20, 20);
        g.drawString(Apple + " de Apple", 340, 165);

        g.setColor(new Color(0, 255, 255));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple, grados_asus);
        g.fillRect(310, 180, 20, 20);
        g.drawString(Asus + " de Asus", 340, 195);

        g.setColor(new Color(55, 0, 255));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple + grados_asus, grados_dell);
        g.fillRect(310, 210, 20, 20);
        g.drawString(Dell + " de Dell", 340, 225);

        g.setColor(new Color(0, 0, 0));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple + grados_asus + grados_dell, grados_hp);
        g.fillRect(310, 240, 20, 20);
        g.drawString(HP + " de HP", 340, 255);

        g.setColor(new Color(247, 220, 111));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple + grados_asus + grados_dell + grados_hp, grados_lenovo);
        g.fillRect(310, 270, 20, 20);
        g.drawString(Lenovo + " de Lenovo", 340, 285);

        g.setColor(new Color(21, 42, 160));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple + grados_asus + grados_dell + grados_hp + grados_lenovo, grados_samsung);
        g.fillRect(310, 300, 20, 20);
        g.drawString(Samsung + " de Samsung", 340, 315);

        g.setColor(new Color(215, 96, 0));
        g.fillArc(25, 100, 270, 270, grados_accer + grados_apple + grados_asus + grados_dell + grados_hp + grados_lenovo + grados_samsung, grados_toshiba);
        g.fillRect(310, 330, 20, 20);
        g.drawString(Toshiba + " de Toshiba", 340, 345);
    }

}
