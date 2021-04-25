import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main implements ActionListener {//this class contain the main method and all the stuff useful for the initialization
    static Frame f;

    public static void main(String[]args){//this method will create a frame with two button, one for each game, apply the modification and launch the game
        Main.f = new Frame();
        f.setSize(400,400);
        Button player = new Button("Play with friends");
        player.setSize(400,200);
        Button cpu = new Button("Play alone");
        cpu.setSize(400,200);
        f.add(player);
        f.add(cpu);
        player.addActionListener(new Main());
        cpu.addActionListener(new Main());
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    public static void launchGame(){// in this method the Game board will be initialized and if it's a game with friends it will roll 4 dice to determine who will begin and then launch the game
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        GameBoard gb = new GameBoard(colorArray);
        for(Player p : GameBoard.getPlayers()){
            for(Horse h :p.getHorse()){
                h.setGui(GameBoard.gui);
                GameBoard.gui.addHorse(h);
            }
        }
        GameBoard.gui.addDice(gb);
        GameManager.setGui(GameBoard.gui);
        if(!GameManager.isCpu()){
            int higher=0;
            int test;
            int player=0;
            for(int i=0;i<4;i++){
                test= (int) (Math.random()*6);
                GameManager.setTurn(colorArray[i]);
                GameBoard.gui.log((i+1)+"th roll "+test);
                if(test>higher){
                    higher=test;
                    player=i;
                }
            }
            GameManager.setTurn(colorArray[player]);
        }else{
            GameManager.setTurn(Color.BLUE);
        }
        GameManager.nextTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {//this method is called when the button are clicked, they will set the variable which define the Game mode
        String str = e.getActionCommand();
        if(str.equals("Play with friends")) {
            GameManager.setCpu(false);
        }
        else if(str.equals("Play alone")) {
            GameManager.setCpu(true);
        }
        Main.f.setVisible(false);
        launchGame();
    }
}

