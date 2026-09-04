/**
 * Assignment.java
 * ---------------------------------------------------------
 * Plain data model for a single assignment: its title, the
 * course it belongs to, the due date, and a status (upcoming,
 * due soon, or submitted). The Status enum also carries the
 * label and color used to draw its status pill, so the UI
 * code that renders assignments never has to guess a color.
 * ---------------------------------------------------------
 */
import java.awt.Color;

public class Assignment {

    /** Lifecycle state of an assignment, with its own display label and color. */
    public enum Status {
        UPCOMING("Upcoming", new Color(0xEE, 0xF0, 0xF6), new Color(0x6B, 0x72, 0x80)),
        DUE_SOON("Due soon", new Color(0xF6, 0xEB, 0xDA), new Color(0xB5, 0x72, 0x1B)),
        SUBMITTED("Submitted", new Color(0xE3, 0xEE, 0xE7), new Color(0x2F, 0x6F, 0x4E));

        private final String label;
        private final Color background;
        private final Color foreground;

        Status(String label, Color background, Color foreground) {
            this.label = label;
            this.background = background;
            this.foreground = foreground;
        }

        public String getLabel() { return label; }
        public Color getBackground() { return background; }
        public Color getForeground() { return foreground; }
    }

    private final String title;
    private final String courseName;
    private final String dueDate;
    private final Status status;

    public Assignment(String title, String courseName, String dueDate, Status status) {
        this.title = title;
        this.courseName = courseName;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getCourseName() { return courseName; }
    public String getDueDate() { return dueDate; }
    public Status getStatus() { return status; }
}
