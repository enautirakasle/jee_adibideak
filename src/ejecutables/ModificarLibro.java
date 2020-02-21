package ejecutables;

import java.util.Scanner;

import modelo.bean.Libro;
import modelo.dao.ModeloLibro;

public class ModificarLibro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un titulo de un libro");
		String titulo = scan.nextLine();
		
		ModeloLibro lm = new ModeloLibro();
		Libro libro = lm.select(titulo);
		
		if(libro != null) {
			System.out.println("Este es el libro que va ha modificar");
			System.out.println(libro);
			
			System.out.println("Introduce el titulo nuevo del libro o Enter sin escribir nada");
			String tituloNuevo = scan.nextLine();
			
			//erabiltzaileak ezer idatzi gabe enter eman badio
			if(tituloNuevo.length() > 0) {
				libro.setTitulo(tituloNuevo);
			}
			
			System.out.println("Introduce el autor nuevo del libro o Enter sin escribir nada");
			String autorNuevo = scan.nextLine();
			
			//erabiltzaileak ezer idatzi gabe enter eman badio
			if(autorNuevo.length() > 0) {
				libro.setAutor(autorNuevo);
			}
			
			System.out.println("Introduce el numero de paginas nuevo del libro o Enter sin escribir nada");
			String numPagString = scan.nextLine();
			
			//erabiltzaileak ezer idatzi gabe enter eman badio
			if(numPagString.length() > 0) {
				int numeroDePaginasNuevo = Integer.parseInt(numPagString);
				libro.setNumeroPaginas(numeroDePaginasNuevo);
			}

			lm.update(libro);
			System.out.println("Libro modificado");
			
		}else {
			System.out.println("el libro " + titulo + " no existe");
		}

	}

}
