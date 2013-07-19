package prop.kilian.Entrypayment;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.World;

import cosine.boseconomy.BOSEconomy;


public class EventListener implements Listener {
	
	public static EntryPayment plugin;
	public static BOSEconomy economy;
	
	public EventListener(EntryPayment instance,BOSEconomy bose)
	{
		plugin = instance;
		economy = bose;
	}
	@EventHandler
	public void onSignInteract(SignChangeEvent event)
	{
		String line1 = event.getLine(0);
		String coords = event.getLine(1);
		String line3 = event.getLine(2);
		String[] coordinates;
		String[] amount;
		Player p = event.getPlayer();
		
		if(line1.equalsIgnoreCase("entry"))
		{
			coordinates = coords.split(",");
			amount = line3.split(" ");
			
			String strAmount = "-" + amount[0];
			
			double dblAmount;
			dblAmount = Double.parseDouble(strAmount);
			
			if(economy.addPlayerMoney(p.getName(), dblAmount, true) == true)
			{
				p.sendMessage(ChatColor.GOLD + "The amount of " + ChatColor.GREEN + amount[0] + ChatColor.GOLD + " has been taken from your acount");
				p.sendMessage(ChatColor.GOLD + "Teleporting you to the desired location...");
				
				int xpos = Integer.parseInt(coordinates[0]);
				int ypos = Integer.parseInt(coordinates[1]);
				int zpos = Integer.parseInt(coordinates[2]);
				
				p.teleport(new Location(Bukkit.getWorld("VegasCraft"),xpos,ypos,zpos));
				p.sendMessage(ChatColor.GOLD + "Teleported succesfully!");
				return;
			}
			else
			{
				p.sendMessage(ChatColor.GOLD + "Error , could not take money from player balance !");
				return;
			}
		}
	}
}
