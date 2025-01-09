package success.coching.center.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import success.coching.center.beans.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {
		
	@Query("SELECT s FROM Student s WHERE CONCAT(s.studentid, ' ',s.name, ' ', s.class, ' ', s.year, ' ', s.location,' ', s.tutionType,' ', s.fees,' ', s.feesStatus,' ',s.month) LIKE %?1%")
	public List<Student> search(String keyword);
	
//	Optional<Product> findById(long id);
	
}