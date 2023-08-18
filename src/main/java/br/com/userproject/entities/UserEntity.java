package br.com.userproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity

public class UserEntity {
	
	@Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private int password;
	
	private String email;
}
