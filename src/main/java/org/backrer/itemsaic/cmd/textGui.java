package org.backrer.itemsaic.cmd;

import org.backrer.itemsaic.Gui.Gui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class textGui implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0){
            if (args[0].equalsIgnoreCase("kong")){
                Gui.allList.get("kong").useToPlayerGui(sender.getServer().getPlayer(sender.getName()));
            }
        }
        return false;
    }
}
