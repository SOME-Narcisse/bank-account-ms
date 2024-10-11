package net.n.some.customerservice;

import net.n.some.customerservice.config.GlobalConfig;
import net.n.some.customerservice.entities.Customer;
import net.n.some.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers =List.of(
                    Customer.builder()
                            .firstName("SOME")
                            .lastName("Narcisse")
                            .email("some.a.narcisse@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("ZIDA")
                            .lastName("Moussa")
                            .email("zida.moussa@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("OUEDRAPGO")
                            .lastName("Melissa")
                            .email("ouedraogo.melissa@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customers);
        };
    }

}
