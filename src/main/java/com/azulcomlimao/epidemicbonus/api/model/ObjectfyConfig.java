package com.azulcomlimao.epidemicbonus.api.model;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

public class ObjectfyConfig {

	public static void configurar() {
		long time = new Date().getTime();
		System.out.println("Iniciando datastore");
		ObjectifyService.register(User.class);
		System.out.println("Models registrados - "+(new Date().getTime()-time)+" ms");
		cargaDeUsers();		
	}

	public static void cargaDeUsers() {
		User u = new User("robsonximenes@gmail.com","1234", "Robson Ximenes");		
		ObjectifyService.begin();
		Key<User> key = Key.create(u)  ;
		User old = ofy().load().key(key).now();
		if(old==null){
			System.out.println("Salvando usuário inicial");
			ofy().save().entity(u).now();
		}
	}

}
