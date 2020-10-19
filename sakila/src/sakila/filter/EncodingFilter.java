package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") // ��� Ȱ������ encodingFilter�� �켱���� ���İ�(?)
public class EncodingFilter implements Filter {
   // request ���ڵ� ���� -> ��� request���� setCharacterEncoding("utf-8"); ���ش�?
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFileter ���� : request utf-8 ���ڵ�");
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
