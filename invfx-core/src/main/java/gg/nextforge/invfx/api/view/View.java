package gg.nextforge.invfx.api.view;

import gg.nextforge.invfx.api.view.ctx.ViewContext;
import lombok.NonNull;

public interface View {
    int rows();            // 1..6 for chest-like
    int cols();            // usually 9
    void render(@NonNull ViewContext ctx);
    default boolean unclosable() { return false; }
}
