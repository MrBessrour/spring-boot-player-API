package resetcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bessrour.players.entities.Player;
import com.bessrour.players.service.PlayerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class resetcontrollers {
	@Autowired
	PlayerService playereService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Player> getAllProduits() 
	{
		return playereService.getAllPlayers();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Player getPlayerById(@PathVariable("idPLayer") Long id) 
	{ 
		return playereService.getPlayer(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Player CreatePlayer(@RequestBody Player vo) {
	return playereService.savePlayer(vo);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Player updatePlayer(@RequestBody Player v) {
	return playereService.updatePlayer(v);
	}
	
	
	@RequestMapping(value="/{idPLayer}",method = RequestMethod.DELETE)
	public void deleteplayer(@PathVariable("idPLayer") Long id)
	{
		playereService.deletePlayerById(id);
	}
	
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Player> getVoituresByCatId(@PathVariable("idCat") Long idCat) {
	return playereService.findByCategorieIdCat(idCat);
	}
}
