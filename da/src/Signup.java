import javax.swing.*;
import java.sql.*;

public class Signup extends JFrame{
    public Signup() {
        JFrame frame = new JFrame("Signup");
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel("Create an Account");
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JLabel confirmPassLabel = new JLabel("Confirm Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        JButton signupButton = new JButton("Signup!");
        JButton backButton = new JButton("Go Back");
        JOptionPane pane = new JOptionPane();

        panel.setLayout(null);
        titleLabel.setBounds(325, 50, 200, 30);
        userLabel.setBounds(250, 120, 100, 25); 
        passLabel.setBounds(250, 160, 100, 25);
        confirmPassLabel.setBounds(250, 200, 150, 25);
        usernameField.setBounds(400, 120, 200, 25);
        passwordField.setBounds(400, 160, 200, 25);
        confirmPasswordField.setBounds(400, 200, 200, 25);
        signupButton.setBounds(250, 260, 150, 40);   
        backButton.setBounds(450, 260, 150, 40);

        panel.add(titleLabel);
        panel.add(userLabel);
        panel.add(usernameField);
        panel.add(passLabel);
        panel.add(passwordField);
        panel.add(confirmPassLabel);
        panel.add(confirmPasswordField);
        panel.add(signupButton);
        panel.add(backButton);

        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        signupButton.addActionListener(e -> accountCreated(usernameField, passwordField, confirmPasswordField, pane));
        backButton.addActionListener(e -> signupDirect(frame));
    }
    private static void signupDirect(JFrame frame){
        frame.dispose();
        OptionPage.main(new String[]{});
    }
    private static void accountCreated(JTextField username, JPasswordField password, JPasswordField confirmPassword, JOptionPane pane){
        String user = username.getText();
        String passcode = new String(password.getPassword());
        String confirmPasscode = new String(confirmPassword.getPassword());
        if(user.isEmpty() || passcode.isEmpty() || confirmPasscode.isEmpty()){
            JOptionPane.showMessageDialog(null, "Application Incomplete");
        }else if(!passcode.equals(confirmPasscode)){
            JOptionPane.showMessageDialog(null, "Passwords do not match!");
        }else{
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javaaccounts",
                "root",
                "Maingat31@"
            );

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, passcode);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Account created for user: " + user);

            conn.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            }
        }
    }
}
