package gg.nextforge.invfx.api.event;

import gg.nextforge.invfx.api.view.View;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class GuiEvent {
    Object actor; // platform-specific (e.g., Player) or null
    View view;
}
