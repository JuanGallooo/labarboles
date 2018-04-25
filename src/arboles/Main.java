package arboles;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {

		ArbolAVL<String> abb =  new ArbolAVL<String>();
		String [] valores  = {"20","15","19","18","17","16","21","22","40"};
		for(int i = 0; i < valores.length; i++){
//			NodoArbol<String> nuevo =  new NodoArbol<String>(valores[i]);
//			abb.agregarNodo(nuevo);
			abb.insertar(valores[i]);
		}
	    ArrayList<String> participantes = new ArrayList<String>();
	    abb.inOrder(participantes);
	    for (int j = 0; j <participantes.size(); j++) {
			System.out.println(participantes.get(j));
		}
		
		
	    NodoArbol <String> eliminar =  new NodoArbol<String>("20");
	    participantes.removeAll(participantes);
		abb.eliminarAVL("20", abb.getRaiz());
		System.out.println(abb.getRaiz().getEstado());
		System.out.println(abb.getRaiz().getIzquierda().getEstado());
		System.out.println(abb.getRaiz().getDerecha().getEstado());
		System.out.println(abb.getRaiz().getDerecha().getIzquierda().getEstado());
		abb.inOrder(participantes);
		
		 for (int k = 0; k <participantes.size(); k++) {
				System.out.println(participantes.get(k));
		}

   }
}
