package edu.autocar.start.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "edu.autocar" })
public class MvcConfig implements WebMvcConfigurer {
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		// css, js, 이미지 등의 정적 파일 배치 위치 등록 - 스프링이 처리 않함
		registry.addResourceHandler("/resources/**") // 적용 경로 //*이 두개있으면 그 아래 계속해서 다
				.addResourceLocations("/resources/"); // 웹 경로 // *이 하나있으면 그 바로 아래만 다
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP 뷰 리졸러 설정
		// 뷰 이름 앞,뒤에 붙일 prefix(접두어), surfix(접미어) 설정
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
}
