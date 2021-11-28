package com.example.jpa;

import com.example.jpa.assocations.entity.Customer;
import com.example.jpa.assocations.entity.PhoneNumber;
import com.example.jpa.assocations.repo.CustomerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class AssociationsTest {
    private final CustomerRepo customerRepo;

    @Autowired
    public AssociationsTest(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Test
    public void createCust()
    {
        Customer customer = new Customer();
        customer.setName("Anwar");
        PhoneNumber p1 = new PhoneNumber();
        p1.setNumber("78989789");
        p1.setType("home");
        PhoneNumber p2 = new PhoneNumber();
        p2.setNumber("789798");
        p2.setType("pers");
        p1.setCustomer(customer);
        p2.setCustomer(customer);
        Set<PhoneNumber> pno = new HashSet<>();
        pno.add(p1);
        pno.add(p2);

        customer.setNumbers(pno);

        customerRepo.save(customer);


    }

//for lazy loading to work method must be marked with @Transactional

    @Test
    @Transactional
    public void testLoadCust()
    {
        Optional<Customer> byId = customerRepo.findById(2L);
        byId.ifPresent(cust-> {
            System.out.println("Name : " + cust.getName());
            cust.getNumbers().forEach(num-> System.out.println("Numbers : "+num.getNumber()));
        });
    }

    @Test
    public void testDelete()
    {
        customerRepo.deleteById(2L);
    }
}
