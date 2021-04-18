import java.awt.*;

public class Main{
    public static void main(String[]args){
        GameBoard gb = new GameBoard();
        Horse horse = gb.getPlayers()[0].getHorse()[0];
        while(!horse.isWin()){
            horse.moveForward(6);
        }

    }

}

