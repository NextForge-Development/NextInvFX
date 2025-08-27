package gg.nextforge.invfx.spi;

import net.kyori.adventure.text.Component;

/** Opaque bridge to the platform's inventory API (Bukkit, etc.). */
public interface InventoryAdapter {
    Object createInventory(int size, String title);
    Object createInventory(int size, Component title);
    void setItem(Object inventory, int rawSlot, Object platformItem);
    void open(Object playerHandle, Object inventory);
}
