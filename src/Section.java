import java.awt.*;
import java.util.Arrays;

public class Section{
    private String type;
    private Color color;
    public Section next;
    public Section nextLadder;
    private Case[] cases;
    private Vector origin;
    private Vector x;
    private Vector y;

    private Vector getPosition(Vector origin, Vector xVec, Vector yVec, int x, int y){
        Vector xToAdd = xVec.times(x);
        Vector yToAdd = yVec.times(y);
        return origin.add(xToAdd.add(yToAdd));
    }

    public Section(String type, Color color, Section next, Section nextLadder){
        this.next = next;
        this.nextLadder = nextLadder;
        this.type = type;
        this.color = color;

        if (Color.GREEN.equals(color)) {
            this.origin = new Vector(238, 0);
            this.x = new Vector(0, 1);
            this.y = new Vector(-1, 0);
        } else if (Color.YELLOW.equals(color)) {
            this.origin = new Vector(448, 239);
            this.x = new Vector(-1, 0);
            this.y = new Vector(-1, 0);
        } else if (Color.BLUE.equals(color)) {
            this.origin = new Vector(211, 450);
            this.x = new Vector(0, -1);
            this.y = new Vector(1, 0);
        } else {
            this.origin = new Vector(0, 212);
            this.x = new Vector(1, 0);
            this.y = new Vector(0, 1);
        }

        switch (type) {
            case "Home" -> {
                this.cases = new Case[4];
                for(int i = 0; i<4;i++){
                    int[] xPos = {35,122,35,122};
                    int[] yPos = {85,85,175,175};
                    Vector finalPos = getPosition(this.origin,this.x,this.y,xPos[i], yPos[i]);
                    this.cases[i] = new Case("Home", 0, 0);
                }
            }
            case "Ladder" -> {
                this.cases = new Case[6];
                for (int i = 0; i < 6; i++) {
                    this.cases[i] = new Case("Safe", 0, 0);
                }
            }
            case "Normal" -> {
                this.cases = new Case[14];
                for (int i = 0; i < 9; i++) {
                    this.cases[i] = new Case("Normal", 0, 0);
                }
                this.cases[9] = new Case("Safe", 0, 0);
                for (int i = 10; i < 14; i++) {
                    this.cases[i] = new Case("Normal", 0, 0);
                }
            }
        }
    }

    void setNext(Section section){
        this.next = section;
    }
    Case[] getCases(){return this.cases;}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Section{" +
                "   type='" + type + '\'' + "\n" +
                "   color=" + color + "\n" +
                //"   next=" + next.getType() + " " + next.getColor() + "\n" +
                //"   nextLadder=" + nextLadder.getType() + " " + nextLadder.getColor() + "\n" +
                "   cases=" + Arrays.toString(cases) + "\n" +
                '}' + "\n";
    }
}


