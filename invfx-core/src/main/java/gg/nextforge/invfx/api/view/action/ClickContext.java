package gg.nextforge.invfx.api.view.action;

import gg.nextforge.invfx.api.types.ClickTypeEx;
import gg.nextforge.invfx.api.types.SlotRef;
import lombok.Builder;
import lombok.Value;

/**
 * Platform-agnostic click context. 'actor' is a platform object (e.g., Player),
 * exposed as Object to keep the API shadable and decoupled.
 */
@Value
@Builder
public class ClickContext {
    Object actor;                  // nullable
    SlotRef slot;
    ClickTypeEx type;
    int hotbarButton;              // 0 if N/A
}
