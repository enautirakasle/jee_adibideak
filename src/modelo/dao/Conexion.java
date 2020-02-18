package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {
	protected Connection conexion;
	
	protected String host;
	protected String bbdd;
	protected String usuario;
	protected String contrasenia;
	
	public Conexion(String host, String bbdd, String usuario, String contrasenia) {
		super();
		this.host = host;
		this.bbdd = bbdd;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd, usuario, contrasenia);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	

}
