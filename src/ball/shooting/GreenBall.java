
package ball.shooting;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;
/***
 * this class is for green ball extends globalposition class
 * @author Shiam Chowdhury
 */
public class GreenBall extends GlobalPosition{

    private String greenballimage = "/images/smallgreenball.png";
    
    private LinkedList<GreenBall> greenball = Controller.getGreenBallBounds();
    
    double speedx = 1.5;
    double speedy = 1.5;
    double incre = 1.5;
    double decre = 1.5;
    /***
     * position of greenball
     * @param x
     * @param y 
     */
    public GreenBall(int x, int y) {
        super(x, y);
    }
    /***
     * updates position of green ball
     */
    public void update(){
        x+=speedx; 
        y+=speedy;
        Random rand = new Random(); 
        incre = rand.nextInt(3);
        decre = rand.nextInt(3);
        if(x>BallShooting.WIDTH-43){
            speedx = -decre;
        }
        if(x<0){
            speedx = incre;
        }
        
        if(y>=BallShooting.HEIGHT-56)
        {
            speedy = -decre;
        }
        
        if(y<0)
        {
            speedy = incre;
        }
        
        //afterShoot();
            
    }
    
   /* 
    public void afterShoot(){
        for(int i = 0 ; i < greenball.size() ; i++){
            if((MouseClick.mx>=x+3 && MouseClick.mx<=x+28)
                    && (MouseClick.my>=y+3 && MouseClick.my<=y+28 ))
            {
                System.out.println("fire");
                MouseClick.mx = -1;
                MouseClick.my = -1;
            }
            
        }
    }
    
    */
    /***
     * draws rectangle under green ball
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x+1,y+1,28,28);
    }
    /***
     * this method draws images of greenball
     * @param g2d 
     */
    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImage(), x,y, null); 
        
        //g2d.draw(getBounds());
    }
    /***
     * this method is loading the image
     * @return 
     */
    public Image getPlayerImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(greenballimage));
        return i.getImage();
    }
     
}
