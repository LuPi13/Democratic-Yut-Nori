package yasking.lupi13.greenlightredlight;

import org.bukkit.plugin.java.JavaPlugin;

public final class GreenLightRedLight extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("glrl").setExecutor(new GameToggle(this));
        System.out.println("무궁화 꽃이 피었습니다.");

    }

    @Override
    public void onDisable() {
        System.out.println("무궁화 꽃이 졌습니다.");
    }
}
