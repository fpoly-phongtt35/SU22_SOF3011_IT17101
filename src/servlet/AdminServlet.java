package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.ProductService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	private final ProductService productService
		= new ProductService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Lấy danh sách sản phẩm
		List<Product> products = productService.getAllProduct();
		
		// Đẩy danh sách sản phẩm lên
		req.setAttribute("products", products);
		
		// Di chuyển đến client
		req.getRequestDispatcher("/WEB-INF/view/admin.jsp")
			.forward(req, resp);
	}
}
