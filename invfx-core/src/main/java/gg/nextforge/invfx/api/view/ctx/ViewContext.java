package gg.nextforge.invfx.api.view.ctx;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.action.ClickAction;
import lombok.NonNull;

public interface ViewContext {

    void set(@NonNull SlotRef slot, @NonNull ItemDescriptor item, ClickAction onClick);

    ItemDescriptor get(@NonNull SlotRef slot);

    default void set(int row, int col, @NonNull ItemDescriptor item, ClickAction onClick) {
        set(new SlotRef(row, col), item, onClick);
    }
}
