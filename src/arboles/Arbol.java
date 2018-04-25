package arboles;

import java.util.ArrayList;

public  class Arbol<T extends Comparable>{
	
	private  NodoArbol <T> raiz;
	
	public Arbol (){
		
	}
	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}

	
	public void agregarNodo(NodoArbol<T> nodo) throws Exception {
		// TODO Auto-generated method stub
		if(raiz == null){
			raiz = nodo;
		}
		else{
			raiz.agregarNodo(nodo);
		}
	}

	
	public NodoArbol<T> eliminarNodo(NodoArbol<T> nodo)throws Exception {
		// TODO Auto-generated method stub
		NodoArbol<T> verificar = raiz.buscarNodo(nodo);
	if(verificar != null){
			raiz = raiz.eliminarNodo(nodo);
			return raiz;
		}
	else{
		throw new Exception ("El nodo a eliminar no se encuentra en el Arbol");
	}
  }

	
	public NodoArbol<T> buscarNodo(NodoArbol<T> nodo) {
		// TODO Auto-generated method stub
		if(raiz != null){
			return raiz.buscarNodo(nodo);
		}
		else{
			return null;
		}
		
		
	}

	
	public NodoArbol<T> minimo() {
		// TODO Auto-generated method stub
		if(raiz != null){
			return raiz.minimo();
		}
		else{	
			return null;
		}
	}

	
	public NodoArbol<T> maximo() {
		// TODO Auto-generated method stub
		if(raiz != null){
			return raiz.maximo();
		}
		else{	
			return null;
		}
	}


	
	public boolean esHoja() throws Exception {
		// TODO Auto-generated method stub
		if(raiz != null){
			return raiz.esHoja();
		}
		else{
			throw new Exception ("No se han ingresado datos");
		}
	}
	public int darAltura(){
		return raiz.darAltura();
	}
	public void inOrder(ArrayList<T> participantes){
		if(raiz!=null) raiz.inOrder(participantes);
	}


	

}