package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import arboles.Arbol;
import arboles.NodoArbol;

public class ArbolBinarioBusquedaTest {
	
	
	private Arbol<String> abb;
	private ArrayList<String> arreglo;
	
	private void escenarioInicial(){
		abb = new Arbol();
		arreglo = new ArrayList<String>();
		
		String uno = "4";
		String dos = "6";
	    String tres = "5";
	    String cuatro = "2";
	    String cinco = "3";
	    String seis = "1";
	    String siete = "8";
	    String ocho = "7";
	    String nueve = "9";
		
	    arreglo.add(uno);
		arreglo.add(dos);
		arreglo.add(tres);
		arreglo.add(cuatro);
		arreglo.add(cinco);
		arreglo.add(seis);
		arreglo.add(siete);
		arreglo.add(ocho);
		arreglo.add(nueve);
	}

	@Test
	public void agregarNodoTest() {
		escenarioInicial();
		//Agregado Simple
		
		for(int i = 0; i < 3; i++){
			NodoArbol<String> nuevo =  new NodoArbol(arreglo.get(i));
		   try {
			abb.agregarNodo(nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No se esperaba la excepcion");
		}
		}
		assertSame(abb.getRaiz().getElemento(), arreglo.get(0));
		assertSame(abb.getRaiz().getDerecha().getElemento(), arreglo.get(1));
		assertSame(abb.getRaiz().getDerecha().getIzquierda().getElemento(), arreglo.get(2));
		assertTrue(abb.getRaiz().getIzquierda() == null);
		
		for(int i = 3; i < arreglo.size(); i++){
			NodoArbol<String> nuevo =  new NodoArbol(arreglo.get(i));
		   try {
			abb.agregarNodo(nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No se esperaba la excepcion");
		}
	  }
		
		assertSame(abb.getRaiz().getElemento(), arreglo.get(0));
		assertSame(abb.getRaiz().getDerecha().getElemento(), arreglo.get(1));
		assertSame(abb.getRaiz().getDerecha().getIzquierda().getElemento(), arreglo.get(2));
		assertSame(abb.getRaiz().getIzquierda().getElemento(), arreglo.get(3));
		assertSame(abb.getRaiz().getIzquierda().getDerecha().getElemento(), arreglo.get(4));
		assertSame(abb.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(5));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(6));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getIzquierda().getElemento(), arreglo.get(7));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getDerecha().getElemento(), arreglo.get(8));
       
		
		//Caso Repetido
		
		NodoArbol<String> repetido =  new NodoArbol<String>("8");
		try {
			abb.agregarNodo(repetido);
			fail("No debe agregarse");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
		//Caso Null
		repetido = null;
		try {
			abb.agregarNodo(repetido);
			fail("No debe agregarse");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	
	@Test
	public void buscarNodoTest(){
		escenarioInicial();
		for(int i = 0; i < arreglo.size(); i++){
			NodoArbol<String> nuevo =  new NodoArbol(arreglo.get(i));
		   try {
			abb.agregarNodo(nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No se esperaba la excepcion");
		}
	  }
	
	  NodoArbol<String> buscado = new NodoArbol("1");
	  NodoArbol<String> encontrado =  null;
	  
	  encontrado = abb.buscarNodo(buscado);
	  
	  assertTrue(encontrado != null);
	  assertSame(encontrado.getElemento(), "1");
	  
	 buscado = new NodoArbol("9");
	  encontrado = abb.buscarNodo(buscado);
	  
	  assertTrue(encontrado != null);
	  assertSame(encontrado.getElemento(), "9");
	  
	  buscado = new NodoArbol("12");
	  encontrado = abb.buscarNodo(buscado);
	  
	  assertTrue(encontrado == null);
	
	}
	
	@Test
	public void eliminarTest(){
		escenarioInicial();
		for(int i = 0; i < arreglo.size(); i++){
			NodoArbol<String> nuevo =  new NodoArbol(arreglo.get(i));
		   try {
			abb.agregarNodo(nuevo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No se esperaba la excepcion");
		}
	  }
		
     NodoArbol eliminar = new NodoArbol("4");
     
     try {
		abb.eliminarNodo(eliminar);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		fail("No se esperaba la excepcion");
	}
     assertSame(abb.getRaiz().getElemento(), arreglo.get(2));
		assertSame(abb.getRaiz().getDerecha().getElemento(), arreglo.get(1));
		assertSame(abb.getRaiz().getIzquierda().getElemento(), arreglo.get(3));
		assertSame(abb.getRaiz().getIzquierda().getDerecha().getElemento(), arreglo.get(4));
		assertSame(abb.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(5));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(6));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getIzquierda().getElemento(), arreglo.get(7));
		assertSame(abb.getRaiz().getDerecha().getDerecha().getDerecha().getElemento(), arreglo.get(8));
     
	   eliminar =  new NodoArbol("3");
	   
	     try {
	 		abb.eliminarNodo(eliminar);
	 	} catch (Exception e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 		fail("No se esperaba la excepcion");
	 	}
	     
	     assertSame(abb.getRaiz().getElemento(), arreglo.get(2));
			assertSame(abb.getRaiz().getDerecha().getElemento(), arreglo.get(1));
			assertSame(abb.getRaiz().getIzquierda().getElemento(), arreglo.get(3));
			assertSame(abb.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(5));
			assertSame(abb.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(6));
			assertSame(abb.getRaiz().getDerecha().getDerecha().getIzquierda().getElemento(), arreglo.get(7));
			assertSame(abb.getRaiz().getDerecha().getDerecha().getDerecha().getElemento(), arreglo.get(8));
	        
			assertTrue(abb.getRaiz().getIzquierda().getDerecha() == null);
	
			
			eliminar = new NodoArbol("12");
			
		     try {
			 		abb.eliminarNodo(eliminar);
			 		fail("Se esperaba la excepcion");
			 	} catch (Exception e) {
			 		// TODO Auto-generated catch block
			 		assertTrue(true);
			 		
			 	}
			
	}

}
