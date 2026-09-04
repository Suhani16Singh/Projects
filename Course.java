/**
 * Course.java
 * ---------------------------------------------------------
 * Plain data model for a single enrolled course: its code
 * (e.g. "CS501"), full name, and instructor. Used by the
 * Courses page and by the course count on the Dashboard page.
 * ---------------------------------------------------------
 */
public class Course {

    private final String code;
    private final String name;
    private final String instructor;

    public Course(String code, String name, String instructor) {
        this.code = code;
        this.name = name;
        this.instructor = instructor;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getInstructor() { return instructor; }
}
