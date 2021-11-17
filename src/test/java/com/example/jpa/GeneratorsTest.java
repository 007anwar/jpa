package com.example.jpa;

import com.example.jpa.entity.Employee;
import com.example.jpa.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        employee.setName("Izan");
        Employee save = employeeRepo.save(employee);
        System.out.println("Employee created : "+save);
    }


}
