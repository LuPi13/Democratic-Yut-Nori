package yasking.lupi13.democracyyutnori;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class UseYut implements Listener {

    private DemocracyYutnori plugin;

    public UseYut(DemocracyYutnori plugin) {
        this.plugin = plugin;
    }

    public static int timer, do1, gae2, girl3, yut4, mo5, backdo6;
    public static boolean toggle = true;

    @EventHandler
    public void useYut(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        List<Player> players = player.getWorld().getPlayers();
        if (event.getItem() != null && event.getItem().equals(YutStart.yut)) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (toggle) {
                    if (plugin.getConfig().getInt("Timer") <= 0) {
                        for (Player player1 : players) {
                            player1.sendMessage(ChatColor.YELLOW + "Timer 값이 " + ChatColor.RED + plugin.getConfig().getInt("Timer") + ChatColor.YELLOW + "로 설정되어있습니다. 1 이상의 값을 넣어주세요.");
                        }
                        return;
                    }
                    if (plugin.getConfig().getInt("InitialDo") <= -1 ||
                            plugin.getConfig().getInt("InitialGae") <= -1 ||
                            plugin.getConfig().getInt("InitialGirl") <= -1 ||
                            plugin.getConfig().getInt("InitialYut") <= -1 ||
                            plugin.getConfig().getInt("InitialMo") <= -1 ||
                            plugin.getConfig().getInt("InitialBackdo") <= -1) {
                        for (Player player1 : players) {
                            player1.sendMessage(ChatColor.YELLOW + "Initial 값에 0보다 작은 값이 있습니다. 0 이상의 값을 넣어주세요.");
                        }
                        return;
                    }
                    timer = plugin.getConfig().getInt("Timer") + 60;
                    do1 = plugin.getConfig().getInt("InitialDo");
                    gae2 = plugin.getConfig().getInt("InitialGae");
                    girl3 = plugin.getConfig().getInt("InitialGirl");
                    yut4 = plugin.getConfig().getInt("InitialYut");
                    mo5 = plugin.getConfig().getInt("InitialMo");
                    backdo6 = plugin.getConfig().getInt("InitialBackdo");
                    toggle = false;

                    new BukkitRunnable() {
                        public void run() {

                            if (timer == plugin.getConfig().getInt("Timer") + 60) {
                                for (Player player1 : players) {
                                    player1.sendTitle("3", ChatColor.GREEN + event.getPlayer().getDisplayName() + ChatColor.RESET + "이(가) 윷을 던집니다!", 0, 21, 0);
                                    player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                                }
                            }
                            if (timer == plugin.getConfig().getInt("Timer") + 40) {
                                for (Player player1 : players) {
                                    player1.sendTitle("2", ChatColor.GREEN + event.getPlayer().getDisplayName() + ChatColor.RESET + "이(가) 윷을 던집니다!", 0, 21, 0);
                                    player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                                }
                            }
                            if (timer == plugin.getConfig().getInt("Timer") + 20) {
                                for (Player player1 : players) {
                                    player1.sendTitle("1", ChatColor.GREEN + event.getPlayer().getDisplayName() + ChatColor.RESET + "이(가) 윷을 던집니다!", 0, 21, 0);
                                    player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                                }
                            }
                            if (timer == plugin.getConfig().getInt("Timer")) {
                                for (Player player1 : players) {
                                    player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2);
                                }
                            }


                            if (timer >= 1 && timer <= plugin.getConfig().getInt("Timer")) {
                                for (Player player1 : players) {

                                    player1.sendTitle(ChatColor.GOLD + "채팅러시 ㄱㄱ! " + ChatColor.RESET + ( (timer / 20) + 1) + "초",
                                            ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                    ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                    ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                    ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                    ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                    ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 2, 0);
                                }
                            }




                            if (timer >= -20 && timer <= 0) {
                                for (Player player1 : players) {
                                    player1.sendTitle(ChatColor.WHITE + "결과는???",
                                            ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                    ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                    ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                    ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                    ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                    ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 2, 0);
                                    player1.playSound(player1.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 1, 0.5F);
                                }
                            }
                            if (timer == -21) {
                                int all = do1 + gae2 + girl3 + yut4 + mo5 + backdo6;
                                double docut = (double) do1 / all;
                                double gaecut = (double) (do1 + gae2) / all;
                                double girlcut = (double) (do1 + gae2 + girl3) / all;
                                double yutcut = (double) (do1 + gae2 + girl3 + yut4) / all;
                                double mocut = (double) (do1 + gae2 + girl3 + yut4 + mo5) / all;
                                double rannum = Math.random();


                                if (rannum <= docut) {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.RED + "도",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }
                                else if (rannum <= gaecut) {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.YELLOW + "개",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }
                                else if (rannum <= girlcut) {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.GREEN + "걸",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }
                                else if (rannum <= yutcut) {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.BLUE + "윷",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }
                                else if (rannum <= mocut) {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.LIGHT_PURPLE + "모",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }
                                else {
                                    for (Player player1 : players) {
                                        player1.sendTitle(ChatColor.DARK_PURPLE + "백도",
                                                ChatColor.RED + "도 " + ChatColor.RESET + do1 +
                                                        ChatColor.YELLOW + " 개 " + ChatColor.RESET + gae2 +
                                                        ChatColor.GREEN + " 걸 " + ChatColor.RESET + girl3 +
                                                        ChatColor.BLUE + " 윷 " + ChatColor.RESET + yut4 +
                                                        ChatColor.LIGHT_PURPLE + " 모 " + ChatColor.RESET + mo5 +
                                                        ChatColor.DARK_PURPLE + " 백도 " + ChatColor.RESET + backdo6, 0, 20, 10);
                                        player1.playSound(player1.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1, 1);
                                    }
                                }

                                cancel();
                                toggle = true;
                            }
                            timer -= 1;
                        }
                    }.runTaskTimer(plugin, 0L, 1L);
                    event.setCancelled(true);
                }

            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (timer >= 1 && timer <= plugin.getConfig().getInt("Timer")) {

            switch (event.getMessage()) {
                case "도":
                    do1 += 1;
                    break;
                case "개":
                    gae2 += 1;
                    break;
                case "걸":
                    girl3 += 1;
                    break;
                case "윷":
                    yut4 += 1;
                    break;
                case "모":
                    mo5 += 1;
                    break;
                case "백도":
                    backdo6 += 1;
                    break;
            }
        }
    }

}
