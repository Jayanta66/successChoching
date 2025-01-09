package success.coching.center.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import success.coching.center.beans.Job;
import success.coching.center.repository.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository repo;
	
	public List<Job> listAll() {
				return repo.findAll();
	}
	
	public List<Job> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	public void save(Job product) {
		repo.save(product);
	}
	
	public Job get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	

	
}
