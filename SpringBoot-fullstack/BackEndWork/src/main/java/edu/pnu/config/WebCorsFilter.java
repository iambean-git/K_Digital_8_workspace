package edu.pnu.config;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebCorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 교차 출처를 허용하는 클라이언트 주소
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        // 쿠키 또는 자격 증명 정보를 클라이언트가 서버로 보내는 것을 허용하도록 설정
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 클라이언트가 서버에 요청할 수 있는 Method 설정
        response.setHeader("Access-Control-Allow-Methods","*");
        // 클라이언트가 서버로부터 응답을 받았을 때 설정 시간 동안은 CORS 제한을 받지 않음.
        response.setHeader("Access-Control-Max-Age", "3600");
        // 클라이언트가 서버에 요청할 수 있는 헤더 설정
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        // 서버가 클라이언트에게 전송할 수 있는 헤더 설정
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        
        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            chain.doFilter(req, resp);
        }
	}
}
