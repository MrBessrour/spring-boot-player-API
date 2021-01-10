package com.bessrour.players.entities;

@org.springframework.data.rest.core.config.Projection(name = "nomPLayer", types = { Player.class })

public interface Projection {
	public String getNomPLayer(); 
}
