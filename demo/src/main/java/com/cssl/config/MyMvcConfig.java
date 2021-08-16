package com.cssl.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cssl.interceptor.MyInterceptor;

@Component
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("添加自己定义拦截器");
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/images/**");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 设置允许跨域的路由
    	registry.addMapping("/**")
            // 设置允许跨域请求的域名
            .allowedOriginPatterns("*")
            // 是否允许证书（cookies）
            .allowCredentials(false)
            // 设置允许的方法
            .allowedMethods("*")
            // 跨域允许时间
            .maxAge(3600);
    	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(new InternalResourceViewResolver("/",".jsp"));
	}

}
