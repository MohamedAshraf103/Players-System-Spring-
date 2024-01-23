package com.player.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.player.DAL.DAO.PlayerDAO;
import com.player.DAL.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerDAO playerDAO;
	public PlayerServiceImpl() {}
	
	
	

	@Override
	@Transactional
	public List<Player> findList()
	{
		return playerDAO.findList();	
	}
	
	@Override
	@Transactional
	public void add(Player p)
	{
	 playerDAO.add(p);
	}
	@Override
	@Transactional
	public void remove(int id) {
		playerDAO.remove(id);
	}

	
	@Override
	@Transactional
	public Player findById(int id)
	{
		return playerDAO.findById(id);
	}
	
}
