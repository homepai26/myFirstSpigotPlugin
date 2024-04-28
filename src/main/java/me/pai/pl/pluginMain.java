package me.pai.pl;

import java.util.logging.Logger;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class pluginMain extends JavaPlugin {
    Logger l = getLogger();
    eventHandler listener = new eventHandler(this.getServer(), this);

    @Override
    public void onEnable() {
        l.info("Hii yaa.");
	getCommand("jail").setExecutor(new jail(this.getServer()));
	getCommand("unbreakableblock").setExecutor(new unbreakableBlock(listener));
        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        l.info("See yaa");
        HandlerList.unregisterAll(listener);
    }
}
