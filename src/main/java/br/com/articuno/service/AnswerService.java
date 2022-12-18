package br.com.articuno.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.articuno.model.Answer;
import br.com.articuno.model.Posts;
import br.com.articuno.repository.AnswerRepository;

@Service
public class AnswerService {
	
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public Answer save(Answer answer) {
		return this.answerRepository.save(answer);
	}
	
	public List<Answer> findAllById(Posts post) {
		List<Answer> all = this.answerRepository.findByPost(post);
		return all;
	}
}
