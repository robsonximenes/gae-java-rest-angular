package com.azulcomlimao.epidemicbonus.api.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;

public class ObjectifyGenericDao<T>{

	protected Class<T> clazz;

	
	protected ObjectifyGenericDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	public Key<T> save(T entity){
		return ofy().save().entity(entity).now();
	}

	public void delete(T entity) {
		ofy().delete().entity(entity);
	}

	public void delete(Key<T> entityKey) {
		ofy().delete().key(entityKey);
	}

	public void deleteAll(Iterable<T> entities) {
		ofy().delete().entities(entities);
	}

	@SuppressWarnings("unchecked")
	public T load(Long id) throws EntityNotFoundException {
		return (T) ofy().load().key(Key.create(this.clazz, id));
	}
	
	public List<T> list(){
		return ofy().load().type(this.clazz).list();
	}

	
}