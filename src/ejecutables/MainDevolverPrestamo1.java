package ejecutables;

import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.dao.ModeloLibro;
import modelo.dao.ModeloPrestamo;

public class MainDevolverPrestamo1 {

	public static void main(String[] args) {
		ModeloLibro mLibro = new ModeloLibro();
		ModeloPrestamo mPrestamo = new ModeloPrestamo();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce el titulo del libro que va a entregar");
		String titulo = scan.nextLine();
		
		Libro libro = mLibro.select(titulo);
		
		if(libro != null) {
			Prestamo prestamo = mPrestamo.getPrestamoNoDevuelto(libro);
			
			if(prestamo !=null) {
				mPrestamo.finalizar(prestamo);
				System.out.println(libro.getTitulo() + "entregado.");
			}else {
				System.out.println("En el sistema no se encuentra ningun prestamo de " + libro.getTitulo());
			}
		}else {
			System.out.println("Libro no encontrado");
		}
		
		
		

	}

}
