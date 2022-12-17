package br.com.articuno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.articuno.model.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer>{
}
