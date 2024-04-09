//package org.servlet.springassign;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/v1/**") // Adjust the mapping pattern as needed
//                .allowedOrigins("http://localhost:3000") // Allow requests from your React app's origin
//                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
//                .allowedHeaders("*"); // Allow all headers
//    }
//}
