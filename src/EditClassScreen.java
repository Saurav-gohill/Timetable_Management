import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditClassScreen extends JFrame {
    private JTextField classNameField;
    private JTextField classSectionField;
    private JTextField subjectsField;

    public EditClassScreen() {
        setTitle("Edit Class");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // Class ID Label
        JLabel classIdLabel = new JLabel("Class ID:");
        classIdLabel.setBounds(50, 50, 100, 25); // x, y, width, height
        add(classIdLabel);

        // Class ID Text Field
        classSectionField = new JTextField();
        classSectionField.setBounds(150, 50, 200, 25); // x, y, width, height
        add(classSectionField);

        // Class Name Label
        JLabel classNameLabel = new JLabel("Class Name:");
        classNameLabel.setBounds(50, 100, 100, 25); // x, y, width, height
        add(classNameLabel);

        // Class Name Text Field
        classNameField = new JTextField();
        classNameField.setBounds(150, 100, 200, 25); // x, y, width, height
        add(classNameField);

        // Subjects Label
        JLabel subjectsLabel = new JLabel("Subjects:");
        subjectsLabel.setBounds(50, 150, 100, 25); // x, y, width, height
        add(subjectsLabel);

        // Subjects Text Field
        subjectsField = new JTextField();
        subjectsField.setBounds(150, 150, 200, 25); // x, y, width, height
        add(subjectsField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 30); // x, y, width, height
        saveButton.addActionListener(e -> saveClass());
        add(saveButton);
    }

    private void saveClass() {
        String classSection = classSectionField.getText();
        String className = classNameField.getText();
        String subjects = subjectsField.getText();

        String sql = "UPDATE Classes SET section = ?, subjects = ? WHERE class_name = ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, className);
            pstmt.setString(2, subjects);
            pstmt.setString(3, classSection);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Class updated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}