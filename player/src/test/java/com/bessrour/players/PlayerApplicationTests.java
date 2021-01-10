package com.bessrour.players;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bessrour.players.entities.Player;
import com.bessrour.players.repos.PlayerRepository;



@SpringBootTest
class PlayerApplicationTests {
	@Autowired
	private PlayerRepository playerRepository;
	@Test
	public void testCreatePlayer() {
		Player p1 = new Player("Ali",new Date(0),200.00);
		playerRepository.save(p1);
	}
	
	@Test
	public void testFindPlayer()
	{
		Player p = playerRepository.findById(451L).get();
		System.out.println(p);
	}
	@Test
	public void testUpdatePlayer()
	{
		Player p = playerRepository.findById(1L).get();
		p.setScorePLayer(1000.0);
		playerRepository.save(p);
	}
	@Test
	public void testDeletePlayer()
	{
		playerRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousPlayers()
	{
		List<Player> prods = playerRepository.findAll();
		for (Player p : prods)
		{
		System.out.println(p);
		}
	}

}
