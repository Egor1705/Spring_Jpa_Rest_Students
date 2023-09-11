package pl.egor.RestSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import pl.egor.RestSpring.entity.Student;
import pl.egor.RestSpring.exception.StudentErrorResponse;
import pl.egor.RestSpring.exception.StudentNotFoundException;
import pl.egor.RestSpring.service.StudentService;

@RestController
public class StudentController {

	// private List<Student> list;

	private StudentService studentService;

//	@PostConstruct
//	public void load() {
//
//		list=new ArrayList<>();
//		list.add(new Student("few","few","few"));
//		list.add(new Student("f12w","trtr","fregre"));
//		list.add(new Student("jiuew","ew",""));
//		
//	}
//    @Autowired
	

	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping("/list")
	public List<Student> getList() {

		return studentService.findAll();
	}

	@GetMapping("/list/{id}")
	public Student getStudent(@PathVariable Integer id) {
		Student st = studentService.findById(id);
		// System.out.println(studentService.findByName("dwe"));

		if (id == null) {
			throw new StudentNotFoundException("id not found " + id);
		}

		return st;

	}
	
	@GetMapping("/list/name/{firstName}")
	public Student findEntityByName(@PathVariable("firstName") String firstName) {
		return studentService.findByName(firstName);
	}

	@GetMapping("/list/order")
	public List<Student> getListName() {

		return studentService.orderByName();
	}

	@PostMapping("/list")
	public Student createStudent(@RequestBody Student st) {
		st.setId(0);
		Student dBStudent = studentService.save(st);
		return dBStudent;
	}

	// without @RequestBody by using this method I just get new JSON object with
	// null fields
	@PutMapping("/list")
	public Student updateStudent(@RequestBody Student st) {
		Student dBStudent = studentService.save(st);
		return dBStudent;

	}

	@DeleteMapping("/list/{studentID}")
	public void deleteStudent(@PathVariable int studentID) {
		Student st = studentService.findById(studentID);
		if (st == null) {
			throw new StudentNotFoundException("id not found " + studentID);
		}
		studentService.deleteByID(studentID);
	}

//	}
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//		
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		
//		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//	}

}
