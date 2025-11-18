import javax.swing.*;
import java.awt.Color;
import java.sql.*;

public class OptionPage{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login/Signup");
        JPanel panel = new JPanel();
        JButton loginButton = new JButton("Login");
        JTextField loginUser = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        JButton signupButton = new JButton("Signup");

        String buttonColor = "#233654";
        String textFieldColor = "#3a527a";
        
        userLabel.setBounds(250, 125, 100, 20);
        loginUser.setBounds(250, 145, 300, 35);
        passLabel.setBounds(250, 180, 100, 20);
        password.setBounds(250, 200, 300, 35);
        loginButton.setBounds(250, 260, 140, 40);
        panel.setBounds(0, 0, 800, 500);
        signupButton.setBounds(410, 260, 140, 40);

        panel.setBackground(Color.decode("#111b2b"));
        password.setBackground(Color.decode(textFieldColor));
        loginUser.setBackground(Color.decode(textFieldColor));

        loginButton.setBackground(Color.decode(buttonColor));
        signupButton.setBackground(Color.decode(buttonColor));

        userLabel.setForeground(Color.GRAY);
        passLabel.setForeground(Color.GRAY);
        loginButton.setForeground(Color.GRAY);
        signupButton.setForeground(Color.GRAY);
        loginUser.setForeground(Color.LIGHT_GRAY);
        password.setForeground(Color.LIGHT_GRAY);

        panel.setLayout(null);
        panel.add(userLabel);
        panel.add(loginUser);
        panel.add(passLabel);
        panel.add(password);
        panel.add(loginButton);
        panel.add(signupButton);
        
        frame.setVisible(true);
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        loginButton.addActionListener(e -> loginDirectMain(frame, loginButton, loginUser, password));
        signupButton.addActionListener(e -> signupDirect(frame));
    }
    private static void loginDirectMain(JFrame frame, JButton button, JTextField loginUser, JPasswordField password){
    String username = loginUser.getText();
    String passcode = new String(password.getPassword());

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/javaaccounts",
            "root",
            "Maingat31@"
        );
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, passcode);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            frame.dispose();
            new Main();
        }else if(username.equals("admin") && passcode.equals("admin")){
            frame.dispose();
            new AdminLogin();
        }else{
            JOptionPane.showMessageDialog(null, "Invalid username or password!");
        }

        conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }
    private static void signupDirect(JFrame frame){
        frame.dispose();
        new Signup();
    }
}
