import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddRoomScreen extends JFrame {
    private JTextField roomNameField;
    private JTextField capacityField;

    public AddRoomScreen() {
        setTitle("Add Room");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the icon for the JFrame
        ImageIcon icon = new ImageIcon("experiment.png"); // Path to your icon file
        Image image = icon.getImage(); // Convert ImageIcon to Image
        setIconImage(image); // Set the icon for the JFrame

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Room Name:"));
        roomNameField = new JTextField();
        panel.add(roomNameField);

        panel.add(new JLabel("Capacity:"));
        capacityField = new JTextField();
        panel.add(capacityField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveRoom());
        panel.add(saveButton);

        add(panel);
    }

    private void saveRoom() {
        String roomName = roomNameField.getText();
        int capacity = Integer.parseInt(capacityField.getText());

        String sql = "INSERT INTO Rooms (room_name, capacity) VALUES (?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, roomName);
            pstmt.setInt(2, capacity);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}