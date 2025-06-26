import javax.swing.*;
import java.awt.*;

public class AddDetailsScreen extends JFrame {
    public AddDetailsScreen() {
        setTitle("Add Details");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // Add Faculty Button
        JButton addFacultyButton = new JButton("Add Faculty");
        addFacultyButton.setBounds(50, 50, 150, 30); // x, y, width, height
        addFacultyButton.addActionListener(e -> new AddFacultyScreen().setVisible(true));
        add(addFacultyButton);

        // Add Room Button
        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.setBounds(50, 100, 150, 30); // x, y, width, height
        addRoomButton.addActionListener(e -> new AddRoomScreen().setVisible(true));
        add(addRoomButton);

        // Add Class Button
        JButton addClassButton = new JButton("Add Class");
        addClassButton.setBounds(50, 150, 150, 30); // x, y, width, height
        addClassButton.addActionListener(e -> new AddClassScreen().setVisible(true));
        add(addClassButton);
    }
}