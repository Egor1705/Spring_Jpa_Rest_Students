package pl.egor.RestSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.egor.RestSpring.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("select s FROM Student s ORDER BY firstName")
	List<Student> orderByName();
	
	@Query("select s From Student s WHERE s.firstName=:firstName")
	Student findByName(@Param("firstName") String firstName);
	
}
