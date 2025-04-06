import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DisplayPanel extends JPanel implements ActionListener, KeyListener {
    private boolean a;
    private ArrayList<Player> playerList;
    private JTextField textField;
    private BufferedImage pipe2;
    private BufferedImage background;
    private String message;
    private BufferedImage pipe;
    private BufferedImage img;
    private JButton button4;
    private boolean p;
    private String lbMessage=" ";
    private boolean k;
    private BufferedImage logo;
    private BufferedImage start;
    private int saveScore;
    private boolean f;
    private JButton button3;
    private JLabel label;
    private BufferedImage tryAgain;
    private BufferedImage space;
    private BufferedImage shop;
    private BufferedImage floor;
    private BufferedImage pipes;
    private BufferedImage pipesBottom;
    private BufferedImage top;
private BufferedImage lb;
    private BufferedImage bottom;
    private boolean d;
    private BufferedImage save;
    private JLabel y;
    private int pipesX;
    private int pipesY;
    private int pipesBX;
    private int pipesBY;
    private int topX;
    private int topY;
    private String str;
    private int bottomX;
    private int bottomY;
    private int birdX;
    private BufferedImage shopButton;
    private int floorX;
    private boolean c;
    private int bird2Y;
    private leaderboard lbs;
    private double velocity;
    private Timer time;
    private BufferedImage gameOver;
    private JButton button1;
    private JButton button;
    private JButton button2;
    private int birdY;
    private boolean b=false;
    private int bird2X;
    private String score;

    private BufferedImage bird2;
    private BufferedImage bird2up;
    private BufferedImage bird2down;
    private BufferedImage blue;
    private BufferedImage blueUp;
    private BufferedImage blueDown;
    private BufferedImage red;
    private BufferedImage redUp;
    private BufferedImage redDown;

    private BufferedImage[][] animation = new BufferedImage[3][3];
    private int animationFrame;
    private int animationVariant;
    private int animationTime;

    public DisplayPanel() {
         lbs =new leaderboard();
        playerList= new ArrayList<>();
        str="Click 1/2/3 to change color";
        message="Enter Name to save score (then click enter):";
        score="0";
        floorX=0;
        animationFrame = 0;
        animationVariant = 0;
        animationTime = 0;
        bird2Y=150;
        bird2X=150;
        birdX=200;
        birdY=100;
        pipesX = 750;
        pipesBX = 750;
        pipesY = -300;
        pipesBY = pipesY + 635;
        topX = 1200;
        bottomX = 1200;
        topY = -300;
        bottomY = topY + 635;
        button4= new JButton("ENTER");
        button = new JButton("");
        button1 = new JButton("");
        button2= new JButton("");
        button3= new JButton("");
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorderPainted(true);
        button.setBorder(null);
        button.addActionListener(this);
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
        button3.addActionListener(this);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setFocusable(false);
        button3.setBorderPainted(true);
        button3.setBorder(null);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button4.setFocusable(false);

        try {
            lb=ImageIO.read(new File("src\\leaderboard.jpg"));
            save = ImageIO.read(new File("src\\save.png"));
            tryAgain=ImageIO.read(new File("src\\tryAgain.png"));
            shopButton=ImageIO.read(new File("src\\shopButton.png"));
            //YELLOW BIRD
            bird2 = ImageIO.read(new File("src\\bird2.png"));
            bird2up = ImageIO.read(new File("src\\bird2up.png"));
            bird2down = ImageIO.read(new File("src\\bird2down.png"));
            //BLUE BIRD
            blue = ImageIO.read(new File("src\\blue.png"));
            blueUp = ImageIO.read(new File("src\\blueup.png"));
            blueDown = ImageIO.read(new File("src\\bluedown.png"));
            //RED BIRD
            red = ImageIO.read(new File("src\\red.png"));
            redUp = ImageIO.read(new File("src\\redup.png"));
            redDown = ImageIO.read(new File("src\\reddown.png"));

            space = ImageIO.read(new File("src\\space.png"));
            background = ImageIO.read(new File("src\\a.png"));
            gameOver=ImageIO.read(new File("src\\gameOver.png"));
            pipes = ImageIO.read(new File("src\\pipes.png"));
            pipesBottom = ImageIO.read(new File("src\\pipesbottom.png"));
            top = ImageIO.read(new File("src\\top.png"));
            bottom = ImageIO.read(new File("src\\bottom.png"));
            img =ImageIO.read(new File("src\\bird.png"));
            pipe = ImageIO.read(new File("src\\pipe.png"));
            pipe2 = ImageIO.read(new File("src\\pipe2.png"));
            logo = ImageIO.read(new File("src\\Logo.png"));
            start =ImageIO.read(new File("src\\Start.png"));
            floor = ImageIO.read(new File("src\\floor.png"));
            animation[0][0] = bird2;
            animation[0][1] = bird2up;
            animation[0][2] = bird2down;
            animation[1][0] = blue;
            animation[1][1] = blueUp;
            animation[1][2] = blueDown;
            animation[2][0] = red;
            animation[2][1] = redUp;
            animation[2][2] = redDown;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        label=new JLabel(" ");
        y=new JLabel(score);
        add(button);
        add(y);
        add(label);
        label.setVisible(false);
        y.setVisible(false);
        label.setForeground(Color.black);
        textField = new JTextField(20);
        time= new Timer(15,this);
        time.start();
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Monospaced", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawImage(background, 0, -100, null);
        if (!a && !c){
            g.drawImage(pipe,450,300,null);
            g.drawImage(pipe2,375,-150,null);
            g.drawImage(logo,75,50,null);
            g.drawImage(start,80,300,this);
            g.drawImage(img,birdX,birdY,null);
            g.drawImage(shop,360,280,null);
            g.drawImage(floor,floorX,460, null);
            y.setSize(300,300);
            label.setFont(new Font("Monospaced", Font.BOLD,30));
            label.setSize(5,2);
            label.setLocation(0,100);
            y.setFont(new Font("Monospaced", Font.BOLD,75));
            button.setSize(300,110 );
            button.setLocation(80,300);
            button1.setSize(100,108 );
            button1.setLocation(475,250);
            button2.setSize(200,111);
            button2.setLocation(250,250);
            button3.setSize(150,150);
            button3.setLocation(75,220);
            button4.setLocation(250,150);
            button4.setSize(200,50);
        }
        if (a) {
            if (!b) {
                g.drawImage(space,250,50,null);
            }

            y.setVisible(true);
            y.setText(score);
            label.setText("<html>CLICK R TO GO BACK<br>" + lbMessage + "</html>");
            g.drawString(str,25,50);
            g.drawImage(animation[animationVariant][animationFrame], bird2X, bird2Y, null);
            g.drawImage(floor,floorX,460, null);
            g.drawImage(pipes, pipesX, pipesY, null);
            g.drawImage(pipesBottom, pipesBX, pipesBY, null);
            g.drawImage(top, topX, topY, null);
            g.drawImage(bottom, bottomX, bottomY, null);
        }
        g.drawImage(floor,floorX,460, null);
        if (d && !c) {
            setLayout(null);
            this.add(button1);
            this.add(button2);
            this.add(button3);
            repaint();
            revalidate();
            g.drawImage(lb,475,250,null);
            g.drawImage(save,75,220,null);
            g.drawImage(gameOver,135,100,null);
            g.drawImage (tryAgain,250,250,null);
        }
        if (p) {
            g.drawString(message,225,100);
        }
    }
    public void actionPerformed(ActionEvent e) {
        int birdWidth = animation[0][animationFrame].getWidth() - 10;
        int birdHeight = animation[0][animationFrame].getHeight() - 10;
        Rectangle bird2 = new Rectangle(bird2X + 5, bird2Y + 5, birdWidth, birdHeight);
        Rectangle pipe1Top = new Rectangle(pipesX, pipesY, pipes.getWidth(), pipes.getHeight());
        Rectangle pipe1Bottom = new Rectangle(pipesBX, pipesBY, pipesBottom.getWidth(), pipesBottom.getHeight());
        Rectangle pipe2Top = new Rectangle(topX, topY, top.getWidth(), top.getHeight());
        Rectangle pipe2Bottom = new Rectangle(bottomX, bottomY, bottom.getWidth(), bottom.getHeight());
        repaint();
        if (bird2.intersects(pipe1Top) || bird2.intersects(pipe1Bottom) ||
                bird2.intersects(pipe2Top) || bird2.intersects(pipe2Bottom)) {
            if (a && b) {
                d = true;
            }
        }
        if (e.getSource() instanceof JButton) {
            JButton casted = (JButton) e.getSource();
            if (casted == button) {
                a = true;
                remove(button);
                remove(button1);
                repaint();
            }
            else if (casted == button1) {
                if (textField.isVisible()) {
                    textField.setVisible(false);
                }
                y.setVisible(false);
                p=false;
                remove(button4);
                a = false;
                c=true;
                remove(button);
                remove(button1);
                k=true;
                if (lbs.getList() !=null) {
                    lbMessage="";
                    lbMessage=lbs.playerData();
                    k=true;
                    label.setLocation(20,-200);
                    label.setSize(new Dimension(750, 750));  // Force label size
                    label.setVisible(true);
                    label.setText("<html>CLICK R TO GO BACK<br>"+lbMessage+"<html>");
                    }
            }
            else if (casted == button2) {
                p=false;
                textField.setVisible(false);
                System.out.println("Try Again clicked");
                bird2Y = 150;
                b = false;
                d = false;
                saveScore=Integer.parseInt(score);
                score = "0";
                pipesX = 750;
                pipesY = -300;
                pipesBX = 750;
                pipesBY = pipesY + 635;
                topX = 1200;
                bottomX = 1200;
                topY = (int) (Math.random() * (-400 - (-200) + 1) + (-200));;
                remove(button4);
                remove(button2);
                bottomY = topY + 635;
                message="Enter Name to save score (then click enter):";
            }
            if (casted==button3)  {
                add(button4);
                textField.setVisible(true);
                p=true;
                textField.setSize(80,20);
                textField.setLocation(300, 100);
                textField.requestFocusInWindow();
                add(textField);
                remove(button3);
            }
            if (casted==button4) {
                if (!(textField.getText().isEmpty())) {
                    System.out.println("HI");
                    message = "score saved on leaderboard";
                    saveScore = Integer.parseInt(score);
                    String name = textField.getText();
                    textField.setText("");
                    Player a = new Player(name, saveScore);
                    lbs.addData(a);
                    label.setText("<html>CLICK R TO GO BACK<br>"+lbMessage+"<html>");

                    requestFocusInWindow();
                }
            }
        }
        if (e.getSource() instanceof Timer) {
            floorX -= 5;
            if (pipesX < -200) {
                pipesY = (int) (Math.random() * (-400 - (-200) + 1) + (-200));
                pipesBY = pipesY + 635;
                pipesX = topX + 450;
                pipesBX = bottomX + 450;
            }
            if (topX < -200) {
                topY = (int) (Math.random() * (-400 - (-200) + 1) + (-200));
                bottomY = topY + 635;
                topX = pipesX + 450;
                bottomX = pipesBX + 450;
            }
            if (birdX > 750) {
                birdX = 100;
            }
            if (floorX < -460) {
                floorX = -30;
            }
            if (b && !d) {

                f = true;

                if (pipesX == bird2X) {
                    score = Integer.toString(Integer.parseInt(score) + 1);
                }
                if (topX == bird2X) {
                    score = Integer.toString(Integer.parseInt(score) + 1);
                }
                velocity += .5;
                bird2Y += velocity; // when velocity - bird go up
                if (bird2Y < 0 ){
                    bird2Y = -5;
                }
                if (animationTime > 10) {
                    animationFrame++;
                    animationTime = 0;
                }
                animationTime++;
                pipesX -= 5;
                pipesBX -= 5;
                topX -= 5;
                bottomX -= 5;
                if (animationFrame >= 3){
                    animationFrame = 0;
                }
            }
        }
        if (bird2Y > 415) { // less than 415 because velocity goes to fast
                d=true;

                add(button2);
        }
        if (birdY == 16) {
            birdY -= 9;
        }
        repaint();
        if (p) {
            //do nothing
        } else{
        requestFocusInWindow(); }
    }

    public void keyTyped(KeyEvent e) { }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            b=true;
        }
        if ( f &&e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocity = -7.7;
        }
        if (e.getKeyCode()== KeyEvent.VK_0) {
            animationVariant = 1;
        }
        if (e.getKeyCode()== KeyEvent.VK_1) {
            animationVariant = 2;
        }
        if (e.getKeyCode()== KeyEvent.VK_2) {
            animationVariant = 3;
        }

        if (e.getKeyCode()== KeyEvent.VK_R) {

            a=true;
            b=false;
            label.setVisible(false);
            d=false;
            c=false;
            bird2Y=150;
            bird2X=150;
            pipesX = 750;
            pipesBX = 750;
            pipesY = -300;
            pipesBY = pipesY + 635;
            topX = 1200;
            bottomX = 1200;
            topY = -300;
            bottomY = topY + 635;


            score="0";
            k=false;
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

