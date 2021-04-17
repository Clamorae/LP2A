import java.awt.*;
import java.awt.event.*;

/*import java.swing.*
public class First {

    public static void main(String[] args)
    {

        JFrame fenetre = new JFrame();
        fenetre.setTitle("Ludo game");
        fenetre.setSize(780, 630);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Icon Back = new ImageIcon("Board.png");
        JLabel BackGround = new JLabel();
        BackGround.setIcon(Back);

        JButton Roll = new JButton("Roll the dice");


        fenetre.add(Roll);
        Roll.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fenetre.add(BackGround);
        BackGround.setLayout(new FlowLayout(FlowLayout.LEFT));

        fenetre.setVisible(true);
    }
}*/


public class AWT extends Frame implements ActionListener  {

    private final Image image;
    private final Image blue;
    private final Image red;
    private final Image yellow;
    private final Image green;
    private GameBoard gb;


    AWT(GameBoard gb) {
        super("Ludo Game");
        this.gb=gb;
        setLayout(new FlowLayout());
        MediaTracker mt = new MediaTracker (this);
        image = Toolkit.getDefaultToolkit().getImage("BG.png");
        red = Toolkit.getDefaultToolkit().getImage("RedHorse.png");
        blue = Toolkit.getDefaultToolkit().getImage("BlueHorse.png");
        green = Toolkit.getDefaultToolkit().getImage("GreenHorse.png");
        yellow = Toolkit.getDefaultToolkit().getImage("YellowHorse.png");
        mt.addImage(image, 0);




        Button Roll = new Button("Roll the dice");
        Roll.addActionListener(this);
        add(Roll);

        setSize(600, 487);
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        addWindowListener(new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.out.println("Bye.");
                         System.exit(0);
                     }
                 });
    }

    public void paint(Graphics g) {
        g.drawImage(image,0,28,this);
    }

    public void Move(Graphics g,Image image, int X, int Y) {
        g.drawImage(image,X,Y,this);
    }


    static public void init(GameBoard gb) {
        AWT iframe = new AWT(gb);
        iframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Roses are red, Violets are blue and Dice is rolling");
        gb.RollDice();
    }
}