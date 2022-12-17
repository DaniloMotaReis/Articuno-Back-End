package br.com.articuno.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.articuno.model.Posts;
import br.com.articuno.model.Reactions;
import br.com.articuno.model.User;
import br.com.articuno.service.PostsService;
import br.com.articuno.service.ReactionsService;
import br.com.articuno.service.UserService;

@RestController
@RequestMapping("/reactions")
public class ReactionsController {
	
	@Autowired
	private ReactionsService reactionsService;
	@Autowired
	private UserService userService;
	@Autowired
	private PostsService postsService;
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> edit(@PathVariable(name = "id") Integer id, @RequestBody Map<String, String> react) {
		User user = userService.findByEmail(react.get("email")).get();
		Posts post = postsService.findById(id).get();
		if(reactionsService.findByPostAndUser(post, user).isPresent()) {
			Optional<Reactions> pesq = reactionsService.findByPostAndUser(post, user);
			pesq.get().setTpReaction(Boolean.parseBoolean(react.get("tpReaction")));
			reactionsService.save(pesq.get());
			return ResponseEntity.ok(HttpStatus.OK);
		} else {
			Reactions created = new Reactions();
			created.setPost(post);
			created.setUser(user);
			created.setTpReaction(Boolean.parseBoolean(react.get("tpReaction")));
			reactionsService.save(created);
			return ResponseEntity.ok(HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/status/{id}")
	public Boolean statusReaction(@PathVariable(name = "id") Integer id, @RequestBody Map<String, String> email){
		User user = userService.findByEmail(email.get("email")).get();
		Posts post = postsService.findById(id).get();
		Optional<Reactions> pesq = reactionsService.findByPostAndUser(post, user);
		try {
			return pesq.get().getTpReaction();
		} catch (Exception e) {
			return null;
		} 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Integer>> listReactions(@PathVariable(name = "id") Integer id) {
		int like = 0, deslike = 0;
		Posts post = postsService.findById(id).get();
		List<Reactions> re = reactionsService.findAllById(post);
		Map<String, Integer> cont = new HashMap<>();
		for(int i = 0; i < re.size(); i++) {
			if(re.get(i).getTpReaction() == true) {
				like++;
			} else {
				deslike++;
			}
		}
		cont.put("like", like);
		cont.put("deslike", deslike);
		return ResponseEntity.ok(cont);
	}
}
