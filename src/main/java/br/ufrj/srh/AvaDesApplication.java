package br.ufrj.srh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.ufrj.srh.*")
@SpringBootApplication
public class AvaDesApplication {

	public static void main(String[] args) {

		SpringApplication.run(AvaDesApplication.class, args);
		
	}
}
