import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * AttendanceRing.java
 * ---------------------------------------------------------
 * A small circular progress indicator, used on the Dashboard
 * page to show attendance percentage at a glance. It draws a
 * light gray track circle and a colored arc on top of it,
 * with the percentage printed in the middle.
 * ---------------------------------------------------------
 */
public class AttendanceRing extends JPanel {

    private final double percent; // 0–100

    public AttendanceRing(double percent) {
        this.percent = percent;
        setOpaque(false);
        setPreferredSize(new Dimension(110, 110));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int strokeWidth = 10;
        int size = Math.min(getWidth(), getHeight()) - strokeWidth;
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;

        // Background track
        g2.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setColor(UITheme.TRACK);
        g2.drawOval(x, y, size, size);

        // Progress arc — starts at 90 degrees (top) and sweeps clockwise
        Color arcColor = percent >= 75 ? UITheme.ACCENT : new Color(0xB5, 0x72, 0x1B);
        g2.setColor(arcColor);
        double angle = 360.0 * (percent / 100.0);
        g2.drawArc(x, y, size, size, 90, -(int) Math.round(angle));

        // Percentage label in the center
        String label = Math.round(percent) + "%";
        g2.setColor(UITheme.TEXT);
        g2.setFont(UITheme.heading(20));
        FontMetrics fm = g2.getFontMetrics();
        int textX = (getWidth() - fm.stringWidth(label)) / 2;
        int textY = (getHeight() + fm.getAscent()) / 2 - 4;
        g2.drawString(label, textX, textY);

        g2.dispose();
    }
}
