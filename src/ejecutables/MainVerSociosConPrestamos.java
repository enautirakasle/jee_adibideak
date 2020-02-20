package ejecutables;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.ModeloSocio;

public class MainVerSociosConPrestamos {

	public static void main(String[] args) {
		ModeloSocio ms = new ModeloSocio();
		ArrayList<Socio> socios = ms.selectConPrestamos();
		
		for(int i = 0; i< socios.size(); i++) {
			Socio socio = socios.get(i);
			System.out.println(socio);
			
			ArrayList<Prestamo> prestamos = socio.getPrestamos();
			for(int j = 0; j<prestamos.size(); j++) {
				Prestamo prestamo = prestamos.get(j);
				System.out.println(prestamo.infoConLibro());
			}
			System.out.println("\n");
			
		}
	}

}
