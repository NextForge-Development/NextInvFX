package gg.nextforge.invfx.binding.bukkit.item;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.item.ItemProvider;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class BukkitItemProvider implements ItemProvider {

    @Override
    public ItemDescriptor fromPlatformItem(Object platformItem) {
        return new BukkitItemDescriptor((ItemStack) platformItem);
    }

    @Override
    public ItemDescriptor simple(String material, Component name, List<Component> lore, boolean glow) {
        Material mat = Material.matchMaterial(material);
        if (mat == null) mat = Material.BARRIER;
        ItemStack is = new ItemStack(mat);
        ItemMeta meta = is.getItemMeta();
        if (meta != null) {
            meta.displayName(name);
            if (!lore.isEmpty()) meta.lore(lore);
            if (glow) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            is.setItemMeta(meta);
        }
        return new BukkitItemDescriptor(is);
    }
}
