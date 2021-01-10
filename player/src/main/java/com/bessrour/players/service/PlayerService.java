package com.bessrour.players.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bessrour.players.entities.Categorie;
import com.bessrour.players.entities.Player;

public interface PlayerService {

	Player savePlayer(Player p);
	Player updatePlayer(Player p);
	void deletePlayer(Player p);
	void deletePlayerById(Long id);
	Player getPlayer(Long id);
	List<Player> getAllPlayers();
	
	 
	 List<Player> findBynomPLayer(String nomPLayer);
	 
	 List<Player> findBynomPLayerContains(String nomPLayer);
	 
	 List<Player> findBynomPLayer(String nomPLayer, double scorePLayer);
	 
	 List<Player> findByCategorie (Categorie categorie);
	 
	 List<Player> findByCategorieIdCat(Long idPLayer);
	 
	 List<Player> findByOrderBynomPLayerAsc();
	 
	 List<Player> trierscorePLayer();
	 
	 Page<Player> getAllPLayerParPage(int page, int size) ;
}
