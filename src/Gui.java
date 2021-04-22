import javax.swing.*;

public class Gui extends JFrame {
    private JLayeredPane masterPan;
    private JPanel bgPan;
    private JLayeredPane horsePan;
    private JTextArea console;
    private int nOfLines;
    private JPanel dicePan;


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
        console.setBounds(455,4,140,450);
        this.masterPan.add(this.console, Integer.valueOf(3));


        this.dicePan = new JPanel();
        dicePan.setOpaque(false);
        dicePan.setLayout(null);
        this.dicePan.setBounds(190,200,450,460);
        this.masterPan.add(this.dicePan, Integer.valueOf(4));

        this.add(masterPan);
        setVisible(true);
    }

    public void addHorse(Horse horse){
        horsePan.add(horse.getPan());
    }

    public void addDice(GameBoard gb){
        dicePan.add(gb.getPan());
    }


    public void log(String str){
        this.nOfLines++;
        if (this.nOfLines >= 30){
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
