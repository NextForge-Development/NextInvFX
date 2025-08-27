package gg.nextforge.invfx.api.view.ctx;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.SlotRef;

public interface ViewContext {
    void set(SlotRef slot, ItemDescriptor item, Runnable onClick);
    ItemDescriptor get(SlotRef slot);
}