import java.awt.*;
import javax.swing.*;

public class App {
    private JFrame frame;
    private JPanel cards;
    private CardLayout cardLayout;

    public App() {
        // Membuat Frame
        frame = new JFrame("Login dan Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Mengatur CardLayout untuk berpindah antar form
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Membuat panel untuk Login dan Register
        JPanel loginPanel = createLoginPanel();
        JPanel registerPanel = createRegisterPanel();

        // Menambahkan panel ke CardLayout
        cards.add(loginPanel, "Login");
        cards.add(registerPanel, "Register");

        frame.add(cards);
        frame.setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new BorderLayout());
        loginPanel.setBackground(Color.PINK); // Set background warna pink
        
        // Judul dengan BoxLayout
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.PINK); // Set background warna pink untuk judul
        JLabel titleLabel = new JLabel("LOGIN", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);
        loginPanel.add(titlePanel, BorderLayout.NORTH);

        // Form login menggunakan GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.PINK); // Set background warna pink untuk form
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Email:"), gbc);
        
        gbc.gridx = 1;
        JTextField emailField = new JTextField(15);
        formPanel.add(emailField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);
        
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        formPanel.add(passwordField, gbc);

        loginPanel.add(formPanel, BorderLayout.CENTER);

        // Panel untuk tombol menggunakan FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.PINK); // Set background warna pink untuk tombol
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(loginButton);
        
        JButton switchToRegisterButton = new JButton("Sign Up");
        switchToRegisterButton.setBorderPainted(false);
        switchToRegisterButton.setForeground(Color.BLUE);
        switchToRegisterButton.setContentAreaFilled(false);
        switchToRegisterButton.addActionListener(e -> cardLayout.show(cards, "Register"));
        buttonPanel.add(switchToRegisterButton);

        loginPanel.add(buttonPanel, BorderLayout.SOUTH);

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new BorderLayout());
        registerPanel.setBackground(Color.PINK); // Set background warna pink
        
        // Judul dengan BoxLayout
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(Color.PINK); // Set background warna pink untuk judul
        JLabel titleLabel = new JLabel("SIGN UP", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);
        registerPanel.add(titlePanel, BorderLayout.NORTH);

        // Form register menggunakan GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.PINK); // Set background warna pink untuk form
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Full name:"), gbc);

        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        JTextField emailField = new JTextField(15);
        formPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        formPanel.add(passwordField, gbc);

        registerPanel.add(formPanel, BorderLayout.CENTER);

        // Panel untuk tombol menggunakan FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.PINK); // Set background warna pink untuk tombol

        JButton registerButton = new JButton("Sign Up");
        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(registerButton);
        
        JButton switchToLoginButton = new JButton("Login");
        switchToLoginButton.setBorderPainted(false);
        switchToLoginButton.setForeground(Color.BLUE);
        switchToLoginButton.setContentAreaFilled(false);
        switchToLoginButton.addActionListener(e -> cardLayout.show(cards, "Login"));
        buttonPanel.add(switchToLoginButton);

        registerPanel.add(buttonPanel, BorderLayout.SOUTH);

        return registerPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}