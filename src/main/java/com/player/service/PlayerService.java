package com.player.service;

import java.util.List;

import com.player.DAL.model.Player;

public interface PlayerService {
	
	public List<Player> findList();

	public void add(Player p);
	public Player findById(int id);
	public void remove(int id);

	

}
