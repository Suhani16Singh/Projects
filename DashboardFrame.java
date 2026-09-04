import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

/**
 * DashboardFrame.java
 * ---------------------------------------------------------
 * The main application window. It assembles the three big
 * pieces of the UI — Sidebar, HeaderPanel, and the page
 * content area — and owns the CardLayout that switches
 * between the Dashboard / Courses / Assignments / Profile
 * pages when a sidebar button is clicked.
 * ---------------------------------------------------------
 */
public class DashboardFrame extends JFrame {

    private static final java.util.Map<String, String> PAGE_TITLES = java.util.Map.of(
            "dashboard", "Dashboard",
            "courses", "Courses",
            "assignments", "Assignments",
            "profile", "Profile"
    );

    public DashboardFrame(Student student) {
        super("Academix — Student Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 600));
        setSize(1180, 760);
        setLocationRelativeTo(null);
        getContentPane().setBackground(UITheme.BACKGROUND);
        setLayout(new BorderLayout());

        // ----- Content area with CardLayout (one card per page) -----
        CardLayout cardLayout = new CardLayout();
        JPanel pages = new JPanel(cardLayout);
        pages.setOpaque(false);
        pages.add(new DashboardPanel(student), "dashboard");
        pages.add(new CoursesPanel(student), "courses");
        pages.add(new AssignmentsPanel(student), "assignments");
        pages.add(new ProfilePanel(student), "profile");

        // ----- Header sits above the page content, inside a padded wrapper -----
        HeaderPanel header = new HeaderPanel(student);

        JPanel mainArea = new JPanel(new BorderLayout());
        mainArea.setOpaque(false);
        mainArea.setBorder(BorderFactory.createEmptyBorder(28, 32, 32, 32));
        mainArea.add(header, BorderLayout.NORTH);
        mainArea.add(pages, BorderLayout.CENTER);

        // ----- Sidebar switches pages and updates the header title -----
        Sidebar sidebar = new Sidebar(pageKey -> {
            cardLayout.show(pages, pageKey);
            header.setPageTitle(PAGE_TITLES.getOrDefault(pageKey, pageKey));
        });

        add(sidebar, BorderLayout.WEST);
        add(mainArea, BorderLayout.CENTER);
    }
}
