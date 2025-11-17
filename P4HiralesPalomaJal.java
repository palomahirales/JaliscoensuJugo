//package prueba;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class P4HiralesPalomaJal extends JFrame implements ActionListener{
	private JButton bMenu, bNosotros, bFacturacion, bContactanos;
	private ImageIcon iFondoInicio;
	private JLabel eFondoInicio;

	private static Toolkit configuracion = Toolkit.getDefaultToolkit();
	private static Dimension dimensionPantalla = configuracion.getScreenSize();
	private static int anchura = dimensionPantalla.width - 50;
	private static int altura = dimensionPantalla.height - 50;

	public static void main(String[] args) {
		P4HiralesPalomaJal Programa = new P4HiralesPalomaJal ();
		Programa.setSize(anchura, altura);
		Programa.crearInterfaz();
		Programa.setTitle("Jalisco en su Jugo");
		Programa.setVisible(true);
	}
	
	private void crearInterfaz(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container ventana = getContentPane(); //se crea la ventana como un container
		ventana.setLayout(new FlowLayout());
	
		iFondoInicio = new ImageIcon(new ImageIcon("FondoInicio.jpg").getImage().getScaledInstance(anchura, altura, Image.SCALE_DEFAULT));
  	   	Image img1 = iFondoInicio.getImage();
		JLabel eFondoInicio = new JLabel();
		eFondoInicio.setIcon(iFondoInicio);
		eFondoInicio.setBounds(0, 0, anchura, altura);
		ventana.add(eFondoInicio);

		bMenu = new JButton("Salir");
		ventana.add(bMenu);
		bMenu.addActionListener(this);
	}

	public void actionPerformed (ActionEvent listaDeEventos){
		Object evento = listaDeEventos.getSource();

		if(evento == bMenu){
			System.exit(0);
		}
	}
}