package com.bilgeadam.hibernateexample.controller;

import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.repository.UserDao;
import com.bilgeadam.hibernateexample.repository.UserRepository;

public class UserController {

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		UserRepository userRepository = new UserRepository();

//		User user = new User("aylakaadam", "123", "Erkek");
//		User user2 = new User("aylakaadam2", "123", "Erkek");
//		userRepository.save(user);
//		userRepository.save(user2);
		User user3 = userRepository.findbyId(6);
		System.out.println(user3);
		System.out.println("-------User List------------");
		userRepository.findAll().forEach(System.out::println);

//		userDao.update(user, 5);

//		userDao.save(user);
//		User user = userDao.findbyId(1);
//		userDao.delete(3);

//		userDao.findAll();

	}

}
