package br.com.articuno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.articuno.model.Posts;
import br.com.articuno.model.Reactions;
import br.com.articuno.model.User;
import br.com.articuno.repository.ReactionsRepository;

@Service
public class ReactionsService {
	
	private final ReactionsRepository reactionsRepository;
	
	public ReactionsService(ReactionsRepository reactionsRepository) {
		this.reactionsRepository = reactionsRepository;
	}
	
	public Reactions save(Reactions reactions) {
		return this.reactionsRepository.save(reactions);
	}
	
	public Optional<Reactions> findByPostAndUser(Posts post, User user) {
		return this.reactionsRepository.findByPostAndUser(post, user);
	}
	
	public List<Reactions> findAllById(Posts post) {
		try {
			List<Reactions> all = this.reactionsRepository.findByPost(post);
			return all;
		} catch (Exception e) {
			System.out.println("e.getMessage()");
			return null;
		}
	}
}