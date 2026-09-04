import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * StatCard.java
 * ---------------------------------------------------------
 * One reusable "stat card" — the small white boxes on the
 * Dashboard page that show a title, a big value, a subtitle,
 * and a colored tag (e.g. "CGPA" / "8.64" / "out of 10.00").
 * Building this once as its own class means the four cards
 * on the dashboard are each a single line of code to create.
 * ---------------------------------------------------------
 */
public class StatCard extends RoundedPanel {

    public StatCard(String title, String tagText, Color tagBackground, Color tagForeground,
                     Component centerContent, String subtitle) {
        super(UITheme.RADIUS, UITheme.CARD_BG, UITheme.BORDER);
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createEmptyBorder(16, 18, 16, 18));

        // ----- Top row: title + tag -----
        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(UITheme.bodyBold(13));
        titleLabel.setForeground(UITheme.TEXT_MUTED);
        topRow.add(titleLabel, BorderLayout.WEST);

        PillLabel tag = new PillLabel(tagText, tagBackground, tagForeground);
        JPanel tagWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        tagWrap.setOpaque(false);
        tagWrap.add(tag);
        topRow.add(tagWrap, BorderLayout.EAST);

        add(topRow, BorderLayout.NORTH);

        // ----- Center: the big number or the attendance ring -----
        JPanel centerWrap = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 4));
        centerWrap.setOpaque(false);
        centerWrap.add(centerContent);
        add(centerWrap, BorderLayout.CENTER);

        // ----- Bottom: subtitle -----
        if (subtitle != null) {
            JLabel subtitleLabel = new JLabel(subtitle, JLabel.CENTER);
            subtitleLabel.setFont(UITheme.body(12));
            subtitleLabel.setForeground(UITheme.TEXT_MUTED);
            add(subtitleLabel, BorderLayout.SOUTH);
        }
    }

    /** Convenience factory for cards that just show a big number, e.g. CGPA. */
    public static StatCard withBigNumber(String title, String value, String tagText,
                                          Color tagBackground, Color tagForeground, String subtitle) {
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(UITheme.heading(32));
        valueLabel.setForeground(UITheme.TEXT);
        return new StatCard(title, tagText, tagBackground, tagForeground, valueLabel, subtitle);
    }
}
