package pl.egor.RestSpring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import pl.egor.RestSpring.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(Integer id);
	
	Student save(Student student);
	
	void deleteByID(int studentID);
	
	
//	List<Student> findByName(String firstName);
	
	List<Student> orderByName();
	
	Student findByName(String firstName);

}
