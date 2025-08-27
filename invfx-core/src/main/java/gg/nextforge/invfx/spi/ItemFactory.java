package gg.nextforge.invfx.spi;

import gg.nextforge.invfx.api.item.ItemDescriptor;

/** Converts descriptors to platform items. */
public interface ItemFactory {
    Object toPlatformItem(ItemDescriptor descriptor);
}
