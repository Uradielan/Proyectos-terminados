import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener{

  private JTextField txtNombreTrabajador, txtAPaternoTrabajador, txtAMaternoTrabajador;
  private JMenuBar menubar;
  private JMenu opciones, calcular, acercade, fondo;
  private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
  private JLabel labelimagen, bienvenido, titulo, nombretrabajador, APaterno, AMaterno,
                 departamento, antiguedad, resultadoCalculo, footer;
  private JTextArea area;
  private JScrollPane scroll;
  private JComboBox comboDpto, comboAntiguedad;
  String nombreAdministrador = "";

  public Principal(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Pantalla principal");
    getContentPane().setBackground(new Color(255,0,0));
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
    Bienvenida bienvenidaventana = new Bienvenida();
    nombreAdministrador = bienvenidaventana.texto;

    menubar = new JMenuBar();
    menubar.setBackground(new Color(150,1,1));
    setJMenuBar(menubar);

    opciones = new JMenu("Opciones");
    opciones.setBackground(new Color(224,224,224));
    opciones.setFont(new Font("Andale Mono", 1, 14));
    opciones.setForeground(new Color(255,255,255));
    menubar.add(opciones);
 
    calcular = new JMenu("Calcular");
    calcular.setBackground(new Color(224,224,224));
    calcular.setFont(new Font("Andale Mono", 1, 14));
    calcular.setForeground(new Color(255,255,255));
    menubar.add(calcular);

    acercade = new JMenu("Acerca de");
    acercade.setBackground(new Color(224,224,224));
    acercade.setFont(new Font("Andale Mono", 1, 14));
    acercade.setForeground(new Color(255,255,255));
    menubar.add(acercade);
   
    fondo = new JMenu("Color de fondo");
    fondo.setFont(new Font("Andale Mono", 1, 14));
    fondo.setForeground(new Color(0,0,0));
    opciones.add(fondo);
 
    miCalculo = new JMenuItem("Vacaciones");
    miCalculo.setFont(new Font("Andale Mono", 1, 14));
    miCalculo.setForeground(new Color(0,0,0));
    calcular.add(miCalculo);
    miCalculo.addActionListener(this);

    miRojo = new JMenuItem("Rojo");
    miRojo.setFont(new Font("Andale Mono", 1, 14));
    miRojo.setForeground(new Color(0,0,0));
    fondo.add(miRojo);
    miRojo.addActionListener(this);
  
    miNegro = new JMenuItem("Negro");
    miNegro.setFont(new Font("Andale Mono", 1,14));
    miNegro.setForeground(new Color(0,0,0));
    fondo.add(miNegro);
    miNegro.addActionListener(this);

    miMorado = new JMenuItem("Morado");
    miMorado.setFont(new Font("Andale Mono", 1, 14));
    miMorado.setForeground(new Color(0,0,0));
    fondo.add(miMorado);
    miMorado.addActionListener(this);

    miElCreador = new JMenuItem("El creador");
    miElCreador.setFont(new Font("Andale Mono", 1, 14));
    miElCreador.setForeground(new Color(0,0,0));
    acercade.add(miElCreador);
    miElCreador.addActionListener(this);

    miSalir = new JMenuItem("Salir");
    miSalir.setFont(new Font("Andale Mono", 1 ,14));
    miSalir.setForeground(new Color(0,0,0));
    opciones.add(miSalir);
    miSalir.addActionListener(this);

    miNuevo = new JMenuItem("Nuevo");
    miNuevo.setFont(new Font("Andale Mono", 1, 14));
    miNuevo.setForeground(new Color(0,0,0));
    opciones.add(miNuevo);
    miNuevo.addActionListener(this);

    ImageIcon imagen = new ImageIcon("images/logo-coca.png");
    labelimagen = new JLabel(imagen);
    labelimagen.setBounds(5,5,250,100);
    add(labelimagen);

    bienvenido = new JLabel("Bienvenido " + nombreAdministrador);
    bienvenido.setBounds(280,30,300,50);
    bienvenido.setFont(new Font("Andale Mono", 1, 32));
    bienvenido.setForeground(new Color(255,255,255));
    add(bienvenido);

    titulo = new JLabel("Datos del trabajador para el calculo de vacaciones");
    titulo.setBounds(45,140,900,25);
    titulo.setFont(new Font("Andale Mono", 0, 24));
    titulo.setForeground(new Color(255,255,255));
    add(titulo);

    nombretrabajador = new JLabel("Nombre completo");
    nombretrabajador.setBounds(25,188,180,25);
    nombretrabajador.setFont(new Font("Andale Mono", 1, 12));
    nombretrabajador.setForeground(new Color(255,255,255));
    add(nombretrabajador);

    txtNombreTrabajador = new JTextField();
    txtNombreTrabajador.setBounds(25,213,150,25);
    txtNombreTrabajador.setBackground(new java.awt.Color(224,224,224));
    txtNombreTrabajador.setFont(new java.awt.Font("Andale Mono",1,14));
    txtNombreTrabajador.setForeground(new java.awt.Color(0,0,0));
    add(txtNombreTrabajador);

    APaterno = new JLabel("Apellido paterno");
    APaterno.setBounds(25,248,180,25);
    APaterno.setFont(new Font("Andale Mono", 1, 12));
    APaterno.setForeground(new Color(255,255,255));
    add(APaterno);

    txtAPaternoTrabajador = new JTextField();
    txtAPaternoTrabajador.setBounds(25,273,150,25);
    txtAPaternoTrabajador.setBackground(new java.awt.Color(224,224,224));
    txtAPaternoTrabajador.setFont(new java.awt.Font("Andale Mono",1,14));
    txtAPaternoTrabajador.setForeground(new java.awt.Color(0,0,0));
    add(txtAPaternoTrabajador);

    AMaterno = new JLabel("Apellido materno");
    AMaterno.setBounds(25,308,180,25);
    AMaterno.setFont(new Font("Andale Mono", 1, 12));
    AMaterno.setForeground(new Color(255,255,255));
    add(AMaterno);

    txtAMaternoTrabajador = new JTextField();
    txtAMaternoTrabajador.setBounds(25,334,150,25);
    txtAMaternoTrabajador.setBackground(new java.awt.Color(224,224,224));
    txtAMaternoTrabajador.setFont(new java.awt.Font("Andale Mono",1,14));
    txtAMaternoTrabajador.setForeground(new java.awt.Color(0,0,0));
    add(txtAMaternoTrabajador);

    departamento = new JLabel("Selecciona el Departamento");
    departamento.setBounds(220,188,180,25);
    departamento.setFont(new Font("Andale Mono", 1, 12));
    departamento.setForeground(new Color(255,255,255));
    add(departamento);

    comboDpto = new JComboBox();
    comboDpto.setBounds(220,213,220,25);
    comboDpto.setBackground(new java.awt.Color(224, 224, 224));
    comboDpto.setFont(new java.awt.Font("Andale Mono", 1, 14));
    comboDpto.setForeground(new java.awt.Color(225, 0, 0));
    add(comboDpto);
    comboDpto.addItem("");
    comboDpto.addItem("Atencion al Cliente");
    comboDpto.addItem("Departamento de Logistica");
    comboDpto.addItem("Departamento de Gerencia");

    antiguedad = new JLabel("Selecciona la Antiguedad");
    antiguedad.setBounds(220,248,180,25);
    antiguedad.setFont(new Font("Andale Mono", 1, 12));
    antiguedad.setForeground(new Color(255,255,255));
    add(antiguedad);

    comboAntiguedad = new JComboBox();
    comboAntiguedad.setBounds(220,273,220,25);
    comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224));
    comboAntiguedad.setFont(new java.awt.Font("Andale Mono", 1, 14));
    comboAntiguedad.setForeground(new java.awt.Color(225, 0, 0));
    add(comboAntiguedad);
    comboAntiguedad.addItem("");
    comboAntiguedad.addItem("1 año de servicio");
    comboAntiguedad.addItem("2 a 6 años de servicio");
    comboAntiguedad.addItem("7 años o mas de servicio");

    resultadoCalculo = new JLabel("Resultado del Calculo");
    resultadoCalculo.setBounds(220,307,180,25);
    resultadoCalculo.setFont(new Font("Andale Mono", 1, 12));
    resultadoCalculo.setForeground(new Color(255,255,255));
    add(resultadoCalculo);

    area = new JTextArea();
    area.setEditable(false);
    area.setBackground(new Color(224,224,224));
    area.setFont(new Font("Andale Mono", 1, 11));
    area.setForeground(new Color(255, 0, 0));
    area.setText("\n Aqui aparece el resultado del calculo de las vacaciones.");
    scroll = new JScrollPane(area);
    scroll.setBounds(220,333,385,90);
    add(scroll);

    footer = new JLabel("2017 The Coca-Cola Company | Todos los derechos reservados");
    footer.setBounds(135,445,500,30);
    footer.setFont(new java.awt.Font("Andale Mono", 1, 12));
    footer.setForeground(new java.awt.Color(255,255,255));
    add(footer);
  }  

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == miCalculo){
      String nombreTrabajador = txtNombreTrabajador.getText();
      String AP = txtAPaternoTrabajador.getText();
      String AM = txtAMaternoTrabajador.getText();
      String Departamento = comboDpto.getSelectedItem().toString();
      String Antiguedad = comboAntiguedad.getSelectedItem().toString();

      if(nombreTrabajador.equals("") || AP.equals("") || AM.equals("") ||
         Departamento.equals("") || Antiguedad.equals("")){

        JOptionPane.showMessageDialog(null,"Debes de llenar todos los campos");
        
      } else{

        if(Departamento.equals("Atencion al Cliente")){
          if(Antiguedad.equals("1 año de servicio")){
            area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 6 dias de vacaciones");
          }
          if(Antiguedad.equals("2 a 6 años de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 14 dias de vacaciones");
          }
          if(Antiguedad.equals("7 años o mas de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 20 dias de vacaciones");
          }
        }
        if(Departamento.equals("Departamento de Logistica")){
          if(Antiguedad.equals("1 año de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 7 dias de vacaciones");
          }
          if(Antiguedad.equals("2 a 6 años de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 15 dias de vacaciones");
          }
          if(Antiguedad.equals("7 años o mas de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 22 dias de vacaciones");
          }
        }
        if(Departamento.equals("Departamento de Gerencia")){
          if(Antiguedad.equals("1 año de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 10 dias de vacaciones");
          }
          if(Antiguedad.equals("2 a 6 años de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 20 dias de vacaciones");
          }
          if(Antiguedad.equals("7 años o mas de servicio")){
              area.setText("\n El trabajador " + nombreTrabajador + " " + AP + " " +
                          AM + "\n quien trabaja en " + Departamento + " con " +
                           Antiguedad + "\n le corresponden 30 dias de vacaciones");
          }
        }
      }
    }
    if(e.getSource() == miRojo){
      getContentPane().setBackground(new Color(255,0,0));
    }
    if(e.getSource() == miNegro){
      getContentPane().setBackground(new Color(0,0,0));
    }
    if(e.getSource() == miMorado){
      getContentPane().setBackground(new Color(59,23,99));
    }
    if(e.getSource() == miNuevo){
      
      txtNombreTrabajador.setText("");
      txtAPaternoTrabajador.setText("");
      txtAMaternoTrabajador.setText("");
      comboDpto.setSelectedIndex(0);
      comboAntiguedad.setSelectedIndex(0);
      area.setText("\n aqui aparece el resultado del calculo de las vacaciones.");
    }
    if(e.getSource() == miSalir){
      Bienvenida bienvenida = new Bienvenida();
      bienvenida.setBounds(0,0,350,450);
      bienvenida.setVisible(true);
      bienvenida.setResizable(false);
      bienvenida.setLocationRelativeTo(null);
      this.setVisible(false);
    }
    if(e.getSource() == miElCreador){
      JOptionPane.showMessageDialog(null,"Uriel Rodriguez Lagorio,"
                  + " el crack que creo este software." +
                   "\n  para mas creaciones: https://www.instagram.com/_rodriguezuri/?hl=es-la ");
    }
  }

  public static void main(String args[]){
    Principal principal = new Principal();
    principal.setBounds(0,0,640,535);
    principal.setVisible(true);
    principal.setResizable(false);
    principal.setLocationRelativeTo(null);
 }
}