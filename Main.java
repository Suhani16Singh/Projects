import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Main.java
 * ---------------------------------------------------------
 * The application's entry point. Its only job is to set a
 * clean platform look-and-feel, build the sample student
 * data, and hand off to DashboardFrame on Swing's event
 * dispatch thread (the thread Swing requires all UI work to
 * happen on).
 *
 * To run: compile every .java file in this folder, then run
 * this class.
 *
 *     javac *.java
 *     java Main
 * ---------------------------------------------------------
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // If the system look-and-feel isn't available, Swing's default is fine.
        }

        SwingUtilities.invokeLater(() -> {
            Student student = SampleData.buildStudent();
            DashboardFrame frame = new DashboardFrame(student);
            frame.setVisible(true);
        });
    }
}
