import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame{

    private Main() {
        WeatherPanel weatherPanel = new WeatherPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        weatherPanel.setSize(800,600);
        weatherPanel.setFocusable(false);
        weatherPanel.requestFocusInWindow();
        this.add(weatherPanel);
    }

    public static void main(String[] args)  {
        try {
            Data.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main frame = new Main();
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}