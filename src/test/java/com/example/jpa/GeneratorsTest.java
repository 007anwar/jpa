package com.example.jpa;

import com.example.jpa.entity.Employee;
import com.example.jpa.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.Random;

@SpringBootTest
public class GeneratorsTest {
    private  EmployeeRepo employeeRepo;

    @Autowired
    public GeneratorsTest(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Test
    public void createEmployee()
    {
        Employee employee = new Employee();
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        employee.setName(generatedString);
        Employee save = employeeRepo.save(employee);
        System.out.println("Employee created : "+save);
    }


}
