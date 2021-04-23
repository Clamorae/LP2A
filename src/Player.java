import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class Player {//the player class contain his horses, color and score, when is score reach four he wins the game
    private final Color color;
    private final Horse[] horse;

    public Player(Color color, HashMap<Color,Section[]> section){//in the constructor we create four horses int the home section for the player and initialize his score and his color
        this.horse = new Horse[4];
        this.color=color;
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        Section home = section.get(color)[0];
        for (int i = 0; i<4; i++){
            horse[i]=new Horse(home.getCases()[i].getX(),home.getCases()[i].getY(),home,i,this.color);
            home.getCases()[i].getHorses()[0] = horse[i];
        }
    }

    public Horse[] getHorse() {
        return horse;
    }

    @Override
    public String toString() {//this methods override the toString method to create a method which will return a string with the case's information
        return "Player{" + "\n" +
                "   color=" + color + "\n" +
                "   horse=" + Arrays.toString(horse) + "\n" +
                '}' + "\n";
    }

}
