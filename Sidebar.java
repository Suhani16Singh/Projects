import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Sidebar.java
 * ---------------------------------------------------------
 * The left-hand navigation panel: the app name at the top,
 * one button per page (Dashboard, Courses, Assignments,
 * Profile), and the current term at the bottom. It does not
 * know how to switch pages itself — it just reports which
 * button was clicked to a listener supplied by the caller,
 * keeping navigation logic separate from navigation display.
 * ---------------------------------------------------------
 */
public class Sidebar extends JPanel {

    private final Map<String, JButton> navButtons = new LinkedHashMap<>();
    private String activePage;

    public Sidebar(Consumer<String> onNavigate) {
        setLayout(new BorderLayout());
        setBackground(UITheme.SIDEBAR);
        setPreferredSize(new Dimension(UITheme.SIDEBAR_WIDTH, 0));
        setBorder(BorderFactory.createEmptyBorder(24, 16, 24, 16));

        add(buildBrand(), BorderLayout.NORTH);
        add(buildNav(onNavigate), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    private JPanel buildBrand() {
        JPanel brand = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        brand.setOpaque(false);
        brand.setBorder(BorderFactory.createEmptyBorder(0, 4, 30, 0));

        JLabel mark = new JLabel("A", JLabel.CENTER) {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
                        java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(UITheme.ACCENT);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        mark.setForeground(Color.WHITE);
        mark.setFont(UITheme.heading(15));
        mark.setPreferredSize(new Dimension(32, 32));

        JLabel name = new JLabel("Academix");
        name.setForeground(Color.WHITE);
        name.setFont(UITheme.heading(18));

        brand.add(mark);
        brand.add(name);
        return brand;
    }

    private JPanel buildNav(Consumer<String> onNavigate) {
        JPanel nav = new JPanel();
        nav.setOpaque(false);
        nav.setLayout(new javax.swing.BoxLayout(nav, javax.swing.BoxLayout.Y_AXIS));

        addNavButton(nav, "dashboard", "Dashboard", onNavigate);
        addNavButton(nav, "courses", "Courses", onNavigate);
        addNavButton(nav, "assignments", "Assignments", onNavigate);
        addNavButton(nav, "profile", "Profile", onNavigate);

        return nav;
    }

    private void addNavButton(JPanel nav, String key, String label, Consumer<String> onNavigate) {
        JButton button = new JButton(label);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(JButton.LEFT);
        button.setBorder(BorderFactory.createEmptyBorder(11, 12, 11, 12));
        button.setFont(UITheme.bodyBold(14));
        button.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.addActionListener(e -> {
            setActivePage(key);
            onNavigate.accept(key);
        });

        navButtons.put(key, button);
        nav.add(button);
        nav.add(javax.swing.Box.createVerticalStrut(4));

        setButtonStyle(button, key.equals("dashboard"));
        if (key.equals("dashboard")) {
            activePage = "dashboard";
        }
    }

    private void setActivePage(String key) {
        activePage = key;
        navButtons.forEach((k, btn) -> setButtonStyle(btn, k.equals(key)));
    }

    private void setButtonStyle(JButton button, boolean active) {
        if (active) {
            button.setBackground(UITheme.ACCENT);
            button.setForeground(Color.WHITE);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setContentAreaFilled(true);
        } else {
            button.setBackground(UITheme.SIDEBAR);
            button.setForeground(UITheme.SIDEBAR_TEXT);
            button.setOpaque(false);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
        }
    }

    private JPanel buildFooter() {
        JPanel footer = new JPanel();
        footer.setOpaque(false);
        footer.setLayout(new javax.swing.BoxLayout(footer, javax.swing.BoxLayout.Y_AXIS));
        footer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(255, 255, 255, 30)),
                BorderFactory.createEmptyBorder(14, 4, 0, 0)));

        JLabel line1 = new JLabel("Fall Semester");
        line1.setForeground(UITheme.SIDEBAR_TEXT);
        line1.setFont(UITheme.body(12));

        JLabel line2 = new JLabel("2026\u201327");
        line2.setForeground(Color.WHITE);
        line2.setFont(UITheme.bodyBold(12));

        footer.add(line1);
        footer.add(line2);
        return footer;
    }
}
