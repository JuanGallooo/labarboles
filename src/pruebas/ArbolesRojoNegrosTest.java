package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import arboles.ArbolRojoNegro;
import arboles.NodoRojoNegro;
import mundo.Colegio;

public class ArbolesRojoNegrosTest {
	private ArbolRojoNegro<Colegio> arn;
	private NodoRojoNegro<Colegio> nill;
	
	private void escenarioInicial(){
		nill =  new NodoRojoNegro<Colegio>();
		arn = new ArbolRojoNegro<Colegio>(nill);
	}
	
	private Colegio[] colegiosBase(){
		Colegio uno
	}

	@Test
	public void agregarNodoTest() {
		//Agregado Simple
		
		
	}

}
