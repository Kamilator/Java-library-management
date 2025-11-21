import java.awt.Color;
import javax.swing.*;

public class AdminLogin extends JFrame {
    public AdminLogin() {
        setTitle("Library");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#111b2b"));
        setVisible(true);

        String panelColor = "#16243b";
        String buttonColor = "#233654";

        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();
        JPanel topPanel = new JPanel();
        JButton Account = new JButton("ACCOUNT");
        JButton bookList = new JButton("BOOK LIST");
        JButton Student = new JButton("STUDENTS");
        JButton menu = new JButton("<>");
        JButton enter = new JButton();
        JTextField search = new JTextField("Search book title");
        JScrollPane scroll = new JScrollPane();

        leftPanel.setLayout(null);
        middlePanel.setLayout(null);
        rightPanel.setLayout(null);
        topPanel.setLayout(null);

        this.add(leftPanel);
        this.add(middlePanel);
        this.add(rightPanel);
        this.add(topPanel);

        leftPanel.add(Account);
        leftPanel.add(bookList);
        leftPanel.add(Student);

        Account.setBounds(10, 10, 180, 50);
        bookList.setBounds(10, 70, 180, 50);
        Student.setBounds(10, 130, 180, 50);

        Account.setBackground(Color.decode(buttonColor));
        bookList.setBackground(Color.decode(buttonColor));
        Student.setBackground(Color.decode(buttonColor));

        Account.setForeground(Color.GRAY);
        bookList.setForeground(Color.GRAY);
        Student.setForeground(Color.GRAY);

        rightPanel.add(menu);
        menu.setBounds(10, 10, 35, 35);
        menu.setBackground(Color.decode(buttonColor));
        menu.setForeground(Color.GRAY);

        middlePanel.add(scroll);
        scroll.setBounds(10, 10, 690, 490);
        scroll.setBackground(Color.decode("#28374f"));
        scroll.setLayout(null);

        topPanel.add(search);
        topPanel.add(enter);

        search.setBounds(10, 10, 660, 25);
        enter.setBounds(675, 10, 25, 25);

        search.setBackground(Color.decode("#3a527a"));
        enter.setBackground(Color.decode(buttonColor));

        search.setForeground(Color.LIGHT_GRAY);

        leftPanel.setBackground(Color.decode(panelColor));
        middlePanel.setBackground(Color.decode(panelColor));
        rightPanel.setBackground(Color.decode(panelColor));
        topPanel.setBackground(Color.decode(panelColor));

        leftPanel.setBounds(5, 5, 200, 550);
        middlePanel.setBounds(210, 55, 710, 500 ); //730w
        rightPanel.setBounds(925, 5, 55, 550);
        topPanel.setBounds(210, 5, 710, 45);
    }
    public static void main(String[] args) {
        new AdminLogin();
    }
}
