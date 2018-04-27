package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		try {
			mundo.cargarArchivos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
		
		setPreferredSize(new Dimension(900,600));
		setTitle("ColegiosBogota");
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		banner= new JLabel();
		ImageIcon icono5 = new ImageIcon("./imgs/bogota.jpg");
		banner.setIcon(icono5);
		miPanelColegios= new PanelColegios(mundo.getInfoColegios());
		miPanelBotones= new PanelBotones(this);
		JScrollPane deslizar= new JScrollPane(miPanelColegios);
		add(banner, BorderLayout.NORTH);
		add(deslizar, BorderLayout.CENTER);
		add(miPanelBotones, BorderLayout.SOUTH);
		pack();
	}
	public static void main(String[] args) {
		FramePrincipal ventana= new FramePrincipal();
		ventana.setVisible(true);
	}
	public void buscarNombreAVL(String texto) {
		try {
			Long inicio=System.nanoTime();
			String retorno=mundo.buscarNombreAVL(texto);
			Long finalTiempo = System.nanoTime();
			String calculo= (finalTiempo-inicio)+"";
			JOptionPane.showMessageDialog(this,"El elemento solicitado es "+ retorno + " y su tiempo de busqueda fue de "+ calculo + "En nanosegundos");	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
	public void buscarTelefonoARN(String texto) {
		try {
			Long inicio=System.nanoTime();
			String retorno=mundo.buscarTelefonoARN(texto);
			Long finalTiempo = System.nanoTime();
			String calculo= (finalTiempo-inicio)+"";
			JOptionPane.showMessageDialog(this,"El elemento solicitado es "+ retorno + " y su tiempo de busqueda fue de "+ calculo + "En nanosegundos");	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
	public void buscarRectorABB(String texto) {
		try {
			Long inicio=System.nanoTime();
			String retorno=mundo.buscarRectorABB(texto);
			Long finalTiempo = System.nanoTime();
			String calculo= (finalTiempo-inicio)+"";
			JOptionPane.showMessageDialog(this,"El elemento solicitado es "+ retorno + " y su tiempo de busqueda fue de "+ calculo + "En nanosegundos");	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
	}
}
