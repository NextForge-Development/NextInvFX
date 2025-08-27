package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.types.CloseReason;
import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiCloseEvent {
    Object actor;
    View view;
    CloseReason reason;
}