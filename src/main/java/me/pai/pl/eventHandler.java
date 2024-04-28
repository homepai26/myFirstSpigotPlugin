package me.pai.pl;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class eventHandler implements Listener {
    ArrayList<Material> unbreakableBlock = new ArrayList();
    Server server;
    Plugin plugin;
    
    eventHandler(Server server, Plugin plugin) {
	this.server = server;
	this.plugin = plugin;
    }

    @EventHandler
    public void onBlockDestroyEvent(BlockBreakEvent e) {
	Block blockOnEvent = e.getBlock();
	Player playerOnEvent = e.getPlayer();
	for (Material m : unbreakableBlock) {
	    if (blockOnEvent.getType().equals(m))
		e.setCancelled(true);
	}

	plugin.getLogger().info(playerOnEvent.getName() + " " + "is destroying" + " " + blockOnEvent.getType().toString());
	
    }

    public void setServer(Server server) {
	this.server = server;
    }

    public void setPlugin(Plugin plugin) {
	this.plugin = plugin;
    }

    public void addBlock(Material m) {
	unbreakableBlock.add(m);
    }

    public void removeBlock(Material m) {
	unbreakableBlock.remove(m);
    }
}
