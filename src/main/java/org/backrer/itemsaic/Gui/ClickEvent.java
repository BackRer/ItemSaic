package org.backrer.itemsaic.Gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Collection;
import java.util.Set;

public class ClickEvent implements Listener {
    @EventHandler
    public void allGuiCheck(InventoryClickEvent event) {
        Collection<Gui> values = Gui.allList.values();
        for (Gui gui : values){
            if (event.getView().getTitle().equalsIgnoreCase(gui.guiName())){

            }
        }
    }
}
