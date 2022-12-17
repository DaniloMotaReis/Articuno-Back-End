package br.com.articuno.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.articuno.model.User;
import br.com.articuno.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	public UserService(UserRepository useRepository, PasswordEncoder encoder) {
		this.userRepository = useRepository;
		this.encoder = encoder;
	}
	
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		try {
			return this.userRepository.save(user);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Optional<User>findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	public Boolean validaSenha(String email, String password) {
		Optional<User> user = findByEmail(email);
		return encoder.matches(password, user.get().getPassword());
	}
}