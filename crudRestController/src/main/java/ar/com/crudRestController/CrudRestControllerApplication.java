package ar.com.crudRestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrudRestControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestControllerApplication.class, args);
	}

}
