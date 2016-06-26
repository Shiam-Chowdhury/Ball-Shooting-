
package ball.shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/***
 * this class made menu screen
 * @author Shiam Chowdhury
 */
public class Menu {
    
    public Rectangle playButton = new Rectangle(230, 130, 130, 50);
    public Rectangle helpButton = new Rectangle(230, 210, 130, 50);
    public Rectangle quitButton = new Rectangle(230, 290, 130, 50);
    
    public void menuScreen(Graphics2D g2d){
        
       Font font1 = new Font("arial", Font.BOLD, 50);
       g2d.setFont(font1);
       g2d.setColor(Color.DARK_GRAY);
       g2d.drawString("Ball Shooting", 137, 100);
       
       Font font2 = new Font("arial", Font.BOLD, 20);
       g2d.setFont(font2);
       g2d.drawString("New Game", playButton.x+16, playButton.y+32);
       g2d.draw(playButton);
       g2d.drawString("Help", helpButton.x+45, helpButton.y+32);
       g2d.draw(helpButton);
       g2d.drawString("Quit", quitButton.x+45, quitButton.y+32);
       g2d.draw(quitButton);
    }
}
