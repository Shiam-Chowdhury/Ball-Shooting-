
package ball.shooting;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/***
 * this class made pause screen
 * @author Shiam Chowdhury
 */
public class PauseScreen {
    public Rectangle pause = new Rectangle(12, 358, 55,55);
    public Rectangle resume = new Rectangle(173, 93, 245, 240) ;
    
    public void showPause(Graphics2D g2d){
        //g2d.draw(pause);
    }
    
    public void resumeScreen(Graphics2D g2d){
        //g2d.draw(resume);
    }
}
