package com.swapnil.springjpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swapnil.springjpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Query Creation Using JPA Methods.
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // JPA Query @Annotation, This go by the class and not the table name
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1") // here `?1` respresent the first parameter.
    Student getStudentByEmailAddress(String emailID);


    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailID);

    // Native Queries
    @Query(value="SELECT * FROM tbl_student s WHERE s.emailId = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailID);


    @Query(value="SELECT * FROM tbl_student s WHERE s.emailId = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailID") String emailID);


    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery=true)
    int updateStudentNameByEmailId(String firstName, String emailId);

}
