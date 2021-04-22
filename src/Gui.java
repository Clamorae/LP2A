import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Gui extends JFrame {
    public Gui(){
        super("Super Mega Ultra Small Horses");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600,600);
        setResizable(false);

        JLayeredPane masterPan = new JLayeredPane();
        masterPan.setLayout(null);
        masterPan.setOpaque(true);

        JPanel bgPan = new JPanel();
        bgPan.setBounds(0,0,450,460);
        ImageIcon bgPic = new ImageIcon("BG.png");
        JLabel bgLab = new JLabel(bgPic);
        bgPan.add(bgLab);
        masterPan.add(bgPan, Integer.valueOf(1));

        JPanel horsePan = new JPanel();
        horsePan.setOpaque(false);
        horsePan.setBounds(0,0,500,500);
        ImageIcon horsePic = new ImageIcon("RedHorse.png");
        JLabel horseLab = new JLabel(horsePic);
        horsePan.add(horseLab);
        masterPan.add(horsePan, Integer.valueOf(2));

        getContentPane().add(masterPan);
        setVisible(true);

    }
}
