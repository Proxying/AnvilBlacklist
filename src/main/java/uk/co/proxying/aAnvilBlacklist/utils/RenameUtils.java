package uk.co.proxying.aAnvilBlacklist.utils;

import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Kieran Quigley (Proxying) on 07-Jun-16.
 */
public class RenameUtils {

    public static boolean isItemBlacklisted(ItemStack itemStack) {
        int itemID = itemStack.getType().getId();
        for (int blacklistedItems : new Config<List<Integer>>("blacklist.anvil-rename-blacklist").getValue()) {
            if (itemID == blacklistedItems) {
                return true;
            }
        }
        return false;
    }
}
