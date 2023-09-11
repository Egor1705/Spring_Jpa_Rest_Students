package pl.egor.RestSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.egor.RestSpring.dao.StudentGroupRepository;
import pl.egor.RestSpring.entity.StudentGroup;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

	private StudentGroupRepository studentGroupRepository;

	@Autowired
	public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository) {
		this.studentGroupRepository = studentGroupRepository;
	}

	@Override
	public List<StudentGroup> findAll() {
		// TODO Auto-generated method stub
		return studentGroupRepository.findAll();
	}

	//@Transactional
	@Override
	public StudentGroup save(StudentGroup studentGroup) {
		// TODO Auto-generated method stub
		return studentGroupRepository.save(studentGroup);
	}

	//@Transactional
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentGroupRepository.deleteById(id);
	}



	

}
