package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // 모든 활동들이 encodingFilter를 우선으로 거쳐감(?)
public class EncodingFilter implements Filter {
   // request 인코딩 필터 -> 모든 request들을 setCharacterEncoding("utf-8"); 해준다?
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFileter 실행 : request utf-8 인코딩");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	 public EncodingFilter() {

    }
    
	public void destroy() {

	}
	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
