import java.awt.*;

public class GameManager {
    private static Color turn;
    private static boolean threwDice;
    private static boolean played;
    private static int dice;

    public static void nextTurn(){
        GameManager.threwDice = false;
        GameManager.played = false;
        if(GameManager.turn.equals(Color.RED)){
            GameManager.turn=Color.GREEN;
        }else if(GameManager.turn.equals(Color.GREEN)){
            GameManager.turn=Color.YELLOW;
        }else if(GameManager.turn.equals(Color.YELLOW)){
            GameManager.turn=Color.BLUE;
        }else{
            GameManager.turn=Color.RED;
        }
    }

    public static int getDice() {
        return dice;
    }

    public static void setDice(int dice) {
        GameManager.dice = dice;
    }

    public static boolean isThrewDice() {
        return threwDice;
    }

    public static void setThrewDice(boolean threwDice) {
        GameManager.threwDice = threwDice;
    }

    public static boolean isPlayed() {
        return played;
    }

    public static void setPlayed(boolean played) {
        GameManager.played = played;
    }

    public static void setTurn(Color turn) {
        GameManager.turn = turn;
    }

    public static Color getTurn() {
        return turn;
    }
}
