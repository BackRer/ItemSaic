package org.backrer.itemsaic.Gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Gui {
    HashMap<String,Gui> allList = new HashMap<>();
    Inventory getInventory();
    String guiName();
    int[] notMoveGlot();
    int[] getAirGlot();
    int[] eventGlot();
    void createGui();
    void useToPlayerGui(Player player);
}
