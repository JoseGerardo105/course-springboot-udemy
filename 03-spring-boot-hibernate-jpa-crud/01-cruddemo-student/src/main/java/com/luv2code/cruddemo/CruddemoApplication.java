package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			getAStudentById(studentDAO);
//			getAllStudents(studentDAO);
//			getAStudentByLastName(studentDAO);
//			updateAStudent(studentDAO);
//			updateStudentsLastName(studentDAO);
//			deleteAStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Maria", "Lopez", "Maria@gmail.com");
		Student student2 = new Student("Juan", "Gomez", "Juan@gmail.com");
		Student student3 = new Student("Fabian", "Suarez", "Fabian@gmail.com");

		System.out.println("Saving students");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// Display the saved student
		System.out.println("Students saved " + student1);
		System.out.println("Students saved " + student2);
		System.out.println("Students saved " + student3);
	}

	private void createStudent(StudentDAO studentDAO){
		// Create the student object
		Student student = new Student("Jose", "Gomez", "jose@gmail.com");

		// Save the student object
		System.out.println("Saving student");
		studentDAO.save(student);

		// Display the saved student
		System.out.println("Student saved " + student);
	}

	private void getAStudentById(StudentDAO studentDAO) {
		Integer id = 1;
		Student student = studentDAO.findById(id);
		System.out.println("Finded student: " + student);
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		System.out.println("Students list");
		students.forEach(System.out::println);
	}

	private void getAStudentByLastName(StudentDAO studentDAO) {
		String lastName = "Suarez";
		Student student = studentDAO.findByLastName(lastName);
		System.out.println("Student with lastName " + lastName + ": "+ student);
	}

	private void updateAStudent(StudentDAO studentDAO) {
		Integer idStudent = 1;
		Student student = studentDAO.findById(idStudent);
		System.out.println("Original student: " + student);

		student.setFirstName("Jorge");
		studentDAO.updateStudent(student);
		System.out.println("Updated student: " + student);
	}

	private void updateStudentsLastName(StudentDAO studentDAO) {
		System.out.println("Original students list");
		studentDAO.findAll().forEach(System.out::println);

		System.out.println("Updated students list");
		int totalUpdated = studentDAO.updateAllLastNameStudents();
		studentDAO.findAll().forEach(System.out::println);
	}

	private void deleteAStudent(StudentDAO studentDAO){
		Integer idDeletedStudent = 1;
		System.out.println("Deleting student with id: " + idDeletedStudent);
		studentDAO.deleteAStudent(idDeletedStudent);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students");
		studentDAO.deleteAllStudents();
	}
}
