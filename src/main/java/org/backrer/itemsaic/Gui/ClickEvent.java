package org.backrer.itemsaic.Gui;

import org.backrer.itemsaic.unitl.Until;
import org.bukkit.entity.Player;
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
            if (event.getView().getTitle().equalsIgnoreCase(gui.guiName())){ //判断要检测的gui名称
                if (Until.Contains(gui.notMoveGlot(), event.getRawSlot())){ //判断禁止移动的格子
                    event.setCancelled(true);
                }
                if (Until.Contains(gui.eventGlot(), event.getRawSlot())) {
                    gui.EventKongGuiClick(event);
                }
            }
        }
    }
}
