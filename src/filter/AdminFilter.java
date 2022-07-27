package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/admin")
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Lấy code của Request
		String code = request.getParameter("code");
		
		if ("123456".equals(code)) { // Đúng code cho đi tiếp
			chain.doFilter(request, response); // đi tiếp
		} else { // Không đúng cho về
			response.getWriter().append("Not Allowed!");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	

}
