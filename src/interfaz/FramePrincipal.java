package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import mundo.ControladorColegios;

@SuppressWarnings("serial")
public class FramePrincipal extends JFrame
{
	
	private JLabel banner;
	
	private PanelBotones miPanelBotones;
	private PanelColegios miPanelColegios;
	
	private ControladorColegios mundo;
	
	public FramePrincipal() {
		
		mundo= new ControladorColegios();
		mundo.cargarArchivos();
		
		setPreferredSize(new Dimension(900,600));
		setTitle("ColegiosBogota");
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		banner= new JLabel();
		ImageIcon icono5 = new ImageIcon("./imgs/bogota.jpg");
		banner.setIcon(icono5);
		
		miPanelColegios= new PanelColegios(null);
		miPanelBotones= new PanelBotones(this);
		
		JScrollPane deslizar= new JScrollPane(miPanelColegios);
		
		add(banner, BorderLayout.SOUTH);
		add(deslizar, BorderLayout.CENTER);
		add(miPanelBotones, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		FramePrincipal ventana= new FramePrincipal();
		ventana.setVisible(true);
	}
	public void buscarNombreAVL(String texto) {
		
	}
	public void buscarTelefonoARN(String texto) {
		
	}
	public void buscarCorreoABB(String texto) {
		
	}
}