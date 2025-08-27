package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.ClickTypeEx;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiClickEvent {
    Object actor;
    View view;
    SlotRef slot;
    ClickTypeEx type;
    ItemDescriptor item;
    int hotbarButton;
}
