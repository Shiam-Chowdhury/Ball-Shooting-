
package ball.shooting;
/***
 * this is JPanel
 * Time Loop is here
 */
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener{

    private String background = "/images/ashback.jpg";
    private String helpbackground = "/images/scroll.png";
    private String backicon = "/images/backicon3.png";
    private String pause = "/images/pause.png";
    private String play = "/images/playicon.png";
    
    
    Timer gamelooptimer;
    Controller cont;
    Menu menu;
    GameOverScreen lastscreen; 
    HelpState helpstate;
    HighScore highscoreclass;
    ReadHighScore readhighscore;
    PauseScreen pausescreen;
    //public static int flag1=0,flag2;
    boolean running = false;
    String highs;
    //RedBall redball;
    public static  enum STATE{ 
        MENU,
        GAME,
        HELP,
        PAUSE,
        GAMEOVER
    };
     
    public static STATE state = STATE.MENU;
     
    /***
     * constructor of Game class
     */
    public Game(){
        setFocusable(true);  
        
        gameStart();
        menu = new Menu();
        lastscreen = new GameOverScreen();
        helpstate = new HelpState();
        pausescreen = new PauseScreen();
        
        
        //highscoreclass = new HighScore();
        /*readhighscore = new ReadHighScore();
        
        //highscoreclass.writeHighScore();
        readhighscore.openFile();
        Controller.highscore = readhighscore.readScore();*/
        
        updateRead();
        cont = new Controller();
        //this.addMouseListener(new MouseClick());
        this.addMouseListener(new ClickMenu());
        //this.addMouseListener(new LastSceenClick());
        //redball = new RedBall(200,200);
        
        
    }
    /***
     * this method updates high score if current score is greater than last high score
     * @param s 
     */
    public void updateHighScore(String s){
        highscoreclass = new HighScore();
        
        highscoreclass.writeHighScore(s);
    }
    /***
     * this method reads the current high score
     */
    public void updateRead(){
        readhighscore = new ReadHighScore();
        readhighscore.openFile();
        Controller.highscore = readhighscore.readScore();
    }
    /***
     * this method starts the game loop
     */
    public void gameStart(){
        if(!running){
            gamelooptimer = new Timer(10, this);
            gamelooptimer.start();
            running  = true;
        }
        else if(running){
            //System.exit(1);
            //System.out.println(System.currentTimeMillis()/1000);
            //running = false;
            
           // gamelooptimer.stop();
            
            //state = STATE.MENU;
            //gamelooptimer.start();
        }
    }
    /***
     * this is paint method for showing everything visually using Graphics2D class
     * @param g 
     */
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        
        
        if(state == STATE.MENU){
            g2d.drawImage(getBackgroundImage(), 0, 0, this);
            menu.menuScreen(g2d);
        }
        else if(state == STATE.GAME){
            
            g2d.drawImage(getPauseImage(), 0, 345, this);
            //pausescreen.showPause(g2d);
            cont.draw(g2d);
        
            try {
                cont.update();
            }catch (Exception exception) {}
        
            Controller.printScore(g2d);
        }
        
        else if(state == STATE.HELP){
            g2d.drawImage(getHelpBackgroundImage(), 17, 0, this);
            g2d.drawImage(getBackIconImage(), 250, 325, this);
            helpstate.backButton(g2d);
        }
        else if(state == STATE.PAUSE){
            g2d.drawImage(getPlayImage(), 170, 90, this);
            
            
            //pausescreen.resumeScreen(g2d);
        }
        else if(state == STATE.GAMEOVER){
            
            gameStart();
            int y = Integer.parseInt(Controller.highscore);
            if(Controller.score>y)
            {
                String s = Integer.toString(Controller.score);
                updateHighScore(s);
                updateRead();
            }
            lastscreen.gameOver(g2d);
            Controller.printHighScore(g2d);
        }
        
        //redball.draw(g2d);
        
        
    }
    
    /***
     *This method loads the background image using ImageIcon 
     * @return Image
     */
    
    
    public Image getBackgroundImage(){
        ImageIcon backgroungimage = new ImageIcon(getClass().getResource(background));
        return backgroungimage.getImage();
    }
    /***
     * /***
     *This method loads the background image using ImageIcon of help screen
     * @return Image
     */
     
    public Image getHelpBackgroundImage(){
        ImageIcon helpbackgroungimage = new ImageIcon(getClass().getResource(helpbackground));
        return helpbackgroungimage.getImage();
    }
    /***
     * /***
     *This method loads the background image using ImageIcon of pause screen
     * @return Image
     */
     
    public Image getPauseImage(){
        ImageIcon helpbackgroungimage = new ImageIcon(getClass().getResource(pause));
        return helpbackgroungimage.getImage();
    }
    /***
     * this method loads play icon on pause state
     * @return Image
     */
    public Image getPlayImage(){
        ImageIcon helpbackgroungimage = new ImageIcon(getClass().getResource(play));
        return helpbackgroungimage.getImage();
    }
    /***
     * 
     * @return Image
     */
    public Image getBackIconImage(){
        ImageIcon backiconimage = new ImageIcon(getClass().getResource(backicon));
        return backiconimage.getImage();
    }
    /***
     * actionperformed method is called every 10 miliseconds because of timer 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
        
        //redball.update();  
        
    }
    
}

