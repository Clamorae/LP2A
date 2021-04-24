import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main implements ActionListener {//this class contain the main method which will call create the Game board and use it to initialize everything else
    static Frame f;

    public static void main(String[]args){
        init();
    }

    public static void launchGame(){
        GameBoard gb = new GameBoard();
        for(Player p : GameBoard.getPlayers()){
            for(Horse h :p.getHorse()){
                h.setGui(GameBoard.gui);
                GameBoard.gui.addHorse(h);
            }
        }
        GameBoard.gui.addDice(gb);
        GameManager.setGui(GameBoard.gui);
        GameManager.setTurn(Color.BLUE);
        GameManager.nextTurn();
    }

    public static void init(){
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


    @Override
    public void actionPerformed(ActionEvent e) {
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

