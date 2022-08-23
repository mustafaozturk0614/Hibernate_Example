package com.bilgeadam.hibernateexample.controller;

import com.bilgeadam.hibernateexample.repository.UserDao;

public class UserController {

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
//		User user = new User("aylakaadam", "123", "Erkek");
//		userDao.update(user, 5);

//		userDao.save(user);
//		User user = userDao.findbyId(1);
//		userDao.delete(3);

		userDao.findAll();

	}

}
