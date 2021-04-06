import java.awt.*;

public class Section{
    private String label;
    private Color color;
    public Section next;
    private Case[] cases;

    Section(String type, String label, Color color, Section next){
        this.next = next;
        this.label = label;
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
                for (int i = 0; i < 4; i++) {
                    this.cases[i] = new Case("Safe", 0, 0);
                }
            }
            case "Normal" -> {
                this.cases = new Case[14];
                for (int i = 0; i < 9; i++) {
                    this.cases[i] = new Case("Normal", 0, 0);
                }
                this.cases[9] = new Case("Safe", 0, 0);
                for (int i = 10; i < 13; i++) {
                    this.cases[i] = new Case("Normal", 0, 0);
                }
            }
        }
    }

    void setNext(Section section){
        this.next = section;
    }

}


