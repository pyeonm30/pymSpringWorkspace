package kr.board.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//web.xml 을 자바로 구현한 클래스 

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	// 루트 컨텍스트 객체
	@Override
	protected Class<?>[] getRootConfigClasses() {  // root-context.xml
		// TODO Auto-generated method stub
		return new Class[] { RootConfig.class , SecurityConfig.class };
	}

	// 서블렛 컨텍스트 객체 
	@Override
	protected Class<?>[] getServletConfigClasses() { // servlet-context.xml
		// TODO Auto-generated method stub
		return new Class[] { ServletConfig.class };
	}
	
	
	// 핸들러 맵핑 객체 

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	// 한글 인코딩 필터 
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);		
		return new Filter[]{encodingFilter};
	}


	
}
