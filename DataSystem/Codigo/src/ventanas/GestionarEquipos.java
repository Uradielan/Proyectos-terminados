package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    public static int IDequipo_update = 0;
    DefaultTableModel model = new DefaultTableModel();

    public GestionarEquipos() {
        initComponents();

        user = Login.user;

        setTitle("Capturista - Sesion de " + user);
        setSize(640, 380);
        setResizable(false);
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
                    "select id_equipo, tipo_equipo, marca, estatus from equipos");
            ResultSet rs = pst.executeQuery();

            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);

            model.addColumn(" ");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

            cn.close();

        } catch (SQLException e) {
            System.err.println("Error en el llenado de la tabla" + e);
            JOptionPane.showMessageDialog(null, "Error en el llenado de la tabla");
        }

        ObtenerDatosTabla();

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
        jScrollPane_equipos = new javax.swing.JScrollPane();
        jTable_equipos = new javax.swing.JTable();
        jLabel_footer = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<>();
        Mostrar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jTable_equipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_equipos.setViewportView(jTable_equipos);

        getContentPane().add(jScrollPane_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        jLabel_footer.setText("Creado por Uriel");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        Mostrar.setBackground(new java.awt.Color(153, 153, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 210, 35));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed

        String seleccion = cmb_estatus.getSelectedItem().toString();
        String query = "";
        
        model.setRowCount(0);
        model.setColumnCount(0);
        
        try {
            Connection cn = Conexion.conectar();
            
            if (seleccion.equalsIgnoreCase("Todos")) {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos";
            } else {
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus = '" + seleccion + "'";
            }
            
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            jTable_equipos = new JTable(model);
            jScrollPane_equipos.setViewportView(jTable_equipos);
            
            model.addColumn(" ");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");
            
            while(rs.next()){
                Object [] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i+1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipo "+e);
        }
        ObtenerDatosTabla();
    }//GEN-LAST:event_MostrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JScrollPane jScrollPane_equipos;
    private javax.swing.JTable jTable_equipos;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        jTable_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_equipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDequipo_update = (int) model.getValueAt(fila_point, columna_point);
                    InformacionEquipoTecnico Infoequipotecnico = new InformacionEquipoTecnico();
                    Infoequipotecnico.setVisible(true);

                }
            }
        });
    }
}
