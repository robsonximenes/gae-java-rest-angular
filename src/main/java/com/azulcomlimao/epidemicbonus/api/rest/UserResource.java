package com.azulcomlimao.epidemicbonus.api.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.azulcomlimao.epidemicbonus.api.dao.UserDAO;
import com.azulcomlimao.epidemicbonus.api.model.User;

@Produces(MediaType.APPLICATION_JSON)
@Path("/user") 
public class UserResource {

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") String id) {
    	UserDTO u = new UserDTO();
    	u.email = id;
    	u.password = id;
        return Response.ok(u).build();
    }
    
    @GET
    //TODO segurança, barrar o acesso para não admin
    public Response findAll() {   
    	List<User> list = new UserDAO().list();
    	return Response.ok(list).build();
    }
    
    
    public class UserDTO{
    	public String email;
    	public String password;
    }
    
}