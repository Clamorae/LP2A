import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class GameBoard {
    public Gui gui;
    private final Random dice = new Random();
    private static int intDice;
    private Player[] players;
    public static HashMap<Color, Section[]> sections;
    JPanel dicePan;

    public GameBoard() {
        Color[] colorArray = {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        this.sections = new HashMap<>();
        this.players = new Player[4];
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
        Section blue = this.sections.get(Color.BLUE)[1];
        Section red = this.sections.get(Color.RED)[1];
        Section green = this.sections.get(Color.GREEN)[1];
        Section yellow = this.sections.get(Color.YELLOW)[1];
        blue.next = red;
        red.next = green;
        green.next = yellow;
        yellow.next = blue;
        this.gui = new Gui();

        ImageIcon dicePic = new ImageIcon("Images/1.png");
        JLabel diceLab = new JLabel(dicePic);
        diceLab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RollDice();
                System.out.println(intDice);
                switch (intDice){
                    case 1:
                        diceLab.setIcon(new ImageIcon("images/1.png"));;
                        break;
                    case 2:
                        diceLab.setIcon(new ImageIcon("images/2.png"));
                        break;
                    case 3:
                        diceLab.setIcon(new ImageIcon("images/3.png"));
                        break;
                    case 4:
                        diceLab.setIcon(new ImageIcon("images/4.png"));
                        break;
                    case 5:
                        diceLab.setIcon(new ImageIcon("images/5.png"));;
                        break;
                    default:
                        diceLab.setIcon(new ImageIcon("images/6.png"));
                }
            }
        });
        this.dicePan = new JPanel();
        this.dicePan.setBounds(0,0,70,70);
        this.dicePan.setOpaque(false);
        this.dicePan.setVisible(true);
        this.dicePan.add(diceLab);
    }

    public Player[] getPlayers() {
        return players;
    }

    public HashMap<Color, Section[]> getSections() {
         return sections;
    }

    public static void rollDice() {
        //return this.dice.nextInt(6)+1;
    }

    public void RollDice() {
        intDice = (this.dice.nextInt(6))+1;
    }

    public JPanel getPan(){
        return dicePan;
    }

    @Override
    public String toString() {
        return "GameBoard{" + "\n" +
                "   dice=" + dice + "\n" +
                "   players=" + Arrays.toString(players) + "\n" +
                "   sections=" + sections + "\n" +
                '}' + "\n";
    }
}
