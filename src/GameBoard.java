import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class GameBoard {//this class contain the GUI, the dice, the players and an hashmap of sections
    public static Gui gui;
    private static final Random dice = new Random();
    private static Player[] players;
    public static HashMap<Color, Section[]> sections;
    JPanel dicePan;

    public GameBoard(Color[] colorArray ) {//this constructor construct the fourth player, call the GUI constructor, create sections,and the dice panel
        GameBoard.sections = new HashMap<>();
        GameBoard.players = new Player[4];
        int i=0;
        for (Color temp : colorArray) {
            Section[] secArray = new Section[3];
            secArray[2] = new Section("Ladder", temp, null,null);
            secArray[1] = new Section("Normal", temp, null, secArray[2]);
            secArray[0] = new Section("Home", temp, secArray[1],null);
            sections.put(temp, secArray);
            players[i]=new Player(temp,sections);
            i++;
        }
        Section blue = GameBoard.sections.get(Color.BLUE)[1];
        Section red = GameBoard.sections.get(Color.RED)[1];
        Section green = GameBoard.sections.get(Color.GREEN)[1];
        Section yellow = GameBoard.sections.get(Color.YELLOW)[1];
        blue.next = red;
        red.next = green;
        green.next = yellow;
        yellow.next = blue;
        gui = new Gui();

        ImageIcon dicePic = new ImageIcon("Images/1.png");
        JLabel diceLab = new JLabel(dicePic);
        diceLab.addMouseListener(new MouseAdapter() {//when someone click on the dice label it will trigger the following method
            @Override
            public void mouseClicked(MouseEvent e) {//the panel Icon will change depending on the dice roll
                rollDice();
                switch (GameManager.getDice()) {
                    case 1 -> diceLab.setIcon(new ImageIcon("Images/1.png"));
                    case 2 -> diceLab.setIcon(new ImageIcon("Images/2.png"));
                    case 3 -> diceLab.setIcon(new ImageIcon("Images/3.png"));
                    case 4 -> diceLab.setIcon(new ImageIcon("Images/4.png"));
                    case 5 -> diceLab.setIcon(new ImageIcon("Images/5.png"));
                    default -> diceLab.setIcon(new ImageIcon("Images/6.png"));
                }
            }
        });
        this.dicePan = new JPanel();
        this.dicePan.setBounds(0,0,70,70);
        this.dicePan.setOpaque(false);
        this.dicePan.setVisible(true);
        this.dicePan.add(diceLab);
    }

    public static Player[] getPlayers() {
        return players;
    }

    public JPanel getPan(){
        return dicePan;
    }

    public static void rollDice() {// this method will change of value of intDice for a value between 1 and 6
        if (!GameManager.isThrewDice()/*||true*/){
            GameManager.setDice((GameBoard.dice.nextInt(6))+1);
            GameBoard.gui.log("It's a "+GameManager.getDice());
            GameManager.setThrewDice(true);
        }else{
            GameBoard.gui.log("Nope.");
        }
    }

    @Override
    public String toString() {//this methods override the toString method to create a method which will return a string with the case's information
        return "GameBoard{" + "\n" +
                "   dice=" + dice + "\n" +
                "   players=" + Arrays.toString(players) + "\n" +
                "   sections=" + sections + "\n" +
                '}' + "\n";
    }
}
