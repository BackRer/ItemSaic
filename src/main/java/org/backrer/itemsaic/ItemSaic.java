package org.backrer.itemsaic;

import org.backrer.itemsaic.Gui.ClickEvent;
import org.backrer.itemsaic.Gui.Gui;
import org.backrer.itemsaic.Gui.KongGui;
import org.backrer.itemsaic.cmd.textGui;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSaic extends JavaPlugin {

    @Override
    public void onEnable() {
        //加载config
        saveDefaultConfig();
        saveConfig();
        //注册事件
        getServer().getPluginManager().registerEvents(new ClickEvent(),this);
        //注册Gui
        Gui.allList.put("kong",new KongGui());

        //注册指令
        getCommand("textGui").setExecutor(new textGui());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
