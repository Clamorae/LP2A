import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class GameBoard {
    private final Random dice = new Random();
    private Player[] players;
    public HashMap<Color, Section[]> sections;

    public GameBoard() {
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        this.sections = new HashMap<>();
        int i=0;
        for (Color temp : colorArray) {
            Section[] secArray = new Section[3];
            secArray[2] = new Section("Ladder", temp, null,null);
            secArray[1] = new Section("Normal", temp, null, secArray[2]);
            secArray[0] = new Section("Home", temp, secArray[1],null);
            sections.put(temp, secArray);
            players[i]=new Player(temp,sections);
            i++;
        }

    }

    private void RollDice(Random dice){
        dice.nextInt();
    }

}
