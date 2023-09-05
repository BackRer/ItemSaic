package org.backrer.itemsaic.Gui;

import org.backrer.itemsaic.ItemSaic;
import org.backrer.itemsaic.unitl.Lang;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;


public class KongGui implements Gui{
    private Inventory inventory;
    public KongGui(){
        inventory = Bukkit.createInventory(null,9,guiName());
    }
    @Override
    public Inventory getInventory() {
        return inventory;
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
        fgbItemMeta.setDisplayName(Lang.lang.getString("GuiName.kongFG"));
        fgb.setItemMeta(fgbItemMeta);

        inventory.addItem(fgb);

        for (int a : notMoveGlot()){
            getInventory().setItem(a,fgb);
        }

        ItemStack dj = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta djItemMeta = dj.getItemMeta();
        djItemMeta.setDisplayName(Lang.lang.getString("GuiName.kongButton"));
        dj.setItemMeta(djItemMeta);

        for (int a : eventGlot()){
            inventory.setItem(a,dj);
        }



    }

    @Override
    public void useToPlayerGui(Player player) {
        createGui();
        player.openInventory(getInventory());
    }
    @Override
    public void EventKongGuiClick(InventoryClickEvent event){
        ItemStack clickItem = Objects.requireNonNull(event.getClickedInventory()).getItem(getAirGlot()[0]);
        Player player = (Player) event.getWhoClicked();

        if (clickItem == null){
            player.sendMessage(Lang.lang.getString("null"));
            return;
        }

        ItemMeta clickMeta = clickItem.getItemMeta();
        List<String> clickLore = clickMeta.getLore();

        if (clickLore == null){
            player.sendMessage(Lang.lang.getString("null"));
            return;
        }
        if (clickLore.size() == 0){
            player.sendMessage(Lang.lang.getString("null"));
            return;
        }

        String checkLore = ItemSaic.ins.getConfig().getString("Lore");
        if (clickLore.contains(checkLore)){
            player.sendMessage(Lang.lang.getString("loreEnable"));
            return;
        }

        //写入lore
        clickLore.add(checkLore);
        clickMeta.setLore(clickLore);
        clickItem.setItemMeta(clickMeta);
    }
}
