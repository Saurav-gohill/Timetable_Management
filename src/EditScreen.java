import javax.swing.*;
import java.awt.*;

public class EditScreen extends JFrame {
    public EditScreen() {
        setTitle("Edit Details");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // Edit Faculty Button
        JButton editFacultyButton = new JButton("Edit Faculty");
        editFacultyButton.setBounds(50, 50, 150, 30); // x, y, width, height
        editFacultyButton.addActionListener(e -> new EditFacultyScreen().setVisible(true));
        add(editFacultyButton);

        // Edit Room Button
        JButton editRoomButton = new JButton("Edit Room");
        editRoomButton.setBounds(50, 100, 150, 30); // x, y, width, height
        editRoomButton.addActionListener(e -> new EditRoomScreen().setVisible(true));
        add(editRoomButton);

        // Edit Class Button
        JButton editClassButton = new JButton("Edit Class");
        editClassButton.setBounds(50, 150, 150, 30); // x, y, width, height
        editClassButton.addActionListener(e -> new EditClassScreen().setVisible(true));
        add(editClassButton);
    }
}