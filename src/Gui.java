import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame {//This class is creating a Jframe using swing and will print the whole game in the screen and allow players to interact with it
    private JLayeredPane masterPan;
    private JPanel bgPan;
    private JLayeredPane horsePan;
    private JTextArea console;
    private int nOfLines;
    private JPanel dicePan;
    private JPanel pass;


    public Gui(){//in the constructor we create different panel in superposition to print game board, horses, dice and terminal on the same picture
        super("Ludo Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,500);
        setResizable(false);

        this.masterPan = new JLayeredPane();
        this.masterPan.setLayout(null);
        this.masterPan.setOpaque(true);

        this.bgPan = new JPanel();
        this.bgPan.setBounds(0,0,450,460);
        ImageIcon bgPic = new ImageIcon("Images/BG.png");
        JLabel bgLab = new JLabel(bgPic);
        this.bgPan.add(bgLab);
        this.masterPan.add(bgPan, Integer.valueOf(1));

        this.horsePan = new JLayeredPane();
        horsePan.setOpaque(false);
        horsePan.setLayout(null);
        this.horsePan.setBounds(0,0,450,460);
        this.masterPan.add(this.horsePan, Integer.valueOf(2));

        this.console = new JTextArea("       [BIENVENUE]");
        this.nOfLines = 1;
        console.setEditable(false);
        console.setBounds(455,4,140,400);
        this.masterPan.add(this.console, Integer.valueOf(3));


        this.dicePan = new JPanel();
        dicePan.setOpaque(false);
        dicePan.setLayout(null);
        this.dicePan.setBounds(190,200,450,460);
        this.masterPan.add(this.dicePan, Integer.valueOf(4));

        this.pass = new JPanel();
        pass.setOpaque(false);
        this.pass.setBounds(455,405,50,50);
        ImageIcon passPic = new ImageIcon("Images/next.png");
        JLabel passLab = new JLabel(passPic);
        passLab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GameManager.nextTurn();
            }
        });
        this.pass.add(passLab);
        this.masterPan.add(pass, Integer.valueOf(5));



        this.add(masterPan);
        setVisible(true);
    }

    public void addHorse(Horse horse){//this function add an horse panel at the Jframe
        horsePan.add(horse.getPan());
    }

    public void addDice(GameBoard gb){// this function will add the dice panel to the Jframe
        dicePan.add(gb.getPan());
    }


    public void log(String str){//this method take a string and print it in the textbox to give info at user
        this.nOfLines++;
        if (this.nOfLines >= 26){
            this.nOfLines = 1;
            console.setText(">"+str);
        }else {
            console.setText(console.getText() + "\n>" + str);
        }
    }

    public void top(Horse h){
        this.horsePan.setLayer(h.getPan(),2);
    }

    public void bottom(Horse h){
        this.horsePan.setLayer(h.getPan(),1);
    }

}
