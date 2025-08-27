package gg.nextforge.invfx.binding.bukkit.item;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.item.ItemProvider;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class BukkitItemProvider implements ItemProvider {

    @Override
    public ItemDescriptor fromPlatformItem(Object platformItem) {
        return new BukkitItemDescriptor((ItemStack) platformItem);
    }

    @Override
    public ItemDescriptor simple(String material, String name, List<String> lore, boolean glow) {
        Material mat = Material.matchMaterial(material);
        if (mat == null) mat = Material.BARRIER;
        ItemStack is = new ItemStack(mat);
        ItemMeta meta = is.getItemMeta();
        if (meta != null) {
            if (name != null) meta.setDisplayName(name);
            if (lore != null && !lore.isEmpty()) meta.setLore(lore);
            is.setItemMeta(meta);
        }
        return new BukkitItemDescriptor(is);
    }
}
