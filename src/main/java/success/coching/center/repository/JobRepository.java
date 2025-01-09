package success.coching.center.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import success.coching.center.beans.Student;


public interface JobRepository extends JpaRepository<Student, Long> {
		
	@Query("SELECT j FROM Job j WHERE CONCAT(j.applicationid, ' ',j.jobdesignation, ' ', j.department, ' ', j.salary, ' ', j.location,' ', j.noticepriod,' ', j.jobtype,' ', j.jobdescription) LIKE %?1%")
	public List<Student> search(String keyword);
	
//	Optional<Product> findById(long id);
	
}