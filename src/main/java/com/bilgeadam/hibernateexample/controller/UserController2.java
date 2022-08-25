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
		Address address1 = new Address("Fatih cad", "Türkiye", "Ankara");
		Address address2 = new Address("Barýþ Cad", "Türkiye", "Ankara");
		Map<EAddressType, Address> map = new HashMap();
		map.put(EAddressType.HOME, address1);
		map.put(EAddressType.BUSINESS, address2);
		List<String> interest = new ArrayList();
		interest.add("Tiyatro");
		interest.add("Müzik");
		UserDetail userDetail = new UserDetail(EGender.MAN, new Name("Mustafa", null, "Öztürk"), map, interest, 10);
		User user = new User("musti", "123", userDetail);
		userRepository.save(user);

	}

}
