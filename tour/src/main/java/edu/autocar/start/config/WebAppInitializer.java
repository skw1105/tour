package edu.autocar.start.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// 어떤 컴포넌트를 쓰겠다 이걸 알려주는 클래스
// 전반적인 웹 어플리케이션 구성
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class, DatabaseConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { MvcConfig.class };
	}

	// 서블릿 매핑
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// 어떤 필터들을 적용하겠다.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		// 컨텍스트 경로를 application 스코프에 저장하기
		String contextPath = servletContext.getContextPath();
		servletContext.setAttribute("contextPath", contextPath);
		// 문자 인코딩 필터 설정
		FilterRegistration charEncodingFilterReg = servletContext.addFilter("CharacterEncodingFilter",
				CharacterEncodingFilter.class);
		charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingFilterReg.setInitParameter("forceEncoding", "true");
		charEncodingFilterReg.addMappingForUrlPatterns(null, true, "/*");
	}
}
