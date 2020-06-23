package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class SaveForm
 */
@WebServlet("/SaveForm")
public class SaveForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String izena = request.getParameter("fname");
	    String abizena = request.getParameter("lname");
	    
	    String[] cars = request.getParameterValues("cars");
	    
	    String message = request.getParameter("message");
	    
	    String gender = request.getParameter("gender");
	    
	    String vehicle1 = request.getParameter("vehicle1");
	    String vehicle2 = request.getParameter("vehicle2");
	    String vehicle3 = request.getParameter("vehicle3");
	    
	    String[] osagaiak = request.getParameterValues("osagaia");
	    ArrayList<String> osagaiakAL = new ArrayList<String>();
	    for (String osagaia : osagaiak) {
			osagaiakAL.add(osagaia);
		}
	    List<String> osagaiakL = Arrays.asList(osagaiak);
	    
	    
	    request.setAttribute("osagaiak", osagaiakL);
	    
	    request.getRequestDispatcher("/form/formDatuak.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
