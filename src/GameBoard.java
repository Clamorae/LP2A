import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class GameBoard {
    private final Random dice = new Random();
    private HashMap<Color, Section[]> sections;

    GameBoard() {
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        for (Color temp : colorArray) {
            Section[] secArray = new Section[3];
            secArray[2] = new Section("Ladder", "Ladder" + temp, temp, null);
            secArray[1] = new NormalSection("Normal", "Normal" + temp, temp, null, secArray[2]);
            secArray[0] = new Section("Home", "Home" + temp, temp, secArray[1]);
            sections.put(temp, secArray);
        }
    }

}
