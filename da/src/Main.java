import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

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

        leftPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));
        middlePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));

        Account.setBorder(BorderFactory.createLineBorder(Color.decode("#061836"), 2));
        bookList.setBorder(BorderFactory.createLineBorder(Color.decode("#061836"), 2));
        borrowBook.setBorder(BorderFactory.createLineBorder(Color.decode("#061836"), 2));
        menu.setBorder(BorderFactory.createLineBorder(Color.decode("#061836"), 2));
        enter.setBorder(BorderFactory.createLineBorder(Color.decode("#061836"), 2));

        search.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));

        Account.addActionListener(e -> UserAccount(middlePanel, topPanel, panelColor));
        bookList.addActionListener(e -> showBookList(middlePanel, topPanel, panelColor,buttonColor));
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
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));
        panel.setBackground(Color.decode(panelColor));
    }
    public static void showBookList(JPanel middlePanel, JPanel topPanel, String panelColor, String buttonColor){
        middlePanel.setVisible(true);
        topPanel.setVisible(true);
        middlePanel.removeAll();
        middlePanel.setLayout(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 5, 5, 5)); 

        //placeholder btn
        for (int i = 1; i <= 500; i++) {
            JButton btn = new JButton("Book " + i);
            btn.setPreferredSize(new Dimension(90, 170));
            btn.setBackground(Color.decode(buttonColor));
            btn.setForeground(Color.LIGHT_GRAY);
            contentPanel.add(btn);
        }

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        contentPanel.setBackground(Color.decode(panelColor));
        scrollPane.setBounds(10, 10, middlePanel.getWidth() - 20, middlePanel.getHeight() - 20);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.decode(buttonColor);
                this.trackColor = Color.decode(panelColor);
            }
        });

        middlePanel.add(scrollPane);
        middlePanel.revalidate();
        middlePanel.repaint();
    }
    public  void showBorrowBook(JPanel middlePanel, JPanel topPanel, String panelColor){
        middlePanel.setVisible(false);
        topPanel.setVisible(false);
        JPanel panel = new JPanel();
        this.add(panel);

        panel.setBounds(210, 5, 710, 550 );
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#051226"), 3));
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
