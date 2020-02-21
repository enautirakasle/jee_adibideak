package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.bean.Socio;



public class ModeloSocio extends Conector{

	public ModeloSocio() {
		super();
	}
	
	/*
	 * socio guztiak datu basetik irakurri
	 * eta arraylist batean sartzen ditu
	 * arraylist hori itzultzen du
	 */
	public ArrayList<Socio> selectAll(){

		ArrayList<Socio> socios = new ArrayList<Socio>();
		Statement st;
		try {
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");

			Socio socio;
			while (rs.next()) {
				
				socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				
				socios.add(socio);
				
			}
			return socios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socios;
		
	}
	
	public ArrayList<Socio> selectConPrestamos(){
		ModeloPrestamo modeloPrestamo = new ModeloPrestamo();
		
		ArrayList<Socio> socios = new ArrayList<Socio>();
		Statement st;
		try {
			st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");

			Socio socio;
			while (rs.next()) {
				
				socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				
				socio.setPrestamos(modeloPrestamo.prestamosDeSocio(socio.getId()));
				
				socios.add(socio);
				
			}
			return socios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socios;
	}

	public ArrayList<Socio> selectLike(String parte) {
		// TODO Auto-generated method stub
		return null;
	}

	public Socio select(String dni) {
		
		try {
			PreparedStatement pst = conexion.prepareStatement("select * from socios where dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			
			Socio socio;
			if (rs.next()) {
				
				socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				
				return socio;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Socio select(int id) {
		ArrayList<Socio> socios = new ArrayList<Socio>();
		
		try {
			PreparedStatement pst = conexion.prepareStatement("select * from socios where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			Socio socio;
			if (rs.next()) {
				
				socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDni(rs.getString("dni"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				
				return socio;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(String dni) {
		// TODO Auto-generated method stub
		
	}

	public void update(Socio socio) {
		// TODO Auto-generated method stub
		
	}

}
