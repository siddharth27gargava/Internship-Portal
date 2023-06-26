package com.example.InternshipPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.example.InternshipPortal.controller","com.example.InternshipPortal.dao","com.example.InternshipPortal.pojo","com.example.InternshipPortal.util"})
public class InternshipPortalApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/InternshipPortal/");
		SpringApplication.run(InternshipPortalApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("fpage");
		
	}

}
