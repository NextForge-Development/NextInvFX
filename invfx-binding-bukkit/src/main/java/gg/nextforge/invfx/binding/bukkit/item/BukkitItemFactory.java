package gg.nextforge.invfx.binding.bukkit.item;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.item.impl.RichItemDescriptor;
import gg.nextforge.invfx.spi.ItemFactory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class BukkitItemFactory implements ItemFactory {

    @Override
    public Object toPlatformItem(ItemDescriptor descriptor) {
        if (descriptor == null) return null;

        // Already a Bukkit item?
        if (descriptor instanceof BukkitItemDescriptor b) {
            return b.asBukkit();
        }

        if (descriptor instanceof RichItemDescriptor rich) {
            Material mat = Material.matchMaterial(rich.getMaterial());
            if (mat == null) mat = Material.BARRIER;
            ItemStack is = new ItemStack(mat);
            ItemMeta meta = is.getItemMeta();
            if (meta != null) {
                if (rich.getDisplayName() != null)
                    meta.displayName(rich.getDisplayName()); // Adventure API
                if (rich.getLore() != null && !rich.getLore().isEmpty())
                    meta.lore(rich.getLore()); // Adventure API list
                if (rich.isGlowing()) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                is.setItemMeta(meta);
            }
            return is;
        }

        // Last resort: assume the raw platform item is returned by descriptor
        Object raw = descriptor.getItemStack();
        if (raw instanceof ItemStack) return raw;

        // Unknown input → BARRIER as visible fallback
        return new ItemStack(Material.BARRIER);
    }
}
