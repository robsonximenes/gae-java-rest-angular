package com.azulcomlimao.epidemicbonus.api.rest;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.azulcomlimao.epidemicbonus.api.dao.UserDAO;
import com.azulcomlimao.epidemicbonus.api.model.User;
import com.googlecode.objectify.Key;


@Path("/register") 
public class RegisterResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(final RegisterDTO dto, @Context UriInfo uriInfo) {
    	UserDAO dao = new UserDAO();
    	
    	if(dto.email==null ||
    			dto.name==null ||
    			dto.password==null){
    		return Response.status(Status.PRECONDITION_FAILED).entity("Fields Requireds: E-mail, Password, Name").build();
    	}
    	
    	if(dao.load(dto.email)!=null)
    		return Response.status(Status.PRECONDITION_FAILED).entity("This e-mail is already in use").build();
  	
    	
    	User u = new User(dto.email, dto.password, dto.name);
    	u.date = new Date();
    	Key<User> key = dao.save(u);
    	URI baseUri = uriInfo.getRequestUri().resolve("/"+key.getString());
        return Response.created(baseUri).entity("{\"id\":\""+key.getString()+"\"}").build();
    }
    
    
    public static class RegisterDTO{
    	public String email;
    	public String name;
    	public String password;
    }
    
}