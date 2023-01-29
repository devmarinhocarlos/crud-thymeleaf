package com.devmarinhocarlos.thymeleaf.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devmarinhocarlos.thymeleaf.model.User;
import com.devmarinhocarlos.thymeleaf.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User getById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		User user = null;
		if (optional.isPresent())
			user = optional.get();
		else
			throw new RuntimeException("User not found for id : " + id);
		return user;
	}

	@Override
	public void deleteViaId(Long id) {
		userRepository.deleteById(id);
	}
}
