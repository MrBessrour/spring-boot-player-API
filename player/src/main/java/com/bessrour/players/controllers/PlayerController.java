package com.bessrour.players.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bessrour.players.entities.Player;
import com.bessrour.players.service.PlayerService ;

@Controller
public class PlayerController {
	@Autowired
	PlayerService PlayerService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createPlayer";
	}
	@RequestMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("Player") Player Player,
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws
	ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Player.setDateCreation(dateCreation);

	Player savePlayer = PlayerService.savePlayer(Player);
	String msg ="Player enregistré avec Id "+savePlayer.getIdPlayer();
	modelMap.addAttribute("msg", msg);
	return "createPlayer";
	}
	@RequestMapping("/ListePlayers")
	public String listePlayers(ModelMap modelMap)
	{
	List<Player> prods = PlayerService.getAllPlayers();
	modelMap.addAttribute("Players", prods);
	return "listePlayers";
	}
	@RequestMapping("/supprimerPlayer")
	public String supprimerPlayer(@RequestParam("id") Long id,
	 ModelMap modelMap)
	{
	PlayerService.deletePlayerById(id);
	List<Player> prods = PlayerService.getAllPlayers();
	modelMap.addAttribute("Players", prods);
	return "listePlayers";
	}
	
	@RequestMapping("/modifierPlayer")
	public String editerPlayer(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Player p= PlayerService.getPlayer(id);
	modelMap.addAttribute("Player", p);
	return "editerPlayer";
	}
	
	@RequestMapping("/updatePlayer")
	public String updatePlayer(@ModelAttribute("Player") Player Player,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Player.setDateCreation(dateCreation);

	 PlayerService.updatePlayer(Player);
	 List<Player> prods = PlayerService.getAllPlayers();
	 modelMap.addAttribute("Players", prods);
	 return "listePlayers";
	}
}

	
