package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{

	public static final String BUSCAR_NOMBRE="BUSCAR_NOMBRE";
	public static final String BUSCAR_TELEFONO="BUSCAR_TELEFONO";
	public static final String BUSCAR_CORREO="BUSCAR_CORREO";
	
	private JButton btnNombre;
	private JButton btnTelefono;
	private JButton btnCorreo;
	
	private FramePrincipal principal;
	
	public PanelBotones(FramePrincipal p) {
		principal= p;
		
		setPreferredSize(new Dimension(300,400));
		TitledBorder borde= new TitledBorder("Opciones");
	    setBorder(borde);
	    setLayout(new BorderLayout());
	    
	    btnNombre= new JButton("Buscar Nombre(AVL)");
	    btnNombre.setActionCommand(BUSCAR_NOMBRE);
	    btnNombre.addActionListener(this);
	    btnNombre.setPreferredSize(new Dimension(100, 100));
	    btnTelefono= new JButton("Buscar telefono(ARN)");
	    btnTelefono.setActionCommand(BUSCAR_TELEFONO);
	    btnTelefono.addActionListener(this);
	    btnTelefono.setPreferredSize(new Dimension(100, 100));
	    btnCorreo= new JButton("Buscar Correo Electronico(ABB)");
	    btnCorreo.setActionCommand(BUSCAR_CORREO);
	    btnCorreo.addActionListener(this);
	    btnCorreo.setPreferredSize(new Dimension(100, 100));
	    
	    
	    add(btnNombre, BorderLayout.EAST);
	    add(btnTelefono, BorderLayout.CENTER);
	    add(btnCorreo, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String seleccion= arg0.getActionCommand();
		String texto= JOptionPane.showInputDialog(this, "Ingrese el respectivo dato de busqueda");
		if( !texto.equals("") && texto != null) {
		if( seleccion.equals(BUSCAR_NOMBRE))principal.buscarNombreAVL(texto);
		else if( seleccion.equals(BUSCAR_TELEFONO))principal.buscarTelefonoARN(texto);
		else if( seleccion.equals(BUSCAR_CORREO))principal.buscarCorreoABB(texto);
		}
		else JOptionPane.showMessageDialog(this, "Elemento no valido", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
