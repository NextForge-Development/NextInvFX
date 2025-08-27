package gg.nextforge.invfx.api.item;

import net.kyori.adventure.text.Component;

import java.util.List;

public interface ItemProvider {
    ItemDescriptor fromPlatformItem(Object platformItem);
    ItemDescriptor simple(String material, Component name, List<Component> lore, boolean glow);

    default ItemDescriptor simple(String material, Component name) {
        return simple(material, name, List.of(), false);
    }
}
