package success.coching.center.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="studentid")
	private Long studentid;
	@Column(name="studentName")
	private	String StudentName; //job title
	@Column(name="class")
	private	String classes;
	@Column(name="location")
	private	String location;
	@Column(name="tutionType")
	private	String tutionType;
	@Column(name="fees")
	private	String fees;
	@Column(name="feesStatus")
	private	String feesStatus;
	@Column(name="month")
	private	String month;
	@Column(name="year")
	private	String year;

	public Student() {
	}

	

	
	
}
