package ejecutables;

import java.util.Scanner;

import modelo.bean.Libro;
import modelo.dao.ModeloLibro;

public class MainEliminarLibro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce un titulo de un libro");
		String titulo = scan.nextLine();
		
		ModeloLibro lm = new ModeloLibro();
		Libro libro = lm.select(titulo);
		
		//libro null bada liburua ez delako aurkitu da
		if(libro != null) {
			
			lm.delete(libro.getId());
			System.out.println("Libro eliminado");
		}else {
			System.out.println("el libro " + titulo + " no existe");
		}

	}

}
