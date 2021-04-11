import javax.swing.*;
/* import java.awt.*; */

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

        ButtonModel Roll = new DefaultButtonModel();

        fenetre.add(BackGround);
        fenetre.setVisible(true);
    }
}

/*import java.awt.*;
import java.awt.event.*;

public class First extends Frame  {

    private Image image;

    First() {
        super("test");
        MediaTracker mt = new MediaTracker (this);
        image = Toolkit.getDefaultToolkit().getImage("BG.png");
        mt.addImage(image, 0);


        setLayout(new FlowLayout());

        add(new Button("hello"));
        setSize(449, 455);

        addWindowListener
                (new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         // change this for an Applet
                         System.out.println("Bye.");
                         System.exit(0);
                     }
                 }
                );
        (new windowAdapter(){

        })
    }

    public void update( Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        if(image != null) {
            int x, y = 0;
            while(y < getSize().height) {
                x = 0;
                while(x< getSize().width) {
                    g.drawImage(image, x, y, this);
                    x= x + image.getWidth(null);
                }
                y = y + image.getHeight(null);
            }
        }
        else {
            g.clearRect(0, 0, getSize().width, getSize().height);
        }
    }

    static public void main(String[] args) {
        First iframe = new First();
        iframe.setVisible(true);
    }
}*/