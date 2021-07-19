package com.api_agenda_virtual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.api_agenda_virtual.controller")) //local onde estão as controllers
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Api Agenda Virtual Spring Boot REST API")
				.description("\"Um aplicação Spring Boot REST API em Java\"").version("1.0.0")
				.license("The MIT License").licenseUrl("https://opensource.org/licenses/MIT\"")
				.contact(new Contact("Marcelo F Silva", "https://github.com/marcelofelipesilva", "marcelofelipesilva@outlook.com"))
				.build();
	}
}
