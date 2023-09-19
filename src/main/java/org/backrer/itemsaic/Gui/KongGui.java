package org.backrer.itemsaic.Gui;

import org.backrer.itemsaic.ItemSaic;
import org.backrer.itemsaic.unitl.FileYML;
import org.backrer.itemsaic.unitl.Until;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;
import java.util.Set;


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
        return FileYML.lang.getString("GuiName.kongName");
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
        fgbItemMeta.setDisplayName(FileYML.lang.getString("GuiName.kongFG"));
        fgb.setItemMeta(fgbItemMeta);

        inventory.addItem(fgb);

        for (int a : notMoveGlot()){
            getInventory().setItem(a,fgb);
        }

        ItemStack dj = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta djItemMeta = dj.getItemMeta();
        djItemMeta.setDisplayName(FileYML.lang.getString("GuiName.kongButton"));
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
    public void EventKongGuiClick(InventoryClickEvent event) {
        ItemStack clickItem = Objects.requireNonNull(event.getClickedInventory()).getItem(getAirGlot()[0]);
        Player player = (Player) event.getWhoClicked();

        if (clickItem == null) {
            player.sendMessage(FileYML.lang.getString("null"));
            return;
        }

        ItemMeta clickMeta = clickItem.getItemMeta();
        List<String> clickLore = clickMeta.getLore();

        if (clickLore == null) {
            player.sendMessage(FileYML.lang.getString("null"));
            return;
        }
        if (clickLore.size() == 0) {
            player.sendMessage(FileYML.lang.getString("null"));
            return;
        }

        String checkLore = ItemSaic.ins.getConfig().getString("Lore");
        if (clickLore.contains(checkLore)) {
            player.sendMessage(FileYML.lang.getString("loreEnable"));
            return;
        }


        ConfigurationSection kong = FileYML.saic.getConfigurationSection("Kong");
        double randomDouble = Math.random();
        String kongList = null;
        if (kong != null) {
            Set<String> keys = kong.getKeys(false);
            kongList = null;
            int kongSize = (int) (randomDouble * 10);
            for (int i = 0; i < kongSize; i++) {
                if (kongList == null){
                    kongList = FileYML.saic.getString("Kong."+Until.RandomSetString(keys));
                }else {
                    kongList += FileYML.saic.getString("Kong."+Until.RandomSetString(keys));
                }
            }
        }

        //写入lore
        clickLore.add(checkLore);
        clickLore.add(kongList);
        clickLore.add(checkLore);
        clickMeta.setLore(clickLore);
        clickItem.setItemMeta(clickMeta);

    }
}
