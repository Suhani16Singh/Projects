import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * RoundedPanel.java
 * ---------------------------------------------------------
 * A JPanel with rounded corners and an optional border,
 * used everywhere a "card" appears on the dashboard (stat
 * cards, list containers, the profile card, etc). Plain Swing
 * panels are always rectangular, so this small class draws
 * the rounded background itself instead of pulling in a UI
 * framework just for card styling.
 * ---------------------------------------------------------
 */
public class RoundedPanel extends JPanel {

    private final int cornerRadius;
    private final Color backgroundColor;
    private final Color borderColor;

    public RoundedPanel(int cornerRadius, Color backgroundColor, Color borderColor) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        setOpaque(false); // we paint the background ourselves
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        if (borderColor != null) {
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }

        g2.dispose();
        super.paintComponent(g);
    }
}
