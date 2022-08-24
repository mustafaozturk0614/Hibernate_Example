package com.bilgeadam.hibernateexample.controller;

import com.bilgeadam.hibernateexample.repository.UserDao;
import com.bilgeadam.hibernateexample.repository.UserRepository;

public class UserController {

	public static void main(String[] args) throws InterruptedException {

		UserDao userDao = new UserDao();
		UserRepository userRepository = new UserRepository();

//		User user = new User("aylakaadam", "123", "Erkek");
//		User user2 = new User("aylakaadam2", "123", "Erkek");
//		userRepository.save(user);
//		userRepository.save(user2);
//		User user3 = new User("aylakmadam", "345", "Kadýn");
//		userRepository.update(user3, 8);
//		Thread.sleep(1000);
//		user3.setPassword("abc");
//		userRepository.update(user3, 6);

//		System.out.println(user3);
//		System.out.println("-------User List------------");
//		userRepository.findAll().forEach(System.out::println);

//		userDao.update(user, 5);

//		userDao.save(user);
//		User user = userDao.findbyId(1);
//		userDao.delete(3);

//		userDao.findAll();

		userRepository.delete(7);

	}

}
