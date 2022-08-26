package com.bilgeadam.hibernateexample.controller;

import java.util.Date;

import com.bilgeadam.hibernateexample.repository.PostRepository;

public class PostController {

	public static void main(String[] args) {

		PostRepository postRepository = new PostRepository();

		Date date = new Date();
//		Address address1 = new Address("Fatih cad", "Türkiye", "Ankara");
//		Address address2 = new Address("Barýþ Cad", "Türkiye", "Ankara");
//		Map<EAddressType, Address> map = new HashMap();
//		map.put(EAddressType.HOME, address1);
//		map.put(EAddressType.BUSINESS, address2);
//		List<String> interest = new ArrayList();
//		interest.add("Tiyatro");
//		interest.add("Müzik");
//		UserDetail userDetail = new UserDetail(EGender.MAN, new Name("Mehmet", "Aras", "Gürel"), map, interest, 10);
//		User user = new User("arasssss", "123", userDetail);
//		postRepository.save(new Post("içerik 1 ", date, user));

		postRepository.findAll().forEach(System.out::println);
		;

	}
}
