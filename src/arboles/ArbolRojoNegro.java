package arboles;

import java.util.ArrayList;

public class ArbolRojoNegro<T extends Comparable<? super T>> {

	private NodoRojoNegro<T> raiz;
	public NodoRojoNegro<T> nill;

	public ArbolRojoNegro(NodoRojoNegro<T> nill){
		this.nill= nill;
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
			NodoRojoNegro<T> agregar=raiz.insertar(nodo);
			revisarRaiz(agregar);
		}
	}
	public ArrayList<NodoRojoNegro<Elemento>> inOrder(ArrayList<NodoRojoNegro<Elemento>> lista){
		raiz.inOrder(lista);
		return lista;
	}
	public void revisarRaiz(NodoRojoNegro<T> nodo) {
		NodoRojoNegro<T> aux= nodo;
		while(!aux.getPadre().equals(nill)) {
			aux= aux.getPadre();
		}
		setRaiz(aux);
	}
}
