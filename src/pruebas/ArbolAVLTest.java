package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import arboles.ArbolAVL;
import arboles.ArbolRojoNegro;
import mundo.Colegio;

public class ArbolAVLTest {
	
	private ArbolAVL<Colegio> avl;
	private ArrayList<Colegio> arreglo;
	
   private void escenarioInicial(){
	   
    avl = new ArbolAVL<Colegio>();
	arreglo = new ArrayList<Colegio>();
	colegiosBase();
}

    private void colegiosBase(){
	Colegio uno = new Colegio("","","Frances", "","","",""); 
	uno.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio dos = new Colegio("","","Boston", "","","","");
	dos.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio tres = new Colegio("","","Agustiniano", "","","","");
	tres.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio cuatro = new Colegio("","","Enseñanza", "","","","");
	cuatro.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio cinco = new Colegio("","","Comercial", "","","","");
	cinco.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio seis = new Colegio("","","Colombo", "","","","");
	seis.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio siete = new Colegio("","","Pio", "","","","");
	siete.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio ocho = new Colegio("","","Fray", "","","","");
	ocho.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio nueve = new Colegio("","","Philadelphia", "","","","");
	nueve.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	Colegio diez = new Colegio("","","Ingles", "","","","");
	diez.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
	
	arreglo.add(uno);
	arreglo.add(dos);
	arreglo.add(tres);
	arreglo.add(cuatro);
	arreglo.add(cinco);
	arreglo.add(seis);
	arreglo.add(siete);
	arreglo.add(ocho);
	arreglo.add(nueve);
	arreglo.add(diez);
	
	
}
	
	@Test
	public void agregarNodoTest() {
		escenarioInicial();
		
		//Agregar simple
		
		for(int i = 0; i < 3; i++){
		avl.insertar(arreglo.get(i));
		}
		
		assertSame(avl.getRaiz().getElemento(), arreglo.get(1));
		assertSame(avl.getRaiz().getDerecha().getElemento(), arreglo.get(0));
		assertSame(avl.getRaiz().getIzquierda().getElemento(),arreglo.get(2));

		
		
	}
	@Test
	public void buscarNodoTest() { 
		
	}
	@Test
	public void eliminarNodoTest() { 
		assertTrue(true);
	}

}
