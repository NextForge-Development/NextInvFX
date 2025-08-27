package gg.nextforge.invfx.api.layout;

import lombok.Value;

import java.util.List;

/**
 * Declarative layout description (e.g., list of strings).
 * Parsing/interpretation is up to the implementation layer.
 */
@Value
public class LayoutSpec {
    List<String> rows;
}
