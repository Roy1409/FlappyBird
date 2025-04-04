import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.Rectangle;

public class DisplayPanel extends JPanel implements ActionListener, KeyListener {
    private boolean a;

    private BufferedImage pipe2;
    private BufferedImage background;
    private BufferedImage pipe;
    private BufferedImage img;
    private BufferedImage logo;
    private BufferedImage start;
    private boolean f;
    private boolean h;

    private BufferedImage tryAgain;
    private BufferedImage bird2;
    private BufferedImage space;
    private BufferedImage shop;
    private BufferedImage floor;
    private BufferedImage pipes;
    private BufferedImage pipes2;
    private boolean d;
    private JLabel y;
    private int pipesX;
    private int pipesY;
    private int birdX;
    private BufferedImage shopButton;
    private int floorX;
    private boolean c;
    private int bird2Y;
    private Timer time;
    private BufferedImage gameOver;
    private JButton button1;
    private JButton button;
    private JButton button2;
    private int birdY;
    private boolean b=false;
    private int bird2X;
    private String score;
    public DisplayPanel() {
        score="0";
        floorX=0;
        bird2Y=150;
        bird2X=150;
        birdX=200;
        birdY=100;
        pipesX = 750;
        pipesY = -300;
        button = new JButton("");
        button2= new JButton("");
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
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusable(false);
        button2.setBorderPainted(true);
        button2.setBorder(null);
        button2.addActionListener(this);




        try {
            tryAgain=ImageIO.read(new File("src\\tryAgain.png"));
            shopButton=ImageIO.read(new File("src\\shopButton.png"));
            bird2 = ImageIO.read(new File("src\\bird2.png"));
            space = ImageIO.read(new File("src\\space.png"));
            background = ImageIO.read(new File("src\\a.png"));
            gameOver=ImageIO.read(new File("src\\gameOver.png"));
            pipes = ImageIO.read(new File("src\\pipes.png"));
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
        y=new JLabel(score);
        add(button);
        add(y);
        add(button1);
        y.setVisible(false);


        time= new Timer(15,this);
        time.start();
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
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

            y.setSize(200,200);
            y.setFont(new Font("Courier", Font.BOLD,75));
            button.setSize(300,110 );

            button.setLocation(80,300);


            button1.setSize(150,150 );

            button1.setLocation(360,280);

            button2.setSize(200,111);
            button2.setLocation(250,250);

        } else if (c)
        {
            g.drawImage(shopButton,200,0,null);
        }
        if (a) {
            if (!b) {
                g.drawImage(space,250,50,null);

            }
            y.setVisible(true);
            y.setText(score);
            g.drawImage(bird2,bird2X,bird2Y,null);
            g.drawImage(floor,floorX,460, null);
            g.drawImage(pipes, pipesX, pipesY, null);
            System.out.println(score);
        }
        g.drawImage(floor,floorX,460, null);

        if (d ) {
            this.add(button2);
            g.drawImage(gameOver,135,100,null);
            g.drawImage (tryAgain,250,250,null);
        }
    }


    public void actionPerformed(ActionEvent e) {
        int x=bird2.getWidth()-70;
        int y=bird2.getHeight()-70;
        int x1=pipes.getWidth()-70;
        int y1=pipes.getHeight()-70;
        Rectangle bird2=new Rectangle(bird2X,bird2Y,x,y);
        Rectangle pipesTop=new Rectangle(pipesX,pipesY,x1,y1);


        if (bird2.intersects(pipesTop)) {
            if (a && b) {
                System.out.println("TOUCH");
                d = true; } }



        if (e.getSource() instanceof JButton) {
            JButton casted = (JButton) e.getSource();
            if (casted == button) {
                a = true;
                remove(button);
                remove(button1);
                repaint();
            }
            else if (casted == button1) {
                a = false;
                c = true;
                remove(button);
                remove(button1);
                repaint();
            }
            else if (casted == button2) {
                System.out.println("Try Again clicked");

                bird2Y = 150;
                b = false;
                d = false;
                score = "0";
                pipesX = 750;
                pipesY = -300;

            }
        }


        if (e.getSource() instanceof Timer) {
            floorX -= 4;

            if (pipesX == bird2X) {
                score = Integer.toString(Integer.parseInt(score) + 1);
            }

            if (pipesX < -100) {
                pipesY = (int) (Math.random() * (-400 - (-200) + 1) + (-200));
                pipesX = 750;
            }

            if (birdX > 750) {
                birdX = 100;
            }

            if (floorX < -400) {
                floorX = -1;
            }

            if (h) {
                bird2Y -= 40;
                h = false;
            }

            if (b && !d) {
                f = true;
                bird2Y += 2;
                pipesX -= 10;
            }
        }


        if (bird2Y == 340) {
            d = true;
        }
        if (birdY == 16) {
            birdY -= 9;
        }

        repaint();
        requestFocusInWindow();
    }


    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            b=true;
        }
        if ( f &&e.getKeyCode() == KeyEvent.VK_SPACE) {
            h=true;
        }
        requestFocusInWindow();

    }


    public void keyReleased(KeyEvent e) { }

    // must add all 5 of the following methods, which are required by MouseListener interface

    public void mouseClicked(MouseEvent e) {
    } // leave empty; don't need this one


    public void mousePressed(MouseEvent e) { } // leave empty; don't need this one


    public void mouseReleased(MouseEvent e) {
    }


    public void mouseEntered(MouseEvent e) { } // leave empty; don't need this one


    public void mouseExited(MouseEvent e) { } // leave empty; don't need this one




}

