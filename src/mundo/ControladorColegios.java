package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import arboles.ArbolRojoNegro;
import arboles.NodoRojoNegro;

public class ControladorColegios {
	
	private ArbolRojoNegro<Colegio> arn;
	private NodoRojoNegro<Colegio> nill;
	private String[][] infoColegios;
	
	public ControladorColegios(){
		nill= new NodoRojoNegro<Colegio>();
		arn= new ArbolRojoNegro<Colegio>(nill);
	}
	public void cargarArchivos() throws Exception{
		cargarArchivosArn();
	}
	public void cargarArchivosArn() throws Exception{
		File archivo=new File("./docs/LISTADO_COLEGIOS_BOGOTA.csv");
		try {
			BufferedReader br=new BufferedReader(new FileReader(archivo));
			br.readLine();
			String mensaje= br.readLine();
			infoColegios= new String[2404][7];
			int contador=0;
			while(mensaje!=null && !mensaje.isEmpty()) {
				String[] infoColegio= mensaje.split(",");
				String calendario=infoColegio[0];
				String sector=infoColegio[1];
				String nombre=infoColegio[2]; 
				String telefono=infoColegio[3];
				String rector=infoColegio[4]; 
				String correo=infoColegio[5];
				String direccion=infoColegio[6];
				Colegio agregar= new Colegio(calendario, sector, nombre, telefono, rector, correo, direccion);
				agregar.setBusquedaActual(1);
				NodoRojoNegro<Colegio> nodoAgregar= new NodoRojoNegro<Colegio>(agregar,nill);
				try {
					arn.agregarNodo(nodoAgregar);
//					mensaje= br.readLine();
				} catch (Exception e) {
//					System.out.println(contador);
//					contador++;
				}
				if(agregar!=null) {
				infoColegios[contador][0]= agregar.getCalendario();
				infoColegios[contador][1]= agregar.getSector();
				infoColegios[contador][2]= agregar.getNombre();
				infoColegios[contador][3]= agregar.getTelefono()+"";
				infoColegios[contador][4]= agregar.getRector();
				infoColegios[contador][5]= agregar.getCorreo();
				infoColegios[contador][6]= agregar.getDireccion();
				}
				contador++;
				mensaje= br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al leer el archivo");
		}
	}
	public void generarInfoColegiosArn() {
		ArrayList<Colegio> colegios= new ArrayList<Colegio>(); 
		
		arn.inOrder(colegios);
		
		infoColegios= new String[colegios.size()][7];
		
		for (int i = 0; i < colegios.size(); i++) {
			Colegio temp= colegios.get(i);
			if(temp!=null) {
			infoColegios[i][0]= temp.getCalendario();
			infoColegios[i][1]= temp.getSector();
			infoColegios[i][2]= temp.getNombre();
			infoColegios[i][3]= temp.getTelefono()+"";
			infoColegios[i][4]= temp.getRector();
			infoColegios[i][5]= temp.getCorreo();
			infoColegios[i][6]= temp.getDireccion();
			}
		}
	}
	public ArbolRojoNegro<Colegio> getArn() {
		return arn;
	}
	public void setArn(ArbolRojoNegro<Colegio> arn) {
		this.arn = arn;
	}
	public NodoRojoNegro<Colegio> getNill() {
		return nill;
	}
	public void setNill(NodoRojoNegro<Colegio> nill) {
		this.nill = nill;
	}
	public String[][] getInfoColegios() {
		return infoColegios;
	}
	public void setInfoColegios(String[][] infoColegios) {
		this.infoColegios = infoColegios;
	}
}
