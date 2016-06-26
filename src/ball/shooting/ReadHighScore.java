
package ball.shooting;

import java.io.File;
import java.util.Scanner;


public class ReadHighScore {
    
    private Scanner s;
    public void openFile(){
        
        try {
            s = new Scanner(new File("keephighscore.txt"));
        } catch (Exception e) {
        }
    }
    
    public String readScore(){
        String score = null;
        if(s.hasNext())
            score = s.next();
        return score;
    }
    
    public void closeFile(){
        s.close();
    }
    
    
}
