package cisco.assignment.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Filter to add headers detailing what methods of access are allowed. 
 * @author kyle
 *
 */
@Component
public class RequestFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(req, res);
		if (res instanceof HttpServletResponse) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader("Allow", "POST, GET, PUT, DELETE");
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}