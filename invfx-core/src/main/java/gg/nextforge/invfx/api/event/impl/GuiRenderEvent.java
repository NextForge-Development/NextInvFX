package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiRenderEvent {
    Object actor;
    View view;
}