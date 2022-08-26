package com.bilgeadam.hibernateexample.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bilgeadam.hibernateexample.entity.Address;
import com.bilgeadam.hibernateexample.entity.EAddressType;
import com.bilgeadam.hibernateexample.entity.EGender;
import com.bilgeadam.hibernateexample.entity.Name;
import com.bilgeadam.hibernateexample.entity.User;
import com.bilgeadam.hibernateexample.entity.UserDetail;
import com.bilgeadam.hibernateexample.repository.UserRepository;

public class UserController2 {

	public static void main(String[] args) {

		UserRepository userRepository = new UserRepository();
		Address address1 = new Address("Fatih cad", "T�rkiye", "Ankara");
		Address address2 = new Address("Bar�� Cad", "T�rkiye", "Ankara");
		Map<EAddressType, Address> map = new HashMap();
		map.put(EAddressType.HOME, address1);
		map.put(EAddressType.BUSINESS, address2);
		List<String> interest = new ArrayList();
		interest.add("Tiyatro");
		interest.add("M�zik");
		UserDetail userDetail = new UserDetail(EGender.MAN, new Name("Mehmet", "Aras", "G�rel"), map, interest, 20);
		User user = new User("arass", "123", userDetail);
		userRepository.save(user);
		userRepository.findAll().forEach(System.out::println);
		;

	}

}
