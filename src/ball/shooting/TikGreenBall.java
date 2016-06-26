
package ball.shooting;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/***
 * this class is for the tickgreenball(life ball on game state)
 * @author Shiam Chowdhury
 */
public class TikGreenBall extends GlobalPosition {

    private String tikgreenballimage = "/images/greenTick.png";
    /***
     * maintains the positions of the balls
     * @param x
     * @param y 
     */
    public TikGreenBall(int x, int y) {
        super(x, y);
    }
    /***
     * draw the balls 
     * @param g2d 
     */
    public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImage(), x,y, null); 
        
        //g2d.draw(getBounds());
    }
    /***
     * get image of green tick ball(life ball)
     * @return 
     */
    public Image getPlayerImage(){
        ImageIcon i = new ImageIcon(getClass().getResource(tikgreenballimage));
        return i.getImage();
    }
    
}
