package arboles;

import java.util.ArrayList;


public class NodoArbol <T extends Comparable> implements Comparable<NodoArbol<T>>{
	
	private NodoArbol <T> izquierda;
	private NodoArbol <T> derecha;
	private T elemento;
	
	public NodoArbol( T elemento){
		this.elemento = elemento;
		
	}
	public NodoArbol<T> getIzquierda() {
		return izquierda;
	}

	public void setIzquierda(NodoArbol<T> izquierda) {
		this.izquierda = izquierda;
	}



	public NodoArbol<T> getDerecha() {
		return derecha;
	}



	public void setDerecha(NodoArbol<T> derecha) {
		this.derecha = derecha;
	}



	public T getElemento() {
		return elemento;
	}



	public void setElemento(T elemento) {
		this.elemento = elemento;
	}



	
	public void agregarNodo(NodoArbol<T> nodo) throws Exception {
		// TODO Auto-generated method stub
		int resultado = this.compareTo(nodo);
		if(resultado == 1){
			if(izquierda == null){
				izquierda = nodo;
			}
			else{
				izquierda.agregarNodo(nodo);
			}
		}
		else if(resultado == -1){
			if(derecha == null){
				derecha = nodo;
			}
			else{
				derecha.agregarNodo(nodo);
			}
		}
		else if (resultado == 0){
			throw new Exception("Nodo duplicado");
		}
		else{
			throw new Exception("Se deseaba insertar un null");
		}
	}



	
	public NodoArbol<T> eliminarNodo(NodoArbol<T> nodo) throws Exception {
		// TODO Auto-generated method stub
		if(esHoja()){
			return null;
		}
	    if(this.compareTo(nodo) == 0){
	    	if(izquierda == null){
	    		return derecha;
	    	}
	    	if(derecha == null){
	    		return izquierda;
	    	}
	    	NodoArbol<T> sucesor = derecha.minimo();
	    	this.setDerecha(derecha.eliminarNodo(sucesor));
	    	sucesor.setIzquierda(izquierda);
	    	sucesor.setDerecha(derecha);
	    	return sucesor;
	    }
	    else if(this.compareTo(nodo) == 1){
	    	this.setIzquierda(izquierda.eliminarNodo(nodo));

	    }
	    else{
	    	this.setDerecha(derecha.eliminarNodo(nodo));
	    	
	    	
	    }
	    return this;
	}

	public NodoArbol<T> buscarNodo(NodoArbol <T> nodo) {
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

	
	public NodoArbol <T> minimo() {
		// TODO Auto-generated method stub
		if(izquierda == null){
			return this;
		}
		else{
			return izquierda.minimo();
		}
	}
	
	public NodoArbol <T> maximo() {
		// TODO Auto-generated method stub
		if(derecha == null){
			return this;
		}
		else{
			return derecha.maximo();
		}
	}
	
	public int compareTo(NodoArbol<T> c){
		
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

	
	
	public boolean esHoja() {
		// TODO Auto-generated method stub
		if(izquierda == null && derecha == null){
			return true;
		}
		return false;
	}
	
	public int darAltura(){
		int altura1 = 0;
		int altura2 = 0;
	        if(esHoja()) {
	            return 0;
	        }
	        if(izquierda != null) altura1 = getIzquierda().darAltura( );
	        else altura1 = 0;
	        if(derecha != null) altura2 = getDerecha().darAltura( );
	        else altura2 = 0;
	        if(altura1 >= altura2) return altura1 + 1;
	        else return altura2 + 1;
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
	
	
	public String orden(String mensaje){
		mensaje += this.elemento + "\n";
		String mensaje2 = "";
		if(this.getIzquierda() != null){
			mensaje += "Izquierda de " + this.elemento +": " + this.getIzquierda().orden(mensaje2) + "\n";
		}
		if(this.getDerecha() != null){
			mensaje += "Derecha de " + this.elemento + ": " + this.getDerecha().orden(mensaje2) + "\n";
		}
		return mensaje;
	}


	
}	