import javax.swing.*;

public class Gui extends JFrame {
    JLayeredPane masterPan;
    JPanel bgPan;
    JPanel horsePan;

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
        this.add(masterPan);
        setVisible(true);
    }

    public void addHorse(Horse horse){
        horsePan.add(horse.getPan());
    }

}
