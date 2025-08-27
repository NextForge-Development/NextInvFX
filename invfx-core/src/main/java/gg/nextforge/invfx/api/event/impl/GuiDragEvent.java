package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import lombok.Value;

import java.util.Set;

@Value
public class GuiDragEvent {
    Object actor;
    View view;
    Set<SlotRef> affectedSlots;
    ItemDescriptor item;
}