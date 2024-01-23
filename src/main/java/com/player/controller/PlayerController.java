package com.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.player.DAL.DAO.PlayerDAO;
import com.player.DAL.DAO.PlayerDAOImpl;
import com.player.DAL.managers.HibernateDBManager;
import com.player.DAL.model.Player;
import com.player.service.PlayerService;



// http://localhost:8080/Players/playerController

@Controller
@RequestMapping("/fifa")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	public PlayerController() {
	}
	
	@GetMapping("/players")
	public String players(Model model) throws Exception
	{
		List<Player> players = playerService.findList();
		model.addAttribute("players",players);
		return "players";
	}
	
	@GetMapping("/add")
	public String add(Model model)
	{
		model.addAttribute("player",new Player());
		return "addPlayer"; 
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("player") Player player) throws Exception
	{
		playerService.add(player);
		return "redirect:/fifa/players"; 
	}
	
	@GetMapping("/showPlayer")
	public String showPlayer(Model model ,@RequestParam("playerId")int id)
	{
		Player p=playerService.findById(id);
		model.addAttribute("player",p);
		return "addPlayer";
	}
	
	@GetMapping("/removePlayer")
	public String removePlayer(@RequestParam("playerId")int id)
	{
		playerService.remove(id);
		return "redirect:/fifa/players"; 
	}

}
