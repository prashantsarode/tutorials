package com.sampleprograms.spring.boot.rest.webservices.user.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
