package com.azulcomlimao.epidemicbonus.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.azulcomlimao.epidemicbonus.api.dao.UserDAO;
import com.azulcomlimao.epidemicbonus.api.model.User;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/login") 
public class LoginResource {

    @POST
    public Response login(final LoginDTO dto) {
    	UserDAO dao = new UserDAO();
    	
    	if(dto.email==null ||
    			dto.password==null){
    		return Response.status(Status.PRECONDITION_FAILED).entity("Fields Requireds: E-mail, Password").build();
    	}
    	    	
    	User u = dao.load(dto.email);
    	if(u.password.equals(dto.password))    	
    		return Response.ok().entity(new UserDTO(u)).build();
    	else{
    		return Response.ok().build();
    	}
    }
        
    public static class LoginDTO{
    	public String email;
    	public String password;
    }
    
    public class UserDTO{
    	public String email;    	
    	public UserDTO(User model) {
    		this.email = model.email;
		}    	
    }    
}