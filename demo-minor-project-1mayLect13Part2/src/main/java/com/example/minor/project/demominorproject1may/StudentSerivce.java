package com.example.minor.project.demominorproject1may;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentSerivce {

	@Autowired
	StudentRepository studentRepo;

	public void createStudent(Student student) {

		studentRepo.save(student);
	}

	public List<Student> getAllStudents() {

		return studentRepo.findAll();
	}

	public void updateStudent(Student student) {
		// merge both create and update later
		studentRepo.save(student);

	}

	public Optional<Student> getStudentById(int studentId) {

		return studentRepo.findById(studentId);
	}

}
