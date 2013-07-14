package com.xknucklesx.Guns;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
 
	
	@Override 
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		
	}
	
	@EventHandler
	public void onClick2(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.WOOD_HOE) {
			Gun2(p);
			
		}
	}
	
	@EventHandler
	public void onClick1(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.STONE_HOE) {
			Gun1(p);
		}
	}

	private void Gun1(Player p) {
		EnderPearl ep = p.launchProjectile(EnderPearl.class); //Config - EnderPearl Example
		ep.setVelocity(p.getLocation().getDirection().multiply(2.5)); //Config - 2.5 Example
		
	}

	private void Gun2(Player p) {
		Arrow ar = p.launchProjectile(Arrow.class); //Config - Arrow Example
		ar.setVelocity(p.getLocation().getDirection().multiply(2.0)); //Config - 2.0 Example
	}
		
}
