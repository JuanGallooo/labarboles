package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import arboles.Arbol;
import arboles.ArbolAVL;
import arboles.ArbolRojoNegro;
import arboles.NodoArbol;
import arboles.NodoArbolAVL;
import arboles.NodoRojoNegro;

public class ControladorColegios {
	
	private ArbolAVL<Colegio> avl;
	private ArbolRojoNegro<Colegio> arn;
	private NodoRojoNegro<Colegio> nill;
	private Arbol<Colegio> abb;
	private String[][] infoColegios;
	
	public ControladorColegios(){
		nill= new NodoRojoNegro<Colegio>();
		arn= new ArbolRojoNegro<Colegio>(nill);
		avl = new ArbolAVL<Colegio>();
		abb= new Arbol<Colegio>();
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
					agregar.setBusquedaActual(0);
					avl.insertar(agregar);
					agregar.setBusquedaActual(2);
					NodoArbol<Colegio> nodoAgregarABB= new NodoArbol<Colegio>(agregar);
					abb.agregarNodo(nodoAgregarABB);
				} catch (Exception e) {
//					System.out.println(contador);
//					contador++;
				}
				infoColegios[contador][0]= agregar.getCalendario();
				infoColegios[contador][1]= agregar.getSector();
				infoColegios[contador][2]= agregar.getNombre();
				infoColegios[contador][3]= agregar.getTelefono()+"";
				infoColegios[contador][4]= agregar.getRector();
				infoColegios[contador][5]= agregar.getCorreo();
				infoColegios[contador][6]= agregar.getDireccion();
				contador++;
				mensaje= br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error al leer el archivo");
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

	public String buscarNombreAVL(String texto) throws Exception{
		Colegio agregar= new Colegio("", "",  texto,"", "","", "");
		agregar.setBusquedaActual(0);
		NodoArbolAVL<Colegio> nodoComparar= new NodoArbolAVL<Colegio>(agregar);
		String retorno=avl.buscarNodo(nodoComparar).getElemento().toString();
		return retorno;
	}
	public String buscarTelefonoARN(String texto) throws Exception{
		Colegio agregar= new Colegio("", "", "", texto, "","", "");
		agregar.setBusquedaActual(1);
		String retorno=arn.elementoBuscado(agregar);
		return retorno;
	}
	public String buscarRectorABB(String texto) throws Exception{
		Colegio agregar= new Colegio("", "", "", "", texto,"", "");
		agregar.setBusquedaActual(2);
		NodoArbol<Colegio> nodoComparar= new NodoArbol<Colegio>(agregar);
		String retorno=abb.buscarNodo(nodoComparar).getElemento().toString();
		return retorno;
	}
}
