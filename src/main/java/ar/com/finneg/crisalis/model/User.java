package ar.com.finneg.crisalis.model;

import javax.persistence.*;


import ar.com.finneg.crisalis.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="nombre")
	private String name;
	@Column(name="lastname")
	private String lastname;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	public User(UserDTO userDTO) {
		this.name=userDTO.getName();
		this.lastname=userDTO.getLastname();
		this.username=userDTO.getUsername();
		this.password=userDTO.getPassword();
	}
	
	public UserDTO toUserDTO() { 
		return  UserDTO
						.builder()
						.name(this.name)
						.lastname(this.lastname)
						.username(this.username)
						.password(this.password)
						.build();
	}
}
