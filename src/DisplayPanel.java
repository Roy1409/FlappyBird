import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import javax.swing.JButton;


public class DisplayPanel extends JPanel implements ActionListener, KeyListener {
    private boolean a;
    private BufferedImage pipe2;
    private String userName;
    private String message;
    private JButton submit;
    private BufferedImage background;
    private BufferedImage pipe;
    private BufferedImage img;
    private BufferedImage logo;
    private JTextField textField;
    private BufferedImage start;
    private BufferedImage bird2;
    private BufferedImage space;
    private BufferedImage shop;
    private BufferedImage floor;
    private int birdX;
    private BufferedImage shopButton;
    private int floorX;
    private boolean c;
    private int bird2Y;
    private Timer time;
    private JButton button1;

    private JButton button;
    private int birdY;
    private boolean b=false;
    private int bird2X;
    public DisplayPanel() {

        floorX=0;
        bird2Y=150;
        bird2X=150;
        birdX=200;
        birdY=100;
        button = new JButton("");

        button.setOpaque(false);
       button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorderPainted(true);
        button.setBorder(null);
        button.addActionListener(this);
        button1 = new JButton("");
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setFocusable(false);
        button1.setBorderPainted(true);
        button1.setBorder(null);
        button1.addActionListener(this);




        try {
            img =ImageIO.read(new File("src\\bird.png"));
            pipe = ImageIO.read(new File("src\\pipe.png"));
            pipe2 = ImageIO.read(new File("src\\pipe2.png"));
            logo = ImageIO.read(new File("src\\Logo.png"));
            start =ImageIO.read(new File("src\\Start.png"));
            floor = ImageIO.read(new File("src\\floor.png"));
            shop= ImageIO.read(new File("src\\shop.png"));
            background = ImageIO.read(new File("src\\a.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        time= new Timer(150,this);
        time.start();


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawImage(background, 0, -100, null);g.drawImage(background, 0, -100, null);
        if (!a && !c){
        g.drawImage(pipe,450,300,null);
        g.drawImage(pipe2,375,-150,null);
        g.drawImage(logo,75,50,null);
        g.drawImage(start,80,300,this);
        g.drawImage(img,birdX,birdY,null);
        g.drawImage(shop,360,280,null);
            g.drawImage(floor,floorX,460, null);

        add(button);
        button.setSize(300,110 );

        button.setLocation(80,300);

            add(button1);
            button1.setSize(150,150 );

            button1.setLocation(360,280);

        } else if (c)



        {

        g.drawImage(shopButton,200,0,null);
        }


       if (a) {
            g.drawImage(bird2,bird2X,bird2Y,null);
            g.drawImage(space,250,50,null);
            g.drawImage(floor,floorX,460, null);





        }

        g.drawImage(floor,floorX,460, null);






    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton casted = (JButton) e.getSource();
            if (casted==button) {
            a= true;
            Start();
            } else
            if (casted==button1) {
                a=false;
                c=true;
                shop();

            }

        }

    if(e.getSource() instanceof Timer){
        birdY+=30;
        floorX-=30;
        birdX+=30;
        if (birdX>750) {
            birdX=100;
        }

        if (floorX<-400) {
            floorX=-10;

        }

                if (b) {
                bird2Y+=10; }



    }


    if (birdY==160) {
        birdY-=90;
    }


        repaint();
        }




    public void keyTyped(KeyEvent e) { }


    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
           b=true;
            System.out.println(b);
            System.out.println("PRESSED");
            System.out.println(bird2Y);
            repaint();
        }


    }


    public void keyReleased(KeyEvent e) { }

    // must add all 5 of the following methods, which are required by MouseListener interface

    public void mouseClicked(MouseEvent e) {
    } // leave empty; don't need this one


    public void mousePressed(MouseEvent e) { } // leave empty; don't need this one

    // when the user clicks either mouse button (left or right),
    // this method is called by the system when the user lets go of the mouse button

    public void mouseReleased(MouseEvent e) {
    }


    public void mouseEntered(MouseEvent e) { } // leave empty; don't need this one


    public void mouseExited(MouseEvent e) { } // leave empty; don't need this one


    public void Start() {
        try {
            bird2 = ImageIO.read(new File("src\\bird2.png"));
            space = ImageIO.read(new File("src\\space.png"));
            background = ImageIO.read(new File("src\\a.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void shop() {
            try{
                shopButton=ImageIO.read(new File("src\\shopButton.png"));
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
    }



}

