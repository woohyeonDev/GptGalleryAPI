package com.springAPI.main.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // API 패턴 설정
                .allowedOrigins("http://localhost:3000") // 허용할 오리진 목록
                .allowedMethods("*") // 허용할 HTTP 메서드 (GET, POST, PUT, DELETE 등)
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true) // 쿠키 및 인증 정보 허용 설정
                .maxAge(3600); // preflight 요청의 캐시 시간
    }
}