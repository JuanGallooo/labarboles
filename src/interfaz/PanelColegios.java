package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelColegios extends JPanel{
	private JTable tabla;
	private JLabel[] cabeza;
	
	public PanelColegios(String[][] infoDada){
		TitledBorder bordePrincipal= new TitledBorder("Informacion Colegios Bogota");
	    setBorder(bordePrincipal);
	    setLayout(new BorderLayout());
	    TitledBorder borde= new TitledBorder("");
		MatteBorder contorno=  new MatteBorder(1, 1, 1, 1, Color.BLACK);
		borde.setBorder(contorno);
		JPanel aux= new JPanel();
		aux.setLayout(new GridLayout(1,7));
		JPanel auxiliar= new JPanel();
		auxiliar.setLayout(new GridLayout(1, 1));
		String[] cabezaInfo= {"Calendario","Sector","Nombre","Telefono","Rector","Correo Electronico","Direccion"};
		cabeza= new JLabel[7];
		for (int i = 0; i < cabezaInfo.length; i++) {
			cabeza[i]= new JLabel(cabezaInfo[i]);
			aux.add(cabeza[i]);
		}
	    tabla= new JTable(infoDada, cabezaInfo);
	    auxiliar.add(tabla);
	    add(aux, BorderLayout.NORTH);
	    add(new JScrollPane(auxiliar), BorderLayout.CENTER);
	}
}
