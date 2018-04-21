package arboles;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {

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
		
		Arbol abb =  new Arbol();
		String [] valores  = {"4", "2", "1", "3", "6", "5", "7"};
		for(int i = 0; i < valores.length; i++){
			NodoArbolAVL <String> nuevo =  new NodoArbolAVL(valores[i]);
			abb.agregarNodo(nuevo);
		}
		ArrayList<String> numeros =  new ArrayList<String>();
		abb.getRaiz().inOrder(numeros);
		for(int j = 0; j < valores.length; j++){
			System.out.println(numeros.get(j));
		}

   }
}
