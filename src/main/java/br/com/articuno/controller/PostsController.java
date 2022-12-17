package br.com.articuno.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.articuno.model.Posts;
import br.com.articuno.service.PostsService;
import br.com.articuno.service.UserService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Posts> create(@RequestBody Map<String, String> post) {
		Posts created = new Posts();
		created.setPost(post.get("post"));
		created.setUser(userService.findByEmail(post.get("email")).get());
		return ResponseEntity.status(HttpStatus.CREATED).body(postsService.save(created));
	}
	
	@GetMapping
	public ResponseEntity<List<Posts>> findAll() {
		List<Posts> list = postsService.findAll();
		return ResponseEntity.ok(list);
	}

}
