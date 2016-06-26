
package ball.shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

/***
 * Controller method manages the number of green ball and red ball
 * their movement everything
 * @author Shiam Chowdhury
 */
public class Controller {
    static LinkedList<GreenBall> greenball = new LinkedList<>();
    static LinkedList<RedBall> redball = new LinkedList<>();
    
    static LinkedList<TikGreenBall> tikgreen = new LinkedList<>();
    static LinkedList<CrossRedBall> crossred = new LinkedList<>();
    
    
    static GreenBall tempgreenball;
    
    static RedBall tempredball;
    static TikGreenBall temptikgreen;
    static CrossRedBall tempcrossred;
    public static int clickflag;
    
    public static int score=0;
    public static String highscore;
    public static int cross=0;
    
    public Controller(){
        addGreenBall(new GreenBall(50, -40));
        addGreenBall(new GreenBall(500, -40));
        addGreenBall(new GreenBall(0, 500));
        addGreenBall(new GreenBall(700, 500));
        addGreenBall(new GreenBall(250, 380));
        addGreenBall(new GreenBall(300, -40));
        addGreenBall(new GreenBall(300, -50));
        addGreenBall(new GreenBall(200, 500));
        addGreenBall(new GreenBall(600, -50));
        addGreenBall(new GreenBall(100, 200));
        addGreenBall(new GreenBall(500, 300));
        addGreenBall(new GreenBall(350, 500));
        addRedBall(new RedBall(0, 150));
        addRedBall(new RedBall(-100, 300));
        addRedBall(new RedBall(-50, 450));
        addRedBall(new RedBall(210, -100));
        addRedBall(new RedBall(420, -50));
        addRedBall(new RedBall(640, 0));
        addRedBall(new RedBall(210, 400));
        addRedBall(new RedBall(420, 460));
        addRedBall(new RedBall(640, 300));
        addRedBall(new RedBall(650, 150));
        addRedBall(new RedBall(550, 300));
        addRedBall(new RedBall(300, 450));
        addTikCrossBall();
//        addCrossRedBall(new CrossRedBall(430, 20));
//        addCrossRedBall(new CrossRedBall(460, 20));
//        addCrossRedBall(new CrossRedBall(490, 20));
//        addCrossRedBall(new CrossRedBall(520, 20));
//        addCrossRedBall(new CrossRedBall(550, 20));
//        addTikGreenBall(new TikGreenBall(430, 20));
//        addTikGreenBall(new TikGreenBall(460, 20));
//        addTikGreenBall(new TikGreenBall(490, 20));
//        addTikGreenBall(new TikGreenBall(520, 20));
//        addTikGreenBall(new TikGreenBall(550, 20));
        
        
    }
    
    /***
     * this method adds tick and cross ball indicating life during game
     */
    public static void addTikCrossBall()
    {
        addCrossRedBall(new CrossRedBall(430, 20));
        addCrossRedBall(new CrossRedBall(460, 20));
        addCrossRedBall(new CrossRedBall(490, 20));
        addCrossRedBall(new CrossRedBall(520, 20));
        addCrossRedBall(new CrossRedBall(550, 20));
        addTikGreenBall(new TikGreenBall(430, 20));
        addTikGreenBall(new TikGreenBall(460, 20));
        addTikGreenBall(new TikGreenBall(490, 20));
        addTikGreenBall(new TikGreenBall(520, 20));
        addTikGreenBall(new TikGreenBall(550, 20));
    }
    
