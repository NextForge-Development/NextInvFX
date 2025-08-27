package gg.nextforge.invfx.binding.bukkit.adapter;

import gg.nextforge.invfx.spi.InventoryAdapter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public final class BukkitInventoryAdapter implements InventoryAdapter {

    @Override
    public Object createInventory(int size, String title) {
        return Bukkit.createInventory(null, size, MiniMessage.miniMessage().deserialize(title));
    }

    @Override
    public void setItem(Object inventory, int rawSlot, Object platformItem) {
        Inventory inv = (Inventory) inventory;
        inv.setItem(rawSlot, (org.bukkit.inventory.ItemStack) platformItem);
    }

    @Override
    public void open(Object playerHandle, Object inventory) {
        ((org.bukkit.entity.Player) playerHandle).openInventory((Inventory) inventory);
    }
}
