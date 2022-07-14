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

public class InformacionEquipoTecnico extends javax.swing.JFrame {

    int IDequipo = 0;
    String user = "";

    public InformacionEquipoTecnico() {
        initComponents();

        user = Login.user;
        IDequipo = GestionarEquipos.IDequipo_update;

        try {
            Connection cn2 = Conexion.conectar();
            PreparedStatement pst = cn2.prepareStatement(
                    "select * from equipos where id_equipo = '" + IDequipo + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cmb_tipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                cmb_Marcas.setSelectedItem(rs.getString("marca"));
                cmb_estatus.setSelectedItem(rs.getString("estatus"));
                txt_Modelo.setText(rs.getString("modelo"));
                txt_numSerie.setText(rs.getString("num_serie"));
                txt_UltimaModificacion.setText(rs.getString("ultima_modificacion"));

                String dia = "", mes = "", annio = "";
                dia = rs.getString("dia_ingreso");
                mes = rs.getString("mes_ingreso");
                annio = rs.getString("annio_ingreso");
                txt_fecha.setText(dia + " del " + mes + " del " + annio);

                jTextPane_Observaciiones.setText(rs.getString("observaciones"));
                jTextPane_ComentariosTecnico.setText(rs.getString("comentarios_tecnicos"));
                jLabel_revisionTecnicaDe.setText("Comentarios y actualizacion del tecnico: " + rs.getString("revision_tecnica_de"));

            }

        } catch (SQLException e) {
            System.err.println("Error al consultar informacion del equipo.");
        }

        setTitle("Equipo registrado con el ID " + IDequipo + " - Sesion de " + user);
        setSize(670, 530);
        setResizable(false);
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

        jLabel_titulo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Nombre1 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jLabel_Nombre3 = new javax.swing.JLabel();
        jLabel_Nombre4 = new javax.swing.JLabel();
        jLabel_Nombre5 = new javax.swing.JLabel();
        jLabel_Nombre6 = new javax.swing.JLabel();
        jLabel_Nombre7 = new javax.swing.JLabel();
        jLabel_Nombre8 = new javax.swing.JLabel();
        jLabel_revisionTecnicaDe = new javax.swing.JLabel();
        txt_nombreCliente = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_numSerie = new javax.swing.JTextField();
        txt_UltimaModificacion = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        cmb_tipoEquipo = new javax.swing.JComboBox<>();
        cmb_Marcas = new javax.swing.JComboBox<>();
        cmb_estatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_Observaciiones = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane_ComentariosTecnico = new javax.swing.JTextPane();
        jButton_Actualizar = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Informacion del equipo");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jLabel_Nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre.setText("Nombre del cliente:");
        getContentPane().add(jLabel_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre1.setText("Tipo de equipo");
        getContentPane().add(jLabel_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre2.setText("Marca");
        getContentPane().add(jLabel_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre3.setText("Modelo:");
        getContentPane().add(jLabel_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel_Nombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre4.setText("Numero de serie");
        getContentPane().add(jLabel_Nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel_Nombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre5.setText("Fecha de ingreso");
        getContentPane().add(jLabel_Nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        jLabel_Nombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre6.setText("Ul;tima modificacion por:");
        getContentPane().add(jLabel_Nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel_Nombre7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre7.setText("Estatus");
        getContentPane().add(jLabel_Nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel_Nombre8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_Nombre8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Nombre8.setText("Dannio reportado y observaciones");
        getContentPane().add(jLabel_Nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel_revisionTecnicaDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_revisionTecnicaDe.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_revisionTecnicaDe.setText("Comentarios y actualizacion de tecnico");
        getContentPane().add(jLabel_revisionTecnicaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        txt_nombreCliente.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombreCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombreCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombreCliente.setEnabled(false);
        getContentPane().add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        txt_Modelo.setBackground(new java.awt.Color(153, 153, 255));
        txt_Modelo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_Modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 210, -1));

        txt_numSerie.setBackground(new java.awt.Color(153, 153, 255));
        txt_numSerie.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_numSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_numSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numSerie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 210, -1));

        txt_UltimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_UltimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_UltimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_UltimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_UltimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_UltimaModificacion.setEnabled(false);
        getContentPane().add(txt_UltimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 210, -1));

        txt_fecha.setBackground(new java.awt.Color(153, 153, 255));
        txt_fecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_fecha.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha.setEnabled(false);
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 180, -1));

        cmb_tipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Notebook", "PC", "Impresora", "Multifuncional", " " }));
        getContentPane().add(cmb_tipoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmb_Marcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Apple", "Asus", "Dell", "HP", "Lenovo", "Samsung", "Toshiba" }));
        getContentPane().add(cmb_Marcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jTextPane_Observaciiones.setEditable(false);
        jScrollPane1.setViewportView(jTextPane_Observaciiones);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 330, 120));

        jScrollPane2.setViewportView(jTextPane_ComentariosTecnico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 330, 120));

        jButton_Actualizar.setBackground(new java.awt.Color(153, 153, 255));
        jButton_Actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jButton_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Actualizar.setText("Comentar y actualizar");
        jButton_Actualizar.setBorder(null);
        jButton_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 210, 35));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ActualizarActionPerformed

        String estatus, comentariosTecnicos, tecnico;
        
        estatus = cmb_estatus.getSelectedItem().toString();
        comentariosTecnicos = jTextPane_ComentariosTecnico.getText();
        tecnico = user;
        
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "update equipos set estatus=?, comentarios_tecnicos=?, revision_tecnica_de=? where id_equipo = '" + IDequipo + "'");
        
            pst.setString(1, estatus);
            pst.setString(2, comentariosTecnicos);
            pst.setString(3, tecnico);
            
            pst.executeUpdate();
            cn.close();
            
            JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
            this.dispose();
        
        } catch (SQLException e) {
            System.err.println("Error en actualizar equipo " + e);
            JOptionPane.showMessageDialog(null, "Error al actualizar equipo");
        }
        
    }//GEN-LAST:event_jButton_ActualizarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipoTecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Marcas;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JComboBox<String> cmb_tipoEquipo;
    private javax.swing.JButton jButton_Actualizar;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre1;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Nombre3;
    private javax.swing.JLabel jLabel_Nombre4;
    private javax.swing.JLabel jLabel_Nombre5;
    private javax.swing.JLabel jLabel_Nombre6;
    private javax.swing.JLabel jLabel_Nombre7;
    private javax.swing.JLabel jLabel_Nombre8;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JLabel jLabel_revisionTecnicaDe;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane_ComentariosTecnico;
    private javax.swing.JTextPane jTextPane_Observaciiones;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_UltimaModificacion;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_numSerie;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombreCliente.setText("");
        txt_fecha.setText("");
        txt_Modelo.setText("");
        txt_numSerie.setText("");
        jTextPane_Observaciiones.setText("");
    }

}
