package com.azulcomlimao.epidemicbonus.api.model;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity @Cache
public class User {
	
	@Id
	public String email;
	public String password;
	public String name;
	public Date date;
	public Date lastUpdate;
	
	public User() {
	}
	
	public User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name= name;
	}


	public static Key<User> key(long id) {
		return Key.create(User.class, id);
	}
	

}
