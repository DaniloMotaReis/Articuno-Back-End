package br.com.articuno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.articuno.model.Answer;
import br.com.articuno.model.Posts;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	@Query("select a from Answer a where a.post = ?1")
	List<Answer> findByPost(Posts post);
}
