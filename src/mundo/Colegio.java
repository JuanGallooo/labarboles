package mundo;

public class Colegio implements Comparable<Colegio>{
	
	public static final int BUSQUEDA_NOMBRE=0;
	public static final int BUSQUEDA_TELEFONO=1;
	public static final int BUSQUEDA_RECTOR=2;
	
	private String calendario;
	private String sector;
	private String nombre;
	private String telefono;
	private String rector;
	private String correo;
	private String direccion;
	
	private int busquedaActual;
	
	public Colegio(String calendario, String sector, String nombre, String telefono, String rector, String correo,
			String direccion) {
		this.calendario = calendario;
		this.sector = sector;
		this.nombre = nombre;
		this.telefono= telefono;
		this.rector = rector;
		this.correo = correo;
		this.direccion = direccion;
		this.busquedaActual = 0;
	}
	public String getCalendario() {
		return calendario;
	}
	public void setCalendario(String calendario) {
		this.calendario = calendario;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getRector() {
		return rector;
	}
	public void setRector(String rector) {
		this.rector = rector;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getBusquedaActual() {
		return busquedaActual;
	}
	public void setBusquedaActual(int busquedaActual) {
		this.busquedaActual = busquedaActual;
	}
	@Override
	public int compareTo(Colegio o) {
		int retorno=0;
		if( busquedaActual==BUSQUEDA_NOMBRE) {
			if(o.getNombre().compareTo(getNombre())<0)retorno=-1;
			else if (o.getNombre().compareTo(getNombre())>0)retorno=1;
		}
		else if( busquedaActual==BUSQUEDA_TELEFONO) {
			if(o.getTelefono().compareTo(getTelefono())<0)retorno=-1;
			else if (o.getTelefono().compareTo(getTelefono())>0)retorno=1;
		}
		else {
			if(o.getRector().compareToIgnoreCase(getRector())<0)retorno=-1;
			else if (o.getRector().compareToIgnoreCase(getRector())>0)retorno=1;
		}
		return retorno;
	}
	@Override
	public String toString() {
		return "Colegio [calendario=" + calendario + ", sector=" + sector + ", nombre=" + nombre + ", telefono="
				+ telefono + ", rector=" + rector + ", correo=" + correo + ", direccion=" + direccion
				+ ", busquedaActual=" + busquedaActual + "]";
	}

	
	
}
