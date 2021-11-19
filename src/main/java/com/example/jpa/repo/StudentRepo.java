package com.example.jpa.repo;

import com.example.jpa.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer> {

    @Query(value = "select * from student where lname=:lname",nativeQuery = true)
    List<Student> findAllStudentByFirstNameNative(String lname);

    @Query(value = "select * from student",nativeQuery = true)
    List<Student> findAllStudentNative();

    @Query("from Student")
    List<Student> findAllStudent(Pageable pageable);

    @Query("select firstName,lastName from Student")
    List<Object[]> findSpecificColumn(Pageable pageable);


    List<Student> findAllByFirstName(String fname);


    @Query("select lastName from Student where firstName=:fname")
    List<String> findLatNames(@Param("fname") String fnamee);

    List<Student> findByScoreBetween(String s1,String s2);

    @Query("select firstName from Student where score>:min and score<:max")
    List<String> findFirstNameByScoreBetween(String min,String max);

    @Modifying
    void deleteByFirstName(String name);

    @Modifying
    @Query("update Student set firstName=:name where id=:id")
    void updateFirstNameById(String name,Long id);
}
