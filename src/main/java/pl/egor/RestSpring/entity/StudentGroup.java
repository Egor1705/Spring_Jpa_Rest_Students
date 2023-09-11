package pl.egor.RestSpring.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "db_Student_Group")
public class StudentGroup {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "group_number")
	private int groupNumber;

	@OneToMany(mappedBy="studentGroup")
	private List<Student> students;
	
	public StudentGroup() {
	
	}


//	public StudentGroup(String groupName, int groupNumber, List<Student> students) {
//		
//		this.groupName = groupName;
//		this.groupNumber = groupNumber;
//		this.students = students;
//	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public int getGroupNumber() {
		return groupNumber;
	}


	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	
	
	
}
