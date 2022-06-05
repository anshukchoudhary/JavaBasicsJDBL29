package org.WalletUserService;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

	@NotBlank
	private String name;
	
	private String contact;

	@Email
	@NotBlank
	private String email;

	public User to() {

		return User.builder().email(this.email).contact(this.contact).name(this.name).build();
	}

}
