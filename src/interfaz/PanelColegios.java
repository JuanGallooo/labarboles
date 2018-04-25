package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelColegios extends JPanel{

	private JLabel[] cabeza;
	private JLabel[][] info;
	
	public PanelColegios(String[][] infoDada){
//		setPreferredSize(new Dimension(600,600));
		TitledBorder bordePrincipal= new TitledBorder("Informacion Colegios Bogota");
	    setBorder(bordePrincipal);
	    setLayout(new BorderLayout());
	    
	    TitledBorder borde= new TitledBorder("");
		MatteBorder contorno=  new MatteBorder(1, 1, 1, 1, Color.BLACK);
		borde.setBorder(contorno);
		JPanel auxiliar= new JPanel();
		auxiliar.setLayout(new GridLayout(1, 7));
		cabeza= new JLabel[7];
		String[] cabezaInfo= {"Calendario","Sector","Nombre","Telefono","Rector","Correo Electronico","Direccion"};
		for (int i = 0; i < cabeza.length; i++) {
			cabeza[i]= new JLabel(cabezaInfo[i]);
//			cabeza[i].setHorizontalAlignment(JLabel.CENTER);
			cabeza[i].setBorder(borde);
//			cabeza[i].set
			auxiliar.add(cabeza[i]);
		}
	    JPanel aux=new JPanel();
	    aux.setLayout(new GridLayout(infoDada.length, infoDada[0].length));
		
		info= new JLabel[infoDada.length][infoDada[0].length];
		
		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info[0].length; j++){
				info[i][j]=new JLabel(infoDada[i][j]);
				info[i][j].setHorizontalAlignment(JLabel.CENTER);
				info[i][j].setBorder(borde);
				aux.add(info[i][j]);
			}
		}
		add(auxiliar, BorderLayout.CENTER);
		add(aux, BorderLayout.SOUTH);
	}
}
