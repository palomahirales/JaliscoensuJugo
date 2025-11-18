//package prueba;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class P4HiralesPalomaJal extends JFrame implements ActionListener{
	private ImageIcon iFondoInicio, iNosotros;
	private JLabel eFondoInicio, eNosotros;
	private JButton bMenu, bNosotros, bContactanos, bRegresar;
	private JTextArea tNosotros;
	private Container ventana;

	//para encontrar las dimensiones de diferentes pantallas
	private static Toolkit configuracion = Toolkit.getDefaultToolkit();
	private static Dimension dimensionPantalla = configuracion.getScreenSize();
	private static int anchura = dimensionPantalla.width;
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
		ventana = new Container();
		ventana = getContentPane(); //se crea la ventana como un container
		ventana.setLayout(null);

		//instancias para seguir usando en los objetos
		Color azulRey = new Color(0, 28, 50);
		Color cianFuerte = new Color(27, 60, 87);
		Color babyBlue = new Color(231, 237, 241);
		Color arena = new Color(247, 221, 192);
		Color arenaClara = new Color(255, 241, 212);
		Font fuenteLeagueGothic = new Font("LeagueGothic", 3, 58);
		Font fuenteWorkSans = new Font("WorkSans", 0, 25);

		ventana.setBackground(azulRey); //cambio el color del fondo

		//imagen del fondo
		iFondoInicio = new ImageIcon(new ImageIcon("FondoInicio.jpg").getImage().getScaledInstance(anchura, returnInt(0.85*altura), Image.SCALE_DEFAULT));
		eFondoInicio = new JLabel("Imagen fondo Jalisco");
		eFondoInicio.setIcon(iFondoInicio);
		eFondoInicio.setBounds(0, 0, anchura, returnInt(0.85*altura));
		ventana.add(eFondoInicio);

		//instanciar del boton de nosotros
		bNosotros = new JButton("Nosotros");
		bNosotros.setBounds(returnInt(0.02*anchura), returnInt(0.86*altura), returnInt(0.30*anchura), returnInt(0.1*altura));
		bNosotros.setFont(fuenteLeagueGothic); 
		bNosotros.setBackground(cianFuerte); //color del boton
		bNosotros.setForeground(babyBlue); //color del texto
		ventana.add(bNosotros);
		bNosotros.addActionListener(this);

		//instanciar del boton de menu
		String nombreBotonMenu = new String("Menú");
		bMenu = new JButton(nombreBotonMenu);
		bMenu.setBounds(returnInt(0.35*anchura), returnInt(0.86*altura), returnInt(0.30*anchura), returnInt(0.1*altura));
		bMenu.setFont(fuenteLeagueGothic);
		bMenu.setBackground(cianFuerte);
		bMenu.setForeground(babyBlue);
		ventana.add(bMenu);
		bMenu.addActionListener(this);

		//instanciar del boton de contactanos
		String nombreBotonContactanos = new String("Contáctanos");
		bContactanos = new JButton(nombreBotonContactanos);
		bContactanos.setBounds(returnInt(0.68*anchura), returnInt(0.86*altura), returnInt(0.30*anchura), returnInt(0.1*altura));
		bContactanos.setFont(fuenteLeagueGothic);
		bContactanos.setBackground(cianFuerte);
		bContactanos.setForeground(babyBlue);
		ventana.add(bContactanos);
		bContactanos.addActionListener(this);

		//instanciar del boton de regresar
		bRegresar = new JButton("Regresar");
		bRegresar.setBounds(returnInt(0.35*anchura), returnInt(0.86*altura), returnInt(0.30*anchura), returnInt(0.1*altura));
		bRegresar.setFont(fuenteLeagueGothic);
		bRegresar.setBackground(cianFuerte);
		bRegresar.setForeground(babyBlue);
		bRegresar.setVisible(false);
		ventana.add(bRegresar);
		bRegresar.addActionListener(this);

		//imagen de la pagina de nosotros
		iNosotros = new ImageIcon(new ImageIcon("ImagenNosotros.jpg").getImage().getScaledInstance(anchura, returnInt(0.85*altura), Image.SCALE_DEFAULT));
		eNosotros = new JLabel("Imagen mural Nosotros");
		eNosotros.setIcon(iNosotros);
		eNosotros.setBounds(0, 0, anchura, returnInt(0.85*altura));
		eNosotros.setVisible(false);
		ventana.add(eNosotros);
	}

	public void actionPerformed (ActionEvent listaDeEventos){
		Object evento = listaDeEventos.getSource();
		Color arena = new Color(247, 221, 192);
		Color arenaClara = new Color(255, 241, 212);

		if(evento == bNosotros){
			switchObjetos(false);
			bRegresar.setBackground(arenaClara);
			bRegresar.setForeground(Color.BLACK);
			eNosotros.setVisible(true);
			ventana.setBackground(arena);
		}

		if(evento == bMenu){
			System.exit(0);
		}

		if(evento == bContactanos){
			System.exit(0);
		}

		if(evento == bRegresar){
			switchObjetos(true);
		}
	}
	
	private static int returnInt (double numeroDecimal){
		int numeroEntero = (int) Math.round(numeroDecimal);
		return numeroEntero;
	}

	public void switchObjetos (boolean opcion){ //los objetos regresan al estado elegido
		bContactanos.setVisible(opcion);
		bMenu.setVisible(opcion);
		bNosotros.setVisible(opcion);
		bRegresar.setVisible(!opcion);
		eFondoInicio.setVisible(opcion);

		Color azulRey = new Color(0, 28, 50);

		eNosotros.setVisible(false);
		ventana.setBackground(azulRey);
		return;
	}
}