package success.coching.center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import success.coching.center.beans.Student;
import success.coching.center.repository.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository repo;
	
	public List<Student> listAll() {
				return repo.findAll();
	}
	
	public List<Student> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Student product) {
		repo.save(product);
	}
	
	public Student get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	

	
}
