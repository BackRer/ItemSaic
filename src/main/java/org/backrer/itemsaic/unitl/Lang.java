package org.backrer.itemsaic.unitl;

import org.backrer.itemsaic.ItemSaic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Lang {
    public static File langFile = new File(ItemSaic.ins.getDataFolder()+"lang.yml");
    public static FileConfiguration lang = YamlConfiguration.loadConfiguration(langFile);
    public static void reloadConfig(){

    }
}
