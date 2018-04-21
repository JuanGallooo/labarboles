package arboles;

import java.util.ArrayList;


public class NodoArbolAVL <T extends Comparable> extends NodoArbol {
	private int estado;

	public NodoArbolAVL(Comparable elemento) {
		super(elemento);
	}
	
	public int getEstado(){
		factorBalanceo();
		return estado;
	}
	public void factorBalanceo(){
		int altDerecha = 0;
		int altIzquierda = 0;
		
		if(super.getDerecha() != null) altDerecha = this.getDerecha().darAltura() + 1;

		if(super.getIzquierda() != null){
			altIzquierda = this.getIzquierda().darAltura() + 1;
		}
		estado = altDerecha -altIzquierda;
		
	
	}
	
	
	
	

	


}
