package ar.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import ar.com.repository.PersonaDao;
import ar.com.repository.PersonaDaoImpl;
import ar.com.service.PersonaBo;
import ar.com.service.PersonaBoImpl;

@Configuration
@ComponentScan(basePackages = { "ar.com" })
public class JDBCConfiguration {

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/crud");
		ds.setUsername("root");
		ds.setPassword("2712");

		return ds;
	}

	@Bean
	public PersonaDao getPersonaDao() {
		return new PersonaDaoImpl(getDataSource());
	}

}