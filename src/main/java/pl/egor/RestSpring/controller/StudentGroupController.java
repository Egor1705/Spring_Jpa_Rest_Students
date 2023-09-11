package pl.egor.RestSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.egor.RestSpring.entity.StudentGroup;
import pl.egor.RestSpring.service.StudentGroupService;
import pl.egor.RestSpring.service.StudentService;

@RestController
public class StudentGroupController {

	
	private StudentGroupService studentGroupService;
	
	//@Autowired
	public StudentGroupController(StudentGroupService studentGroupService) {
		this.studentGroupService = studentGroupService;
	}
	
	@GetMapping("/listGroups")
	public List<StudentGroup> findAll(){
		return studentGroupService.findAll();
	}
	
	@PostMapping("/save")
	public StudentGroup createStudentGroup(@RequestBody StudentGroup studentGroup) {
		studentGroup.setId(0);
		return studentGroupService.save(studentGroup);
	}
	
	@DeleteMapping("/listGroups/{id}")
	public void deleteStudentGroup(@PathVariable int id) {
		studentGroupService.deleteById(id);
	}
	@PutMapping("listGroups")
	public StudentGroup updateGroup(@RequestBody StudentGroup studentGroup) {
		return studentGroupService.save(studentGroup);
	}
	
}
