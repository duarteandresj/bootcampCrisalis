package ar.com.finneg.crisalis.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.finneg.crisalis.model.User;
import ar.com.finneg.crisalis.model.dto.UserDTO;
import ar.com.finneg.crisalis.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public User saveUser(@RequestBody UserDTO userDTO) {
		return this.userService.saveUser(userDTO);
	}
	@GetMapping(value="Login",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserDTO loginUser(@RequestParam String username,@RequestParam String password) {
		return this.userService.loginUserWithCredentials(username, password);	
	}
	@GetMapping(value = "List",produces = MediaType.APPLICATION_JSON_VALUE)
		public List<UserDTO> getAllUser(){
		return this.userService.getListAllUsersToBD();
		
	}
	
	
}
