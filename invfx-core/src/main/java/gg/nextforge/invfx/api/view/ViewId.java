package gg.nextforge.invfx.api.view;

import lombok.NonNull;
import lombok.Value;

@Value
public class ViewId {
    @NonNull String value;

    @Override public String toString() { return value; }
}
