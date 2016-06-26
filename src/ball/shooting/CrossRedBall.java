
package ball.shooting;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/***
 * this class object actually red ball object
 * @author Shiam Chowdhury
 */
public class CrossRedBall extends GlobalPosition{

    private String crossredballimage = "/images/redCross.png";
    /***
     * position of ball
     * @param x
     * @param y 
     */
    public CrossRedBall(int x, int y) {
        super(x, y);
    }
    /***
     * draw the ball
     * @param g2d 
     */
    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImage(), x,y, null); 
        
        //g2d.draw(getBounds());
    }
    /***
     * get image of cross ball
     * @return 
     */
    public Image getPlayerImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(crossredballimage));
        return i.getImage();
    }
    
}
