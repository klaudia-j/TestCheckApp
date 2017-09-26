package pl.jarno;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.jarno.converter.AnswerConverter;
import pl.jarno.converter.CategoryConverter;
import pl.jarno.converter.QuestionConverter;
import pl.jarno.entity.Category;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "pl.jarno")
@EnableJpaRepositories(basePackages = "pl.jarno.repository")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() { 
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean(); 
		emfb.setPersistenceUnitName("fiklaPersistenceUnit");
		return emfb; 
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) { 
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm; 
	}
	
	@Bean
	public ViewResolver viewResolver() { 
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
		viewResolver.setPrefix("/WEB-INF/views/"); 
		viewResolver.setSuffix(".jsp");
		return viewResolver; 
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) { 
		registry.addConverter(getCategoryConverter());
		registry.addConverter(getQuestionConverter());
		registry.addConverter(getAnswerConverter());
	}
	
	@Bean
	public CategoryConverter getCategoryConverter() { 
		return new CategoryConverter();
	}
	
	@Bean
	public QuestionConverter getQuestionConverter() { 
		return new QuestionConverter();
	}
	
	@Bean
	public AnswerConverter getAnswerConverter() { 
		return new AnswerConverter();
	}
}
