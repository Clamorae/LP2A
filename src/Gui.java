import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private JLayeredPane masterPan;
    private JPanel bgPan;
    private JPanel horsePan;
    private JTextArea console;
    private JLabel dice;

    public Gui(){
        super("Lew Pewtit Cheweaux UwU");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);

        this.masterPan = new JLayeredPane();
        this.masterPan.setLayout(null);
        this.masterPan.setOpaque(true);

        this.bgPan = new JPanel();
        this.bgPan.setBounds(0,0,450,460);
        ImageIcon bgPic = new ImageIcon("BG.png");
        JLabel bgLab = new JLabel(bgPic);
        this.bgPan.add(bgLab);
        this.masterPan.add(bgPan, Integer.valueOf(1));

        this.horsePan = new JPanel();
        horsePan.setOpaque(false);
        horsePan.setLayout(null);
        this.horsePan.setBounds(0,0,450,460);
        this.masterPan.add(this.horsePan, Integer.valueOf(2));

        this.console = new JTextArea("       [BIENVENUE]");
        console.setEditable(false);
        console.setBounds(455,4,140,450);
        this.masterPan.add(this.console, Integer.valueOf(3));

        ImageIcon dicePic = new ImageIcon("RedHorse.png");
        this.dice = new JLabel(dicePic);
        this.dice.setBounds(0,0,50,50);
        this.dice.setVisible(true);
        this.masterPan.add(this.dice, Integer.valueOf(3));

        this.add(masterPan);
        setVisible(true);
    }

    public void addHorse(Horse horse){
        horsePan.add(horse.getPan());
    }

    public void log(String str){
        console.setText(console.getText()+"\n>"+str);
    }

}
