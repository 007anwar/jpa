package com.example.jpa;

import com.example.jpa.entity.License;
import com.example.jpa.entity.Person;
import com.example.jpa.repo.LicenseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestOneToOne {
    private final LicenseRepo licenseRepo;

    @Autowired
    public TestOneToOne(LicenseRepo licenseRepo) {
        this.licenseRepo = licenseRepo;
    }

    @Test
    public void create()
    {
        License license = new License();
        license.setType("CAR");
        license.setValidFrom(new Date());
        license.setValidFrom(new Date());
        Person person = new Person();
        person.setAge(23);
        person.setFirstName("fsdhjd");
        person.setLastName("jdsjk");
        license.setPerson(person);
        licenseRepo.save(license);
    }
}
