package dark.com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica o CORS a todos os endpoints
                        .allowedOrigins("http://localhost:4200") // Permite origens específicas
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("Content-Type", "Authorization") // Cabeçalhos permitidos
                        .allowCredentials(true); // Permitir envio de credenciais (cookies, headers de autenticação, etc.)
            }
        };
    }
}
