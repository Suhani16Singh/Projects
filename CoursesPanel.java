import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * CoursesPanel.java
 * ---------------------------------------------------------
 * The "Courses" page: a card containing a grid of every
 * course the student is enrolled in, each showing its name,
 * instructor, and course code.
 * ---------------------------------------------------------
 */
public class CoursesPanel extends JPanel {

    public CoursesPanel(Student student) {
        setOpaque(false);
        setLayout(new BorderLayout());

        RoundedPanel card = new RoundedPanel(UITheme.RADIUS, UITheme.CARD_BG, UITheme.BORDER);
        card.setLayout(new BorderLayout(0, 14));
        card.setBorder(BorderFactory.createEmptyBorder(18, 20, 18, 20));

        JLabel title = new JLabel("Enrolled courses");
        title.setFont(UITheme.bodyBold(16));
        title.setForeground(UITheme.TEXT);
        card.add(title, BorderLayout.NORTH);

        int rows = (int) Math.ceil(student.getCourses().size() / 2.0);
        JPanel grid = new JPanel(new GridLayout(rows, 2, 14, 14));
        grid.setOpaque(false);
        for (Course course : student.getCourses()) {
            grid.add(buildCourseTile(course));
        }
        card.add(grid, BorderLayout.CENTER);

        add(card, BorderLayout.CENTER);
    }

    private RoundedPanel buildCourseTile(Course course) {
        RoundedPanel tile = new RoundedPanel(8, UITheme.CARD_BG, UITheme.BORDER);
        tile.setLayout(new javax.swing.BoxLayout(tile, javax.swing.BoxLayout.Y_AXIS));
        tile.setBorder(BorderFactory.createEmptyBorder(14, 16, 14, 16));

        JLabel name = new JLabel(course.getName());
        name.setFont(UITheme.bodyBold(15));
        name.setForeground(UITheme.TEXT);
        name.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        JLabel instructor = new JLabel(course.getInstructor());
        instructor.setFont(UITheme.body(12));
        instructor.setForeground(UITheme.TEXT_MUTED);
        instructor.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        PillLabel code = new PillLabel(course.getCode(), UITheme.ACCENT_SOFT, UITheme.ACCENT);
        code.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        tile.add(name);
        tile.add(javax.swing.Box.createVerticalStrut(4));
        tile.add(instructor);
        tile.add(javax.swing.Box.createVerticalStrut(10));

        JPanel codeWrap = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        codeWrap.setOpaque(false);
        codeWrap.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        codeWrap.add(code);
        tile.add(codeWrap);

        return tile;
    }
}
