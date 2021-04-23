import java.awt.*;

public class GameManager {
    private static Color turn;
    private static boolean threwDice;
    private static int dice;
    private static Gui gui;

    public static void nextTurn(){
        GameManager.threwDice = false;
        if(GameManager.turn.equals(Color.RED)){
            GameManager.turn=Color.GREEN;
        }else if(GameManager.turn.equals(Color.GREEN)){
            GameManager.turn=Color.YELLOW;
        }else if(GameManager.turn.equals(Color.YELLOW)){
            GameManager.turn=Color.BLUE;
        }else{
            GameManager.turn=Color.RED;
        }
        gui.log("It's " + GameManager.getStrColor() + "'s turn");
        gui.log("Please roll the dice");
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

    public static void setTurn(Color turn) {
        GameManager.turn = turn;
    }

    public static Color getTurn() {
        return turn;
    }

    public static void setGui(Gui gui) {
        GameManager.gui = gui;
    }

    private static String getStrColor() {
        if(GameManager.turn.equals(Color.BLUE)){
            return "blue";
        }else if(GameManager.turn.equals(Color.RED)){
            return "red";
        }else if(GameManager.turn.equals(Color.YELLOW)) {
            return "yellow";
        }else{
            return "green";
        }
    }
}
