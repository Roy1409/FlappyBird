import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class DisplayPanel extends JPanel implements ActionListener {
    private String str;
    private BufferedImage pipe2;
    private String userName;
    private String message;
    private JButton submit;
    private BufferedImage background;
    private BufferedImage pipe;
    private BufferedImage img;
    private JTextField textField;
    private int birdX;
    private int birdY;
    public DisplayPanel() {
        birdX=200;
        birdY=100;
        message = "Welcome To Flappy Bird!";

        try {
            img =ImageIO.read(new File("src\\bird.png"));
            pipe = ImageIO.read(new File("src\\pipe.jpg"));
            pipe2 = ImageIO.read(new File("src\\pipe2.png"));

            background = ImageIO.read(new File("src\\a.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Timer time= new Timer(200,this);
        time.start();


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString(message, 225, 100);
        g.drawImage(background, 0, -100, null);
        g.drawImage(pipe,450,300,null);
        g.drawImage(pipe2,375,-150,null);

        g.drawImage(img,birdX,birdY,null);


    }


    public void actionPerformed(ActionEvent e) {
    if(e.getSource() instanceof Timer) {
        birdY+=30;
        birdX+=30;
        if (birdX>750) {
            birdX=100;
        }
    }


    if (birdY==160) {
        birdY-=90;
    }



repaint();

        }


    }