package mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import arboles.ArbolRojoNegro;
import arboles.NodoRojoNegro;

public class ControladorColegios {
	
	private ArbolRojoNegro<Colegio> arn;
	private NodoRojoNegro<Colegio> nill;
	private String[][] infoColegios;
	
	public ControladorColegios() {
		nill= new NodoRojoNegro<Colegio>();
		arn= new ArbolRojoNegro<Colegio>(nill);
	}
	public void cargarArchivos() {
		cargarArchivosArn();
	}
	public void cargarArchivosArn() {
		File archivo=new File("./docs/LISTADO_COLEGIOS_BOGOTA.csv");
		try {
			BufferedReader br=new BufferedReader(new FileReader(archivo));
		} catch (Exception e) {
		}
	}
}
