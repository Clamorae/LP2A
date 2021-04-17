import java.awt.*;

public class Main{
    public static void main(String[]args){
        GameBoard gb = new GameBoard();
        gb.getPlayers()[0].getHorse()[0].setTo(gb.getSections().get(Color.blue)[1],5);
        System.out.print("hello");
        System.out.println(gb);
        AWT.init(gb);
    }

}

