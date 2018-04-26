package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sun.prism.paint.Color;

import arboles.ArbolRojoNegro;
import arboles.NodoRojoNegro;
import mundo.Colegio;

public class ArbolesRojoNegrosTest {
	private ArbolRojoNegro<Colegio> arn;
	private NodoRojoNegro<Colegio> nill;
	private ArrayList<Colegio> arreglo;
	
	private void escenarioInicial(){
		nill =  new NodoRojoNegro<Colegio>();
		arn = new ArbolRojoNegro<Colegio>(nill);
		arreglo = new ArrayList<Colegio>();
		colegiosBase();
	}
	
	private void colegiosBase(){
		Colegio uno = new Colegio("","","", "3802467","","",""); 
		uno.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio dos = new Colegio("","","", "7577794","","","");
		dos.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio tres = new Colegio("","","", "2163035","","","");
		tres.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio cuatro = new Colegio("","","", "2853125","","","");
		cuatro.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio cinco = new Colegio("","","", "2978830","","","");
		cinco.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio seis = new Colegio("","","", "2653471","","","");
		seis.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio siete = new Colegio("","","", "3068411","","","");
		siete.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio ocho = new Colegio("","","", "3197522","","","");
		ocho.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio nueve = new Colegio("","","", "2213583","","","");
		nueve.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		Colegio diez = new Colegio("","","", "2502266","","","");
		diez.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		
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
		//Agregado Simple
		escenarioInicial();
		
		for(int i = 0; i < 3; i++){
			NodoRojoNegro<Colegio> nuevo = new NodoRojoNegro<Colegio>(arreglo.get(i),nill);
			try {
				arn.agregarNodo(nuevo);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
			    fail("No se esperaba la excepción");
			}
		}
		
		assertSame(arn.getRaiz().getElemento(), arreglo.get(0));
		assertSame(arn.getRaiz().getDerecha().getElemento(),arreglo.get(1));
		assertSame(arn.getRaiz().getIzquierda().getElemento(),arreglo.get(2));
		
		assertTrue(arn.getRaiz().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		
		//Agregado completo con rotaciones y cambios de color.
		for(int i = 3; i < arreglo.size(); i++){
			NodoRojoNegro<Colegio> nuevo = new NodoRojoNegro<Colegio>(arreglo.get(i),nill);
			try {
				arn.agregarNodo(nuevo);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
			    fail("No se esperaba la excepción");
			}
		}
		assertSame(arn.getRaiz().getElemento(), arreglo.get(3));
		assertSame(arn.getRaiz().getDerecha().getElemento(),arreglo.get(0));
		assertSame(arn.getRaiz().getIzquierda().getElemento(),arreglo.get(8));
		assertSame(arn.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(2));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getElemento(),arreglo.get(5));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getElemento(),arreglo.get(9));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getElemento(), arreglo.get(6));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getIzquierda().getElemento(),arreglo.get(4));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getDerecha().getElemento(),arreglo.get(7));
 		assertSame(arn.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(1));
 		
 		
 		assertTrue(arn.getRaiz().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getDerecha().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getDerecha().getColor() == NodoRojoNegro.NEGRO);
	
	    Colegio rep= new Colegio("","","", "2502266","","","");
	    rep.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
	    NodoRojoNegro<Colegio> repetido = new NodoRojoNegro<Colegio>(rep,nill);
	    
	    try {
			arn.agregarNodo(repetido);
			fail("Se esperaba la excepción");
		} catch (Exception e) {
			assertTrue(true);
		}
	
	}
	
	@Test
	public void buscarNodoTest (){
		escenarioInicial();
		
		for(int i = 0; i < arreglo.size(); i++){
			NodoRojoNegro<Colegio> nuevo = new NodoRojoNegro<Colegio>(arreglo.get(i),nill);
			try {
				arn.agregarNodo(nuevo);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
			    fail("No se esperaba la excepción");
			}
		}
		
		NodoRojoNegro<Colegio> buscado =  arn.getRaiz().buscarElemento(arreglo.get(0));
		assertSame(buscado.getElemento(), arreglo.get(0));
		
	    buscado =  arn.getRaiz().buscarElemento(arreglo.get(3));
		assertSame(buscado.getElemento(), arreglo.get(3));
		
		buscado = arn.getRaiz().buscarElemento(arreglo.get(7));
		assertSame (buscado.getElemento(), arreglo.get(7));
		
		Colegio inexistente = new Colegio("","","", "123","","","");
		inexistente.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		buscado = arn.getRaiz().buscarElemento(inexistente);
		
		buscado = arn.getRaiz().buscarElemento(inexistente);

		assertTrue(buscado == null);
		
	}
	
	@Test
	public void eliminarNodo(){
	escenarioInicial();
		
		for(int i = 0; i < arreglo.size(); i++){
			NodoRojoNegro<Colegio> nuevo = new NodoRojoNegro<Colegio>(arreglo.get(i),nill);
			try {
				arn.agregarNodo(nuevo);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
			    fail("No se esperaba la excepción");
			}
		}
		
		Colegio del = new Colegio("","","", "3068411","","","");
		del.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);

		try {
			arn.eliminarNodo(del);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    fail("No se esperaba la excepción");
		}
		
		NodoRojoNegro<Colegio> buscado =  arn.getRaiz().buscarElemento(del);
		
		
		assertSame(arn.getRaiz().getElemento(), arreglo.get(3));
		assertSame(arn.getRaiz().getDerecha().getElemento(),arreglo.get(0));
		assertSame(arn.getRaiz().getIzquierda().getElemento(),arreglo.get(8));
		assertSame(arn.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(2));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getElemento(),arreglo.get(5));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getElemento(),arreglo.get(9));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getElemento(), arreglo.get(7));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getIzquierda().getElemento(),arreglo.get(4));
 		assertSame(arn.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(1));
 		
 		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getDerecha() == nill);
 		assertTrue(buscado == null);
 		
 		
 		assertTrue(arn.getRaiz().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getDerecha().getColor() == NodoRojoNegro.NEGRO);
		
		
		del = new Colegio("","","", "2853125","","","");
		del.setBusquedaActual(Colegio.BUSQUEDA_TELEFONO);
		
		try {
			arn.eliminarNodo(del);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    fail("No se esperaba la excepción");
		}
		
		
		System.out.println(arn.getRaiz().getElemento().getTelefono());
		
        buscado =  arn.getRaiz().buscarElemento(del);
		
		
		assertSame(arn.getRaiz().getElemento(), arreglo.get(4));
		
		assertSame(arn.getRaiz().getDerecha().getElemento(),arreglo.get(0));
		assertSame(arn.getRaiz().getIzquierda().getElemento(),arreglo.get(8));
		assertSame(arn.getRaiz().getIzquierda().getIzquierda().getElemento(), arreglo.get(2));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getElemento(),arreglo.get(5));
		assertSame(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getElemento(),arreglo.get(9));
		assertSame(arn.getRaiz().getDerecha().getIzquierda().getElemento(), arreglo.get(7));
 		assertSame(arn.getRaiz().getDerecha().getDerecha().getElemento(), arreglo.get(1));
 		
 		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getIzquierda() == nill);
 		assertTrue(buscado == null);
 		
 		
 		assertTrue(arn.getRaiz().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getIzquierda().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getIzquierda().getDerecha().getIzquierda().getColor() == NodoRojoNegro.ROJO);
		assertTrue(arn.getRaiz().getDerecha().getIzquierda().getColor() == NodoRojoNegro.NEGRO);
		assertTrue(arn.getRaiz().getDerecha().getDerecha().getColor() == NodoRojoNegro.NEGRO);
		
		
	}


}
