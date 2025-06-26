import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainScreen extends JFrame {
    public MainScreen() {
        if (LoginPage.rol.equals("admin")) {
            setTitle("Main Screen");
            setSize(950, 700); // Set the size of the window
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the window on the screen
            setLayout(null); // Disable the default layout manager
            setBackground(Color.decode("#F1F0E9"));
            setVisible(true);

            // Set the icon for the JFrame
            ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
            Image image2 = icon2.getImage(); // Convert ImageIcon to Image
            setIconImage(image2); // Set the icon for the JFrame

            // Add Image
            ImageIcon icon = new ImageIcon("Main.png"); // Path to your image file
            Image image = icon.getImage(); // Get the image from the ImageIcon
            Image resizedImage = image.getScaledInstance(450, 280, Image.SCALE_SMOOTH); // Resize the image
            ImageIcon resizedIcon = new ImageIcon(resizedImage); // Create a new ImageIcon from the resized image

            // Add the resized image to a JLabel
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(20,150,450,280);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            add(imageLabel, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setBounds(500, 0, 400, 900); // x, y, width, height
            panel.setBackground(Color.decode("#41644A"));
            add(panel);
            panel.setLayout(null);

            JLabel title1 = new JLabel(LoginPage.rol+" Dashboard");
            title1.setForeground(Color.WHITE);
            title1.setFont(new Font("Arial", Font.BOLD, 20));
            title1.setBounds(20, 50, 200, 30); // x, y, width, height
            panel.add(title1);

            JLabel title2 = new JLabel("Welcome "+LoginPage.usernae+" !! ");
            title2.setFont(new Font("Arial", Font.BOLD, 20));
            title2.setBounds(20, 70, 200, 30); // x, y, width, height
            add(title2);

            JPanel panel2 = new JPanel();
            panel2.setBounds(80, 120, 350, 330); // x, y, width, height
            panel2.setBackground(Color.decode("#0D4715"));
            panel.add(panel2);
            panel2.setLayout(null);

            JLabel text1 = new JLabel("View Details (Faculty, Rooms, Classes) : ");
            text1.setForeground(Color.WHITE);
            text1.setFont(new Font("Arial", Font.BOLD, 15));
            text1.setBounds(10, 20, 300, 20); // x, y, width, height
            panel2.add(text1);

            JLabel text2 = new JLabel("Generate Timetable : ");
            text2.setForeground(Color.WHITE);
            text2.setFont(new Font("Arial", Font.BOLD, 15));
            text2.setBounds(10, 240, 300, 20); // x, y, width, height
            panel2.add(text2);

            // View Button
            JButton viewButton = new JButton("View");
            viewButton.setBounds(10, 50, 150, 30); // x, y, width, height
            viewButton.setBackground(Color.decode("#E07A5F"));
            viewButton.setForeground(Color.WHITE);
            viewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewButton.addActionListener(e -> new ViewScreen().setVisible(true));
            panel2.add(viewButton);

            JLabel text3 = new JLabel("Edit Details (Faculty, Rooms, Classes) : ");
            text3.setForeground(Color.WHITE);
            text3.setFont(new Font("Arial", Font.BOLD, 15));
            text3.setBounds(10, 100, 300, 20); // x, y, width, height
            panel2.add(text3);

            // Edit Button
            JButton editButton = new JButton("Edit");
            editButton.setBounds(10, 130, 150, 30); // x, y, width, height
            editButton.setBackground(Color.decode("#E07A5F"));
            editButton.setForeground(Color.WHITE);
            editButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            editButton.addActionListener(e -> new EditScreen().setVisible(true));
            panel2.add(editButton);

            // Generate Timetable Button
            JButton generateTimetableButton = new JButton("Generate ");
            generateTimetableButton.setBounds(10, 270, 150, 30);
            generateTimetableButton.setBackground(Color.decode("#E07A5F"));
            generateTimetableButton.setForeground(Color.WHITE);
            generateTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            generateTimetableButton.addActionListener(e -> TimetableGenerator.generateAndShowTimetable());
            panel2.add(generateTimetableButton);
            

            JLabel text4 = new JLabel("Add Details (Faculty, Rooms, Classes) : ");
            text4.setForeground(Color.WHITE);
            text4.setFont(new Font("Arial", Font.BOLD, 15));
            text4.setBounds(10, 175, 300, 20); // x, y, width, height
            panel2.add(text4);

            // Add Details Button
            JButton addDetailsButton = new JButton("Add Details");
            addDetailsButton.setBounds(10, 200, 150, 30); // x, y, width, height
            addDetailsButton.addActionListener(e -> new AddDetailsScreen().setVisible(true));
            addDetailsButton.setBackground(Color.decode("#E07A5F"));
            addDetailsButton.setForeground(Color.WHITE);
            addDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            panel2.add(addDetailsButton);

            JPanel panel3 = new JPanel();
            panel3.setBounds(0, 30, 300, 60); // x, y, width, height
            panel3.setBackground(Color.decode("#0D4715"));
            panel.add(panel3);
            panel3.setLayout(null);

            JPanel panel4 = new JPanel();
            panel4.setBounds(130, 490, 270, 60); // x, y, width, height
            panel4.setBackground(Color.decode("#0D4715"));
            panel.add(panel4);
            panel4.setLayout(null);

            JLabel text5 = new JLabel("View Timetable : ");
            text5.setForeground(Color.WHITE);
            text5.setFont(new Font("Arial", Font.BOLD, 15));
            text5.setBounds(10, 0, 300, 20); // x, y, width, height
            panel4.add(text5);


            // View Timetable Button
            JButton viewTimetableButton = new JButton("View Timetable");
            viewTimetableButton.setBounds(110, 22, 150, 30);
            viewTimetableButton.setBackground(Color.decode("#690B22"));
            viewTimetableButton.setForeground(Color.WHITE);
            viewTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewTimetableButton.addActionListener(e -> new TimetableScreen().setVisible(true));
            panel4.add(viewTimetableButton);

        } else if (LoginPage.rol.equals("coordinator")) {
            setTitle("Main Screen");
            setSize(950, 700); // Set the size of the window
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the window on the screen
            setLayout(null); // Disable the default layout manager
            setBackground(Color.decode("#F1F0E9"));
            setVisible(true);

            // Set the icon for the JFrame
            ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
            Image image2 = icon2.getImage(); // Convert ImageIcon to Image
            setIconImage(image2); // Set the icon for the JFrame

            // Add Image
            ImageIcon icon = new ImageIcon("Main.png"); // Path to your image file
            Image image = icon.getImage(); // Get the image from the ImageIcon
            Image resizedImage = image.getScaledInstance(450, 280, Image.SCALE_SMOOTH); // Resize the image
            ImageIcon resizedIcon = new ImageIcon(resizedImage); // Create a new ImageIcon from the resized image

            // Add the resized image to a JLabel
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(20,150,450,280);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            add(imageLabel, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setBounds(500, 0, 400, 900); // x, y, width, height
            panel.setBackground(Color.decode("#41644A"));
            add(panel);
            panel.setLayout(null);

            JLabel title1 = new JLabel(LoginPage.rol+" Dashboard");
            title1.setForeground(Color.WHITE);
            title1.setFont(new Font("Arial", Font.BOLD, 20));
            title1.setBounds(20, 50, 200, 30); // x, y, width, height
            panel.add(title1);

            JLabel title2 = new JLabel("Welcome "+LoginPage.usernae+" !! ");
            title2.setFont(new Font("Arial", Font.BOLD, 20));
            title2.setBounds(20, 70, 200, 30); // x, y, width, height
            add(title2);

            JPanel panel2 = new JPanel();
            panel2.setBounds(80, 120, 350, 330); // x, y, width, height
            panel2.setBackground(Color.decode("#0D4715"));
            panel.add(panel2);
            panel2.setLayout(null);

            JLabel text1 = new JLabel("View Details (Faculty, Rooms, Classes) : ");
            text1.setForeground(Color.WHITE);
            text1.setFont(new Font("Arial", Font.BOLD, 15));
            text1.setBounds(10, 20, 300, 20); // x, y, width, height
            panel2.add(text1);

            JLabel text2 = new JLabel("Generate Timetable : ");
            text2.setForeground(Color.WHITE);
            text2.setFont(new Font("Arial", Font.BOLD, 15));
            text2.setBounds(10, 240, 300, 20); // x, y, width, height
            panel2.add(text2);

            // View Button
            JButton viewButton = new JButton("View");
            viewButton.setBounds(10, 50, 150, 30); // x, y, width, height
            viewButton.setBackground(Color.decode("#E07A5F"));
            viewButton.setForeground(Color.WHITE);
            viewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewButton.addActionListener(e -> new ViewScreen().setVisible(true));
            panel2.add(viewButton);

            JLabel text3 = new JLabel("Edit Details (Faculty, Rooms, Classes) : ");
            text3.setForeground(Color.WHITE);
            text3.setFont(new Font("Arial", Font.BOLD, 15));
            text3.setBounds(10, 100, 300, 20); // x, y, width, height
            panel2.add(text3);

            // Edit Button
            JButton editButton = new JButton("Edit");
            editButton.setBounds(10, 130, 150, 30); // x, y, width, height
            editButton.setBackground(Color.decode("#690B22"));
            editButton.setForeground(Color.WHITE);
            editButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            editButton.addActionListener(e -> new EditScreen().setVisible(true));
            panel2.add(editButton);

            // Generate Timetable Button
            JButton generateTimetableButton = new JButton("Generate ");
            generateTimetableButton.setBounds(10, 270, 150, 30);
            generateTimetableButton.setBackground(Color.decode("#690B22"));
            generateTimetableButton.setForeground(Color.WHITE);
            generateTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            generateTimetableButton.addActionListener(e -> generateTimetable());
            panel2.add(generateTimetableButton);

            JLabel text4 = new JLabel("Add Details (Faculty, Rooms, Classes) : ");
            text4.setForeground(Color.WHITE);
            text4.setFont(new Font("Arial", Font.BOLD, 15));
            text4.setBounds(10, 175, 300, 20); // x, y, width, height
            panel2.add(text4);

            // Add Details Button
            JButton addDetailsButton = new JButton("Add Details");
            addDetailsButton.setBounds(10, 200, 150, 30); // x, y, width, height
            addDetailsButton.addActionListener(e -> new AddDetailsScreen().setVisible(true));
            addDetailsButton.setBackground(Color.decode("#E07A5F"));
            addDetailsButton.setForeground(Color.WHITE);
            addDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            panel2.add(addDetailsButton);

            JPanel panel3 = new JPanel();
            panel3.setBounds(0, 30, 300, 60); // x, y, width, height
            panel3.setBackground(Color.decode("#0D4715"));
            panel.add(panel3);
            panel3.setLayout(null);

            JPanel panel4 = new JPanel();
            panel4.setBounds(130, 490, 270, 60); // x, y, width, height
            panel4.setBackground(Color.decode("#0D4715"));
            panel.add(panel4);
            panel4.setLayout(null);

            JLabel text5 = new JLabel("View Timetable : ");
            text5.setForeground(Color.WHITE);
            text5.setFont(new Font("Arial", Font.BOLD, 15));
            text5.setBounds(10, 0, 300, 20); // x, y, width, height
            panel4.add(text5);


            // View Timetable Button
            JButton viewTimetableButton = new JButton("View Timetable");
            viewTimetableButton.setBounds(110, 22, 150, 30);
            viewTimetableButton.setBackground(Color.decode("#E07A5F"));
            viewTimetableButton.setForeground(Color.WHITE);
            viewTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewTimetableButton.addActionListener(e -> new TimetableScreen().setVisible(true));
            panel4.add(viewTimetableButton);
        }
        else  {
            setTitle("Main Screen");
            setSize(950, 700); // Set the size of the window
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the window on the screen
            setLayout(null); // Disable the default layout manager
            setBackground(Color.decode("#F1F0E9"));
            setVisible(true);

            // Set the icon for the JFrame
            ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
            Image image2 = icon2.getImage(); // Convert ImageIcon to Image
            setIconImage(image2); // Set the icon for the JFrame

            // Add Image
            ImageIcon icon = new ImageIcon("Main.png"); // Path to your image file
            Image image = icon.getImage(); // Get the image from the ImageIcon
            Image resizedImage = image.getScaledInstance(450, 280, Image.SCALE_SMOOTH); // Resize the image
            ImageIcon resizedIcon = new ImageIcon(resizedImage); // Create a new ImageIcon from the resized image

            // Add the resized image to a JLabel
            JLabel imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(20,150,450,280);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            add(imageLabel, BorderLayout.NORTH);

            JPanel panel = new JPanel();
            panel.setBounds(500, 0, 400, 900); // x, y, width, height
            panel.setBackground(Color.decode("#41644A"));
            add(panel);
            panel.setLayout(null);

            JLabel title1 = new JLabel(LoginPage.rol+" Dashboard");
            title1.setForeground(Color.WHITE);
            title1.setFont(new Font("Arial", Font.BOLD, 20));
            title1.setBounds(20, 50, 200, 30); // x, y, width, height
            panel.add(title1);

            JLabel title2 = new JLabel("Welcome "+LoginPage.usernae+" !! ");
            title2.setFont(new Font("Arial", Font.BOLD, 20));
            title2.setBounds(20, 70, 200, 30); // x, y, width, height
            add(title2);

            JPanel panel2 = new JPanel();
            panel2.setBounds(80, 120, 350, 330); // x, y, width, height
            panel2.setBackground(Color.decode("#0D4715"));
            panel.add(panel2);
            panel2.setLayout(null);

            JLabel text1 = new JLabel("View Details (Faculty, Rooms, Classes) : ");
            text1.setForeground(Color.WHITE);
            text1.setFont(new Font("Arial", Font.BOLD, 15));
            text1.setBounds(10, 20, 300, 20); // x, y, width, height
            panel2.add(text1);

//            JLabel text2 = new JLabel("Generate Timetable : ");
//            text2.setForeground(Color.WHITE);
//            text2.setFont(new Font("Arial", Font.BOLD, 15));
//            text2.setBounds(10, 240, 300, 20); // x, y, width, height
//            panel2.add(text2);

            // View Button
            JButton viewButton = new JButton("View");
            viewButton.setBounds(10, 50, 150, 30); // x, y, width, height
            viewButton.setBackground(Color.decode("#E07A5F"));
            viewButton.setForeground(Color.WHITE);
            viewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewButton.addActionListener(e -> new ViewScreen().setVisible(true));
            panel2.add(viewButton);

            JLabel text3 = new JLabel("Edit Details (Faculty, Rooms, Classes) : ");
            text3.setForeground(Color.WHITE);
            text3.setFont(new Font("Arial", Font.BOLD, 15));
            text3.setBounds(10, 100, 300, 20); // x, y, width, height
            panel2.add(text3);

            // Edit Button
            JButton editButton = new JButton("Edit");
            editButton.setBounds(10, 130, 150, 30); // x, y, width, height
            editButton.setBackground(Color.decode("#690B22"));
            editButton.setForeground(Color.WHITE);
            editButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            editButton.addActionListener(e -> new EditScreen().setVisible(true));
            panel2.add(editButton);

            // Generate Timetable Button
//            JButton generateTimetableButton = new JButton("Generate ");
//            generateTimetableButton.setBounds(10, 270, 150, 30);
//            generateTimetableButton.setBackground(Color.decode("#690B22"));
//            generateTimetableButton.setForeground(Color.WHITE);
//            generateTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
//            generateTimetableButton.addActionListener(e -> generateTimetable());
//            panel2.add(generateTimetableButton);

//            JLabel text4 = new JLabel("Add Details (Faculty, Rooms, Classes) : ");
//            text4.setForeground(Color.WHITE);
//            text4.setFont(new Font("Arial", Font.BOLD, 15));
//            text4.setBounds(10, 175, 300, 20); // x, y, width, height
//            panel2.add(text4);

            // Add Details Button
//            JButton addDetailsButton = new JButton("Add Details");
//            addDetailsButton.setBounds(10, 200, 150, 30); // x, y, width, height
//            addDetailsButton.addActionListener(e -> new AddDetailsScreen().setVisible(true));
//            addDetailsButton.setBackground(Color.decode("#E07A5F"));
//            addDetailsButton.setForeground(Color.WHITE);
//            addDetailsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
//            panel2.add(addDetailsButton);

            JPanel panel3 = new JPanel();
            panel3.setBounds(0, 30, 300, 60); // x, y, width, height
            panel3.setBackground(Color.decode("#0D4715"));
            panel.add(panel3);
            panel3.setLayout(null);

            JPanel panel4 = new JPanel();
            panel4.setBounds(130, 490, 270, 60); // x, y, width, height
            panel4.setBackground(Color.decode("#0D4715"));
            panel.add(panel4);
            panel4.setLayout(null);

            JLabel text5 = new JLabel("View Timetable : ");
            text5.setForeground(Color.WHITE);
            text5.setFont(new Font("Arial", Font.BOLD, 15));
            text5.setBounds(10, 0, 300, 20); // x, y, width, height
            panel4.add(text5);


            // View Timetable Button
            JButton viewTimetableButton = new JButton("View Timetable");
            viewTimetableButton.setBounds(110, 22, 150, 30);
            viewTimetableButton.setBackground(Color.decode("#E07A5F"));
            viewTimetableButton.setForeground(Color.WHITE);
            viewTimetableButton.setFont(new Font("Tahoma", Font.BOLD, 12));
            viewTimetableButton.addActionListener(e -> new TimetableScreen().setVisible(true));
            panel4.add(viewTimetableButton);

        }

    }
    private void generateTimetable() {
        // Implement timetable generation logic here
        JOptionPane.showMessageDialog(this, "Timetable generated successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
}