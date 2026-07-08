package com.scms.service;

import com.scms.model.User;

import com.scms.dao.UserDAO;
import com.scms.util.PasswordUtil;
import com.scms.util.ValidationUtil;

public class UserService {

	private UserDAO userDAO = new UserDAO();

	public boolean register(User user) {

		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}

		if (ValidationUtil.isNullOrEmpty(user.getUsername())) {
			throw new IllegalArgumentException("Username is required");
		}

		if (!ValidationUtil.isValidEmail(user.getEmail())) {
			throw new IllegalArgumentException("Invalid email address");
		}

		if (ValidationUtil.isNullOrEmpty(user.getPassword())) {
			throw new IllegalArgumentException("Password is required");
		}

		if (userDAO.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("Username already exists");
		}

		if (userDAO.existsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("Email already exists");
		}

		String hashedPassword = PasswordUtil.hashPassword(user.getPassword());

		user.setPassword(hashedPassword);

		return userDAO.save(user);
	}

	public User authenticate(String username, String password) {

		if (ValidationUtil.isNullOrEmpty(username)) {
			throw new IllegalArgumentException("Username is required");
		}

		if (ValidationUtil.isNullOrEmpty(password)) {
			throw new IllegalArgumentException("Password is required");
		}

		User user = userDAO.findByUsername(username);

		if (user == null) {
			throw new IllegalArgumentException("Invalid Username");
		}

		boolean matched = PasswordUtil.verifyPassword(password, user.getPassword());

		if (!matched) {
			throw new IllegalArgumentException("Invalid Password");
		}

		return user;

	}

}