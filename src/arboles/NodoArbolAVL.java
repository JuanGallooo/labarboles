package arboles;

import java.util.ArrayList;


public class NodoArbolAVL extends NodoArbol {
	private int estado;

	public NodoArbolAVL(Comparable elemento, NodoArbol padre) {
		super(elemento, padre);
	}
	
	public int getEstado(){
		return estado;
	}
	public void factorBalanceo(){
		estado = 2;
	}
	
	
	
	

	


}
