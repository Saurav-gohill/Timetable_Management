import javax.swing.*;
import java.awt.*;

public class Start extends JFrame {
    public Start() {
        setTitle("Timetable Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        // Set the icon for the JFrame
        ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
        Image image2 = icon2.getImage(); // Convert ImageIcon to Image
        setIconImage(image2); // Set the icon for the JFrame

        // Load original GIF
        ImageIcon originalIcon = new ImageIcon("Timely.gif"); // Replace with your GIF file path

        // Resize the GIF (BUT loses animation)
        Image scaledImage = originalIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        // Create JLabel to hold resized GIF
        JLabel gifLabel = new JLabel(resizedIcon);
        gifLabel.setBounds(0, 0, 500, 500); // Set the same width and height as the resized image

        // Add to frame
        add(gifLabel);

        // Start a 3-second timer before switching to the next page
        Timer timer = new Timer(5000, e -> {
            new LoginPage().setVisible(true); // Open the next page
            dispose(); // Close the current window
        });
        timer.setRepeats(false); // Ensure the timer runs only once
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start().setVisible(true);;
        });
    }
}
