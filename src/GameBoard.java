import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class GameBoard {
    private final Random dice = new Random();
    private static int intDice;
    private Player[] players;
    public static HashMap<Color, Section[]> sections;

    public GameBoard() {
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        this.sections = new HashMap<>();
        this.players = new Player[4];
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
        Section blue = this.sections.get(Color.BLUE)[1];
        Section red = this.sections.get(Color.RED)[1];
        Section green = this.sections.get(Color.GREEN)[1];
        Section yellow = this.sections.get(Color.YELLOW)[1];
        blue.next = red;
        red.next = green;
        green.next = yellow;
        yellow.next = blue;


    }

    public Player[] getPlayers() {
        return players;
    }

    public HashMap<Color, Section[]> getSections() {
         return sections;
    }

    public static int getDice() {
        return intDice;
    }

    public void RollDice() {
        intDice = this.dice.nextInt();
    }



    @Override
    public String toString() {
        return "GameBoard{" + "\n" +
                "   dice=" + dice + "\n" +
                "   players=" + Arrays.toString(players) + "\n" +
                "   sections=" + sections + "\n" +
                '}' + "\n";
    }
}
