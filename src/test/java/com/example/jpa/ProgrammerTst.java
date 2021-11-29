package com.example.jpa;

import com.example.jpa.assocations.entity.Programmer;
import com.example.jpa.assocations.entity.Project;
import com.example.jpa.repo.ProgrammerRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;

@SpringBootTest
public class ProgrammerTst {
    private final ProgrammerRepo programmerRepo;

    @Autowired
    public ProgrammerTst(ProgrammerRepo programmerRepo) {
        this.programmerRepo = programmerRepo;
    }

    @Test
    public void createProgammer()
    {
        Programmer programmer = new Programmer();
        programmer.setName("Anwar");
        programmer.setSalary(62000);
        HashSet<Project> projects = new HashSet();
        Project project1 = new Project();
        project1.setName("Java");
        Project project2 = new Project();
        project2.setName("Spring boot");
        projects.add(project1);
        projects.add(project2);
        programmer.setProjects(projects);


        System.out.println("Saving data to database..");



        programmerRepo.save(programmer);
    }


    @Test
    //@Transactional
    public void getProgammer()
    {
        Optional<Programmer> byId = programmerRepo.findById(1);
        byId.ifPresent(progammer->{
            System.out.println(progammer.getName());
            progammer.getProjects().forEach(project -> System.out.println(project.getName()));


        });
    }



}
