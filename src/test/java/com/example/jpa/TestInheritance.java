package com.example.jpa;

import com.example.jpa.entity.*;
import com.example.jpa.repo.EmpRepo;
import com.example.jpa.repo.PaymentPerClassRepo;
import com.example.jpa.repo.PaymentPerSubClassRepo;
import com.example.jpa.repo.PaymentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestInheritance {
    private final EmpRepo empRepo;
    private final PaymentRepo payment;
    private final PaymentPerClassRepo perClassRepo;
    private final PaymentPerSubClassRepo paymentPerSubClass;
@Autowired
    public TestInheritance(EmpRepo empRepo, PaymentRepo payment, PaymentPerClassRepo perClassRepo, PaymentPerSubClassRepo paymentPerSubClass) {
    this.empRepo = empRepo;
    this.payment = payment;
        this.perClassRepo = perClassRepo;
    this.paymentPerSubClass = paymentPerSubClass;
}

    @Test
    public void testCreate()
    {
        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(100.00);
        creditCard.setCardnumber("1234567");
        creditCard.setId(1);
        payment.save(creditCard);

    }
    @Test
    public void testCreateCheck()
    {
        Check check = new Check();
        check.setAmount(100.00);
        check.setChecknumber("1234567");
        check.setId(2);
        payment.save(check);

    }

    @Test
    public void testCreateCheckPerClass()
    {
        CheckPerClass check = new CheckPerClass();
        check.setAmount(100.00);
        check.setChecknumber("1234567");
        check.setId(2);
        perClassRepo.save(check);

    }

    @Test
    public void testCreateCheckPerSubClass()
    {
        CheckPerSubClass check = new CheckPerSubClass();
        check.setAmount(100.00);
        check.setChecknumber("1234567");
        check.setId(2);
        paymentPerSubClass.save(check);
    }

    @Test
    public void testEmp()
    {
        Address address = new Address();
        address.setCity("Wai");
        address.setState("Satara");
        address.setCountry("India");
        address.setZipcode("412803");
        Emp emp = new Emp();
        emp.setAddress(address);
        emp.setName("Anwar");
        emp.setId(123);
        empRepo.save(emp);

    }
}
