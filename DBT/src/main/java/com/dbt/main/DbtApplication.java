package com.dbt.main;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dbt.hedera.utilities.HederaHelper;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.dbt.*")
@EnableJpaRepositories(basePackages="com.dbt.*")
@EntityScan( basePackages = {"com.dbt.*"} )

public class DbtApplication {
	final static Logger logger = LoggerFactory.getLogger(DbtApplication.class);
	

	public static void main(String[] args) {
		ApplicationContext app =SpringApplication.run(DbtApplication.class, args);
		HederaHelper helper = app.getBean(HederaHelper.class);
		helper.loadHederaConfig();
		System.out.println("in main"+app);
		
		
	}
}
