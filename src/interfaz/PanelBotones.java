package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener{

	public static final String BUSCAR_NOMBRE="BUSCAR_NOMBRE";
	public static final String BUSCAR_TELEFONO="BUSCAR_TELEFONO";
	public static final String BUSCAR_RECTOR="BUSCAR_RECTOR";
	
	private JButton btnNombre;
	private JButton btnTelefono;
	private JButton btnRector;
	
	private FramePrincipal principal;
	
	public PanelBotones(FramePrincipal p) {
		principal= p;
		
		TitledBorder borde= new TitledBorder("Opciones");
	    setBorder(borde);
	    setLayout(new GridLayout(1, 3));
	    
	    btnNombre= new JButton("Buscar por nombre(AVL)");
	    btnNombre.setActionCommand(BUSCAR_NOMBRE);
	    btnNombre.addActionListener(this);
	    btnTelefono= new JButton("Buscar por telefono(ARN)");
	    btnTelefono.setActionCommand(BUSCAR_TELEFONO);
	    btnTelefono.addActionListener(this);
	    btnRector= new JButton("Buscar por rector(ABB)");
	    btnRector.setActionCommand(BUSCAR_RECTOR);
	    btnRector.addActionListener(this);
	    add(btnNombre);
	    add(btnTelefono);
	    add(btnRector);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String seleccion= arg0.getActionCommand();
		String texto= JOptionPane.showInputDialog(this, "Ingrese el respectivo dato de busqueda");
		if( texto != null&& !texto.equals("")) {
		if( seleccion.equals(BUSCAR_NOMBRE))principal.buscarNombreAVL(texto);
		else if( seleccion.equals(BUSCAR_TELEFONO))principal.buscarTelefonoARN(texto);
		else if( seleccion.equals(BUSCAR_RECTOR))principal.buscarRectorABB(texto);
		}
		else JOptionPane.showMessageDialog(this, "Elemento no valido", "Error", JOptionPane.WARNING_MESSAGE);
	}
}
