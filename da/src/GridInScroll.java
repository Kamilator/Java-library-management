import javax.swing.*;
import java.awt.*;

public class GridInScroll extends JFrame {

    public GridInScroll() {
        setTitle("Grid in ScrollPane");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel that will hold components using GridLayout
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(0, 1, 10, 10)); // 0 rows = auto expand downward
        gridPanel.setBackground(Color.WHITE);

        // Add sample components
        for (int i = 1; i <= 20; i++) {
            gridPanel.add(new JButton("Button " + i));
        }

        // Wrap grid panel inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(gridPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridInScroll();
    }
}
