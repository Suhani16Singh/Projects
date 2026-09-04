import java.util.List;

/**
 * Student.java
 * ---------------------------------------------------------
 * Plain data model that holds everything the dashboard needs
 * to know about the logged-in student: identity fields
 * (name, roll number, semester), academic stats (attendance,
 * CGPA), and the lists of courses and assignments.
 *
 * This class has no UI code in it at all — it only stores
 * and hands back data, which keeps the "what data looks like"
 * separate from "how it is displayed".
 * ---------------------------------------------------------
 */
public class Student {

    private final String name;
    private final String rollNumber;
    private final String semester;
    private final String program;
    private final String advisor;
    private final String email;

    private final double attendancePercent;
    private final double cgpa;

    private final List<Course> courses;
    private final List<Assignment> assignments;

    public Student(String name, String rollNumber, String semester, String program,
                   String advisor, String email, double attendancePercent, double cgpa,
                   List<Course> courses, List<Assignment> assignments) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.semester = semester;
        this.program = program;
        this.advisor = advisor;
        this.email = email;
        this.attendancePercent = attendancePercent;
        this.cgpa = cgpa;
        this.courses = courses;
        this.assignments = assignments;
    }

    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getSemester() { return semester; }
    public String getProgram() { return program; }
    public String getAdvisor() { return advisor; }
    public String getEmail() { return email; }
    public double getAttendancePercent() { return attendancePercent; }
    public double getCgpa() { return cgpa; }
    public List<Course> getCourses() { return courses; }
    public List<Assignment> getAssignments() { return assignments; }

    /** Number of assignments that are not yet submitted. */
    public long getPendingAssignmentCount() {
        return assignments.stream()
                .filter(a -> a.getStatus() != Assignment.Status.SUBMITTED)
                .count();
    }

    /** Number of assignments due within the next few days. */
    public long getDueSoonCount() {
        return assignments.stream()
                .filter(a -> a.getStatus() == Assignment.Status.DUE_SOON)
                .count();
    }
}
