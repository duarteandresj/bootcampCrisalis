package ar.com.finneg.crisalis.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import ar.com.finneg.crisalis.exception.custom.EmptyElementException;
import ar.com.finneg.crisalis.exception.custom.InvalidStringException;
import ar.com.finneg.crisalis.exception.custom.NotCreatedException;
import ar.com.finneg.crisalis.exception.custom.UnauthorizedException;
import ar.com.finneg.crisalis.model.User;
import ar.com.finneg.crisalis.model.dto.UserDTO;
import ar.com.finneg.crisalis.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User saveUser(UserDTO userDTO) {
		if (checkUserDTO(userDTO, Boolean.FALSE)) {
			return this.userRepository.save(new User(userDTO));
		}
		throw new NotCreatedException("Error in save new User");
	}

	public UserDTO loginUserWithCredentials(String username, String password) {
		if (this.checkUserDTO(UserDTO.builder().username(username).password(password).build(), Boolean.TRUE)

		) {
			return this.userRepository.findByUsernameAndPassword(username, password)
					.orElseThrow(() -> new UnauthorizedException("invalid credentials")).toUserDTO();

		}
		throw new UnauthorizedException("invalid credentials");

	}
	public List<UserDTO> getListAllUsersToBD(){
		return	this.userRepository
							.findAll()
							.stream()
							.map(User::toUserDTO)
							.collect(Collectors.toList());
		
	}
	
	

	private Boolean checkUserDTO(UserDTO userDTO, Boolean isLogin) {
		if (!isLogin) {
			if (StringUtils.isEmpty(userDTO.getName())) {
				throw new EmptyElementException("Name is empty");
			}
			if (!isOnlyLetters(userDTO.getName())) {
				throw new InvalidStringException("Name invalid");
			}

			if (StringUtils.isEmpty(userDTO.getLastname())) {
				throw new EmptyElementException("Lastname is empty");
			}
			if (!isOnlyLetters(userDTO.getName())) {
				throw new InvalidStringException("Lastname invalid");
			}
		}
		if (StringUtils.isEmpty(userDTO.getUsername())) {
			throw new EmptyElementException("Username is empty");
		}
		if (StringUtils.isEmpty(userDTO.getPassword())) {
			throw new EmptyElementException("Password is empty");
		}
		return Boolean.TRUE;
	}

	// Expresiones regulares
	private Boolean isOnlyLetters(String input) {
		Pattern regexOnlyLetters = Pattern.compile("^[A-z]{1,25}\\S$");
		Matcher mat = regexOnlyLetters.matcher(input);

		return (Boolean) mat.find();
	}
}
