package br.com.articuno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.articuno.model.Posts;
import br.com.articuno.repository.PostsRepository;

@Service
public class PostsService {
	
	private final PostsRepository postsRepository;
	
	public PostsService(PostsRepository postsRepository) {
		this.postsRepository = postsRepository;
	}
	
	public Posts save(Posts posts) {
		try {
			return this.postsRepository.save(posts);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Posts> findAll() {
		return this.postsRepository.findAll();
	}
	
	public Optional<Posts> findById(int idReaction) {
		return this.postsRepository.findById(idReaction);
	}
}
