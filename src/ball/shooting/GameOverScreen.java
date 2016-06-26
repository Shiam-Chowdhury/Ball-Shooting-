package ball.shooting;

//import static ball.shooting.Controller.score;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/***
 * this class is for game over screen
 * @author Shiam Chowdhury
 */
public class GameOverScreen {
    
    public Rectangle playagain = new Rectangle(30, 350, 130, 50);
    public Rectangle exit = new Rectangle(435, 350, 130, 50);
    
    public void gameOver(Graphics2D g2d){
       Font font1 = new Font("arial", Font.BOLD, 50);
       g2d.setFont(font1);
       g2d.setColor(Color.DARK_GRAY);
       g2d.drawString("GAME OVER!", 137, 150);
       String s = Integer.toString(Controller.score);
       Font font2 = new Font("arial", Font.BOLD, 20);
       g2d.setFont(font2);
       g2d.drawString("SCORE: ", 240, 190);
       Font font = new Font("Serif",Font.BOLD,25);
       g2d.setFont(font);
       g2d.setColor(Color.BLACK);
       g2d.drawString(s, 330, 190);
       
       Font font3 = new Font("arial", Font.BOLD, 15);
       g2d.setFont(font2);
       g2d.drawString("Play Again", playagain.x+10, playagain.y+37);
       //g2d.draw(playButton);
       g2d.drawString("Exit", exit.x+80, exit.y+37);
       //g2d.draw(aboutButton);
    }
    
}
