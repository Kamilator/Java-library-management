import java.awt.Color;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
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
        JButton borrowBook = new JButton("BORROW BOOK");
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
        leftPanel.add(borrowBook);

        Account.setBounds(10, 10, 180, 50);
        bookList.setBounds(10, 70, 180, 50);
        borrowBook.setBounds(10, 130, 180, 50);

        Account.setBackground(Color.decode(buttonColor));
        bookList.setBackground(Color.decode(buttonColor));
        borrowBook.setBackground(Color.decode(buttonColor));

        Account.setForeground(Color.GRAY);
        bookList.setForeground(Color.GRAY);
        borrowBook.setForeground(Color.GRAY);

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

        Account.addActionListener(e -> UserAccount(middlePanel, topPanel, panelColor));
        bookList.addActionListener(e -> showBookList(middlePanel, topPanel));
        borrowBook.addActionListener(e -> showBorrowBook(middlePanel, topPanel, panelColor));
        menu.addActionListener(e -> showMenu());
        enter.addActionListener(e -> enterSearch());
    }
    public void UserAccount(JPanel middlePanel, JPanel topPanel, String panelColor){
        middlePanel.setVisible(false);
        topPanel.setVisible(false);
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setBounds(210, 5, 710, 550 );
        panel.setBackground(Color.decode(panelColor));
    }
    public static void showBookList(JPanel middlePanel, JPanel topPanel){
        middlePanel.setVisible(true);
        topPanel.setVisible(true);
    }
    public  void showBorrowBook(JPanel middlePanel, JPanel topPanel, String panelColor){
        middlePanel.setVisible(false);
        topPanel.setVisible(false);
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setBounds(210, 5, 710, 550 );
        panel.setBackground(Color.decode(panelColor));
    }
    public static void showMenu(){
        //nothing yet
    }
    public static void enterSearch(){
        //nothing yet
    } 
    public static void main(String[] args) {
        new Main();
    }
}
