import javax.swing.border.AbstractBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

/**
 * RoundedLineBorder.java
 * ---------------------------------------------------------
 * A thin rounded border used to draw pill-shaped tags, such
 * as the "roll number · semester" tag in the header and the
 * status pills on assignments. Swing's built-in borders can
 * only draw plain rectangles, so this class fills that gap.
 * ---------------------------------------------------------
 */
public class RoundedLineBorder extends AbstractBorder {

    private final Color color;
    private final int cornerRadius;

    public RoundedLineBorder(Color color, int cornerRadius) {
        this.color = color;
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.drawRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(1, 1, 1, 1);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(1, 1, 1, 1);
        return insets;
    }
}
