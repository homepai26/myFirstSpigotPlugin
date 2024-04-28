package me.pai.pl;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class unbreakableBlock implements CommandExecutor {
    eventHandler listener;

    unbreakableBlock(eventHandler listener) {
	this.listener = listener;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if (args.length == 0)
	    return false;

	for (String str : args) {
	    Material m = Material.getMaterial(str.toUpperCase());
	    listener.addBlock(m);
	}
	
	return true;
    }
}
