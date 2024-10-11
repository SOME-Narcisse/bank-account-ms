package net.n.some.customerservice.web;

import lombok.AllArgsConstructor;
import net.n.some.customerservice.entities.Customer;
import net.n.some.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping("/customers")
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/customers")
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

}
