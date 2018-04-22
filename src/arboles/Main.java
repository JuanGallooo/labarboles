package arboles;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		Elemento Creado0= new Elemento(6, 0);
		Elemento Creado1= new Elemento(10, 1);
		Elemento Creado2= new Elemento(11, 1);
		Elemento Creado3= new Elemento(14, 1);
		Elemento Creado4= new Elemento(15, 1);
		Elemento Creado5= new Elemento(4, 1);
		Elemento Creado6= new Elemento(9, 1);
		Elemento Creado7= new Elemento(30, 1);
		Elemento Creado8= new Elemento(31, 1);
		Elemento Creado9= new Elemento(8, 1);
		Elemento Creado10= new Elemento(7, 1);
		Elemento Creado11= new Elemento(3, 1);
		Elemento Creado12= new Elemento(5, 1);
		Elemento Creado13= new Elemento(2, 1);
		
		NodoRojoNegro<Elemento> nill= new NodoRojoNegro<Elemento>();
		ArbolRojoNegro<Elemento> arbol= new ArbolRojoNegro<Elemento>(nill);
		NodoRojoNegro<Elemento> nodo0= new NodoRojoNegro<Elemento>(Creado0, nill);
		nodo0.setColor(NodoRojoNegro.NEGRO);
		nodo0.setPadre(nill);
		
		arbol.agregarNodo(nodo0);

		NodoRojoNegro<Elemento> nodo1= new NodoRojoNegro<Elemento>(Creado1, nill);
		NodoRojoNegro<Elemento> nodo2= new NodoRojoNegro<Elemento>(Creado2, nill);
		NodoRojoNegro<Elemento> nodo3= new NodoRojoNegro<Elemento>(Creado3, nill);
		NodoRojoNegro<Elemento> nodo4= new NodoRojoNegro<Elemento>(Creado4, nill);
		NodoRojoNegro<Elemento> nodo5= new NodoRojoNegro<Elemento>(Creado5, nill);
		NodoRojoNegro<Elemento> nodo6= new NodoRojoNegro<Elemento>(Creado6, nill);
		NodoRojoNegro<Elemento> nodo7= new NodoRojoNegro<Elemento>(Creado7, nill);
		NodoRojoNegro<Elemento> nodo8= new NodoRojoNegro<Elemento>(Creado8, nill);
		NodoRojoNegro<Elemento> nodo9= new NodoRojoNegro<Elemento>(Creado9, nill);
		NodoRojoNegro<Elemento> nodo10= new NodoRojoNegro<Elemento>(Creado10, nill);
		NodoRojoNegro<Elemento> nodo11= new NodoRojoNegro<Elemento>(Creado11, nill);
		NodoRojoNegro<Elemento> nodo12= new NodoRojoNegro<Elemento>(Creado12, nill);
		NodoRojoNegro<Elemento> nodo13= new NodoRojoNegro<Elemento>(Creado13, nill);
		
		arbol.agregarNodo(nodo1);
		arbol.agregarNodo(nodo2);
		arbol.agregarNodo(nodo3);
		arbol.agregarNodo(nodo4);
		arbol.agregarNodo(nodo5);
		arbol.agregarNodo(nodo6);
		arbol.agregarNodo(nodo7);
		arbol.agregarNodo(nodo8);
		arbol.agregarNodo(nodo9);
		arbol.agregarNodo(nodo10);
		arbol.agregarNodo(nodo11);
		arbol.agregarNodo(nodo12);
		arbol.agregarNodo(nodo13);
		
		ArrayList<NodoRojoNegro<Elemento>> lista = new ArrayList<NodoRojoNegro<Elemento>>();
		
		arbol.inOrder(lista);
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) != null) {
				if(lista.get(i).getElemento() != null) {
					System.out.println(lista.get(i).getElemento().toString()+"  "+lista.get(i).getColor());
				}
			}
		}
		
//		System.out.println(nill.inOrder(gay));
//		System.out.println(raizNodo.inOrder(raizNodo));
	}
}
