import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ProfilePanel.java
 * ---------------------------------------------------------
 * The "Profile" page: a circular initials avatar next to a
 * simple label/value list of the student's details (roll
 * number, program, semester, email, advisor).
 * ---------------------------------------------------------
 */
public class ProfilePanel extends JPanel {

    public ProfilePanel(Student student) {
        setOpaque(false);
        setLayout(new BorderLayout());

        RoundedPanel card = new RoundedPanel(UITheme.RADIUS, UITheme.CARD_BG, UITheme.BORDER);
        card.setLayout(new BorderLayout(24, 0));
        card.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        card.add(buildAvatar(student.getName()), BorderLayout.WEST);
        card.add(buildDetails(student), BorderLayout.CENTER);

        add(card, BorderLayout.NORTH);
    }

    private JLabel buildAvatar(String fullName) {
        String initials = initialsOf(fullName);

        JLabel avatar = new JLabel(initials, JLabel.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(UITheme.ACCENT);
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.dispose();
                super.paintComponent(g);
            }
        };
        avatar.setPreferredSize(new Dimension(64, 64));
        avatar.setForeground(Color.WHITE);
        avatar.setFont(UITheme.heading(20));
        return avatar;
    }

    private JPanel buildDetails(Student student) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));

        JLabel name = new JLabel(student.getName());
        name.setFont(UITheme.heading(18));
        name.setForeground(UITheme.TEXT);
        name.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
        panel.add(name);
        panel.add(javax.swing.Box.createVerticalStrut(12));

        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("Roll number", student.getRollNumber());
        fields.put("Program", student.getProgram());
        fields.put("Semester", student.getSemester());
        fields.put("Email", student.getEmail());
        fields.put("Advisor", student.getAdvisor());

        for (Map.Entry<String, String> field : fields.entrySet()) {
            panel.add(buildDetailRow(field.getKey(), field.getValue()));
            panel.add(javax.swing.Box.createVerticalStrut(8));
        }

        return panel;
    }

    private JPanel buildDetailRow(String label, String value) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        row.setOpaque(false);
        row.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        JLabel labelComp = new JLabel(label);
        labelComp.setFont(UITheme.body(13));
        labelComp.setForeground(UITheme.TEXT_MUTED);
        labelComp.setPreferredSize(new Dimension(130, 20));

        JLabel valueComp = new JLabel(value);
        valueComp.setFont(UITheme.bodyBold(13));
        valueComp.setForeground(UITheme.TEXT);

        row.add(labelComp);
        row.add(valueComp);
        return row;
    }

    private String initialsOf(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                sb.append(Character.toUpperCase(part.charAt(0)));
            }
            if (sb.length() >= 2) break;
        }
        return sb.toString();
    }
}
