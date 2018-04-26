package arboles;

import java.util.ArrayList;

public class ArbolAVL <T extends Comparable<? super T>> {
	
	private NodoArbolAVL <T> raiz;
	
	
	public ArbolAVL(){
		
	}
	
	public NodoArbolAVL<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoArbolAVL<T> raiz) {
		this.raiz = raiz;
	}

	public NodoArbolAVL<T> buscarNodo(NodoArbolAVL<T> nodo) {
		// TODO Auto-generated method stub
		if(raiz != null){
			return raiz.buscarNodo(nodo);
		}
		else{
			return null;
		}
		
		
	}

	public int obtenerFB(NodoArbolAVL<T> x){
		if(x == null){
			return -1;
		}
		else{
			return x.getEstado();
		}
	}
	
	public NodoArbolAVL<T> rotacionIzquierda(NodoArbolAVL<T> c){
		NodoArbolAVL<T> auxiliar = c.getIzquierda();
	    c.setIzquierda(auxiliar.getDerecha());
	    auxiliar.setDerecha(c);
	    c.setEstado(Math.max(this.obtenerFB((NodoArbolAVL<T>) c.getIzquierda()), this.obtenerFB((NodoArbolAVL<T>) c.getDerecha())) +1 );
	    auxiliar.setEstado(Math.max(this.obtenerFB(auxiliar.getIzquierda()), this.obtenerFB(auxiliar.getDerecha())) + 1);
	    return auxiliar;
	}

	public NodoArbolAVL<T> rotacionDerecha(NodoArbolAVL<T> c){
		NodoArbolAVL <T> auxiliar = (NodoArbolAVL<T>) c.getDerecha();
	    c.setDerecha(auxiliar.getIzquierda());
	    auxiliar.setIzquierda(c);
	    c.setEstado(Math.max(this.obtenerFB((NodoArbolAVL<T>) c.getIzquierda()), this.obtenerFB((NodoArbolAVL<T>) c.getDerecha())) +1 );
	    auxiliar.setEstado(Math.max(this.obtenerFB((NodoArbolAVL<T>) auxiliar.getIzquierda()), this.obtenerFB((NodoArbolAVL<T>) auxiliar.getDerecha())) + 1);
	    return auxiliar;
	}
	
	public NodoArbolAVL <T> rotacionDobleIzquierda (NodoArbolAVL <T> c){
		NodoArbolAVL<T> temporal = null;
		c.setIzquierda(this.rotacionDerecha((NodoArbolAVL<T>) c.getIzquierda()));
	    temporal = this.rotacionIzquierda(c);
	    return temporal;
	}
	public NodoArbolAVL <T> rotacionDobleDerecha(NodoArbolAVL <T> c){
		NodoArbolAVL<T> temporal = null;
		c.setDerecha(this.rotacionIzquierda(c.getDerecha()));
	    temporal = this.rotacionDerecha(c);
	    return temporal;
	}
	
	public NodoArbolAVL<T> insertarAVL (NodoArbolAVL<T> nuevo, NodoArbolAVL<T> subAr){
		NodoArbolAVL<T> nuevoPadre = subAr;
		if(nuevo.compareTo(subAr) == -1){
			if(subAr.getIzquierda() == null){
				subAr.setIzquierda(nuevo);
			}
			else{
				subAr.setIzquierda(insertarAVL(nuevo, subAr.getIzquierda()));
			   if(obtenerFB(subAr.getIzquierda()) - obtenerFB(subAr.getDerecha()) == 2){
				   if(nuevo.compareTo(subAr.getIzquierda()) == -1){
					   nuevoPadre = rotacionIzquierda(subAr);
				   }
				   else{
					   nuevoPadre = rotacionDobleIzquierda(subAr);
				   }
			   }
			   
			}
		
		}
		else if(nuevo.compareTo(subAr) == 1){
			if(subAr.getDerecha() == null){
				subAr.setDerecha(nuevo);
			}
			else{
				subAr.setDerecha(insertarAVL(nuevo, subAr.getDerecha()));
			    if(obtenerFB(subAr.getDerecha()) - obtenerFB(subAr.getIzquierda()) == 2){
			    	if(nuevo.compareTo(subAr.getDerecha())== 1){
			    		nuevoPadre = rotacionDerecha(subAr);
			    	}
			    	else{
			    		nuevoPadre = rotacionDobleDerecha(subAr);
			    	}
			    	
			    }
			}
			
		}
		else{
//			System.out.println("Nodo Duplicado");
		}
		if(subAr.getIzquierda() == null && subAr.getDerecha() != null){
			subAr.setEstado(subAr.getDerecha().getEstado() + 1);
		}
		else if(subAr.getDerecha() == null && subAr.getIzquierda() != null){
			subAr.setEstado(subAr.getIzquierda().getEstado() +1);
		}
		else{
			subAr.setEstado(Math.max(obtenerFB(subAr.getIzquierda()), obtenerFB(subAr.getDerecha())) + 1);
		}
		return nuevoPadre;	
	}
	
	public void insertar (T elemento){
		NodoArbolAVL<T> nuevo  = new NodoArbolAVL<T>(elemento);
		if(raiz == null){
			raiz = nuevo;
		}
		else{
	      setRaiz(insertarAVL(nuevo, raiz));
		}
	}
	
	public void eliminarAVL (T elemento, NodoArbolAVL<T> subAr)throws Exception{
		NodoArbolAVL<T> eliminar = new NodoArbolAVL<T> (elemento);
		NodoArbolAVL<T> auxiliar = subAr;
		NodoArbolAVL<T> padre = subAr;
		boolean esHijoIzq = true;
		while(auxiliar.compareTo(eliminar) != 0){
			padre = auxiliar;
			if(eliminar.compareTo(auxiliar) == -1){
				auxiliar = auxiliar.getIzquierda();
			    esHijoIzq = true;
			}
			else{
			    esHijoIzq = false;
				auxiliar = auxiliar.getDerecha();
			
			}
			if( auxiliar == null){
				throw new Exception("No se encontro nodo");
			}
		}
		if(auxiliar.getIzquierda() == null && auxiliar.getDerecha() == null){
			if(auxiliar.compareTo(raiz) == 0){
				raiz = null;
			}else if(esHijoIzq){
				padre.setIzquierda(null);
			}
			else{
				padre.setDerecha(null);
			}
		}
		else if(auxiliar.getDerecha() == null){
			if(auxiliar.compareTo(raiz) == 0){
				raiz = auxiliar.getIzquierda();
			}else if(esHijoIzq){
				padre.setIzquierda(auxiliar.getIzquierda());
			}
			else{
				padre.setDerecha(auxiliar.getIzquierda());
			}
		}
		else if(auxiliar.getIzquierda() == null){
			if(auxiliar.compareTo(raiz) == 0){
				raiz = auxiliar.getDerecha();
			}else if(esHijoIzq){
				padre.setIzquierda(auxiliar.getDerecha());
			}
			else{
				padre.setDerecha(auxiliar.getIzquierda());
			}
		}
		else{
			NodoArbolAVL<T> reemplazo = obtenerNodoAVLReemplazo(auxiliar);
		    if(auxiliar.compareTo(raiz)==0){
		    	raiz = reemplazo;
		    }
		    else if(esHijoIzq){
		    	padre.setIzquierda(reemplazo);
		    }
		    else{
		    	padre.setDerecha(reemplazo);
		    }
		    reemplazo.setIzquierda(auxiliar.getIzquierda());;
		}
		if(subAr.getIzquierda() == null && subAr.getDerecha() != null){
			subAr.setEstado(subAr.getDerecha().getEstado() + 1);
		}
		else if(subAr.getDerecha() == null && subAr.getIzquierda() != null){
			subAr.setEstado(subAr.getIzquierda().getEstado() +1);
		}
		else{
			subAr.setEstado(Math.max(obtenerFB(subAr.getIzquierda()), obtenerFB(subAr.getDerecha())) + 1);
		}
		
	  
	}
	
	public NodoArbolAVL<T> obtenerNodoAVLReemplazo (NodoArbolAVL<T> nodoReemp){
		NodoArbolAVL<T> reemplazarPadre = nodoReemp;
		NodoArbolAVL<T> reemplazo = nodoReemp;
		NodoArbolAVL<T> auxiliar = nodoReemp.getDerecha();
		
		while(auxiliar != null){
			reemplazarPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar = auxiliar.getIzquierda();
		}
		if(reemplazo.compareTo(nodoReemp.getDerecha()) != 0){
			reemplazarPadre.setIzquierda(reemplazo.getDerecha());
			reemplazo.setDerecha(nodoReemp.getDerecha());
		}
		return reemplazo;
	}
	
	public void inOrder(ArrayList<T> n){
		if(raiz != null){
			raiz.inOrder(n);
		}
	}
	




}
