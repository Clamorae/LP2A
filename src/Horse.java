import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Horse {
    private boolean playable;
    private int x;
    private int y;
    private final Color color;
    private Section currentSection;
    private final Section homeSection;
    private int n;
    private boolean isWin;
    private Gui gui;
    private static int skip;
    JPanel horsePan;

    public Horse(int x, int y, Section startSec, int n, Color color){//when a horse is created we also create his label and print it
        this.x = x;
        this.playable = true;
        this.y = y;
        this.color = color;
        this.currentSection = startSec;
        this.homeSection = startSec;
        this.n = n;
        this.setWin(false);
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
                play();
            }
        });
        this.horsePan = new JPanel();
        this.horsePan.setBounds(this.x,this.y,49,49);
        this.horsePan.setOpaque(false);
        this.horsePan.setVisible(true);
        this.horsePan.add(horseLab, Integer.valueOf(1));
    }

    public static int getSkip() {
        return skip;
    }

    public static void setSkip(int skip) {
        Horse.skip = skip;
    }

    public void setWin(boolean win) {
        this.isWin = win;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    private boolean isCaseReal(Section section, int n){// this function will check if the case is out of the array limit or not
        return section.getCases().length > n;
    }

    public JPanel getPan(){
        return horsePan;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void play(){//this function will check if the player is allow to play this horse and then move it, if the horse can't move four time it will pass the player turn
        if ((this.isPlayable())&&(GameManager.isThrewDice())&&(this.color.equals(GameManager.getTurn()))/*||true*/){
            if (!moveForward(GameManager.getDice())){
                setSkip(getSkip()+1);
                if (!GameManager.isCpu()||(this.color.equals(Color.RED))){
                    gui.log("Nope.");
                }
                if (getSkip()==4){
                    GameManager.nextTurn();
                }
            }else{
                if(GameManager.getDice() == 6){
                    gui.log("Play again !");
                    gui.log("Please re-roll");
                    GameManager.setThrewDice(false);
                    if (GameManager.isCpu()&&(!this.color.equals(Color.RED))){
                        GameBoard.rollDice();
                        this.play();
                    }
                }else {
                    GameManager.nextTurn();
                }

            }
        }else{
            if (!GameManager.isCpu()){
                gui.log("Nope.");
            }else if (this.color.equals(Color.RED)){
                gui.log("Nope.");
            }
        }

    }

    public boolean moveForward(int dr){// this function take a number in argument and will check if the horse can do the move, if he can't it will return false
        if(this.currentSection.getType().equals("Home")){
            if(dr == 6 && (currentSection.next.getCases()[1].getHorses()[0] == null || currentSection.next.getCases()[1].getHorses()[1] == null)){
                setTo(this.currentSection.next, 1);
            }else{
                return false;
            }
        }else{
            while(dr != 0 && this.moveOne()){
                dr--;
            }
        }
        if (this.currentSection.getCases()[this.n].getHorses()[0] != null &&!(this.currentSection.getCases()[this.n].getHorses()[1] == null)) {
            if (!this.currentSection.getCases()[this.n].getHorses()[0].color.equals(this.color)) {
                if (!this.currentSection.getCases()[this.n].getType().equals(Ctype.SAFE)){
                    if(GameManager.isCpu()&&(!this.color.equals(Color.RED))){
                        gui.log("You have been eaten !");
                    }else {
                        gui.log("You ate an opponent !");
                    }
                    backHome(this.currentSection.getCases()[this.n].getHorses()[0]);
                }
            }else if (!this.currentSection.getCases()[this.n].getHorses()[1].color.equals(this.color)) {
                if (!this.currentSection.getCases()[this.n].getType().equals(Ctype.SAFE)){
                    backHome(this.currentSection.getCases()[this.n].getHorses()[1]);
                }
            }
        }
        Horse[] hr = this.currentSection.getCases()[this.n].getHorses();
        for(Horse h:hr){
            if(h != this && h != null){
                gui.top(this);
                this.y-=3;
                this.x+=3;
                this.moveSprite();
                gui.bottom(h);
            }
        }
        return true;

    }

    public boolean moveOne(){//for each movement this method will be called, it will check which is the next case for the horse and then call another method to move him
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
                gui.log("Horse in !");
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

    private Section getNextSection(Section current, Color color){// this section allow the moveOne() method to know where the horse need to go when he is at the end of the array
        if(current.next == null){
            return null;
        }else if (current.next.getColor().equals(color)){
            return current.next.nextLadder;
        }else{
            return current.next;
        }
    }

    public void win(){// this method is called when an horse is on the top of the ladder, he will disappear and increase the player score
        Horse[] horses = this.currentSection.getCases()[n].getHorses();
        for(int i = 0; i<2; i++){
            if(horses[i] == this){
                horses[i] = null;
            }
        }
        this.setWin(true);
        this.setPlayable(false);
        this.horsePan.setVisible(false);
        gui.log("Horse in!");
        GameManager.addScore(this.color);
        GameManager.checkForWin();
    }

    private  boolean isCaseAvailable(Case _case){
        return _case.getHorses()[0] == null || _case.getHorses()[1] == null;
    }

    private void backHome(Horse h){// this function will take an horse has argument and set his position to his home when he get eaten by another horse
        int n=0;
        for (Case c:h.homeSection.getCases()){
            if(c.getHorses()[0]  == null && c.getHorses()[1] == null){

                h.setTo(h.homeSection,n);
                break;
            }else{
                n++;
            }
        }
        h.moveSprite();
    }

    public void moveSprite(){
        this.horsePan.setLocation(this.x,this.y);
    }

    public void setTo(Section section, int n){//this function will check if the case in the section is free, and then set the horse at the right place in his new case
        Horse[] array = this.currentSection.getCases()[this.n].getHorses();
        for(int i=0;i<2;i++){
            if (array[i] == this){
                array[i] = null;
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
                break;
            }
        }
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
}