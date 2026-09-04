import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

/**
 * DashboardPanel.java
 * ---------------------------------------------------------
 * The "Dashboard" page: a row of four stat cards (Attendance,
 * CGPA, Assignments, Courses) followed by a short list of
 * the student's next few pending assignments. This class only
 * arranges components built elsewhere (StatCard, AttendanceRing,
 * PillLabel) — it does not define how any of them look.
 * ---------------------------------------------------------
 */
public class DashboardPanel extends JPanel {

    public DashboardPanel(Student student) {
        setOpaque(false);
        setLayout(new BorderLayout(0, 18));

        add(buildStatGrid(student), BorderLayout.NORTH);
        add(buildUpcomingCard(student), BorderLayout.CENTER);
    }

    private JPanel buildStatGrid(Student student) {
        JPanel grid = new JPanel(new GridLayout(1, 4, 16, 0));
        grid.setOpaque(false);

        // Attendance card uses the circular ring as its center content
        StatCard attendanceCard = new StatCard(
                "Attendance",
                student.getAttendancePercent() >= 75 ? "On track" : "Below 75%",
                student.getAttendancePercent() >= 75 ? UITheme.ACCENT_SOFT : new Color(0xF6, 0xEB, 0xDA),
                student.getAttendancePercent() >= 75 ? UITheme.ACCENT : new Color(0xB5, 0x72, 0x1B),
                new AttendanceRing(student.getAttendancePercent()),
                "present this semester");

        StatCard cgpaCard = StatCard.withBigNumber(
                "CGPA",
                String.format("%.2f", student.getCgpa()),
                "Good standing",
                UITheme.ACCENT_SOFT, UITheme.ACCENT,
                "out of 10.00");

        long pending = student.getPendingAssignmentCount();
        long dueSoon = student.getDueSoonCount();
        StatCard assignmentsCard = StatCard.withBigNumber(
                "Assignments",
                String.valueOf(pending),
                dueSoon + " due soon",
                new Color(0xF6, 0xEB, 0xDA), new Color(0xB5, 0x72, 0x1B),
                "pending out of " + student.getAssignments().size());

        StatCard coursesCard = StatCard.withBigNumber(
                "Courses",
                String.valueOf(student.getCourses().size()),
                student.getSemester(),
                new Color(0xEE, 0xF0, 0xF6), UITheme.TEXT_MUTED,
                "enrolled this semester");

        grid.add(attendanceCard);
        grid.add(cgpaCard);
        grid.add(assignmentsCard);
        grid.add(coursesCard);
        return grid;
    }

    private RoundedPanel buildUpcomingCard(Student student) {
        RoundedPanel card = new RoundedPanel(UITheme.RADIUS, UITheme.CARD_BG, UITheme.BORDER);
        card.setLayout(new BorderLayout(0, 12));
        card.setBorder(BorderFactory.createEmptyBorder(18, 20, 18, 20));

        JLabel title = new JLabel("Upcoming assignments");
        title.setFont(UITheme.bodyBold(16));
        title.setForeground(UITheme.TEXT);
        card.add(title, BorderLayout.NORTH);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new javax.swing.BoxLayout(list, javax.swing.BoxLayout.Y_AXIS));

        List<Assignment> pending = student.getAssignments().stream()
                .filter(a -> a.getStatus() != Assignment.Status.SUBMITTED)
                .toList();

        for (int i = 0; i < pending.size(); i++) {
            list.add(AssignmentRow.build(pending.get(i)));
            if (i < pending.size() - 1) {
                list.add(javax.swing.Box.createVerticalStrut(8));
            }
        }

        card.add(list, BorderLayout.CENTER);
        return card;
    }
}
