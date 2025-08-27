package gg.nextforge.invfx.extras.views;

import gg.nextforge.invfx.api.item.ItemProvider;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.api.view.action.ClickAction;
import gg.nextforge.invfx.api.view.ctx.ViewContext;
import net.kyori.adventure.text.Component;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Generische Chest-View (rows x 9), 1..6 Reihen.
 * Übergib einen "onRender" Callback, der Slots füllt.
 */
public final class SimpleView implements View {
    private final int rows;
    private final ItemProvider items;
    private final BiConsumer<ViewContext, ItemProvider> onRender;

    public SimpleView(int rows, ItemProvider items, BiConsumer<ViewContext, ItemProvider> onRender) {
        if (rows < 1 || rows > 6) throw new IllegalArgumentException("rows must be 1..6");
        this.rows = rows;
        this.items = Objects.requireNonNull(items);
        this.onRender = Objects.requireNonNull(onRender);
    }

    @Override public int rows() { return rows; }
    @Override public int cols() { return 9; }

    @Override
    public void render(ViewContext ctx) {
        onRender.accept(ctx, items);
    }

    /** Convenience: set a label item at (row,col) with optional click */
    public static void set(ViewContext ctx, ItemProvider items, int row, int col,
                           String material, Component name, ClickAction onClick) {
        ctx.set(new SlotRef(row, col), items.simple(material, name), onClick);
    }
}