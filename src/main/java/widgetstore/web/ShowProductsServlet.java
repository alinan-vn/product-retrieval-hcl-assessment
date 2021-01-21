package widgetstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import hibernate.HibernateUtils;
//import product.GenericDAO;
import product.Product;

public class ShowProductsServlet extends HttpServlet {
		
	Session session;
	
	public void init() {
		
		session = HibernateUtils.buildSessionFactory().openSession();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<form action='' method='POST'>");
		out.println("<label>Enter Product ID: <input type='text' name='product-id'></input></label>");
		out.println("<button type='submit'>Get Details</button>");
		out.println("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		
		
		
		String productId = request.getParameter("product-id");
		PrintWriter out = response.getWriter();
		
		Product productEntity = session.get(
				Product.class,
				Long.parseLong(productId)
		);
		if (productEntity != null) {
			out.println("Found Product! Name: " + productEntity.getName() + ", Type: " + productEntity.getType() + ", Price: " + productEntity.getPrice());
		} else {
			out.println("No Product found for id: " + productId);
		}
	}	
}
