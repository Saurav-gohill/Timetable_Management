import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddFacultyScreen extends JFrame {
    private JTextField facultyNameField;
    private JTextField facultyShortNameField;
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

        // Use null layout to manually set bounds
        setLayout(null);

        // Faculty Name Label and Field
        JLabel facultyNameLabel = new JLabel("Faculty Name:");
        facultyNameLabel.setBounds(20, 20, 150, 20); // x, y, width, height
        add(facultyNameLabel);

        facultyNameField = new JTextField();
        facultyNameField.setBounds(220, 20, 180, 20);
        add(facultyNameField);

        // Short Name Label and Field
        JLabel facultyShortNameLabel = new JLabel("Short Name:");
        facultyShortNameLabel.setBounds(20, 50, 150, 20);
        add(facultyShortNameLabel);

        facultyShortNameField = new JTextField();
        facultyShortNameField.setBounds(220, 50, 180, 20);
        add(facultyShortNameField);

        // Subjects Label and Field
        JLabel subjectsLabel = new JLabel("Subjects code (comma-separated):");
        subjectsLabel.setBounds(20, 80, 200, 20);
        add(subjectsLabel);

        subjectsField = new JTextField();
        subjectsField.setBounds(220, 80, 180, 20);
        add(subjectsField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 120, 100, 30);
        saveButton.addActionListener(e -> saveFaculty());
        add(saveButton);
    }

    private void saveFaculty() {
        String facultyName = facultyNameField.getText();
        String facultyShortName = facultyShortNameField.getText();
        String subjects = subjectsField.getText();

        String sql = "INSERT INTO Faculty (faculty_name, nick_name, subjects) VALUES (?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, facultyName);
            pstmt.setString(2, facultyShortName);
            pstmt.setString(3, subjects);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}