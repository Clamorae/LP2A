import java.awt.*;
import java.util.HashMap;

public class Player {
    private Color color;
    private int score;
    private Horse[] Horse;

    public Player(Color color, HashMap<Color,Section[]> section){
        this.score=0;
        this.color=color;
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        for (int i = 0; i<4; i++){
            Horse[i]=new Horse(0,0, section.get(color)[0] ,0);
        }
    }

}
