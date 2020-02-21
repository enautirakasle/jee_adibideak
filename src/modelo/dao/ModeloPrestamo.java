package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;



public class ModeloPrestamo extends Conector{
	
	public ModeloPrestamo() {
		super();
	}

	public ArrayList<Prestamo> selectAll(){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		/*
		 * SELECT prestamos.*, libros.titulo, libros.autor, libros.num_pag, socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia 
		 * FROM (prestamos join libros on prestamos.id_libro=libros.id) join socios on prestamos.id_socio=socios.id
		 */
		Statement st;
		try {
			st = this.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT prestamos.*, libros.titulo, libros.autor, libros.num_pag, socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia "
					+ "FROM (prestamos join libros on prestamos.id_libro=libros.id) join socios on prestamos.id_socio=socios.id");
			
			while(rs.next()){
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				
				Libro libro = new Libro();
				libro.setId(rs.getInt("id_libro"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumeroPaginas(rs.getInt("num_pag"));
				prestamo.setLibro(libro);
				
				Socio socio = new Socio();
				socio.setId(rs.getInt("id_socio"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				prestamo.setSocio(socio);
				
				prestamos.add(prestamo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamos;
	}
	
	public ArrayList<Prestamo> prestamosDeLibro(int idLibro){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT prestamos.*, "
					+ "libros.titulo, libros.autor, libros.num_pag, "
					+ "socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia "
					+ "FROM (prestamos join libros on prestamos.id_libro=libros.id) "
					+ "join socios on prestamos.id_socio=socios.id "
					+ "where libros.id= ?");
			pst.setInt(1, idLibro);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				
				Libro libro = new Libro();
				libro.setId(rs.getInt("id_libro"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumeroPaginas(rs.getInt("num_pag"));
				prestamo.setLibro(libro);
				
				Socio socio = new Socio();
				socio.setId(rs.getInt("id_socio"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				prestamo.setSocio(socio);
				
				prestamos.add(prestamo);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestamos;
	}
	
	public void finalizar(Prestamo prestamo){
	
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE prestamos SET devuelto=true WHERE id_libro=? and id_socio=? and fecha=?");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getSocio().getId());
			pst.setDate(3, new java.sql.Date(prestamo.getFecha().getTime()));
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

	public ArrayList<Prestamo> prestamosDeSocio(int idSocio) {
ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT prestamos.*, "
					+ "libros.titulo, libros.autor, libros.num_pag, "
					+ "socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia "
					+ "FROM (prestamos join libros on prestamos.id_libro=libros.id) "
					+ "join socios on prestamos.id_socio=socios.id "
					+ "where socios.id= ?");
			pst.setInt(1, idSocio);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				
				Libro libro = new Libro();
				libro.setId(rs.getInt("id_libro"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumeroPaginas(rs.getInt("num_pag"));
				prestamo.setLibro(libro);
				
				Socio socio = new Socio();
				socio.setId(rs.getInt("id_socio"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				prestamo.setSocio(socio);
				
				prestamos.add(prestamo);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prestamos;
	}

	public void insert(Prestamo prestamo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO prestamos(id_libro, id_socio, fecha, devuelto) VALUES (?, ?, ?, ?)");
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getSocio().getId());
			pst.setDate(3, new java.sql.Date(prestamo.getFecha().getTime()));
			pst.setBoolean(4, prestamo.isDevuelto());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public Prestamo getPrestamoNoDevuelto(Libro libro) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from prestamos where id_libro=? and devuelto=false");
			pst.setInt(1, libro.getId());
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				prestamo.setFecha(rs.getDate("fecha"));
				
				Libro libroTemp = new Libro();
				libroTemp.setId(rs.getInt("id_libro"));
				prestamo.setLibro(libroTemp);
				
				Socio socioTemp = new Socio();
				socioTemp.setId(rs.getInt("id_socio"));
				prestamo.setSocio(socioTemp);
				
				return prestamo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Prestamo> getPrestamosNoDevueltos(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
