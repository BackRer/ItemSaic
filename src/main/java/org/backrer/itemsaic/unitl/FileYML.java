package org.backrer.itemsaic.unitl;

import org.backrer.itemsaic.ItemSaic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileYML {
    public static File langFile = new File(ItemSaic.ins.getDataFolder()+"/lang.yml");
    public static FileConfiguration lang = YamlConfiguration.loadConfiguration(langFile);
    public static void reloadLangConfig(){
        langFile = null;
        lang = null;
        langFile = new File(ItemSaic.ins.getDataFolder()+"lang.yml");
        lang = YamlConfiguration.loadConfiguration(langFile);
    }

    public static File saicFile = new File(ItemSaic.ins.getDataFolder()+"/Saic.yml");
    public static FileConfiguration saic = YamlConfiguration.loadConfiguration(saicFile);
    public static void reloadSaicConfig(){
        saicFile = null;
        saic = null;
        saicFile = new File(ItemSaic.ins.getDataFolder()+"Saic.yml");
        saic = YamlConfiguration.loadConfiguration(langFile);
    }
}
