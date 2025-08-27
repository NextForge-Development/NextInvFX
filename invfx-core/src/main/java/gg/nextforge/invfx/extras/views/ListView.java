package gg.nextforge.invfx.extras.views;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.item.ItemProvider;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.api.view.ctx.ViewContext;
import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public final class ListView<T> implements View {
    private final List<T> data;
    private final ItemProvider items;
    private final int contentRows;         // e.g. 5 (rows 0..4), row 5 can be footer
    private final Consumer<T> onSelect;
    private final java.util.function.Function<T, Component> label;

    public ListView(
            List<T> data,
            ItemProvider items,
            int contentRows,
            java.util.function.Function<T, Component> label,
            Consumer<T> onSelect
    ) {
        this.data = List.copyOf(Objects.requireNonNull(data, "data"));
        this.items = Objects.requireNonNull(items, "items");
        this.contentRows = contentRows <= 0 ? 5 : contentRows;
        this.label = Objects.requireNonNull(label, "label");
        this.onSelect = Objects.requireNonNull(onSelect, "onSelect");
    }

    @Override public int rows() { return Math.max(1, contentRows + 1); } // +1 optional footer row
    @Override public int cols() { return 9; }

    @Override
    public void render(ViewContext ctx) {
        int max = Math.min(data.size(), contentRows * 9);
        for (int i = 0; i < max; i++) {
            int r = i / 9, c = i % 9;
            T value = data.get(i);
            ItemDescriptor it = items.simple("PAPER", label.apply(value), List.of(), false);
            ctx.set(new SlotRef(r, c), it, click -> onSelect.accept(value));
        }
        // Optional footer hint
        var hint = items.simple("BOOK", Component.text("Select an item"), List.of(), false);
        ctx.set(new SlotRef(rows() - 1, 4), hint, null);
    }
}
