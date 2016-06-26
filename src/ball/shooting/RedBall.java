
package ball.shooting;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/***
 * this class makes red ball
 * @author Shiam Chowdhury
 */
public class RedBall extends GlobalPosition {

    private String redball = "/images/smallred.png";
   double speedx = 5;
   double speedy = 5;
    /***
     * positions of red balls
     * @param x
     * @param y 
     */
    public RedBall(int x, int y) {
        super(x, y);
    }
    /***
     * update red ball position
     */
    public void update(){ 
        x+=speedx; 
        y+=speedy;
        double incre;
        double decre;
        Random rand = new Random(); 
        incre = rand.nextInt(3);
        decre = rand.nextInt(3);
        if(x>BallShooting.WIDTH-43){
            speedx = -decre;
        }
        if(x<0){
            speedx = incre;
        }
        
        if(y>BallShooting.HEIGHT-60)
        {
            speedy = -decre;
        }
        
        if(y<0)
        {
            speedy = incre;
        }
    }
    /***
     * create rectangle under red ball
     * @return 
     */
    public Rectangle getBounds(){
        return new Rectangle(x+5,y+5,32,32);
    }
    /***
     * draw red ball on screen
     * @param g2d 
     */
    public void draw(Graphics2D g2d){  
        g2d.drawImage(getRedBallImage(), x, y,null); 
    
        //g2d.draw(getBounds());
    }
    /***
     * this is loading image of the red ball
     * @return 
     */
    public Image getRedBallImage(){
        ImageIcon redballimage = new ImageIcon(getClass().getResource(redball));
        return redballimage.getImage();
    }
    
}
