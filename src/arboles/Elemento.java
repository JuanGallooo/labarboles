package arboles;

public class Elemento implements Comparable<Elemento>{
	private int numero;
	private int numeroCreado;
	public Elemento(int numero, int numeroCreado) {
		super();
		this.numero = numero;
		this.numeroCreado = numeroCreado;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumeroCreado() {
		return numeroCreado;
	}
	public void setNumeroCreado(int numeroCreado) {
		this.numeroCreado = numeroCreado;
	}
	@Override
	public int compareTo(Elemento o) {
		int retorno=0;
		if(o.getNumero()<numero)retorno=-1;
		else if (o.getNumero()>numero)retorno=1;
		return retorno;
	}

}
