import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class Player {
    private Color color;
    private int score;
    private Horse[] horse;

    public Player(Color color, HashMap<Color,Section[]> section){
        this.horse = new Horse[4];
        this.score=0;
        this.color=color;
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        Section home = section.get(color)[0];
        for (int i = 0; i<4; i++){
            horse[i]=new Horse(home.getCases()[i].getX(),home.getCases()[i].getY(),home,i,this.color);
        }
    }

    public Horse[] getHorse() {
        return horse;
    }

    @Override
    public String toString() {
        return "Player{" + "\n" +
                "   color=" + color + "\n" +
                "   score=" + score + "\n" +
                "   horse=" + Arrays.toString(horse) + "\n" +
                '}' + "\n";
    }
}
