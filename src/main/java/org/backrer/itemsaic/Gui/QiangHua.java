package org.backrer.itemsaic.Gui;

import org.backrer.itemsaic.unitl.FileYML;
import org.backrer.itemsaic.unitl.Until;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class QiangHua implements Gui{
    private Inventory inventory;
    public QiangHua(){
        inventory = Bukkit.createInventory(null,36,guiName());
    }
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String guiName() {
        return FileYML.lang.getString("GuiName.xiangQian");
    }

    @Override
    public int[] notMoveGlot() {
        int[] kl = null;
        for (int a = 0; a < 36; a++){
            if (Until.Contains(getAirGlot(),a)){
                continue;
            }
            if (Until.Contains(eventGlot(),a)){
                continue;
            }
            kl[a] = a;
        }

        return kl;
    }

    @Override
    public int[] getAirGlot() {
        return new int[]{22,2,7};
    }

    @Override
    public int[] eventGlot() {
        return new int[]{28,29,30,31,32,33,34,35,36};
    }

    @Override
    public void createGui() {
        ItemStack itemStack = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        for (int a : notMoveGlot()){
            if (a < 8){
                itemStack.setType(Material.BLACK_STAINED_GLASS_PANE);
                itemMeta.setDisplayName("Top 1");
            }else if (a > 8 && a < 17){
                itemStack.setType(Material.GREEN_STAINED_GLASS_PANE);
                itemMeta.setDisplayName("Top 2");
            }else if (a > 17 && a < 35){
                itemStack.setType(Material.RED_STAINED_GLASS_PANE);
                itemMeta.setDisplayName("Top 3");
            }
            itemStack.setItemMeta(itemMeta);
            inventory.setItem(a,itemStack);
        }
    }

    @Override
    public void useToPlayerGui(Player player) {
        player.openInventory(inventory);
    }

    @Override
    public void EventKongGuiClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        for (int a : getAirGlot()){
            if (event.getInventory().getItem(a) == null){
                player.sendMessage(FileYML.lang.getString("GuiName.QiangHua"));
                return;
            }
        }


    }
}
