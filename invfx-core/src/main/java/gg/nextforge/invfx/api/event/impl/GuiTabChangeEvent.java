package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiTabChangeEvent {
    Object actor;
    View view;
    int oldTab;
    int newTab;
}
