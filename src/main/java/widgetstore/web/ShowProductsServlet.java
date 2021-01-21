package widgetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.GenericDAO;

public class ShowProductsServlet extends HttpServlet {
	
	GenericDAO<productDTO> productDAO;
	
	public ProductDetailsServlet() {
		productDAO = new ProductDAOImpl();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<form action='' method='POST'>");
		out.println("<label>Enter Product ID: <input type='text' name='product-id></input></label>");
		out.println("<input type='submit'>Get Details</input>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		
		String productId = request.getParameter("product-id");
		PrintWriter out = response.getWriter();
		
		// Use the productDAO . . get the productDTO
		// show the details
		// or if not found
		// show an error message
		
		out.println("showing product details - or an issue if not found");
		
	}
	
	
}
