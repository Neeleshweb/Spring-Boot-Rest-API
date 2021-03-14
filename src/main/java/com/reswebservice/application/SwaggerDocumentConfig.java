package com.reswebservice.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentConfig {
	
	
	@Primary
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
    }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors
	            .basePackage("com.reswebservice.application.controller"))
	            .paths(PathSelectors.any()).build();
	}
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("SPRING BOOT API URL USAGE GUIDE")
            .description("To view the URL along with request type for each resource, read this API document. This document also provides dummy request format to make requests to resources easier")
            .version("1.0")
            .license("This API has valid licenses.").termsOfServiceUrl("Click here to view terms and conditions.")
            .build();
    }
}
