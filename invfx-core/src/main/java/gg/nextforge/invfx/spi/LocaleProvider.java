package gg.nextforge.invfx.spi;

import java.util.Locale;

/** Provide a locale for a platform actor (player). */
public interface LocaleProvider {
    Locale localeOf(Object actor);
}
