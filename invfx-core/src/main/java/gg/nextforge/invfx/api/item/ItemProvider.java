package gg.nextforge.invfx.api.item;

import java.util.List;

/**
 * Factory for creating ItemDescriptors without exposing platform types.
 * Implemented by bindings or your core-impl.
 */
public interface ItemProvider {
    ItemDescriptor fromPlatformItem(Object platformItem);
    ItemDescriptor simple(String material, String name, List<String> lore, boolean glow);

    default ItemDescriptor simple(String material, String name) {
        return simple(material, name, List.of(), false);
    }
}
