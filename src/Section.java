import java.awt.*;
import java.util.Arrays;

public class Section{
    private String type;
    private Color color;
    public Section next;
    public Section nextLadder;
    private Case[] cases;

    public Section(String type, Color color, Section next, Section nextLadder){
        this.next = next;
        this.nextLadder = nextLadder;
        this.type = type;
        this.color = color;
        switch (type) {
            case "Home" -> {
                this.cases = new Case[4];
                for (int i = 0; i < 4; i++) {
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


