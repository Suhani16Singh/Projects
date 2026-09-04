import java.awt.Color;
import java.awt.Font;

/**
 * UITheme.java
 * ---------------------------------------------------------
 * Central place for every color and font used across the
 * dashboard. Every panel reads its styling from here instead
 * of hard-coding values, so the whole look can be changed by
 * editing one file. This is the Java equivalent of the CSS
 * variables in a web stylesheet.
 * ---------------------------------------------------------
 */
public final class UITheme {

    private UITheme() { } // constants only, never instantiated

    // ----- Palette -----
    public static final Color BACKGROUND   = new Color(0xF5, 0xF6, 0xFA);
    public static final Color SIDEBAR      = new Color(0x16, 0x21, 0x3E);
    public static final Color SIDEBAR_TEXT = new Color(0xAE, 0xB8, 0xDA);
    public static final Color SIDEBAR_TEXT_ACTIVE = Color.WHITE;
    public static final Color ACCENT       = new Color(0x2F, 0x6F, 0x4E);
    public static final Color ACCENT_SOFT  = new Color(0xE3, 0xEE, 0xE7);
    public static final Color CARD_BG      = Color.WHITE;
    public static final Color BORDER       = new Color(0xE4, 0xE6, 0xEF);
    public static final Color TEXT         = new Color(0x1B, 0x20, 0x33);
    public static final Color TEXT_MUTED   = new Color(0x6B, 0x72, 0x80);
    public static final Color TRACK        = new Color(0xEE, 0xF0, 0xF6);

    // ----- Typography -----
    // Java Swing does not ship the web fonts used elsewhere in this project
    // (Lora / Inter), so we fall back to a clean system font that renders
    // well on Windows, macOS and Linux alike.
    private static final String FONT_FAMILY = "Segoe UI";

    public static Font heading(int size) {
        return new Font(FONT_FAMILY, Font.BOLD, size);
    }

    public static Font body(int size) {
        return new Font(FONT_FAMILY, Font.PLAIN, size);
    }

    public static Font bodyBold(int size) {
        return new Font(FONT_FAMILY, Font.BOLD, size);
    }

    // ----- Layout constants -----
    public static final int RADIUS = 12;
    public static final int SIDEBAR_WIDTH = 220;
}
