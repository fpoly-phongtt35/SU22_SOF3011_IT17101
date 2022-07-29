package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;

@WebFilter("/admin")
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// Lấy Role của Người đăng nhập
		HttpSession session = req.getSession();
		
		// Kiểm tra có phải role Admin
		if (session.getAttribute("role") == AccountRole.ADMIN) { 
			chain.doFilter(request, response); // đi tiếp
		} else { // Không đúng cho về
			response.getWriter().append("Not Allowed!");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	

}
