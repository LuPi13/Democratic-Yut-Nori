package yasking.lupi13.greenlightredlight;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class GameToggle implements CommandExecutor {

    private GreenLightRedLight plugin;

    public GameToggle(GreenLightRedLight plugin) {
        this.plugin = plugin;
    }

    public static boolean toggle = false;
    public static int timer = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.isOp()) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (plugin.getConfig().getInt("mintick") < 0 ||
                                plugin.getConfig().getInt("maxtick") < plugin.getConfig().getInt("mintick") ||
                                plugin.getConfig().getInt("mincool") < 0 ||
                                plugin.getConfig().getInt("maxcool") < plugin.getConfig().getInt("mincool")) {
                            for (Player target : player.getWorld().getPlayers()) {
                                target.sendMessage(ChatColor.RED + "config.yml 에 올바르지 않은 값이 있습니다!");
                            }
                        }
                        toggle = true;
                        gamecount(player.getWorld().getPlayers());
                        for (Player target : player.getWorld().getPlayers()) {
                            target.sendMessage(ChatColor.GREEN + "무궁화꽃이 피었습니다를 시작합니다.");
                            target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }
                    }
                    else if (args[0].equalsIgnoreCase("stop")) {
                        toggle = false;
                        gamecount(player.getWorld().getPlayers());
                        for (Player target : player.getWorld().getPlayers()) {
                            target.sendMessage(ChatColor.GREEN + "무궁화꽃이 피었습니다를 종료합니다.");
                            target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "/game [start/stop]");
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "/game [start/stop]");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
            }
        }
        return true;
    }

    /*
    0 1 2 3 4 5 6 7 8 9101112
    무궁화  꽃  이   피었습니다
     */

    public void gamecount(List<Player> players) {
        final int[] tick = {0};
        final int[] cooltime = {0};
        final Location[] location = new Location[1];

        new BukkitRunnable() {
            @Override
            public void run() {
                if (toggle) {
                    if (timer == 0) {
                        tick[0] = (int) (Math.random() * (plugin.getConfig().getInt("maxtick") - plugin.getConfig().getInt("mintick"))) + plugin.getConfig().getInt("mintick");
                        cooltime[0] = (int) (Math.random() * (plugin.getConfig().getInt("maxcool") - plugin.getConfig().getInt("mincool"))) + plugin.getConfig().getInt("mincool");
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무" + ChatColor.GREEN + "궁화꽃이 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0.89F);
                        }
                    }
                    if (timer == tick[0]) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁" + ChatColor.GREEN + "화꽃이 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.19F);
                        }
                    }
                    if (timer == tick[0] * 2) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화" + ChatColor.GREEN + "꽃이 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.19F);
                        }
                    }
                    if (timer == tick[0] * 4) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃" + ChatColor.GREEN + "이 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.19F);
                        }
                    }
                    if (timer == tick[0] * 6) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃이" + ChatColor.GREEN + " 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.06F);
                        }
                    }
                    if (timer == tick[0] * 8) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃이 피" + ChatColor.GREEN + "었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.19F);
                        }
                    }
                    if (timer == tick[0] * 9) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃이 피었" + ChatColor.GREEN + "습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.19F);
                        }
                    }
                    if (timer == tick[0] * 10) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃이 피었습" + ChatColor.GREEN + "니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0.89F);
                        }
                    }
                    if (timer == tick[0] * 11) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.YELLOW + "?", ChatColor.RED + "무궁화꽃이 피었습니" + ChatColor.GREEN + "다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 0.89F);
                        }
                    }
                    if (timer == tick[0] * 12) {
                        for (Player target : players) {
                            target.sendTitle(ChatColor.RED + "!", ChatColor.RED + "무궁화꽃이 피었습니다", 0, cooltime[0], 0);
                            target.playSound(target.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1.06F);
                            location[0] = target.getLocation();
                        }
                    }

                    if (timer >=tick[0] * 12 && timer < (tick[0] * 12) + cooltime[0]) {
                        for (Player target : players) {
                            if (!target.isSneaking()) {
                                target.damage(1);
                                target.setNoDamageTicks(1);
                            }
                            if (!target.getLocation().equals(location[0])) {
                                target.damage(1);
                                target.setNoDamageTicks(1);
                                location[0] = target.getLocation();
                            }
                        }
                    }

                    if (timer >= (tick[0] * 12) + cooltime[0]) {
                        timer = -1;
                    }

                    timer += 1;
                }
                else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }
}
