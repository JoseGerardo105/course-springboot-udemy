package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    Student findByLastName(String lastName);
    void updateStudent(Student student);
    int updateAllLastNameStudents();
    void deleteAStudent(Integer id);
    void deleteAllStudents();
}
