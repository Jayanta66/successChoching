package success.coching.center.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import success.coching.center.beans.User;


public interface UserRepository extends JpaRepository<User, Integer> {

//	User findByusername(String username);
	 
	User findByemail(String email);



}
