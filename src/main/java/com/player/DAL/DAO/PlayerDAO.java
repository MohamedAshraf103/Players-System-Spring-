package com.player.DAL.DAO;

import java.util.List;

import com.player.DAL.model.Player;

public interface PlayerDAO {
	public  List<Player>findList();
	public void add(Player p);
	public Player findById(int id);
	public void remove(int id);

}
