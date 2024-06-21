package pl.chylu;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Utworzenie instancji klasy swing oraz utworzenie parametrów okna (m.in rozmiar czy tytuł)
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Adventure Game v1.0");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(800, 600);

        //Pobranie rozmiarów ekranu oraz określenie wypośrodkowania otwarcia okna
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(screenSize.width / 2 - window.getWidth() / 2, screenSize.height / 2 - window.getHeight() / 2);

        //Dodanie klasy odpowiedzialnej za wyświetlanie treści w oknie
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        gamePanel.requestFocusInWindow();

        gamePanel.startGameThread();
    }
}