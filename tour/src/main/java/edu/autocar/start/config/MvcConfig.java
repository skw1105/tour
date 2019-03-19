package edu.autocar.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import edu.autocar.interceptor.AdminInterceptor;
import edu.autocar.interceptor.LoginInterceptor;

@Configuration
@EnableWebMvc
@EnableTransactionManagement // 메서드 호출했는데 예외발생 하면 커밋, 예외발생하면 롤백 이런 기능을 지원해주는 annotation
@ComponentScan(basePackages = { "edu.autocar" })
public class MvcConfig implements WebMvcConfigurer {
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		// css, js, 이미지 등의 정적 파일 배치 위치 등록 - 스프링이 처리 안함
		registry.addResourceHandler("/resources/**") // 적용 경로 //*이 두개있으면 그 아래 계속해서 다
				.addResourceLocations("/resources/"); // 웹 경로 // *이 하나있으면 그 바로 아래만 다
	}

	// view resolver가 servlet dispatcher기능 하는 듯
	// url을 보고 저 경로에서 .jsp파일을 찾음
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// JSP view resolver 설정
		// 뷰 이름 앞,뒤에 붙일 prefix(접두어), surfix(접미어) 설정
		//registry.jsp("/WEB-INF/views/", ".jsp"); // 이게 없으면 /hello라는 주소에 대한 게 없다.? -> 404에러
		// 이걸 주석처리 해야 190314 레이아웃 적용된거 나옴 
		
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-layout.xml" });
		tilesConfigurer.setCheckRefresh(true);
		
		return tilesConfigurer;
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Bean
	public AdminInterceptor adminInterceptor() {
		return new AdminInterceptor();
	}

	// 인터셉터 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()) // 인터셉터 등록
				.addPathPatterns(new String[] { // 적용 url 패턴
						"/member/**",
						"/admin/**",
						"/board/*"})
				.excludePathPatterns(new String[] { // 제외 url 패턴
						"/board/list",
						"/board/view"});
		
		registry.addInterceptor(adminInterceptor()) // 인터셉터 등록
				.addPathPatterns("/admin/**"); // 적용 url 패턴
	}
	
}



