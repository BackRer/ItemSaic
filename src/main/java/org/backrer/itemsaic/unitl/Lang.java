package org.backrer.itemsaic.unitl;

import org.backrer.itemsaic.ItemSaic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Lang {
    public static File langFile = new File(ItemSaic.ins.getDataFolder()+"/lang.yml");
    public static FileConfiguration lang = YamlConfiguration.loadConfiguration(langFile);
    public static void reloadConfig(){
        langFile = null;
        lang = null;
        langFile = new File(ItemSaic.ins.getDataFolder()+"//lang.yml");
        lang = YamlConfiguration.loadConfiguration(langFile);
        List<String> s = new ArrayList<>();
    }
}
