package arboles;

import java.util.ArrayList;

public class ArbolRojoNegro<T extends Comparable<? super T>> {
	private NodoRojoNegro<T> raiz;

	public ArbolRojoNegro(){
	}
	public NodoRojoNegro<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoRojoNegro<T> raiz) {
		this.raiz = raiz;
	}
	
	public void agregarNodo(NodoRojoNegro<T> nodo) {
		if(raiz == null){
			raiz = nodo;
		}
		else{
			raiz.insertar(nodo);
		}
	}
	public void inOrder(ArrayList<NodoRojoNegro> lista){
		raiz.inOrder(lista);
	}
}
