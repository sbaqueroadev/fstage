package co.com.sbaqueroa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@EnableScheduling
@ComponentScan
public class Main extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		/* ApplicationContext ctx = new ClassPathXmlApplicationContext(
        "co/com/sbaqueroa/xml/beansConfig.xml");*/



		/*List<Customer> list = new CustomerImpl().getAll();
    System.out.println("User count: " + list.size());
    System.out.println("User count: " + list.get(0).getAvailableProducts().size());*/


		/*Customer user = new Customer();
    user.setame("johndoe");
    user.setName("John Doe");
    customerImpl.insertUser(user);
    System.out.println("User inserted!");

    list = customerImpl.findAllUsers();
    System.out.println("User count: " + list.size());*/

	}

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	/* @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
      return args -> {

          System.out.println("Let's inspect the beans provided by Spring Boot:");

          String[] beanNames = ctx.getBeanDefinitionNames();
          Arrays.sort(beanNames);
          for (String beanName : beanNames) {
              System.out.println(beanName);
          }

      };
  }*/

}