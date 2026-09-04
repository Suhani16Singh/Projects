import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * PillLabel.java
 * ---------------------------------------------------------
 * A small filled, rounded label used for status tags like
 * "Due soon" or "Submitted" on the Assignments page. It is
 * a JLabel that paints its own rounded background before the
 * text is drawn on top.
 * ---------------------------------------------------------
 */
public class PillLabel extends JLabel {

    private final Color background;

    public PillLabel(String text, Color background, Color foreground) {
        super(text, CENTER);
        this.background = background;
        setForeground(foreground);
        setFont(UITheme.bodyBold(11));
        setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(background);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }
}
