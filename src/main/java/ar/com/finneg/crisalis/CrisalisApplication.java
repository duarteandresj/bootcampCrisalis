package ar.com.finneg.crisalis;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class CrisalisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrisalisApplication.class, args);
	}
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		CorsConfiguration config=new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOriginPatterns(Arrays.asList("*"));
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter();
	}


}
