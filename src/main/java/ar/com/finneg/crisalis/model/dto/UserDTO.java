package ar.com.finneg.crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
	@JsonProperty("usuario")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("name")
	private String name;
	@JsonProperty("lastname")
	private String lastname;
}
