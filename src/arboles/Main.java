package arboles;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Elemento Creado0= new Elemento(20, 0);
		Elemento Creado1= new Elemento(7, 1);
		Elemento Creado2= new Elemento(5, 1);
		Elemento Creado3= new Elemento(3, 1);
		Elemento Creado4= new Elemento(25, 1);
		Elemento Creado5= new Elemento(30, 1);
		Elemento Creado6= new Elemento(10, 1);
		Elemento Creado7= new Elemento(8, 1);
		
		NodoRojoNegro<Elemento> nill= new NodoRojoNegro<Elemento>();
		ArbolRojoNegro<Elemento> arbol= new ArbolRojoNegro<Elemento>(nill);

		
		NodoRojoNegro<Elemento> nodo0= new NodoRojoNegro<Elemento>(Creado0, nill);
		NodoRojoNegro<Elemento> nodo1= new NodoRojoNegro<Elemento>(Creado1, nill);
		NodoRojoNegro<Elemento> nodo2= new NodoRojoNegro<Elemento>(Creado2, nill);
		NodoRojoNegro<Elemento> nodo3= new NodoRojoNegro<Elemento>(Creado3, nill);
		NodoRojoNegro<Elemento> nodo4= new NodoRojoNegro<Elemento>(Creado4, nill);
		NodoRojoNegro<Elemento> nodo5= new NodoRojoNegro<Elemento>(Creado5, nill);
		NodoRojoNegro<Elemento> nodo6= new NodoRojoNegro<Elemento>(Creado6, nill);
		NodoRojoNegro<Elemento> nodo7= new NodoRojoNegro<Elemento>(Creado7, nill);
		
		arbol.agregarNodo(nodo0);
		arbol.agregarNodo(nodo1);
		arbol.agregarNodo(nodo2);
		arbol.agregarNodo(nodo3);
		arbol.agregarNodo(nodo4);
		arbol.agregarNodo(nodo5);
		arbol.agregarNodo(nodo6);
		arbol.agregarNodo(nodo7);
		arbol.eliminarNodo(Creado4);
		arbol.eliminarNodo(Creado5);
		arbol.eliminarNodo(Creado6);
		arbol.eliminarNodo(Creado1);
		arbol.eliminarNodo(Creado0);
		arbol.eliminarNodo(Creado3);
		arbol.eliminarNodo(Creado2);
		arbol.eliminarNodo(Creado7);

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
//	}
//=======

//		Elemento raiz= new Elemento(1, 0);
//		NodoRojoNegro<Elemento> nill= new NodoRojoNegro<Elemento>();
//		
//		NodoRojoNegro<Elemento> raizNodo= new NodoRojoNegro<Elemento>(raiz, nill);
//		raizNodo.setColor(NodoRojoNegro.NEGRO);
//		raizNodo.setPadre(nill);
//		
//		Elemento Creado1= new Elemento(2, 1);
//		NodoRojoNegro<Elemento> nodo1= new NodoRojoNegro<Elemento>(Creado1, nill);
//		Elemento Creado2= new Elemento(3, 1);
//		NodoRojoNegro<Elemento> nodo2= new NodoRojoNegro<Elemento>(Creado2, nill);
//		
//		raizNodo.insertar(nodo1);
//		raizNodo.insertar(nodo2);
//		System.out.println(raizNodo.inOrder(raizNodo));
//		
//		Arbol abb =  new Arbol();
//		String [] valores  = {"4", "2", "1", "3", "6", "5", "7"};
//		for(int i = 0; i < valores.length; i++){
//			NodoArbolAVL <String> nuevo =  new NodoArbolAVL(valores[i]);
//			abb.agregarNodo(nuevo);
//		}
//		ArrayList<String> numeros =  new ArrayList<String>();
//		abb.getRaiz().inOrder(numeros);
//		for(int j = 0; j < valores.length; j++){
//			System.out.println(numeros.get(j));
//		}
   }
//>>>>>>> 9c661ce66a868fca70db8d5e39d21ce00f990cc7
}
