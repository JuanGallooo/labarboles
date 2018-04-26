package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import arboles.ArbolAVL;
import arboles.ArbolRojoNegro;
import arboles.NodoArbolAVL;
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
		
		for(int i = 3; i < arreglo.size(); i++){
			avl.insertar(arreglo.get(i));
		}
		
		
		//Primeros 3
		assertSame(avl.getRaiz().getElemento(), arreglo.get(4));
		assertSame(avl.getRaiz().getDerecha().getElemento(), arreglo.get(7));
		assertSame(avl.getRaiz().getIzquierda().getElemento(),arreglo.get(1));
		
		//SubArbol Izquierdo del Izquierdo de la raiz
		assertSame(avl.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(2));
		assertSame(avl.getRaiz().getIzquierda().getDerecha().getElemento(), arreglo.get(5));
		
		//SubArbol Derecho del Derecho de la raiz
		assertSame(avl.getRaiz().getDerecha().getIzquierda().getElemento(),arreglo.get(0));
		assertSame(avl.getRaiz().getDerecha().getIzquierda().getIzquierda().getElemento(), arreglo.get(3));
		assertSame(avl.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(8));
		assertSame(avl.getRaiz().getDerecha().getDerecha().getDerecha().getElemento(),arreglo.get(6));
		assertSame(avl.getRaiz().getDerecha().getDerecha().getIzquierda().getElemento(),arreglo.get(9));
			
		//Organizacion
		System.out.println("Organización actual del arbol AVL");
		//Primeros 3
		System.out.println("Raiz: " + avl.getRaiz().getElemento());
		System.out.println("Derecha: " + avl.getRaiz().getDerecha().getElemento());
		System.out.println("Izquierda: " + avl.getRaiz().getIzquierda().getElemento());
		
		//SubArbol Izquierdo del Izquierdo de la raiz
		System.out.println("Izquierda de "+  avl.getRaiz().getIzquierda().getElemento().getNombre()+ ": "+ avl.getRaiz().getIzquierda().getIzquierda().getElemento());
		System.out.println("Derecha de " + avl.getRaiz().getIzquierda().getElemento().getNombre()+ ": "+ avl.getRaiz().getIzquierda().getDerecha().getElemento());
		
		//SubArbol Derecho del Derecho de la raiz
		System.out.println("Izquierda de "+  avl.getRaiz().getDerecha().getElemento().getNombre()+ ": "+avl.getRaiz().getDerecha().getIzquierda().getElemento());
		System.out.println("Izquierda de "+  avl.getRaiz().getDerecha().getIzquierda().getElemento().getNombre()+ ": "+avl.getRaiz().getDerecha().getIzquierda().getIzquierda().getElemento());
		System.out.println("Derecha de " + avl.getRaiz().getDerecha().getElemento().getNombre()+ ": "+avl.getRaiz().getDerecha().getDerecha().getElemento());
		System.out.println("Derecha de " + avl.getRaiz().getDerecha().getDerecha().getElemento().getNombre()+ ": "+avl.getRaiz().getDerecha().getDerecha().getDerecha().getElemento());
		System.out.println("Izquierda de "+  avl.getRaiz().getDerecha().getDerecha().getElemento().getNombre()+ ": "+avl.getRaiz().getDerecha().getDerecha().getIzquierda().getElemento());	
		
	}
	@Test
	public void buscarNodoTest() { 
		escenarioInicial();
		for(int i = 0; i < arreglo.size(); i++){
			avl.insertar(arreglo.get(i));
		}
		//Caso 1
		Colegio buscar = new Colegio("","","Fray", "","","","");
		buscar.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
		
		NodoArbolAVL<Colegio> buscado = new NodoArbolAVL<Colegio>(buscar);
		NodoArbolAVL<Colegio> encontrado = avl.buscarNodo(buscado);
		
		assertTrue(encontrado != null);
		assertSame(encontrado.getElemento(), arreglo.get(7));
		//Caso 2
		buscar =  new Colegio("","","Enseñanza", "","","","");
		buscar.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
		
	    buscado = new NodoArbolAVL<Colegio>(buscar);
		encontrado = avl.buscarNodo(buscado);
		
		assertTrue(encontrado != null);
		assertSame(encontrado.getElemento(), arreglo.get(3));
		
		//Caso 3
		buscar =  new Colegio("","","Nuevo", "","","","");
		buscar.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
		
		avl.insertar(buscar);
		
		buscado = new NodoArbolAVL<Colegio>(buscar);
		encontrado = avl.buscarNodo(buscado);
		
		assertTrue(encontrado != null);
		assertSame(encontrado.getElemento(), buscar);
		
	    //Caso 4
		
		buscar =  new Colegio("","","No Existe", "","","","");
		buscar.setBusquedaActual(Colegio.BUSQUEDA_NOMBRE);
		
		buscado = new NodoArbolAVL<Colegio>(buscar);
		encontrado = avl.buscarNodo(buscado);
		
		assertTrue(encontrado == null);
		
		
	}
	@Test
	public void eliminarNodoTest() { 
		assertTrue(true);
	}

}
