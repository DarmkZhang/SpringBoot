package com.hsbc.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication /*extends WebMvcConfigurerAdapter*/{
	/*public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
		super.configureMessageConverters(converters);
	}
*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
