import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddFacultyScreen extends JFrame {
    private JTextField facultyNameField;
    private JTextField subjectsField;

    public AddFacultyScreen() {
        setTitle("Add Faculty");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the icon for the JFrame
        ImageIcon icon = new ImageIcon("experiment.png"); // Path to your icon file
        Image image = icon.getImage(); // Convert ImageIcon to Image
        setIconImage(image); // Set the icon for the JFrame

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Faculty Name:"));
        facultyNameField = new JTextField();
        panel.add(facultyNameField);

        panel.add(new JLabel("Subjects (comma-separated):"));
        subjectsField = new JTextField();
        panel.add(subjectsField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveFaculty());
        panel.add(saveButton);

        add(panel);
    }

    private void saveFaculty() {
        String facultyName = facultyNameField.getText();
        String subjects = subjectsField.getText();

        String sql = "INSERT INTO Faculty (faculty_name, subjects) VALUES (?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, facultyName);
            pstmt.setString(2, subjects);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}