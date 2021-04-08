import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class Horse {
    private int x;
    private int y;
    private Color color;
    private Section currentSection;
    private int n;

    public Horse(int x, int y, Section startSec, int n){
        this.x = x;
        this.y = y;
        this.currentSection = startSec;
        this.n = n;
    }

    private boolean isCaseReal(Section section, int n){
        return section.getCases().length > n;
    }
    private Section getNextSection(Section current, Color color){
        if (current.next.getColor().equals(color)){
            return current.nextLadder;
        }else{
            return current.next;
        }
    }

    private  boolean isCaseAvailable(Case _case){
        return _case.getHorses()[0] == null || _case.getHorses()[1] == null;
    }

    public void win(){}
    public void lose(){}

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
            this.currentSection = newSection;
            this.n = newN;
            this.x = newSection.getCases()[newN].getX();
            this.y = newSection.getCases()[newN].getY();
            return true;
        }else{
            return false;
        }
    }

}