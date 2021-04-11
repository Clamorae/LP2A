import javax.swing.*;
import java.awt.*;

/*public class First {

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

import java.awt.event.*;

public class First extends Frame  {

    private Image image;

    First() {
        super("Ludo Game");
        MediaTracker mt = new MediaTracker (this);
        image = Toolkit.getDefaultToolkit().getImage("BG.png");
        mt.addImage(image, 0);


        setLayout(new FlowLayout());

        Button Roll = new Button("Roll the dice");

        add(Roll);

        setSize(600, 479);

        addWindowListener
                (new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.out.println("Bye.");
                         System.exit(0);
                     }
                 }
                );
    }

    public void paint(Graphics g) {
        g.drawImage(image,0,28,this);
    }

    static public void main(String[] args) {
        First iframe = new First();
        iframe.setVisible(true);
    }
}