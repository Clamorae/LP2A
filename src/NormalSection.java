import java.awt.*;

public class NormalSection extends Section{
    private Section nextLadder;

    NormalSection(String type, String label, Color color, Section next, Section nextLadder) {
        super(type, label, color,next);
        this.nextLadder = nextLadder;
    }

    void setNextLadder(Section section){
        this.nextLadder = section;
    }
}