    /***
     * this method draws the images of the ball
     * @param g2d 
     */
    public void draw(Graphics2D g2d){
        for(int i = 0 ; i < greenball.size() ; ++i){
            tempgreenball = greenball.get(i);
            
            tempgreenball.draw(g2d);
        }
        
        for(int j = 0 ; j < redball.size() ; ++j){
            tempredball = redball.get(j);
            
            tempredball.draw(g2d);
        }
        
        for(int i = 0 ; i < crossred.size() ; ++i){
            tempcrossred = crossred.get(i);
            tempcrossred.draw(g2d);
        }
        
        for(int i = 0 ; i < tikgreen.size() ; ++i){
            temptikgreen = tikgreen.get(i);
            temptikgreen.draw(g2d);
        }
        
        
    }
    /***
     * this method is responsible for updating the current position of red and green ball
     */
    public void update(){
        for(int i = 0 ; i < greenball.size() ; ++i){
            tempgreenball = greenball.get(i);
            tempgreenball.update();
        }
        
        for(int j = 0 ; j < redball.size() ; ++j){
            tempredball = redball.get(j);          
            tempredball.update();
        }
    }
    /***
     * this method manages what will happens after fire the ball or the empty space
     */
    public static void fire(){
        
        for(int i = 0 ; i < redball.size() ; ++i)
        {
            tempredball = redball.get(i);
            int j = 1;
            if((ClickMenu.mx>=tempredball.x+7 && ClickMenu.mx<=tempredball.x+28)
                    && (ClickMenu.my>=tempredball.y+7 && ClickMenu.my<=tempredball.y+28))
            {
                if(Game.state==Game.STATE.GAME){
                score-=1;
                clickflag = 1;
                break;
                }
            }
        }
        
        for(int i = 0 ; i < greenball.size() ; ++i){
            tempgreenball = greenball.get(i);
            
            if((ClickMenu.mx>=tempgreenball.x+3 && ClickMenu.mx<=tempgreenball.x+28)
                    && (ClickMenu.my>=tempgreenball.y+3 && ClickMenu.my<=tempgreenball.y+28 ))
            {
                if(Game.state==Game.STATE.GAME){
                //System.out.println("fire");
                removeGreenBall(i);
                score+=1;
                Random rand = new Random(); 
                int value = rand.nextInt(640);
                addGreenBall(new GreenBall(value, -40));
                ClickMenu.mx = -1;
                ClickMenu.my = -1;
                clickflag = 1;
                break;
                }
            }
            //tempgreenball.update();
        }
        
        if(Game.state==Game.STATE.GAME && clickflag == 0)// && (MouseClick.mx <= 12 && MouseClick.mx >= 67) &&
                //(MouseClick.my <= 358 && MouseClick.my >= 413)) 
        {
            removeTikGreenBall(cross);
        }
            
        
    }
    /***
     * add green ball to the liknedlist
     * @param gb 
     */
    public static void addGreenBall(GreenBall gb){
        greenball.add(gb);
    } 
    /***
     * add red ball to the liknedlist
     * @param rb 
     */
    public void addRedBall(RedBall rb){
        redball.add(rb);
    }
   /***
    * remove green ball from the liknedlist
    * @param index 
    */
    public static void removeGreenBall(int index){
        greenball.remove(index);
    }
    /***
     * remove tickgreenball(life) ball from the screen
     * @param tikgb 
     */
    public static void addTikGreenBall(TikGreenBall tikgb){
        tikgreen.add(tikgb);
    }
    /***
     * remove tickgreenball from the screen
     * @param index 
     */
    public static void removeTikGreenBall(int index){
        tikgreen.remove(index);
        if(tikgreen.size() == 0){
            
            Game.state = Game.STATE.GAMEOVER;
        }
            
    }
    /***
     * add crossredball from the screen
     * @param crossrb 
     */
    public static void addCrossRedBall(CrossRedBall crossrb){
        crossred.add(crossrb);
    }
    
    /***
     * remove crossredball from the screen
     */
    public static void removeCrossRedBall(){
        crossred.remove();
        crossred.remove();
        crossred.remove();
        crossred.remove();
        crossred.remove();
        //System.out.println("red cross size: " + crossred.size());
    }
    
    /***
     * this method prints the score
     * @param g2d 
     */
    public static void printScore(Graphics2D g2d){
        String s = Integer.toString(score);
        Font font = new Font("Serif",Font.BOLD,25);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString(s, 40, 45);
    }
    
    /***
     * this method prints the high score on the gameover screen
     * @param g2d 
     */
    public static void printHighScore(Graphics2D g2d){
        Font font = new Font("Serif",Font.BOLD,25);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);
        g2d.drawString(highscore, 355, 220);
        
        Font font2 = new Font("arial", Font.BOLD, 20);
        g2d.setFont(font2);
        g2d.drawString("HIGH SCORE:", 210, 220);
    }
    public static LinkedList<GreenBall> getGreenBallBounds(){
        return greenball;
    }
    
    public static LinkedList<RedBall> getRedBallBounds(){
        return redball;
    }
    
}
