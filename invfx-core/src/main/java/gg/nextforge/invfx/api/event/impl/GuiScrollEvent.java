package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiScrollEvent {
    Object actor;
    View view;
    int delta; // positive = down/right, negative = up/left
}
