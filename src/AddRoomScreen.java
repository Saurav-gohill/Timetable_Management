import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddRoomScreen extends JFrame {
    private JTextField roomNameField;
    private JComboBox<String> capacityCombobox;

    public AddRoomScreen() {
        setTitle("Add Room");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the icon for the JFrame
        ImageIcon icon = new ImageIcon("experiment.png"); // Path to your icon file
        Image image = icon.getImage(); // Convert ImageIcon to Image
        setIconImage(image); // Set the icon for the JFrame

        // Use null layout to manually set bounds
        setLayout(null);

        // Room Name Label and Field
        JLabel roomNameLabel = new JLabel("Room Name:");
        roomNameLabel.setBounds(20, 20, 100, 20); // x, y, width, height
        add(roomNameLabel);

        roomNameField = new JTextField();
        roomNameField.setBounds(130, 20, 200, 20);
        add(roomNameField);

        // Capacity Label and ComboBox
        JLabel capacityLabel = new JLabel("Capacity:");
        capacityLabel.setBounds(20, 50, 100, 20);
        add(capacityLabel);

        String[] capacity = {"Class", "Lab", "Tutorial"};
        capacityCombobox = new JComboBox<>(capacity);
        capacityCombobox.setBounds(130, 50, 200, 20);
        add(capacityCombobox);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(150, 100, 100, 30);
        saveButton.addActionListener(e -> saveRoom());
        add(saveButton);
    }

    private void saveRoom() {
        String roomName = roomNameField.getText();
        String capacity = (String) capacityCombobox.getSelectedItem();

        String sql = "INSERT INTO Room (room_name, capacity) VALUES (?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, roomName);
            pstmt.setString(2, capacity);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Room saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}