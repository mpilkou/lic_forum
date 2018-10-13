package ug.edu.config;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ug.edu")
@PropertySource("classpath:jdbc.properties")
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();
		try {
			myDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		myDataSource.setUser(environment.getProperty("jdbc.user"));
		myDataSource.setPassword(environment.getProperty("jdbc.password"));
		
		myDataSource.setInitialPoolSize(
				Integer.parseInt(
						environment.getProperty("connection.initPoolSize")));
		myDataSource.setMinPoolSize(
				Integer.parseInt(
						environment.getProperty("connection.minPoolSize")));
		myDataSource.setMaxPoolSize(
				Integer.parseInt(
						environment.getProperty("connection.maxPoolSize")));		
		myDataSource.setMaxIdleTime(
				Integer.parseInt(
						environment.getProperty("connection.maxIdleTime")));
		return myDataSource;
	}
	
	public Properties getProperties() {

		// set hibernate properties
		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(myDataSource());
		sessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(getProperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		
		return hibernateTransactionManager;
	}
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }
}
