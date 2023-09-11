package org.mrmelon__.statsupgrader.events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class InventoryEvents implements Listener {

    @EventHandler
    public void onClickInUI(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        String titleOfUI = null;
        try {
            titleOfUI = event.getView().getTitle().substring(0,9);
        } catch (Exception ignored) {}
        if (titleOfUI.equals("Stats of ")) {
            ItemStack itemStack = event.getCurrentItem();
            int meta = itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("key"), PersistentDataType.INTEGER);
            switch (meta) {
                case 1:
                    break;
            }
        }
    }

}
