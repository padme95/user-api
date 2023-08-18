package br.com.userproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.userproject.entities.UserEntity;
import br.com.userproject.repositories.UserRepository;
import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}
	
	public UserEntity getOne(int id) {
		return userRepository.findById(id).orElse( new UserEntity() );
	}
	
	public UserEntity save(UserEntity user) {
		return userRepository.save(user);
	}
	
	public UserEntity update(int id, UserEntity user) {
		Optional<UserEntity> optional = userRepository.findById(id);
		
		if (optional.isPresent()) {
			UserEntity userBD = optional.get();
			userBD.setEmail( user.getEmail() );
			userBD.setName( user.getName() );
			userBD.setPassword( user.getPassword() );
			
			return userRepository.save(userBD);
		}
		else {
			return new UserEntity();
		}
	}
	
	public void delete(int id) {
		userRepository.deleteById(id);
	}	
} 
