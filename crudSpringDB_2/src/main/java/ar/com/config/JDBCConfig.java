package ar.com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "ar.com")
public class JDBCConfig {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource dataSource(JndiObjectFactoryBean dataSourceFactory) {
		return (DataSource) dataSourceFactory.getObject();
	}

	@Bean
	public JndiObjectFactoryBean dataSourceFactory() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/mariadb/crud");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return jndiObjectFactoryBean;
	}

}