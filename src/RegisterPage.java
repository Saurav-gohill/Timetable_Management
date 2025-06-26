
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class RegisterPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    public RegisterPage() {
        setTitle("Login Page");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use null layout to manually set bounds
        getContentPane().setBackground(Color.decode("#B2C6D5"));

        // Set the icon for the JFrame
        ImageIcon icon2 = new ImageIcon("experiment.png"); // Path to your icon file
        Image image2 = icon2.getImage(); // Convert ImageIcon to Image
        setIconImage(image2); // Set the icon for the JFrame

        // Load and resize the image
        ImageIcon originalIcon = new ImageIcon("S.png"); // Replace with your image path
        Image img = originalIcon.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH); // Resize
        ImageIcon resizedIcon = new ImageIcon(img);

        // JLabel to hold resized image
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(35, 200, 300, 250); // Set bounds to match resized image

        add(imageLabel);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(480, 130, 350, 450);
        add(panel);
        panel.setLayout(null);

        // Title
        JLabel title = new JLabel("Welcome to the Timetable Management System");
        title.setBounds(20, 100, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 15));
        add(title);

        // Title Label
        JLabel titleLabel = new JLabel("New User Register");
        titleLabel.setBounds(490, 90, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        // Username Label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 50, 100, 30);
        panel.add(usernameLabel);

        // Username Field
        usernameField = new JTextField();
        usernameField.setBounds(110, 50, 200, 30);
        panel.add(usernameField);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 100, 100, 30);
        panel.add(passwordLabel);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(110, 100, 200, 30);
        panel.add(passwordField);

        // Role Label
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(30, 150, 100, 30);
        panel.add(roleLabel);

        // Role ComboBox
        String[] roles = {"admin", "coordinator", "faculty"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(110, 150, 200, 30);
        panel.add(roleComboBox);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(150, 210, 100, 30);
        panel.add(registerButton);

        // Role Label
        JLabel CreateAcc = new JLabel("Have an account. Login here: ");
        CreateAcc.setBounds(30, 280, 250, 30);
        panel.add(CreateAcc);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(30, 320, 100, 30);
        panel.add(loginButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterPage.this, "Username and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (registerUser(username, password, role)) {
                        JOptionPane.showMessageDialog(RegisterPage.this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new LoginPage().setVisible(true);
                        dispose();
                        clearFields();
                    } else {
                        JOptionPane.showMessageDialog(RegisterPage.this, "Registration Failed. Username might already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage().setVisible(true);
                dispose(); // Close the register page
            }
        });
    }

    private boolean registerUser(String username, String password, String role) {
        String url = "jdbc:sqlite:timetable.db";
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        roleComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterPage().setVisible(true);
            }
        });
    }
}
