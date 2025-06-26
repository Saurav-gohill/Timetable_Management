import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditFacultyScreen extends JFrame {

    private JTextField facultyNameField;
    private JTextField facultyNicknameField;

    public EditFacultyScreen() {
        setTitle("Edit Faculty");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // Faculty ID Label
        JLabel facultyIdLabel = new JLabel("Faculty ID:");
        facultyIdLabel.setBounds(50, 50, 100, 25); // x, y, width, height
        add(facultyIdLabel);

        // Faculty ID Text Field
        facultyNicknameField = new JTextField();
        facultyNicknameField.setBounds(150, 50, 200, 25); // x, y, width, height
        add(facultyNicknameField);

        // Faculty Name Label
        JLabel facultyNameLabel = new JLabel("Faculty Name:");
        facultyNameLabel.setBounds(50, 100, 100, 25); // x, y, width, height
        add(facultyNameLabel);

        // Faculty Name Text Field
        facultyNameField = new JTextField();
        facultyNameField.setBounds(150, 100, 200, 25); // x, y, width, height
        add(facultyNameField);


        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 30); // x, y, width, height
        saveButton.addActionListener(e -> saveFaculty());
        add(saveButton);
    }

    private void saveFaculty() {
        String nickname = facultyNicknameField.getText();
        String facultyName = facultyNameField.getText();

        String sql = "UPDATE Faculty SET faculty_name = ?, nick_name = ? WHERE faculty_id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, facultyName);
            pstmt.setString(2, nickname);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Faculty updated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}