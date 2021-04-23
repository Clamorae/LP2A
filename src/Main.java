import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {//this class contain the main method which will call create the Game board and use it to initialize everything else
    static Frame f;

    public static void main(String[]args){
        init();
    }

    public static void launchGame(){
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

