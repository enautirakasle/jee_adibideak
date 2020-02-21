package ejecutables;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.ModeloLibro;
import modelo.dao.ModeloPrestamo;
import modelo.dao.ModeloSocio;

public class MainDevolverPrestamo2 {

	public static void main(String[] args) {
		ModeloLibro mLibro = new ModeloLibro();
		ModeloSocio mSocio = new ModeloSocio();
		ModeloPrestamo mPrestamo = new ModeloPrestamo();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce el dni");
		String dni = scan.nextLine();
		
		Socio socio = mSocio.select(dni);
		
		if(socio != null) {
			ArrayList<Prestamo> prestamos = mPrestamo.prestamosDeSocio(socio.getId());
			
			System.out.println("Sus prestamos pendientes son estos");
			for(int i = 0; i<prestamos.size(); i++) {
				Prestamo prestamo = prestamos.get(i);
				if(!prestamo.isDevuelto()) {
					System.out.println(prestamo.infoConLibro());
				}
			}
			
			System.out.println("Introduce el id del libro a devolver");
			int idLibroDevolucion = Integer.parseInt(scan.nextLine());
			Libro libroDevolucion = mLibro.select(idLibroDevolucion);
			
			Prestamo prestamo = mPrestamo.getPrestamoNoDevuelto(libroDevolucion);
			
			mPrestamo.finalizar(prestamo);
			System.out.println(libroDevolucion.getTitulo() + " entregado.");
			
		}else {
			System.out.println("Socio no encontrado");
		}
		
		
		

	}

}
