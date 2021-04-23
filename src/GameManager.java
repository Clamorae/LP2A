import java.awt.*;

public class GameManager {
    private static Color turn;
    private static boolean cpu;
    private static boolean threwDice;
    private static int dice;
    private static Gui gui;

    public static void nextTurn(){
        GameManager.threwDice = false;
        if(GameManager.turn.equals(Color.RED)){
            GameManager.turn=Color.GREEN;
            if (isCpu()){
                GameBoard.gui.log("red->green");
                cpuPlay(GameBoard.getPlayers()[2]);

            }
        }else if(GameManager.turn.equals(Color.GREEN)){
            GameManager.turn=Color.YELLOW;
            if (isCpu()){
                GameBoard.gui.log("green->y");
                cpuPlay(GameBoard.getPlayers()[3]);

            }
        }else if(GameManager.turn.equals(Color.YELLOW)){
            GameManager.turn=Color.BLUE;
            if (isCpu()){
                GameBoard.gui.log("y->blue");
                cpuPlay(GameBoard.getPlayers()[0]);
            }
        }else{
            GameManager.turn=Color.RED;
        }
        Horse.setSkip(0);
        gui.log("It's " + GameManager.getStrColor() + "'s turn");
        gui.log("Please roll the dice");

    }

    public static void cpuPlay(Player p){
        GameBoard.rollDice();
        for(int i=0;i<4;i++){
            p.getHorse()[i].play();
        }
    }

    public static boolean isCpu() {
        return cpu;
    }

    public static void setCpu(boolean cpu) {
        GameManager.cpu = cpu;
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
