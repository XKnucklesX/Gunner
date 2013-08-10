package com.XKnucklesX.Gunner;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@Override 
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		getConfig().options().copyDefaults(true); //Get config
		saveConfig(); //Save config

	}

	@Override
	public void onDisable() {
		saveConfig(); //Final save - To make sure no Config loss
	}

	@EventHandler
	public void onClick1(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.getMaterial(getConfig().getString("Guns.Gun1"))) {
			Gun1(p);

		}
	}

	@EventHandler
	public void onClick2(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
		Player p = e.getPlayer();
	        if(p.getItemInHand().getType() == Material.getMaterial(getConfig().getString("Guns.Gun2"))) {
			Gun2(p);
		}
	}
	
	@EventHandler
	public void onClick3(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK);
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.getMaterial(getConfig().getString("Guns.Gun3"))) {
			Gun3(p);

		}
	}

	private void Gun1(Player p) {
	        EnderPearl ep = (EnderPearl) p.getWorld().spawn(p.getEyeLocation(), EnderPearl.class);
		ep.setShooter(((LivingEntity) p));
	        ep.setVelocity(p.getLocation().getDirection().multiply(1.0));
	}
	
	private void Gun2(Player p){
		Snowball sb = (Snowball) p.getWorld().spawn(p.getEyeLocation(), Snowball.class);
		sb.setShooter(((LivingEntity) p));
		sb.setVelocity(p.getLocation().getDirection().multiply(1.5));
		}
	
        private void Gun3(Player p){
               Arrow a = (Arrow) p.getWorld().spawn(p.getEyeLocation(), Arrow.class);
               a.setShooter(((LivingEntity) p));
               a.setVelocity(p.getLocation().getDirection().multiply(2.0));
    }

}
