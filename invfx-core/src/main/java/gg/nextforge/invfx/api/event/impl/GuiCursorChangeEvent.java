package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiCursorChangeEvent {
    Object actor;
    View view;
    ItemDescriptor previous;
    ItemDescriptor current;
}
