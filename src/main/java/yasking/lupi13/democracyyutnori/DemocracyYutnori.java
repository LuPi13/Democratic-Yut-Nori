package yasking.lupi13.democracyyutnori;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DemocracyYutnori extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new UseYut(this), this);
        getCommand("yut").setExecutor(new YutStart());
        YutStart.init();
        System.out.println("DemocracyYutnori Plug-in Started. Enjoy your 140% Democracy.");
    }

    @Override
    public void onDisable() {
        System.out.println("DemocracyYutnori Plug-in stopped.");
    }
}
