package pl.egor.RestSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.egor.RestSpring.dao.StudentRepository;
import pl.egor.RestSpring.entity.Student;
import pl.egor.RestSpring.exception.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	public Student findById(Integer id) {
		Optional<Student> st = studentRepository.findById(id);
		Student student = null;
		if(st.isPresent()) {
			student = st.get();
		}
		else {
			throw new StudentNotFoundException("id not found "+id);
		}
		return student;
	}

	@Transactional
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Transactional
	@Override
	public void deleteByID(int studentID) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentID);
	}

	@Override
	public List<Student> orderByName() {
		// TODO Auto-generated method stub
		return studentRepository.orderByName();
	}

	@Override
	public Student findByName(String firstName) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(firstName);
	}
	



	



}
