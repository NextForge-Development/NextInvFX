package gg.nextforge.invfx.api.view.action;

import java.util.function.Consumer;

@FunctionalInterface
public interface ClickAction {
    void onClick(ClickContext ctx);

    ClickAction NONE = ctx -> {

    };

    static ClickAction of(Consumer<ClickContext> consumer) {
        return consumer::accept;
    }


}
