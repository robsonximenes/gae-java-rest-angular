package com.azulcomlimao.epidemicbonus.api.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.azulcomlimao.epidemicbonus.api.model.ObjectfyConfig;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		//registerClasses(Register.class);
		packages("com.azulcomlimao.epidemicbonus.api.rest");
		register(JacksonFeature.class);
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		ObjectfyConfig.configurar();
		
	}
}