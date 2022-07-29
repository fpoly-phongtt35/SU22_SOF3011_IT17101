package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private final AuthenticationService authenService
		= new AuthenticationService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Gọi Service để xác thực thông tin
		Account account = authenService
				.authenticate(username, password);
		if (account == null) { // Không hợp lệ
			resp.getWriter().append("Not Allowed");
		} else { // Hợp lệ
			HttpSession session = req.getSession();
			session.setAttribute("username", account.getUsername());
			session.setAttribute("role", account.getRole());
			
			resp.sendRedirect("/SampleORM_IT17101/user");
		}
	}
	
}
