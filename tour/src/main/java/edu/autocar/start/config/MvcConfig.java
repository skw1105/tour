package edu.autocar.start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement // 메서드 호출했는데 예외발생 하면 커밋, 예외발생하면 롤백 이런 기능을 지원해주는 annotation
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
		//registry.jsp("/WEB-INF/views/", ".jsp"); // 이게 없으면 /hello라는 주소에 대한 게 없다.? -> 404에러
		// 이걸 주석처리 해야 190314 레이아웃 적용된거 나옴 
		
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles/tiles-layout.xml" });
		tilesConfigurer.setCheckRefresh(true);
		
		return tilesConfigurer;
	}
}
