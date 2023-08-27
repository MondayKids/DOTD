package com.dotd.user;

import org.hibernate.annotations.common.Version;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.persistence.Persistence;

@SpringBootApplication
@EnableAspectJAutoProxy // aop 사용
public class UserApplication {

	public static void main(String[] args) {
		String jpaVersion = Persistence.class.getPackage().getImplementationVersion();
		System.out.println("JPA Version: " + jpaVersion);
		SpringApplication.run(UserApplication.class, args);
	}

}
