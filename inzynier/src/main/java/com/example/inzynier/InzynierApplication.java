package com.example.inzynier;

import com.example.inzynier.Thread.PaskiZycia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InzynierApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(InzynierApplication.class, args);
		PaskiZycia zycie = new PaskiZycia();
		applicationContext.getAutowireCapableBeanFactory().autowireBean(zycie);
		Thread thread = new Thread(zycie);
		thread.start();
	}

}
