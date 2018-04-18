package InterfazArbolBinario;

import arboles.NodoArbol;

public interface InterfazArbol <T extends Comparable>{
	
     public void agregarNodo( NodoArbol<T> nodo);
     public NodoArbol<T> eliminarNodo(NodoArbol<T> nodo)throws Exception;
     public NodoArbol<T> buscarNodo(NodoArbol<T> nodo);
     public NodoArbol<T> minimo();
     public NodoArbol <T> maximo();
     public boolean esHoja()throws Exception;

}
