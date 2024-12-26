package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // Define field for entity manager
    EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        this.entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
//        Create QUERY
        TypedQuery<Student> query = this.entityManager.createQuery("FROM Student", Student.class);
//        Return QUERY results
        return query.getResultList();
    }

    @Override
    public Student findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList().get(0);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateAllLastNameStudents() {
        return entityManager.createQuery("UPDATE Student SET lastName='Alba'").executeUpdate();
    }

    @Override
    @Transactional
    public void deleteAStudent(Integer id) {
        Student student = this.findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAllStudents() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
