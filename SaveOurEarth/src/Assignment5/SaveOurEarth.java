package Assignment5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * <pre>
 *     Program : SaveOurEarth
 * @author : Taekyung.Kil
 * Date : 05/July/2019
 *
 * Purpose : Draw canvas , Set all componets
 * </pre>
 */
public class SaveOurEarth extends JFrame {
    private Image screenImage;
    private Graphics screenGraphic;

    /**
     * set background image , buttons, star, variables
     */
    private Image introBackground = new ImageIcon(Main.class.getResource("background.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("menu.jpg")));


    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("exit.jpg"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("exit.jpg"));
    private JButton exitButton = new JButton(exitButtonBasicImage);

    private int mouseX, mouseY;



    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("START1.jpg"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("START1.jpg"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("QUIT1.jpg"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("QUIT1.jpg"));




    private boolean isMainScreen = true;
    private boolean isGameScreen = false;
    private boolean isGameOver = false;


    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);

    public static Game game = new Game();

    Star star1 = new Star(100, 300, 10);
    Star star2 = new Star(220, 300, 10);
    Star star3 = new Star(320, 400, 10);
    Star star4 = new Star(420, 250, 10);

    //To get Score
    private int starNum = star1.getSC() + star2.getSC() + star3.getSC() + star4.getSC();
    private String str = Integer.toString(starNum);


    public SaveOurEarth() {

        setUndecorated(true);
        setTitle("Save Our Earth");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);


        /**
         * add Key listener
         */
        addKeyListener(new KeyListener());


        /**
         * Exit Button
         */
        exitButton.setBounds(440, 0, 50, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        //To use mouse
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        //Add Exit Button
        add(exitButton);

        /**
         * Menu Bar
         */
        menuBar.setBounds(0, 0, 480, 30);
        /**
         * To use mouse
         */
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });

        //Add Menu Bar
        add(menuBar);

        /**
         * StartButton
         */
        startButton.setBounds(40, 200, 100, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        /**
         * To use mouse
         */
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon((startButtonBasicImage));
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // game start
                startButton.setVisible(false);
                quitButton.setVisible(false);
                introBackground = new ImageIcon(Main.class.getResource("background.png")).getImage();
                isMainScreen = false;
                gameStart();


            }

        });
        //Add Start Button
        add(startButton);


        /**
         * Quit button
         */
        quitButton.setBounds(350, 200, 100, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        /**
         * To use mouse
         */
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon((quitButtonBasicImage));
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }

        });
        //Add QUIT Button
        add(quitButton);





    }

    /**
     * Game Screen
     */
    public void gameStart() {
        isMainScreen = false;
        quitButton.setVisible(false);
        startButton.setVisible(false);
        introBackground = new ImageIcon(Main.class.getResource("background.png")).getImage();
        isGameScreen = true;

    }


    /**
     * Add components to the screen
     * @param g
     */
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
        starNum = star1.getSC() + star2.getSC() + star3.getSC() + star4.getSC();
        String str = Integer.toString(starNum);

        // Main Screen
        if(isMainScreen) {
            Font currentFont2 = g.getFont();
            Font newFont2 = currentFont2.deriveFont(currentFont2.getSize() * 3.0F);
            g.setFont(newFont2);
            g.setColor(Color.CYAN);
            g.drawString("Save Our Earth  ", 120, 200);

        }

        /**
         * When playing game
         */
        if (isGameScreen) {

            Font currentFont = g.getFont();
            Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
            g.setFont(newFont);
            g.setColor(Color.WHITE);
            g.drawString("Score : ", 380, 50);
            g.drawString(str, 440, 50);

            star1.eatStar();
            star2.eatStar();
            star3.eatStar();
            star4.eatStar();

            star1.screenDraw(g);
            star2.screenDraw(g);
            star3.screenDraw(g);
            star4.screenDraw(g);

            //Finish the game
            if (starNum == 4) {

                isGameOver = true;
            }
            if(isGameOver){
                Font currentFont1 = g.getFont();
                Font newFont1 = currentFont.deriveFont(currentFont1.getSize() * 1.4F);
                g.setFont(newFont1);
                g.setColor(Color.RED);
                g.drawString("GAME OVER", 170, 320);}
            }

    }

    /**
     * Add components to the screen
     * @param g
     */

    public void screenDraw(Graphics2D g) {
        setFocusable(true);
        g.drawImage(introBackground, 0, 0, null);
        if (isGameScreen) {
            game.screenDraw(g);
        }
        paintComponents(g);
            this.repaint();
        }
    }



