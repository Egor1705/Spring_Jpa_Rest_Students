package pl.egor.RestSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.egor.RestSpring.entity.StudentGroup;

public interface StudentGroupRepository extends JpaRepository<StudentGroup,Integer> {

}
