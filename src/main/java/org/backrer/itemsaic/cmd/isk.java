package org.backrer.itemsaic.cmd;

import org.backrer.itemsaic.Gui.Gui;
import org.backrer.itemsaic.ItemSaic;
import org.backrer.itemsaic.unitl.FileYML;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class isk implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0){
            switch (args[0]){
                case "kong":
                    Gui.allList.get("kong").useToPlayerGui(sender.getServer().getPlayer(sender.getName()));
                    break;
                case "item":
                    if (args.length == 2){
                        String baoshi = args[1];
                        if (FileYML.saic.getString("BaoShi."+baoshi+".type") != null){
                            if (sender instanceof Player player){
                                player.getInventory().addItem(BaoShiItem(baoshi));
                            }
                        }else {
                            //宝石不存在
                        }
                    }else {
                        sender.sendMessage(FileYML.lang.getString("Until.item"));
                    }
                    break;
                case "reload":
                    ItemSaic.ins.reloadConfig();
                    FileYML.reloadLangConfig();
                    FileYML.reloadSaicConfig();
                    sender.sendMessage(FileYML.lang.getString("Until.reloadConfig"));
                    break;
            }
        }
        return false;
    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("isk")) {
            if (args.length == 1){
                return filterByStartingLetter(args[0],"kong","reload","help");
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("item")){
                    ConfigurationSection baoshi = FileYML.saic.getConfigurationSection("BaoShi");
                    Set<String> keys = baoshi.getKeys(false);
                    return filterByStartingLetter(args[1],keys.toArray(new String[0]));
                }
            }
        }
        return null;
    }
    public ItemStack BaoShiItem(String BaoShiName){
        ItemStack is = new ItemStack(Material.getMaterial(FileYML.saic.getString("BaoShi."+BaoShiName+".mate")));

        return is;
    }
    private List<String> filterByStartingLetter(String input, String... options) {
        List<String> completions = new ArrayList<>();
        for (String option : options) {
            if (option.toLowerCase().startsWith(input.toLowerCase())) {
                completions.add(option);
            }
        }
        return completions;
    }
}
