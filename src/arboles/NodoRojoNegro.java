package arboles;

import java.util.ArrayList;

public class NodoRojoNegro<T extends Comparable<? super T>>{
	public static final int NEGRO= 1;
	public static final int ROJO= 0;
	
	private T elemento;
	
	public NodoRojoNegro<T> nill;
	
	private NodoRojoNegro<T> padre;
	private NodoRojoNegro<T> derecha;
	private NodoRojoNegro<T> izquierda;
	
	private int color;
	
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------
	public NodoRojoNegro(T elemento, NodoRojoNegro<T> nill) {
		this.elemento= elemento;
		derecha = null;
		izquierda = null;
        color = ROJO;
        this.nill= nill;
        setDerecha( this.nill );
        setIzquierda( this.nill);
        padre = null;
	}
    public NodoRojoNegro(){
        this.elemento = null;
        color = NEGRO;
        padre = null;
    }
	// -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
	public NodoRojoNegro<T> getDerecha(){
		return derecha;
	}
	public NodoRojoNegro<T> getIzquierda(){
		return izquierda;
	}
	public void setPadre(NodoRojoNegro<T> padre) {
		this.padre = padre;
	}
	public void setIzquierda(NodoRojoNegro<T> a){
		a.setPadre(this);
		izquierda = a;
	}
	public void setDerecha(NodoRojoNegro<T> a){
		a.setPadre(this);
		derecha = a;
	}
    public NodoRojoNegro<T> getPadre( ){
        return padre;
    }
    public NodoRojoNegro<T> getTio( ){
        if(padre==null||padre.padre== null){
            return null;
        }
        else{
            if(padre.padre.esHijoDerecho(padre))return padre.padre.getIzquierda();
            else return padre.padre.getDerecha();
        }

    }
	private boolean esHijoDerecho(NodoRojoNegro<T> nodo) {
		return derecha.equals(nodo);
	}
    public boolean esHijoIzquierdo( NodoRojoNegro<T> nodo ){
        return izquierda.equals(nodo);
    }
    public boolean hijoDerechoHoja( ){
        return derecha.equals(nill);
    }
    public boolean hijoIzquierdaHoja(){
        return izquierda.equals(nill);
    }
    public boolean esHoja() {
    	return this.getDerecha()==nill && this.getIzquierda()==nill;
    }
	public boolean esNill() {
		return this.equals(nill);
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public NodoRojoNegro<T> sucesor(NodoRojoNegro<T> nodo){
		if(!nodo.getDerecha().equals(nill)) {
			return minimo(nodo.getDerecha());
		}
		NodoRojoNegro<T> y= nodo.getPadre();
		while(!y.esNill() && nodo.equals(y.getDerecha())){
			nodo=y;
			y= y.getPadre();
		}
		return y;
	}
	public NodoRojoNegro<T> predecesor(NodoRojoNegro<T> nodo){
		if(!nodo.getIzquierda().equals(nill)) {
			return maximo(nodo.getIzquierda());
		}
		NodoRojoNegro<T> y= nodo.getPadre();
		while(!y.esNill() && nodo.equals(y.getIzquierda())){
			nodo=y;
			y= y.getPadre();
		}
		return y;
	}
	
    public NodoRojoNegro<T> maximo(NodoRojoNegro<T> nodo){
    	if(nodo.hijoDerechoHoja()!=true){
    		return maximo(nodo.getDerecha());
    	}
    	else return nodo;
    }

    public NodoRojoNegro<T> minimo(NodoRojoNegro<T> nodo){
    	if(nodo.hijoIzquierdaHoja()!=true) {
    		return minimo(nodo.getIzquierda());
    	}
    	else return nodo;
    }
    public int darAltura(){
        if(esHoja()) {
            return 0;
        }
        int altura1 = getIzquierda().darAltura( );
        int altura2 = getDerecha().darAltura( );
        if(altura1 >= altura2) return altura1 + 1;
        else return altura2 + 1;
    }
    public int darPeso(){
    	if(esHoja()) {
    		return 0;
    	}
    	else {
    		return 1 + derecha.darPeso() + izquierda.darPeso();
    	}
    }
	@SuppressWarnings("unchecked")
	public boolean yaExiste(T e) {
       T elementoBuscado=(T) buscarElemento(e);
       if(elementoBuscado==null) return false;
       else return true;
    }
	public NodoRojoNegro<T> buscarElemento( T elem ) 	    {
		int comparador = elem.compareTo(this.elemento);
        if( comparador == 0 ) {
        	return this;
        }
        else if( comparador > 0 ){
        	if(!getIzquierda().equals(nill)) {
        		return izquierda.buscarElemento( elem );
        	}
        	else return null;
        }
        else{
        	if(!getDerecha().equals(nill)) {
              return derecha.buscarElemento( elem );
        	}
        	else return null;
        }
    }
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
    public boolean derechaNegro(){
        return derecha.getColor() == NEGRO;
    }
    public boolean izquierdaNegro(){
        return izquierda.getColor() == NEGRO;
    }
    public boolean hijosNegros(){
    	boolean retorno=false;
    	if(derechaNegro()&&izquierdaNegro())retorno =true;
        return retorno;
    }
    public NodoRojoNegro<T> darHermano(){
    	if(padre==null) return null;
    	else if(padre.esHijoDerecho(this)) return padre.getIzquierda();
    	else return padre.getDerecha();
    }
    public NodoRojoNegro<T> getNill() {
		return nill;
	}
	public void setNill(NodoRojoNegro<T> nill) {
		this.nill = nill;
	}
    public void izquierdaRotar(NodoRojoNegro<T> x){
    	NodoRojoNegro<T> aux= x.getDerecha();
    	x.setDerecha(aux.getIzquierda());
    	aux.getIzquierda().setPadre(x);
    	
    	aux.setPadre(x.getPadre());
    	if((x.getPadre().equals(nill))){
    		aux.setPadre(nill);
    	}
    	else {
    		if(x.equals(x.getPadre().getIzquierda())) {
    			x.getPadre().setIzquierda(aux);
    		}
    		else x.getPadre().setDerecha(aux);
    	}
    	aux.setIzquierda(x);
		x.setPadre(aux);
    }
    public void derechaRotar(NodoRojoNegro<T> x){
    	NodoRojoNegro<T> aux= x.getIzquierda();
    	x.setIzquierda(aux.getDerecha());
    	aux.getDerecha().setPadre(x);
    	
    	aux.setPadre(x.getPadre());
    	if((x.getPadre().equals(nill))){
    		aux.setPadre(nill);
    	}
    	else {
    		if(x.equals(x.getPadre().getDerecha())) {
    			x.getPadre().setDerecha(aux);
    		}
    		else x.getPadre().setIzquierda(aux);
    	}
    	aux.setDerecha(x);
		x.setPadre(aux);
    }
	public NodoRojoNegro<T> raizNegra(NodoRojoNegro<T> nodo) {
		NodoRojoNegro<T> aux= nodo;
		while(!aux.getPadre().equals(nill)) {
			aux= aux.getPadre();
		}
		aux.setColor(NodoRojoNegro.NEGRO);
		return aux;
	}
	// -----------------------------------------------------------------
    // Insertar
    // -----------------------------------------------------------------
    public NodoRojoNegro<T> insertar( NodoRojoNegro<T> nodo ) throws Exception{
        if(buscarElemento(nodo.getElemento())!=null){
        	throw new Exception("El elemento que desea agregar ya existe");
        }
        else if(elemento.compareTo(nodo.getElemento())>0){
            if(hijoDerechoHoja()){
            	nodo.setPadre(this);
                setDerecha(nodo);
            }
            else derecha.insertar(nodo);
        }
        else{
            if(hijoIzquierdaHoja()){
            	nodo.setPadre(this);
                setIzquierda(nodo);
            }
            else izquierda.insertar( nodo );
        }
        return arreglarInsertar(nodo);
    }
    public NodoRojoNegro<T> arreglarInsertar(NodoRojoNegro<T> nodo) {
    	while( nodo.getPadre().getColor()== ROJO && nodo.getColor()== ROJO) {
    		if(nodo.getPadre().equals(nodo.getPadre().getPadre().getIzquierda())) {
    			NodoRojoNegro<T> aux= nodo.getPadre().getPadre().getDerecha();
    			if( aux.getColor()== ROJO) {
    				nodo.getPadre().setColor(NEGRO);
    				aux.setColor(NEGRO);
    				nodo.getPadre().getPadre().setColor(ROJO);
    				nodo= getPadre().getPadre();
    			}
    			else {
    				if(nodo.equals(nodo.getPadre().getDerecha())) {
    					nodo= nodo.getPadre();
    					izquierdaRotar(nodo);
    				}
    				nodo.getPadre().setColor(NEGRO);
					nodo.getPadre().getPadre().setColor(ROJO);
					derechaRotar(nodo.getPadre().getPadre());
    			}
    		}
    		else {
    			NodoRojoNegro<T> aux= nodo.getPadre().getPadre().getIzquierda();
    			if(aux.getColor()== ROJO){
    				nodo.getPadre().setColor(NEGRO);
    				aux.setColor(NEGRO);
    				nodo.getPadre().getPadre().setColor(ROJO);
    				nodo= getPadre().getPadre();
    			}
    			else{
    				if(nodo.equals(nodo.getPadre().getIzquierda())) {
    					nodo= nodo.getPadre();
    					derechaRotar(nodo);
    				}
    				nodo.getPadre().setColor(NEGRO);
					nodo.getPadre().getPadre().setColor(ROJO);
					izquierdaRotar(nodo.getPadre().getPadre());
    			}
    		}
    	}
    	if(!nodo.getPadre().equals(nill)) {
    	arreglarInsertar(nodo.getPadre());
    	}
    	raizNegra(nodo);
    	return nodo;
    }
    // -----------------------------------------------------------------
    // Eliminar
    // -----------------------------------------------------------------
    
    public void buscarEliminar(T nodo) throws Exception {
    	NodoRojoNegro<T> eliminar= buscarElemento(nodo);
    	if( eliminar== null) throw new Exception("El elemento que quiere eliminar no existe");
    	eliminarNodo(eliminar);
    }
    public NodoRojoNegro<T> eliminarNodo(NodoRojoNegro<T> z){
    	NodoRojoNegro<T> x;
    	NodoRojoNegro<T> y = z;
    	int colorY = y.color;
        if(z.getIzquierda().equals(nill)){
            x = z.getDerecha();  
            remplazar(z, z.getDerecha());  
        }else if(z.getDerecha().equals(nill)){
            x = z.getIzquierda();
            remplazar(z, z.getIzquierda()); 
        }else{
        	y =sucesor(z);
            colorY = y.getColor();
            x = y.getDerecha();
            if(y.getPadre().equals(z))
                x.setPadre(y);
            else{
                remplazar(y, y.getDerecha());
                y.setDerecha(z.getDerecha());
                y.getDerecha().setPadre(y);
            }
            remplazar(z,y);
            y.setIzquierda(z.getIzquierda());
            y.getIzquierda().setPadre(y);
            y.setColor(z.getColor());
        }
        if(colorY==NEGRO) {
        	arreglarEliminar(x);
        }  
        return raizNegra(x);
    }
    
    public void arreglarEliminar(NodoRojoNegro<T> x){
        while(!x.getPadre().equals(nill) && x.getColor()== NEGRO){ 
            if(x.equals(x.getPadre().getIzquierda())){
            	NodoRojoNegro<T> w = x.getPadre().getDerecha();
                if(w.getColor() == ROJO){
                    w.setColor(NEGRO);;
                    x.getPadre().setColor(ROJO);
                    izquierdaRotar(x.getPadre());
                    w = x.getPadre().getDerecha();
                }
                if(w.getIzquierda().getColor() == NEGRO && w.getDerecha().getColor()== NEGRO){
                    w.setColor(ROJO);
                    x = x.getPadre();
                    continue;
                }
                else if(w.getDerecha().getColor()== NEGRO){
                    w.getIzquierda().setColor(NEGRO); 
                    w.setColor(ROJO);
                    derechaRotar(w);
                    w = x.getPadre().getDerecha();
                }
                if(w.getDerecha().getColor()== ROJO){
                    w.color = x.getPadre().color;
                    x.getPadre().color = NEGRO;
                    w.getDerecha().setColor(NEGRO); 
                    izquierdaRotar(x.getPadre());
                    x.setPadre(nill);
                }
            }else{
            	NodoRojoNegro<T> w = x.getPadre().getIzquierda();
                if(w.getColor() == ROJO){
                    w.setColor(NEGRO); 
                    x.getPadre().setColor(ROJO);
                    derechaRotar(x.getPadre());
                    w = x.getPadre().izquierda;
                }
                if(w.getDerecha().getColor()== NEGRO && w.getIzquierda().getColor()== NEGRO){
                    w.setColor(ROJO);
                    x = x.getPadre();
                    continue;
                }
                else if(w.getIzquierda().getColor() == NEGRO){
                    w.getDerecha().setColor(NEGRO);
                    w.color = ROJO;
                    izquierdaRotar(w);
                    w = x.getPadre().getIzquierda();
                }
                if(w.getIzquierda().getColor()== ROJO){
                    w.setColor(x.getPadre().getColor());
                    x.getPadre().setColor(NEGRO);
                    w.getIzquierda().setColor(NEGRO);
                    derechaRotar(x.getPadre());
                    x.setPadre(nill);
                }
            }
        }
        x.setColor(NEGRO); 
    }
   public void remplazar(NodoRojoNegro<T> nodo1, NodoRojoNegro<T> nodo2){ 
        if(nodo1.getPadre().equals(nill)){
            nodo2.setPadre(nill);
        }else if(nodo1.equals(nodo1.getPadre().getIzquierda())){
            nodo1.getPadre().setIzquierda(nodo2);
        }else {
        	nodo1.getPadre().setDerecha(nodo2);
        }
        nodo2.setPadre(nodo1.getPadre());
   }
    
    // -----------------------------------------------------------------
    // inOrder
    // -----------------------------------------------------------------
	public void inOrder(ArrayList<T> lista){
		if(!izquierda.equals(nill)){
			izquierda.inOrder(lista);
		}
		lista.add(this.getElemento());
		if(!derecha.equals(nill)){
			derecha.inOrder(lista);
		}
	}
}
