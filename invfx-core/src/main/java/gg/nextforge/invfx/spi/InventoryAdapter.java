package gg.nextforge.invfx.spi;

/** Opaque bridge to the platform's inventory API (Bukkit, etc.). */
public interface InventoryAdapter {
    Object createInventory(int size, String title);
    void setItem(Object inventory, int rawSlot, Object platformItem);
    void open(Object playerHandle, Object inventory);
}
