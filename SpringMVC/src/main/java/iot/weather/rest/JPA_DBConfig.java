package iot.weather.rest;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement

public class JPA_DBConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();	
		
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getDataSource());
		emf.setPackagesToScan("iot.weather.rest.entity");
		emf.setJpaProperties(jpaProperties());
		
		return emf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		
		dmds.setUrl("jdbc:mysql://localhost:3306/weatherapp?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dmds;
	}
	
	@Bean
	public PlatformTransactionManager transmngr(EntityManagerFactory emf) {
		
		return new JpaTransactionManager(emf);
		
	}
	
	private Properties jpaProperties() {
		
		Properties props = new Properties();
		
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		
		return props;
	}
}
