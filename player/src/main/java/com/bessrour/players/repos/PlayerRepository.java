package com.bessrour.players.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bessrour.players.entities.Categorie;
import com.bessrour.players.entities.Player;

@RepositoryRestResource(path = "rest")
public interface PlayerRepository extends JpaRepository<Player,Long>{
	
	
		List<Player> findBynomPLayer(String nomPLayer);
	
		List<Player> findBynomPLayerContains(String nomPLayer);
		
		
		//@Query("select v from player v where v.nomplayer like %?1 and v.scoreplayer > ?2") 
		//List<Player> findBynomPLayerscore(String nomPLayer, Double scorePLayer);

		@Query("select v from player v where v.categorie = ?1") 
		List<Player> findByCategorie (Categorie categorie);
		
		List<Player> findByCategorieIdCat(Long id);
		List<Player> findByOrderBynomPLayerAsc();
		
		@Query("select v from player v order by v.nomplayer ASC, v.scoreplayer DESC")
		List<Player> trierscorePLayer ();
}
