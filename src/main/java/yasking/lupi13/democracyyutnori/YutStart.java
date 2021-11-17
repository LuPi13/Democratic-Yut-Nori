package yasking.lupi13.democracyyutnori;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class YutStart implements CommandExecutor {
    public static ItemStack yut;
    public static ItemStack rulebook;

    public static void init() {
        createYut();
        createRuleBook();
    }

    public static void createYut() {
        ItemStack item1 = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName(ChatColor.GOLD + "민주주의의 윷");
        List<String> lore1 = new ArrayList<>();
        lore1.add(ChatColor.WHITE + "우클릭으로 140% 민주주의적인 윷 던지기");
        lore1.add(ChatColor.YELLOW + "이 윷은 딱 하나만 들고 있어야 작동합니다");
        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        yut = item1;
    }

    public static void createRuleBook() {
        ItemStack book1 = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) book1.getItemMeta();
        meta.setTitle(ChatColor.RED + "140% 민주주의적인 윷놀이 가이드");
        meta.setDisplayName(ChatColor.RED + "140% 민주주의적인 윷놀이 가이드");
        meta.setAuthor(ChatColor.AQUA + "LuPi13");
        meta.addPage("1. 너희들끼리 알아서 순서를 정합니다.\n" +
                "2. 순서대로 한명씩 민주주의의 윷을 우클릭하여 던집니다.\n" +
                "3. 3초의 카운트다운 후, 모든 플레이어가 10초간 채팅러시로 본인/상대가 나오게끔 하고싶은 [백도~모]를 쓰세요!\n" +
                "4. 10초의 채팅러시가 끝나면 나온 채팅들을 반영하여 윷의 확률이 달라지며, 윷이 굴러갑니다.\n" +
                "5. 플러그인 폴더의 config.yml 파일을 수정하여 채팅러시 시간이나 초기값을 바꿀 수 있습니다.");
        meta.addPage(ChatColor.RED + "[주의점]\n" +
                ChatColor.RESET + "1. 플레이어들에게 OP를 주세요. 안주면 마크가 자동으로 강퇴함\n" +
                "2. 윷은 딱 하나만 들어야 작동합니다.");
        book1.setItemMeta(meta);
        rulebook = book1;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            List<Player> players = player.getWorld().getPlayers();
            for (Player player1 : players) {
                player1.getInventory().addItem(rulebook);
                player1.getInventory().addItem(yut);
                player1.sendMessage(ChatColor.RED + "140% 민주주의적인 윷놀이를 시작합니다!");
            }
        }
        else {
            sender.sendMessage("You are not a player!");
        }

        return true;
    }
}
