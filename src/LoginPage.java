import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class LoginPage extends JFrame {
    public static String username;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;

    static String usernae="";
    static String rol="";
    public LoginPage() {

        setTitle("Login Page");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use null layout to manually set bounds
        getContentPane().setBackground(Color.decode("#EBE5C2"));

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
        JLabel title = new JLabel(" Welcome to the ");
        title.setBounds(20, 100, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        // Titel 2
        JLabel title2 = new JLabel(" Timetable Management System.");
        title2.setBounds(20, 130, 300, 30);
        title2.setFont(new Font("Arial", Font.BOLD, 18));
        add(title2);

        // Title Label
        JLabel titleLabel = new JLabel("Login Page");
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

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 210, 100, 30);
        panel.add(loginButton);

        // Role Label
        JLabel CreateAcc = new JLabel(" Don't have an account? Register here: ");
        CreateAcc.setBounds(30, 280, 250, 30);
        panel.add(CreateAcc);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(30, 320, 100, 30);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Username and Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                usernae=username;
                rol=role;
                if (validateLogin(username, password, role)) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");
                    // Redirect to respective dashboard based on role
                    switch (role) {
                        case "admin":
                            new MainScreen().setVisible(true);
                            dispose();
                            // Open Admin Dashboard
                            break;
                        case "coordinator":
                            new MainScreen().setVisible(true);
                            dispose();
                            // Open Coordinator Dashboard
                            break;
                        case "faculty":
                            new MainScreen().setVisible(true);
                            dispose();
                            // Open Faculty Dashboard
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid Username, Password, or Role", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterPage().setVisible(true);
                dispose(); // Close the login page
            }
        });
    }

    private boolean validateLogin(String username, String password, String role) {
        String url = "jdbc:sqlite:timetable.db";
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }
}