package br.com.articuno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.articuno.model.Posts;
import br.com.articuno.model.Reactions;
import br.com.articuno.model.User;


@Repository
public interface ReactionsRepository extends JpaRepository<Reactions, Integer>{
	@Query("select r from Reactions r where r.post = ?1 and r.user = ?2")
	Optional<Reactions> findByPostAndUser(Posts post, User user);
	
	@Query("select r from Reactions r where r.post = ?1")
	List<Reactions> findByPost(Posts post);
}
