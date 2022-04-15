package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 개발 디버깅 시 확인용 코드
//		HttpServletRequest h_request = (HttpServletRequest) request;
//		h_request.setAttribute("pwdChk", h_request.getParameter("pwd"));

		LoginWrapper lw = new LoginWrapper((HttpServletRequest) request);
		chain.doFilter(lw, response);
	}

}
