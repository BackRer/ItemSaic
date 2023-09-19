package org.backrer.itemsaic;

import org.backrer.itemsaic.Gui.ClickEvent;
import org.backrer.itemsaic.Gui.Gui;
import org.backrer.itemsaic.Gui.KongGui;
import org.backrer.itemsaic.cmd.isk;
import org.backrer.itemsaic.unitl.FileYML;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSaic extends JavaPlugin {
    public static ItemSaic ins;

    @Override
    public void onEnable() {
        ins = this;
        getLogger().info(FileYML.lang.getString("Until.first"));
        //加载配置文件
        saveDefaultConfig();
        saveResource("lang.yml",false);
        saveResource("Saic.yml",false);
        saveConfig();
        //reloadConfig();
        //注册事件
        getServer().getPluginManager().registerEvents(new ClickEvent(),this);
        //注册Gui
        Gui.allList.put("kong",new KongGui());

        //注册指令
        getCommand("isk").setExecutor(new isk());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
