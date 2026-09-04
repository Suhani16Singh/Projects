import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * AssignmentRow.java
 * ---------------------------------------------------------
 * Builds one row describing a single assignment: its title
 * and course/due-date on the left, its status pill on the
 * right. Used both in the "Upcoming assignments" list on the
 * Dashboard page and in the full Assignments page, so the
 * layout is written once here instead of twice.
 * ---------------------------------------------------------
 */
public final class AssignmentRow {

    private AssignmentRow() { }

    public static JPanel build(Assignment assignment) {
        RoundedPanel row = new RoundedPanel(8, UITheme.CARD_BG, UITheme.BORDER);
        row.setLayout(new BorderLayout());
        row.setBorder(BorderFactory.createEmptyBorder(10, 12, 10, 12));

        JPanel textBlock = new JPanel();
        textBlock.setOpaque(false);
        textBlock.setLayout(new javax.swing.BoxLayout(textBlock, javax.swing.BoxLayout.Y_AXIS));

        JLabel title = new JLabel(assignment.getTitle());
        title.setFont(UITheme.bodyBold(13));
        title.setForeground(UITheme.TEXT);
        title.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        JLabel meta = new JLabel(assignment.getCourseName() + "  \u00B7  Due " + assignment.getDueDate());
        meta.setFont(UITheme.body(12));
        meta.setForeground(UITheme.TEXT_MUTED);
        meta.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        textBlock.add(title);
        textBlock.add(meta);
        row.add(textBlock, BorderLayout.WEST);

        PillLabel pill = new PillLabel(
                assignment.getStatus().getLabel(),
                assignment.getStatus().getBackground(),
                assignment.getStatus().getForeground());
        JPanel pillWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        pillWrap.setOpaque(false);
        pillWrap.add(pill);
        row.add(pillWrap, BorderLayout.EAST);

        // Keep rows from stretching to full card height inside a BoxLayout
        row.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 56));
        row.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        return row;
    }
}
