import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Horse {
    private boolean playable;
    private int dice;
    private int x;
    private int y;
    private Color color;
    private Section currentSection;
    private int n;
    private boolean isWin;
    JPanel horsePan;

    public Horse(int x, int y, Section startSec, int n, Color color){
        this.x = x;
        this.playable = true;
        this.dice = 6;
        this.y = y;
        this.color = color;
        this.currentSection = startSec;
        this.n = n;
        this.isWin = false;
        ImageIcon horsePic;
        if (Color.BLUE.equals(color)){
            horsePic = new ImageIcon("Images/BlueHorse.png");
        }else if (Color.RED.equals(color)){
            horsePic = new ImageIcon("Images/RedHorse.png");
        }else if (Color.GREEN.equals(color)){
            horsePic = new ImageIcon("Images/GreenHorse.png");
        }else{
            horsePic = new ImageIcon("Images/YellowHorse.png");
        }
        JLabel horseLab = new JLabel(horsePic);

        horseLab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                play(dice);
            }
        });
        this.horsePan = new JPanel();
        this.horsePan.setBounds(this.x,this.y,49,49);
        this.horsePan.setOpaque(false);
        this.horsePan.setVisible(true);
        this.horsePan.add(horseLab);
    }

    public boolean isWin() {
        return this.isWin;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    private boolean isCaseReal(Section section, int n){
        return section.getCases().length > n;
    }

    public JPanel getPan(){
        return horsePan;
    }

    private Section getNextSection(Section current, Color color){
        if(current.next == null){
            return null;
        }else if (current.next.getColor().equals(color)){
            return current.next.nextLadder;
        }else{
            return current.next;
        }
    }

    private  boolean isCaseAvailable(Case _case){
        return _case.getHorses()[0] == null || _case.getHorses()[1] == null;
    }

    public void win(){
        Horse[] horses = this.currentSection.getCases()[n].getHorses();
        for(int i = 0; i<2; i++){
            if(horses[i] == this){
                horses[i] = null;
            }
        }this.isWin = true;
    }

    public boolean moveOne(){
        Section newSection;
        int newN;
        if(isCaseReal(this.currentSection,this.n+1)){
            newSection = currentSection;
            newN = this.n+1;
        }else{
            newSection = getNextSection(this.currentSection, this.color);
            newN = 0;
            if(newSection == null){
                win();
                return false;
            }

        }
        if(isCaseAvailable(newSection.getCases()[newN])){
            setTo(newSection,newN);
            return true;
        }else{
            return false;
        }
    }

    public void moveForward(int dr){
        if(this.currentSection.getType().equals("Home")){
            if(dr == 1){
                setTo(this.currentSection.next, 1);
            }
        }else{
            while(dr != 0 && this.moveOne()){
                dr--;
            }
        }
    }

    private void backHome(HashMap< Color,Section[]>section){
        this.currentSection=section.get(this.color)[0];
        this.x=0;
        this.y=0;
        moveSprite();
    }

    public void moveSprite(){
        this.horsePan.setLocation(this.x,this.y);
    }

    public boolean setTo(Section section, int n){
        Horse[] array = this.currentSection.getCases()[this.n].getHorses();
        for(Horse temp : array){
            if (temp == this){
                temp = null;
            }
        }
        this.currentSection = section;
        this.n = n;
        this.x = section.getCases()[n].getX();
        this.y = section.getCases()[n].getY();
        this.moveSprite();
        array = this.currentSection.getCases()[this.n].getHorses();
        for(int i=0;i<2;i++){
            if (array[i] == null){
                array[i] = this;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {//this methods override the toString method to create a method which will return a string with the case's information
        return "Horse{" + "\n" +
                "   x=" + x + "\n" +
                "   y=" + y + "\n" +
                "   color=" + color + "\n" +
                "   currentSection=" + currentSection.getType() + currentSection.getColor().toString() + "\n" +
                "   n=" + n + "\n" +
                '}' + "\n";
    }

    public void play(int dice){
        if (this.playable){
            moveForward(1);
            //this.playable = false;
        }
    }
}