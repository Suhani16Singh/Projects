import java.util.List;

/**
 * SampleData.java
 * ---------------------------------------------------------
 * Builds one Student object filled with realistic sample
 * values, so the dashboard has something to display without
 * needing a database or a file to read from. In a real
 * application this class would be replaced by code that
 * loads the same information from a database, file, or API —
 * every other class in the project would stay unchanged.
 * ---------------------------------------------------------
 */
public final class SampleData {

    private SampleData() { }

    public static Student buildStudent() {
        List<Course> courses = List.of(
                new Course("CS501", "Operating Systems", "Dr. R. Menon"),
                new Course("CS502", "Computer Networks", "Prof. S. Iyer"),
                new Course("CS503", "Database Systems", "Dr. A. Kulkarni"),
                new Course("CS504", "Software Engineering", "Prof. N. Rao"),
                new Course("CS505", "Theory of Computation", "Dr. P. Verma"),
                new Course("HS301", "Technical Communication", "Ms. K. Bose")
        );

        List<Assignment> assignments = List.of(
                new Assignment("Process Scheduling Report", "Operating Systems", "3 Sep 2026", Assignment.Status.DUE_SOON),
                new Assignment("Normalization Worksheet", "Database Systems", "5 Sep 2026", Assignment.Status.DUE_SOON),
                new Assignment("Socket Programming Lab", "Computer Networks", "10 Sep 2026", Assignment.Status.UPCOMING),
                new Assignment("Requirements Document", "Software Engineering", "14 Sep 2026", Assignment.Status.UPCOMING),
                new Assignment("Automata Problem Set", "Theory of Computation", "28 Aug 2026", Assignment.Status.SUBMITTED)
        );

        return new Student(
                "Aditi Sharma",
                "21CSE1042",
                "5th Semester",
                "B.Tech, Computer Science & Engineering",
                "Dr. R. Menon",
                "aditi.sharma@college.edu",
                87.0,
                8.64,
                courses,
                assignments
        );
    }
}
