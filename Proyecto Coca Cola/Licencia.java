import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{

  private JButton boton1, boton2;
  private JLabel label1, label2;
  private JCheckBox check;
  private JScrollPane scroll;
  private JTextArea area;
  String nombre = "";

  public Licencia(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Licencia de uso");
    setIconImage(new ImageIcon(getClass().getResource("images/icon.png")).getImage());
    Bienvenida ventanaBienvenida = new Bienvenida();
    nombre = ventanaBienvenida.texto;

    label1 = new JLabel("Terminos y condiciones");
    label1.setBounds(215,5,200,30);
    label1.setFont(new Font("Andale Mono", 1, 14));
    label1.setForeground(new Color(0,0,0));
    add(label1);

    area = new JTextArea();
    area.setEditable(false);
    area.setFont(new Font("Andale Mono", 0,9));
    area.setText("\n\n          TERMINOS Y CONDICIONES" +
                  "\n\n          A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE LA GEEKIPEDIA DE ERNESTO." +
                  "\n          B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                  "\n          C.  LA GEEKIPEDIA DE ERNESTO NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                  "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" + 
                  "\n          (URI EL LINDO Y SU AUTOR URADIELAN),  NO SE RESPONSABILIZAN DEL USO QUE USTED HAGA CON ESTE " +
                  "\n          SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLICK EN (ACEPTO) SI USTED NO ACEPTA " +
                  "\n          ESTOS TERMINOS, HAGA CLICK EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." +
                  "\n\n          PARA MAYOR INFORMACION SO9BRE NEUSTROS PRODUCTOS Y SERVICIOS VAYA A: " +
                  "\n             https://www.instagram.com/_rodriguezuri/?hl=es-la");

    scroll = new JScrollPane(area);
    scroll.setBounds(10,40,575,200);
    add(scroll);
   
    check = new JCheckBox("Yo " + nombre + " acepto");
    check.setBounds(10,250,300,30);
    check.addChangeListener(this);
    add(check);

    boton1 = new JButton("Continuar");
    boton1.setBounds(10,290,100,30);
    boton1.addActionListener(this);
    boton1.setEnabled(false);
    add(boton1);
   

    boton2 = new JButton("No Acepto");
    boton2.setBounds(120,290,100,30);
    boton2.addActionListener(this);
    boton2.setEnabled(true);
    add(boton2);

    ImageIcon imagen = new ImageIcon("images/coca-cola.png");
    label2 = new JLabel(imagen);
    label2.setBounds(315,135,300,300);
    add(label2);
  }
  
  public void stateChanged(ChangeEvent e){
    if(check.isSelected() == true){
      boton1.setEnabled(true);
      boton2.setEnabled(false);
    } else{
      boton2.setEnabled(true);
      boton1.setEnabled(false);
    }
  }

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == boton1){
      Principal principal = new Principal();
      principal.setBounds(0,0,640,535);
      principal.setVisible(true);
      principal.setResizable(false);
      principal.setLocationRelativeTo(null);
      this.setVisible(false);
    } else if(e.getSource() == boton2){
      Bienvenida bienvenida = new Bienvenida();
      bienvenida.setBounds(0,0,350,450);
      bienvenida.setVisible(true);
      bienvenida.setResizable(false);
      bienvenida.setLocationRelativeTo(null);
      this.setVisible(false);
    }
  }

  public static void main(String args[]){
   Licencia licencia = new Licencia();
   licencia.setBounds(0,0,615,375);
   licencia.setVisible(true);
   licencia.setResizable(false);
   licencia.setLocationRelativeTo(null);
 }
}