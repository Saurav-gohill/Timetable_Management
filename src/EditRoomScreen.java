import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EditRoomScreen extends JFrame {
    private JTextField roomIdField;
    private JTextField roomNameField;
    private JTextField capacityField;

    public EditRoomScreen() {
        setTitle("Edit Room");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // Room ID Label
        JLabel roomIdLabel = new JLabel("Room ID:");
        roomIdLabel.setBounds(50, 50, 100, 25); // x, y, width, height
        add(roomIdLabel);

        // Room ID Text Field
        roomIdField = new JTextField();
        roomIdField.setBounds(150, 50, 200, 25); // x, y, width, height
        add(roomIdField);

        // Room Name Label
        JLabel roomNameLabel = new JLabel("Room Name:");
        roomNameLabel.setBounds(50, 100, 100, 25); // x, y, width, height
        add(roomNameLabel);

        // Room Name Text Field
        roomNameField = new JTextField();
        roomNameField.setBounds(150, 100, 200, 25); // x, y, width, height
        add(roomNameField);

        // Capacity Label
        JLabel capacityLabel = new JLabel("Capacity:");
        capacityLabel.setBounds(50, 150, 100, 25); // x, y, width, height
        add(capacityLabel);

        // Capacity Text Field
        capacityField = new JTextField();
        capacityField.setBounds(150, 150, 200, 25); // x, y, width, height
        add(capacityField);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 200, 100, 30); // x, y, width, height
        saveButton.addActionListener(e -> saveRoom());
        add(saveButton);
    }

    private void saveRoom() {
        String roomId = roomIdField.getText();
        String roomName = roomNameField.getText();
        int capacity = Integer.parseInt(capacityField.getText());

        String sql = "UPDATE Rooms SET room_name = ?, capacity = ? WHERE room_id = ?";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, roomName);
            pstmt.setInt(2, capacity);
            pstmt.setString(3, roomId);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room updated successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}