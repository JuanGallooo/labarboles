package arboles;

import java.util.ArrayList;

public class NodoArbolAVL <T extends Comparable>{
	private NodoArbolAVL <T> izquierda;
	private NodoArbolAVL <T> derecha;
	private T elemento;
	
	private int estado;

	public NodoArbolAVL(T elemento) {
		this.elemento = elemento;
	}
	
	public NodoArbolAVL<T> getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(NodoArbolAVL<T> izquierda) {
		this.izquierda = izquierda;
	}

	public NodoArbolAVL<T> getDerecha() {
		return derecha;
	}

	public void setDerecha(NodoArbolAVL<T> derecha) {
		this.derecha = derecha;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public int getEstado(){
		return estado;
	}
	public void setEstado(int estado){
		this.estado = estado;
	}

	public int compareTo(NodoArbolAVL<T> c){
		
		int resultado = 0;
		try{
			resultado = this.getElemento().compareTo(c.getElemento());
			if(resultado > 0){
				resultado = 1;
			}
			else if(resultado < 0){
				resultado = -1;
			}
		}
		catch(NullPointerException e){
			resultado = -2;
		}
		return resultado;
	}
	
	public NodoArbolAVL<T> buscarNodo(NodoArbolAVL <T> nodo) {
		// TODO Auto-generated method stub
		int resultado =  this.compareTo(nodo);
		if(resultado == 0){
			return this;
		}
		else{
			if(resultado == 1){
				if(izquierda != null){
					return izquierda.buscarNodo(nodo);
				}
				else{
					return null;
				}
			}
			else if(resultado == -1){
				if(derecha != null){
					return derecha.buscarNodo(nodo);
				}
				else{
					return null;
				}
			}
			return null;
		}
		
	}
	public void inOrder(ArrayList <T> participantes){
		if(izquierda != null){
			izquierda.inOrder(participantes);
		}
		participantes.add(this.elemento);
	     
		if(derecha != null){
			derecha.inOrder(participantes);
		}
	}
	


}
	
	
	
	

	



