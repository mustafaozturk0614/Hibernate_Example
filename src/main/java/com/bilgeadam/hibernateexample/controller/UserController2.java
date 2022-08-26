package com.bilgeadam.hibernateexample.controller;

import com.bilgeadam.hibernateexample.repository.UserDetailRepository;
import com.bilgeadam.hibernateexample.repository.UserRepository;

public class UserController2 {

	public static void main(String[] args) {

		UserRepository userRepository = new UserRepository();
		UserDetailRepository userDetailRepository = new UserDetailRepository();
//		Address address1 = new Address("Fatih cad", "Türkiye", "Ankara");
//		Address address2 = new Address("Barýþ Cad", "Türkiye", "Ankara");
//		Map<EAddressType, Address> map = new HashMap();
//		map.put(EAddressType.HOME, address1);
//		map.put(EAddressType.BUSINESS, address2);
//		List<String> interest = new ArrayList();
//		interest.add("Tiyatro");
//		interest.add("Müzik");
//		UserDetail userDetail = new UserDetail(EGender.MAN, new Name("Mert", "", "Gürel"), map, interest, 20);
//		User user = new User("mert4", "123", userDetail);
//		Post post1 = new Post("xxx", new Date());
//		Post post2 = new Post("yyy", new Date());
//		List<Post> posts = new ArrayList<>();
//		posts.add(post2);
//		posts.add(post1);
//		post1.setUser(user);
//		post2.setUser(user);
//		user.setPosts(posts);
//
////		user.getPosts().add(post1);
////		user.getPosts().add(post2);
//
//		userRepository.save(user);
		userRepository.findAll().forEach(System.out::println);
//		userDetailRepository.findAll().forEach(System.out::println);

	}

}
