package gg.nextforge.invfx.api.layout;

import gg.nextforge.invfx.api.types.SlotRef;

public interface Layout {
    int rows();
    int cols();
    LayoutSlotRole roleAt(SlotRef slot);
}
