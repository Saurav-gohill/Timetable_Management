import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddClassScreen extends JFrame {
    private JTextField classNameField;
    private JTextField SectionField;
    private JTextField subjectsField;

    public AddClassScreen() {
        setTitle("Add Class");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the icon for the JFrame
        ImageIcon icon = new ImageIcon("experiment.png"); // Path to your icon file
        Image image = icon.getImage(); // Convert ImageIcon to Image
        setIconImage(image); // Set the icon for the JFrame

        // Use null layout to manually set bounds
        setLayout(null);

        // Class Name Label and Field
        JLabel classNameLabel = new JLabel("Class Name:");
        classNameLabel.setBounds(20, 20, 100, 20); // x, y, width, height
        add(classNameLabel);

        classNameField = new JTextField();
        classNameField.setBounds(130, 20, 200, 20);
        add(classNameField);

        // Section Label and Field
        JLabel sectionLabel = new JLabel("Section:");
        sectionLabel.setBounds(20, 50, 100, 20);
        add(sectionLabel);

        SectionField = new JTextField();
        SectionField.setBounds(130, 50, 200, 20);
        add(SectionField);

        // Subjects Label and Field
        JLabel subjectsLabel = new JLabel("Subjects code (comma-separated):");
        subjectsLabel.setBounds(20, 80, 200, 20);
        add(subjectsLabel);

        subjectsField = new JTextField();
        subjectsField.setBounds(130, 80, 200, 20);
        add(subjectsField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 120, 100, 30);
        saveButton.addActionListener(e -> saveClass());
        add(saveButton);
    }

    private void saveClass() {
        String className = classNameField.getText();
        String section = SectionField.getText();
        String subjects = subjectsField.getText();

        String sql = "INSERT INTO Classes (class_name, section, subjects) VALUES (?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, className);
            pstmt.setString(2, section);
            pstmt.setString(3, subjects);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Class saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}