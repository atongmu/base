package com.example.base.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		String auth = "WTVIrZv5e8qy6AtH";
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization").defaultValue(auth).description("令牌").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		List<Parameter> aParameters = new ArrayList<Parameter>();
		aParameters.add(aParameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalOperationParameters(aParameters)
				.select()
				// Controller所在包(必须新建包)
				.apis(RequestHandlerSelectors.basePackage("com.example.base.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 标题
				.title("高投行政督查系统")
				// 描述
				.description("行政督查系统")
				// 超链接
				.termsOfServiceUrl("")
				.version("1.0").build();
	}
}
