import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyListener;

public class jFrame  {

    public jFrame() {

        // create a JFrame (a window) and with a particular text for the title bar
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


        frame.setSize(750, 600);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        DisplayPanel panel = new DisplayPanel();

        frame.add(panel);

        frame.setVisible(true);
//        frame.addKeyListener(new DisplayPanel());

    }





}