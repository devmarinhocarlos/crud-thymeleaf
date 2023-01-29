package com.devmarinhocarlos.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.devmarinhocarlos.thymeleaf.model.User;
import com.devmarinhocarlos.thymeleaf.services.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", userServiceImpl.getAllUsers());
		return "index";
	}

	@GetMapping("/addnew")
	public String addNewUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new-user";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userServiceImpl.save(user);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") Long id, Model model) {
		User user = userServiceImpl.getById(id);
		model.addAttribute("user", user);
		return "update";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteThroughId(@PathVariable(value = "id") Long id) {
		userServiceImpl.deleteViaId(id);
		return "redirect:/";
	}
}
