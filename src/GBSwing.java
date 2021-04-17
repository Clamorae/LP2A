import javax.swing.*;

public class GBSwing {
    public static void main(String[] args) {
        JFrame BackLayer = new JFrame();//creating instance of JFrame

        JButton roll = new JButton("Roll the dice");//creating instance of JButton
        roll.setBounds(130,100,100, 40);//x axis, y axis, width, height

        BackLayer.add(roll);//adding button in JFrame

        BackLayer.setSize(400,500);//400 width and 500 height
        BackLayer.setLayout(null);//using no layout managers
        BackLayer.setVisible(true);//making the frame visible
    }
}
