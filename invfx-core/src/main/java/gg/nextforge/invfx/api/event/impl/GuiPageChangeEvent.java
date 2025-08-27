package gg.nextforge.invfx.api.event.impl;

import gg.nextforge.invfx.api.view.View;
import lombok.Value;

@Value
public class GuiPageChangeEvent {
    Object actor;
    View view;
    int oldPage;
    int newPage;
}