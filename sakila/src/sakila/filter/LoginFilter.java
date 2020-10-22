package sakila.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/auth/*") // EncodingFilter를 거쳐간 것들 중 auth에 포함된 것들만 거쳐감
public class LoginFilter implements Filter {
	// 인증페이지 세션 검사 필터
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginFilter 실행 : session 검사");
		HttpSession session = ((HttpServletRequest)request).getSession(); // 세션 가져오기
		if(session.getAttribute("loginStaff") == null) { // 로그인 세션값이 없으면 로그인 페이지로 이동
			System.out.println("로그인 후 접근");
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet");
			return;
		}
		chain.doFilter(request, response);
	}

	public LoginFilter() {
        
    }

	public void destroy() {
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
