package gg.nextforge.invfx.binding.bukkit.item;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import org.bukkit.inventory.ItemStack;

public final class BukkitItemDescriptor implements ItemDescriptor {
    private final ItemStack delegate;

    public BukkitItemDescriptor(ItemStack delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object getItemStack() {
        return delegate;
    }

    public ItemStack asBukkit() {
        return delegate;
    }
}
