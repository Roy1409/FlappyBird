import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;


public class DisplayPanel extends JPanel implements ActionListener {
    private String str;
    private String userName;
    private String message;
    private JButton submit;
    private BufferedImage bird;
    private JTextField textField;
    private int birdX;
    public DisplayPanel() {
    birdX=150;
        message = "Welcome To Flappy Bird!";

        try {
            bird = ImageIO.read(new File("src\\bird.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        textField = new JTextField(10);
        add(textField);

        submit = new JButton("Start Game!");
        submit.addActionListener(this);
        add(submit);
        Timer time=new Timer(10,this);
        time.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString(message, 225, 100);
        g.drawImage(bird, birdX, 150, null);
        g.setColor(Color.BLACK);
        g.drawString("Enter your name!", 260, 150);
        textField.setLocation(270, 150);
        submit.setLocation(270, 250);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton casted = (JButton) e.getSource();


            if (casted == submit) {
                // obtain string from text field
                String enteredText = textField.getText();

                // update message to the entered text
                userName=enteredText;

                // refresh the screen so that the updated message gets displayed
                repaint();


            }



        }
        if(e.getSource() instanceof Timer) {
            birdX+=2;



        }

        if (birdX==600) {
            birdX=-150;
        }

        repaint();

    }





}