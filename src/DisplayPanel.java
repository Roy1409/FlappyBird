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
    public DisplayPanel() {
        message = "Welcome To Flappy Bird!";

        try {
            img =ImageIO.read(new File("src\\bird.png"));
            pipe = ImageIO.read(new File("src\\pipe.png"));
            pipe2=ImageIO.read(new File("src\\pipe2.png"));
            background = ImageIO.read(new File("src\\a.png"));
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
        g.drawImage(background, 0, -100, null);
        g.drawImage(pipe,0,0,null);
        g.drawImage(pipe2,50,50,null);
        g.drawImage(img,100,100,null);

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
                userName = enteredText;

                // refresh the screen so that the updated message gets displayed
                repaint();


            }


        }


    }}