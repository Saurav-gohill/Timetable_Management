import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewScreen extends JFrame {
    public ViewScreen() {
        setTitle("View Details");
        setSize(400, 300); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center the window on the screen
        setLayout(null); // Disable the default layout manager

        // View Faculty Button
        JButton viewFacultyButton = new JButton("View Faculty");
        viewFacultyButton.setBounds(50, 50, 150, 30); // x, y, width, height
        viewFacultyButton.addActionListener(e -> viewFaculty());
        add(viewFacultyButton);

        // View Rooms Button
        JButton viewRoomsButton = new JButton("View Rooms");
        viewRoomsButton.setBounds(50, 100, 150, 30); // x, y, width, height
        viewRoomsButton.addActionListener(e -> viewRooms());
        add(viewRoomsButton);

        // View Classes Button
        JButton viewClassesButton = new JButton("View Classes");
        viewClassesButton.setBounds(50, 150, 150, 30); // x, y, width, height
        viewClassesButton.addActionListener(e -> viewClasses());
        add(viewClassesButton);
    }

    private void viewFaculty() {
        List<String[]> facultyList = DatabaseFetcher.fetchFaculty();
        displayData("Faculty", facultyList);
    }

    private void viewRooms() {
        List<String[]> roomsList = DatabaseFetcher.fetchRooms();
        displayData("Rooms", roomsList);
    }

    private void viewClasses() {
        List<String[]> classesList = DatabaseFetcher.fetchClasses();
        displayData("Classes", classesList);
    }

    private void displayData(String title, List<String[]> data) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : data) {
            sb.append(String.join(" | ", row)).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), title, JOptionPane.INFORMATION_MESSAGE);
    }
}