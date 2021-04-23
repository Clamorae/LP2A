import java.awt.*;

public class GameManager {
    private static Color turn;
    private static boolean cpu;
    private static boolean threwDice;
    private static boolean played;
    private static int dice;

    GameManager(boolean cpu){
        this.cpu=cpu;
    }

    public static void nextTurn(){
        GameManager.threwDice = false;
        GameManager.played = false;
        if(GameManager.turn.equals(Color.RED)){
            GameManager.turn=Color.GREEN;
            if (GameManager.cpu){
                cpuPlay(GameBoard.getPlayers()[2]);
            }
        }else if(GameManager.turn.equals(Color.GREEN)){
            GameManager.turn=Color.YELLOW;
            if (GameManager.cpu){
                cpuPlay(GameBoard.getPlayers()[3]);
            }
        }else if(GameManager.turn.equals(Color.YELLOW)){
            GameManager.turn=Color.BLUE;
            if (GameManager.cpu){
                cpuPlay(GameBoard.getPlayers()[0]);
            }
        }else{
            GameManager.turn=Color.RED;
            if (GameManager.cpu){
                cpuPlay(GameBoard.getPlayers()[1]);
            }
        }
    }

    public static void cpuPlay(Player p){
        GameBoard.rollDice();
        for(int i=0;i<4;i++){
            p.getHorse()[i].play();
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
