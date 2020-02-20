package modelo.bean;

import java.util.Date;

import modelo.bean.Libro;
import modelo.bean.Socio;

public class Prestamo {

	private Date fecha;
	private boolean devuelto;
	
	private Socio socio;
	private Libro libro;
	

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	@Override
	public String toString() {
		return "Prestamo [fecha=" + fecha + ", devuelto=" + devuelto + ", socio=" + socio + ", libro=" + libro + "]";
	}
	
	public String infoConLibro() {
		return "Prestamo [fecha=" + fecha + ", devuelto=" + devuelto + ", libro=" + libro.getTitulo() + ", autor=" + libro.getAutor() + "]";
	}
	
	
	
	
	

}
