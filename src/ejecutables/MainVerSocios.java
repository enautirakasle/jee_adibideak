package ejecutables;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.bean.Socio;
import modelo.dao.ModeloSocio;

public class MainVerSocios {

	public static void main(String[] args) {
		ModeloSocio ms = new ModeloSocio();
		ArrayList<Socio> socios = ms.selectAll();
		
		Iterator<Socio> i = socios.iterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}


	}

}
