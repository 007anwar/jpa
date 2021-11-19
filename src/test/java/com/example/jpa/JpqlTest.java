package com.example.jpa;

import com.example.jpa.entity.Student;
import com.example.jpa.repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class JpqlTest {
    private final StudentRepo studentRepo;

    @Autowired
    public JpqlTest(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
@Test
    void create()

    {
        for (int i=0;i<30;i++)
        createStudent();
    }

    @Test
    public void createStudent()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString1 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        Student student1 = new Student();
        student1.setFirstName(generatedString1);
        String generatedString2 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        student1.setLastName(generatedString2);
        student1.setScore(String.valueOf(new Random().nextInt(100)));
        studentRepo.save(student1);

    }

    @Test
    void findAll()
    {
        List<Student> allStudent = studentRepo.findAllStudent(PageRequest.of(0,3, Sort.by(Sort.Direction.DESC,"lastName")));
        allStudent.forEach(student -> System.out.println(student));
    }

    @Test
    void findAllFandLNames()
    {
        List<Object[]> specificColumn = studentRepo.findSpecificColumn(PageRequest.of(0,10,Sort.by(Sort.Direction.ASC,"firstName")));
        specificColumn.forEach(stud ->{
          Object[] obj=stud;
            System.out.print(obj[0]+" ");
            System.out.println(obj[1]);

        });
    }

    @Test
    void findAllBYfname()
    {
        List<Student> allStudent = studentRepo.findAllByFirstName("Bill");
        allStudent.forEach(student -> System.out.println(student));
    }


    @Test
    void findAllLnameBYfname()
    {
        List<String> bill = studentRepo.findLatNames("Bill");
        bill.forEach(student -> System.out.println(student));
    }

    @Test
    void findAllinScore()
    {
        List<Student> byScoreBetween = studentRepo.findByScoreBetween("73", "78");
        byScoreBetween.forEach(student -> System.out.println(student));
    }
    @Test
    void findFirstNameeBYScore()
    {
        List<String> byScoreBetween = studentRepo.findFirstNameByScoreBetween("73", "78");
        byScoreBetween.forEach(student -> System.out.println("RESULT>>>>>>>>>>>>>>>>>>>"+student));
    }

    @Test
    @Transactional()
    @Rollback(value = false)//tests roll backs delete
    void deleteByFirstName()
    {
        studentRepo.deleteByFirstName("bill");
    }

    @Test
    @Transactional
    @Modifying
    void updateStudentByid()
    {
  studentRepo.updateFirstNameById("elon", 3l);

    }

    @Test
    void findAllStud()
    {
        List<Student> allStudentNative = studentRepo.findAllStudentNative();
       allStudentNative.forEach(stud-> System.out.println(stud));
    }

    @Test
    void findAllStudByfname()
    {
        List<Student> allStudentNative = studentRepo.findAllStudentByFirstNameNative("qrhrlclpks");
        allStudentNative.forEach(stud-> System.out.println(stud));
    }

}
