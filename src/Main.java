import java.awt.*;

public class Main{//this class contain the main method which will call create the Game board and use it to initialize everything else
    public static void main(String[]args){
        GameBoard gb = new GameBoard();
        for(Player p :gb.getPlayers()){
            for(Horse h :p.getHorse()){
                h.setGui(gb.gui);
                gb.gui.addHorse(h);
            }
        }
        gb.gui.addDice(gb);
        GameManager.setGui(gb.gui);
        GameManager.setTurn(Color.BLUE);
        GameManager.nextTurn();
    }

}

