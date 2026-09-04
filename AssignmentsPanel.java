import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

/**
 * AssignmentsPanel.java
 * ---------------------------------------------------------
 * The "Assignments" page: a card listing every assignment
 * for the semester (not just the pending ones shown on the
 * Dashboard page), each with its course, due date, and a
 * status pill. Reuses AssignmentRow so each row looks exactly
 * like the ones on the Dashboard page's upcoming list.
 * ---------------------------------------------------------
 */
public class AssignmentsPanel extends JPanel {

    public AssignmentsPanel(Student student) {
        setOpaque(false);
        setLayout(new BorderLayout());

        RoundedPanel card = new RoundedPanel(UITheme.RADIUS, UITheme.CARD_BG, UITheme.BORDER);
        card.setLayout(new BorderLayout(0, 14));
        card.setBorder(BorderFactory.createEmptyBorder(18, 20, 18, 20));

        JLabel title = new JLabel("All assignments");
        title.setFont(UITheme.bodyBold(16));
        title.setForeground(UITheme.TEXT);
        card.add(title, BorderLayout.NORTH);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));

        var assignments = student.getAssignments();
        for (int i = 0; i < assignments.size(); i++) {
            list.add(AssignmentRow.build(assignments.get(i)));
            if (i < assignments.size() - 1) {
                list.add(javax.swing.Box.createVerticalStrut(8));
            }
        }

        JScrollPane scroll = new JScrollPane(list);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.getVerticalScrollBar().setUnitIncrement(14);
        card.add(scroll, BorderLayout.CENTER);

        add(card, BorderLayout.CENTER);
    }
}
