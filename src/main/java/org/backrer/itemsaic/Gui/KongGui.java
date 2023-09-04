package org.backrer.itemsaic.Gui;

import org.backrer.itemsaic.unitl.Lang;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class KongGui implements Gui{

    @Override
    public Inventory getInventory() {
        return Bukkit.createInventory(null,9,guiName());
    }

    @Override
    public String guiName() {
        return Lang.lang.getString("GuiName.kongName");
    }

    @Override
    public int[] notMoveGlot() {
        return new int[]{0,1,2,3,5,6,7,8};
    }

    @Override
    public int[] getAirGlot() {
        return new int[]{4};
    }

    @Override
    public int[] eventGlot() {
        return new int[]{3,5};
    }

    @Override
    public void createGui() {
        ItemStack fgb = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta fgbItemMeta = fgb.getItemMeta();
        fgbItemMeta.setDisplayName("§a别看我我就是个分隔板");
        fgb.setItemMeta(fgbItemMeta);

        for (int a : notMoveGlot()){
            getInventory().setItem(a,fgb);
        }

        ItemStack dj = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta djItemMeta = dj.getItemMeta();
        djItemMeta.setDisplayName("§a点击随机打孔");
        dj.setItemMeta(fgbItemMeta);

        for (int a : eventGlot()){
            getInventory().setItem(a,dj);
        }

    }

    @Override
    public void useToPlayerGui(Player player) {
        createGui();
        player.openInventory(getInventory());
    }
}
