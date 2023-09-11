package pl.egor.RestSpring.service;

import java.util.List;

import pl.egor.RestSpring.entity.StudentGroup;

public interface StudentGroupService {

	public List<StudentGroup> findAll();
	
	public StudentGroup save(StudentGroup studentGroup);
	
	public void deleteById(int id);
	
}
