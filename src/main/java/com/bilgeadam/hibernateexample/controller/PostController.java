package com.bilgeadam.hibernateexample.controller;

import java.util.Date;

import com.bilgeadam.hibernateexample.entity.Post;
import com.bilgeadam.hibernateexample.repository.PostRepository;

public class PostController {

	public static void main(String[] args) {

		PostRepository postRepository = new PostRepository();
		Date date = new Date();
		postRepository.save(new Post("i�erik 1 ", date));

	}
}
