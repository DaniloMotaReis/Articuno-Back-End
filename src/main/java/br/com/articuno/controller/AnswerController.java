package br.com.articuno.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.articuno.model.Answer;
import br.com.articuno.model.Posts;
import br.com.articuno.service.AnswerService;
import br.com.articuno.service.PostsService;
import br.com.articuno.service.UserService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	public ResponseEntity<Answer> create(@RequestBody Map<String, String> res){
		Answer answer = new Answer();
		answer.setAnswer(res.get("answer"));
		answer.setPost(postsService.findById(Integer.parseInt(res.get("idPost"))).get());
		answer.setUser(userService.findByEmail(res.get("email")).get());
		return ResponseEntity.status(HttpStatus.CREATED).body(answerService.save(answer));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Answer>> findAllByPost(@PathVariable(name = "id") Integer id){
		Posts post = postsService.findById(id).get();
		List<Answer> allAnswers = answerService.findAllById(post);
		return ResponseEntity.ok(allAnswers);
	}
}
