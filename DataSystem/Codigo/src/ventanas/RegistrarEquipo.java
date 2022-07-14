package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class RegistrarEquipo extends javax.swing.JFrame {

    int IDcliente_update = 0;
    String user = "", nom_cliente = "";

    public RegistrarEquipo() {
        initComponents();
        user = Login.user;
        IDcliente_update = GestionarClientes.IDcliente_update;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_cliente from clientes where id_clientes = '" + IDcliente_update + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                nom_cliente = rs.getString("nombre_cliente");
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar el nombre del cliente" + e);
        }
        setTitle("Registrar nuevo equipo para " + nom_cliente);
        setSize(630, 445);
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                jLabel_Wallpaper.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();

        txt_NombreCliente.setText(nom_cliente);
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
        txt_NombreCliente = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_num_serie = new javax.swing.JTextField();
        cmb_tipoEquipo = new javax.swing.JComboBox<>();
        cmb_marcas = new javax.swing.JComboBox<>();
        jScrollPane_observaciones = new javax.swing.JScrollPane();
        jTextPane_observaciones = new javax.swing.JTextPane();
        jButton_registrar = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Registro de equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo:");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca:");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Numero de serie:");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Danio reportado y observaciones:");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, -1, -1));

        txt_NombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_NombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_NombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_NombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_NombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_NombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_num_serie.setBackground(new java.awt.Color(153, 153, 255));
        txt_num_serie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_num_serie.setForeground(new java.awt.Color(255, 255, 255));
        txt_num_serie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num_serie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_num_serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        cmb_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notebook", "Pc", "Impresora", "Multifuncional" }));
        cmb_tipoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tipoEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Apple", "Asus", "Dell", "HP", "Lenovo", "Samsung", "Toshiba" }));
        getContentPane().add(cmb_marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jScrollPane_observaciones.setViewportView(jTextPane_observaciones);

        getContentPane().add(jScrollPane_observaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 330, 230));

        jButton_registrar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_registrar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registrar.setText("Registrar equipo");
        jButton_registrar.setBorder(null);
        jButton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 210, 35));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 445));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_registrarActionPerformed

        String modelo, num_serie, marca, tipo_equipo, dia_ingreso, mes_ingreso, annio_ingreso, estatus, observaciones;
        int bandera = 0;
        modelo = txt_modelo.getText().trim();
        num_serie = txt_num_serie.getText().trim();
        tipo_equipo = cmb_tipoEquipo.getSelectedItem().toString();
        marca = cmb_marcas.getSelectedItem().toString();
        observaciones = jTextPane_observaciones.getText();
        estatus = "Nuevo ingreso";

        Calendar calendar = Calendar.getInstance();

        dia_ingreso = Integer.toString(calendar.get(Calendar.DATE));
        mes_ingreso = Integer.toString(calendar.get(Calendar.MONTH));
        annio_ingreso = Integer.toString(calendar.get(Calendar.YEAR));

        if (modelo.equals("")) {
            txt_modelo.setBackground(Color.red);
            bandera++;
        }
        if (num_serie.equals("")) {
            txt_num_serie.setBackground(Color.red);
            bandera++;
        }
        if (observaciones.equals("")) {
            jTextPane_observaciones.setText("Sin Observaciones");
        }

        if (bandera == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "insert into equipos values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setInt(1,0);
                pst.setInt(2, IDcliente_update);
                pst.setString(3, tipo_equipo);
                pst.setString(4, marca);
                pst.setString(5, modelo);
                pst.setString(6, num_serie);
                pst.setString(7, dia_ingreso);
                pst.setString(8, mes_ingreso);
                pst.setString(9, annio_ingreso);
                pst.setString(10, observaciones);
                pst.setString(11, estatus);
                pst.setString(12, user);
                pst.setString(13, "");
                pst.setString(14, "");
                
                pst.executeUpdate();
                cn.close();
                
                txt_NombreCliente.setBackground(Color.green);
                txt_modelo.setBackground(Color.green);
                txt_num_serie.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                this.dispose();
                
            } catch (SQLException e) {
                System.out.println("Error en registrar equipo " + e);
                JOptionPane.showMessageDialog(null, "Error al registrar equipo");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Tenes que llenar todos los campos");
            txt_modelo.setBackground(new Color(153, 153, 255));
            txt_num_serie.setBackground(new Color(153, 153, 255));
        }

    }//GEN-LAST:event_jButton_registrarActionPerformed

    private void cmb_tipoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tipoEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_tipoEquipoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarEquipo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_marcas;
    private javax.swing.JComboBox<String> cmb_tipoEquipo;
    private javax.swing.JButton jButton_registrar;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane_observaciones;
    private javax.swing.JTextPane jTextPane_observaciones;
    private javax.swing.JTextField txt_NombreCliente;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_num_serie;
    // End of variables declaration//GEN-END:variables
}
