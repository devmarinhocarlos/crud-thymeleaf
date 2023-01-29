package com.devmarinhocarlos.thymeleaf.services;

import java.util.List;
import com.devmarinhocarlos.thymeleaf.model.User;

public interface UserService {
	List<User> getAllUsers();

	void save(User user);

	User getById(Long id);

	void deleteViaId(Long id);
}
