package com.skolarajak.servisi;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.skolarajak.model.Roles;
import com.skolarajak.model.User;

public class AdministracijaKorisnika {
	private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
	
	public AdministracijaKorisnika() {
		init();
	}

	private void init() {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("password0");
		admin.setRole(Roles.ADMIN);
		
		users.put(admin.getUsername(), admin);
		
		User user = new User();
		user.setUsername("user");
		user.setPassword("password1");
		user.setRole(Roles.USER);
		
		users.put(user.getUsername(), user);
		
	}
	
	public boolean isRegistered(String username) {
		return (users.get(username) != null);
	}
	
	public boolean isAuthenticated(String username, String password) {
		User user = users.get(username);
		return ((user != null) && user.getPassword().equals(password));
	}
	
	public User getUser(String username) {
		return users.get(username);
	}
}
