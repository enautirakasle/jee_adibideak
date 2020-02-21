package ejecutables;

import java.util.Date;
import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.ModeloLibro;
import modelo.dao.ModeloPrestamo;
import modelo.dao.ModeloSocio;

//sozioaren dni-a eskatu
//dniarekin sozio lortu	
		
//if sozioa existitzen da
	//liburuaren tituloa eskatu
	//tituluarekin liburua lortu

	//if liburua existitzen da
		//prestamo objetu bat sortu
		//prestamoa datuekin bete
		//prestamoa datu basean sartu
	
	//bestela
		//errore mezua

//bestela
	//errore mezua
public class MainRealizarPrestamo {

	public static void main(String[] args) {
		ModeloSocio mSocio = new ModeloSocio();
		ModeloLibro mLibro = new ModeloLibro();
		ModeloPrestamo mPrestamo = new ModeloPrestamo();
		
		Scanner scan = new Scanner(System.in);
		
		//sozioaren dni-a eskatu
		System.out.println("Idatzi DNI bat");
		String dni = scan.nextLine();
		
		//dniarekin sozio lortu
		Socio socio = mSocio.select(dni);
		
		//if sozioa existitzen da
		if(socio != null) {
			System.out.println("Idatzi liburu baten tituloa");
			String tituloa = scan.nextLine();
			
			Libro libro = mLibro.select(tituloa);
			if(libro != null) {//liburua eta sozioa existitzen dira
				//prestamo objetu bat sortu
				Prestamo prestamo = new Prestamo();
				prestamo.setSocio(socio);
				prestamo.setLibro(libro);
				prestamo.setDevuelto(false);
				prestamo.setFecha(new Date()); //momentuko data

				mPrestamo.insert(prestamo);
				
			}else {
				System.out.println(tituloa + " liburua ez da existitzen");
			}

		}else {//socio==null
			System.out.println("Sartutako DNI-a ez da existitzen");
		}

	}

}
