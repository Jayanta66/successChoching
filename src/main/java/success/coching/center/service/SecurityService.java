package success.coching.center.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import success.coching.center.beans.User;

public interface SecurityService {

	boolean longin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	
	public User save(User user);
}
