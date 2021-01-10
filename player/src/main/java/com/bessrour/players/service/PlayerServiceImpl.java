package com.bessrour.players.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bessrour.players.entities.Categorie;
import com.bessrour.players.entities.Player;
import com.bessrour.players.repos.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	PlayerRepository PlayerRepository;
	
	
	@Override
	public Player savePlayer(Player p) {
	return PlayerRepository.save(p);
	}
	@Override
	public Player updatePlayer(Player p) {
	return PlayerRepository.save(p);
	}
	@Override
	public void deletePlayer(Player p) {
	PlayerRepository.delete(p);
	}
	 @Override
	public void deletePlayerById(Long id) {
	PlayerRepository.deleteById(id);
	}
	@Override
	public Player getPlayer(Long id) {
	return PlayerRepository.findById(id).get();
	}
	@Override
	public List<Player> getAllPlayers() {
	return PlayerRepository.findAll();
	}
	@Override
	public List<Player> findBynomPLayer(String nomPLayer) {
		return	PlayerRepository.findBynomPLayer(nomPLayer);		 
	}
	@Override
	public List<Player> findBynomPLayerContains(String nomPLayer) {
		
		return	PlayerRepository.findBynomPLayerContains(nomPLayer);
	}
	//@Override
	//public List<Player>findBynomPLayer(String nomPLayer, double scorePLayer) {
		
		//return	PlayerRepository.findBynomPLayerscore(nomPLayer,scorePLayer);
	//}
	@Override
	public List<Player> findByCategorieIdCat(Long idPLayer) {
		
		return PlayerRepository.findByCategorieIdCat(idPLayer);
	}
	@Override
	public List<Player> findByOrderBynomPLayerAsc() {
		
		return PlayerRepository.findByOrderBynomPLayerAsc();
	}
	@Override
	public List<Player> trierscorePLayer() {
		
		return PlayerRepository.trierscorePLayer();
	}
	@Override
	public Page<Player> getAllPLayerParPage(int page, int size) {
		
		return PlayerRepository.findAll(PageRequest.of(page, size));
	}
	@Override
	public List<Player> findByCategorie(Categorie categorie) {
		
		return PlayerRepository.findByCategorie(categorie);
	}
	@Override
	public List<Player> findBynomPLayer(String nomPLayer, double scorePLayer) {
		 //TODO Auto-generated method stub
		 return	PlayerRepository.findBynomPLayer(nomPLayer);
	}
}

