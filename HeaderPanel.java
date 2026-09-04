import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * HeaderPanel.java
 * ---------------------------------------------------------
 * The strip at the top of the main content area. It shows
 * the current page name, a welcome message with the student's
 * name, and a rounded tag with roll number + semester. This
 * is the one place on screen where the student's identity is
 * always visible, no matter which page is open.
 * ---------------------------------------------------------
 */
public class HeaderPanel extends JPanel {

    private final JLabel pageTitleLabel;
    private final JLabel welcomeLabel;

    public HeaderPanel(Student student) {
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 0, 22, 0));

        // Left side: eyebrow page label + welcome heading
        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new javax.swing.BoxLayout(left, javax.swing.BoxLayout.Y_AXIS));

        pageTitleLabel = new JLabel("Dashboard");
        pageTitleLabel.setFont(UITheme.body(13));
        pageTitleLabel.setForeground(UITheme.TEXT_MUTED);
        pageTitleLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        welcomeLabel = new JLabel("Welcome back, " + student.getName());
        welcomeLabel.setFont(UITheme.heading(24));
        welcomeLabel.setForeground(UITheme.TEXT);
        welcomeLabel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        left.add(pageTitleLabel);
        left.add(javax.swing.Box.createVerticalStrut(4));
        left.add(welcomeLabel);

        add(left, BorderLayout.WEST);

        // Right side: roll number + semester tag
        JLabel tag = new JLabel(student.getRollNumber() + "  \u00B7  " + student.getSemester());
        tag.setFont(UITheme.bodyBold(13));
        tag.setForeground(UITheme.TEXT_MUTED);
        tag.setOpaque(false);
        tag.setBorder(BorderFactory.createCompoundBorder(
                new RoundedLineBorder(UITheme.BORDER, 100),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        right.setOpaque(false);
        right.add(tag);
        add(right, BorderLayout.EAST);
    }

    /** Updates the small "Dashboard / Courses / ..." label when the page changes. */
    public void setPageTitle(String title) {
        pageTitleLabel.setText(title);
    }
}
