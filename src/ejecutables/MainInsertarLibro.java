package ejecutables;

import java.util.Scanner;

import modelo.bean.Libro;
import modelo.dao.ModeloLibro;

public class MainInsertarLibro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un titulo de un libro");
		String titulo = scan.nextLine();
		
		ModeloLibro lm = new ModeloLibro();
		if(!lm.existe(titulo)) {
			System.out.println("Introduce el nombre del autor");
			String autor = scan.nextLine();
			
			System.out.println("Introduce el numero de paginas");
			int numeroDePaginas = Integer.parseInt(scan.nextLine());
			
			//liburu objetua sortu eta gure balioekin bete
			Libro libro = new Libro();
			libro.setTitulo(titulo);
			libro.setAutor(autor);
			libro.setNumeroPaginas(numeroDePaginas);
			
			lm.insertLibro(libro);
			
		}else {
			System.out.println("el libro " + titulo + " ya existe");
		}

	}

}
