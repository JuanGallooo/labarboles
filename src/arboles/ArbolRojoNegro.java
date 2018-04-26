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
	public String elementoBuscado(T elemento) throws Exception{
		String retorno="";
		try {
			retorno=raiz.buscarElemento(elemento).getElemento().toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("No se encuentra el elemento buscado");
		}
		return retorno;
	}
	
	public void agregarNodo(NodoRojoNegro<T> nodo) throws Exception {
		if(raiz == null){
			raiz = nodo;
			raiz.setColor(NodoRojoNegro.NEGRO);
			raiz.setPadre(nill);
		}
		else{
			NodoRojoNegro<T> agregar=raiz.insertar(nodo);
			revisarRaiz(agregar);
		}
	}
	public void eliminarNodo(T nodo) throws Exception {
		if(nodo.equals(raiz.getElemento())) {
			T aux;
			if(!raiz.getDerecha().equals(nill)) {
				aux= raiz.getDerecha().getElemento();
				raiz.buscarEliminar(nodo);
				NodoRojoNegro<T> aux2= raiz.buscarElemento(aux);
				revisarRaiz(aux2);
			}
			else if(!raiz.getIzquierda().equals(nill)) {
				aux= raiz.getIzquierda().getElemento();
				raiz.buscarEliminar(nodo);
				NodoRojoNegro<T> aux2= raiz.buscarElemento(aux);
				revisarRaiz(aux2);
			}
			else {
				raiz= null;
				aux=null;
			}
		}
		else
		{
			raiz.buscarEliminar(nodo);
			revisarRaiz(raiz);
		}
	}
	public ArrayList<T> inOrder(ArrayList<T> lista){
		if( raiz!=null)raiz.inOrder(lista);
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
