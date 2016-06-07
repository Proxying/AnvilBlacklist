package uk.co.proxying.aAnvilBlacklist.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import uk.co.proxying.aAnvilBlacklist.utils.Config;
import uk.co.proxying.aAnvilBlacklist.utils.RenameUtils;

/**
 * Created by Kieran Quigley (Proxying) on 07-Jun-16.
 */
public class RenameListener implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST)
    public void anvilRename(InventoryClickEvent event) {
        if (event.getInventory().getType() != InventoryType.ANVIL) return;
        if (event.getRawSlot() != 2) return;
        if (event.getView().getItem(0).getType() == Material.AIR ||event.getView().getItem(2).getType() == Material.AIR) return;
        Player player = (Player) event.getWhoClicked();
        if (player.hasPermission(new Config<String>("blacklist.permission-bypass").getValue())) return;
        if (RenameUtils.isItemBlacklisted(event.getView().getItem(0)) || RenameUtils.isItemBlacklisted(event.getView().getItem(2))) {
            event.setCancelled(true);
            player.getInventory().addItem(event.getView().getItem(0));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', new Config<String>("messages.error-item-blacklisted").getValue()));
            event.getView().setItem(0, new ItemStack(Material.AIR));
            player.closeInventory();
        }
    }
}
