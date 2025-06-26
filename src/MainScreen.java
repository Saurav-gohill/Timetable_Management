import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainScreen extends JFrame {
    public MainScreen() {
        setTitle("Main Screen");
        setSize(500, 400); // Increased size to accommodate components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Disable the default layout manager
        //setResizable(false);

        // Set the icon for the JFrame
        ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
        Image image2 = icon2.getImage(); // Convert ImageIcon to Image
        setIconImage(image2); // Set the icon for the JFrame

        // Add Image
        ImageIcon icon = new ImageIcon("college.png"); // Path to your image file
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(200, 100, Image.SCALE_SMOOTH); // Resize the image
        ImageIcon resizedIcon = new ImageIcon(resizedImage); // Create a new ImageIcon from the resized image

        // Add the resized image to a JLabel
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(20,50,200,100);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // Add Faculty Button
        JButton addFacultyButton = new JButton("Add Faculty");
        addFacultyButton.setBounds(50, 170, 150, 30); // x, y, width, height
        addFacultyButton.addActionListener(e -> new AddFacultyScreen().setVisible(true));
        add(addFacultyButton);

        // Add Room Button
        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.setBounds(50, 210, 150, 30);
        addRoomButton.addActionListener(e -> new AddRoomScreen().setVisible(true));
        add(addRoomButton);

        // Add Class Button
        JButton addClassButton = new JButton("Add Class");
        addClassButton.setBounds(50, 250, 150, 30);
        addClassButton.addActionListener(e -> new AddClassScreen().setVisible(true));
        add(addClassButton);

        // View Faculty Button
        JButton viewFacultyButton = new JButton("View Faculty");
        viewFacultyButton.setBounds(250, 50, 150, 30);
        viewFacultyButton.addActionListener(e -> viewFaculty());
        add(viewFacultyButton);

        // View Rooms Button
        JButton viewRoomsButton = new JButton("View Rooms");
        viewRoomsButton.setBounds(250, 100, 150, 30);
        viewRoomsButton.addActionListener(e -> viewRooms());
        add(viewRoomsButton);

        // View Classes Button
        JButton viewClassesButton = new JButton("View Classes");
        viewClassesButton.setBounds(250, 150, 150, 30);
        viewClassesButton.addActionListener(e -> viewClasses());
        add(viewClassesButton);

        // Generate Timetable Button
        JButton generateTimetableButton = new JButton("Generate Timetable");
        generateTimetableButton.setBounds(250, 200, 150, 30);
        generateTimetableButton.addActionListener(e -> generateTimetable());
        add(generateTimetableButton);

        // View Timetable Button
        JButton viewTimetableButton = new JButton("View Timetable");
        viewTimetableButton.setBounds(250, 250, 150, 30);
        viewTimetableButton.addActionListener(e -> new TimetableScreen().setVisible(true));
        add(viewTimetableButton);


        setVisible(true);
    }

    private void generateTimetable() {
        // Implement timetable generation logic here
        JOptionPane.showMessageDialog(this, "Timetable generated successfully!");
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