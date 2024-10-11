package net.n.some.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.n.some.accountservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("api/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomeById(@PathVariable Long id);
    @GetMapping("api/customers")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomer")
    List<Customer> findAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not vailable");
        customer.setLastName("Not vailable");
        customer.setEmail("Not vailable");
        return customer;
    }

    default List<Customer>getAllCustomer(Exception exception){
        return List.of();
    }
}
