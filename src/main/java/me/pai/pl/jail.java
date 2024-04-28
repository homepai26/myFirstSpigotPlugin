package me.pai.pl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class jail implements CommandExecutor {
    Server server;
    Block[][][] oldBlockData;

    jail(Server server) {
	this.server = server;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if (args.length == 0)
	    return false;
	
	String playerName = args[0];
	oldBlockData = new Block[6][6][6];
	
	Location location = server.getPlayer(playerName).getLocation();
	double x = location.getX();
	double y = location.getY() + 1;
	double z = location.getZ();

	int cy = 0; 
	for (double i = y - 2; i <= y + 2; i++) {
	    int cx = 0;
	    for (double j = x - 2; j <= x + 2; j++) {
		int cz = 0;
		for (double k = z - 2; k <= z + 2; k++) {
		    location.setY(i);
		    location.setX(j);
		    location.setZ(k);
			
		    Block block = location.getBlock();
		    oldBlockData[cy][cx][cz] = block;
		    
		    if ((i == y - 2) || (i == y + 2) || (j == x - 2) || (j == x + 2) || (k == z - 2) || (k == z + 2)) {
			block.setType(Material.OBSIDIAN);
		    } else {
			block.setType(Material.AIR);
		    }

		    String infoString = String.format("Plate block at x: %.2f y: %.2f z: %.2f", i, j, k);
		    server.getLogger().info(infoString);
		    cz++;
		}
		cx++;
	    }
	    cy++;
	}
	return true;
    }

    public void setServer(Server server) {
	this.server = server;
    }

    public Block[][][] getOldBlockDataArray() {
	return oldBlockData;
    }
}
