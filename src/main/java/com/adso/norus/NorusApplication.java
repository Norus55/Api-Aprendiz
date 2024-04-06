package com.adso.norus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.adso.norus"})
public class NorusApplication {

	public static void main(String[] args) {
		System.out.println("Hellow ADSO, This is my Aplication!");
		SpringApplication.run(NorusApplication.class, args);

	}

}
