package com.azulcomlimao.epidemicbonus.api.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;

import com.azulcomlimao.epidemicbonus.api.model.User;
import com.googlecode.objectify.Key;

public class UserDAO extends ObjectifyGenericDao<User> {

	public UserDAO() {
		super(User.class);
	}
	
	@Override
	public Key<User> save(User entity) {
		entity.lastUpdate = new Date();
		return super.save(entity);
	}

	public User load(String email) {
		return  ofy().load().key(Key.create(User.class, email)).now();
	}

}
