
import java.awt.*;
import java.util.HashMap;

public class Horse {
    private int x;
    private int y;
    private Color color;
    private Section currentSection;
    private int n;

    public Horse(int x, int y, Section startSec, int n, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.currentSection = startSec;
        this.n = n;
    }

    private boolean isCaseReal(Section section, int n){
        return section.getCases().length > n;
    }

    private Section getNextSection(Section current, Color color){
        if (current.next.getColor().equals(color)){
            return current.next.nextLadder;
        }else{
            return current.next;
        }
    }

    private  boolean isCaseAvailable(Case _case){
        return _case.getHorses()[0] == null || _case.getHorses()[1] == null;
    }

    public void win(){}

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
            if(dr == 6){
                setTo(this.currentSection.next, 0);
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
        array = this.currentSection.getCases()[this.n].getHorses();
        for(int i=0;i<2;i++){
            if (array[i] == null){
                System.out.print("Cheval Posé");
                array[i] = this;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Horse{" + "\n" +
                "   x=" + x + "\n" +
                "   y=" + y + "\n" +
                "   color=" + color + "\n" +
                "   currentSection=" + currentSection.getType() + currentSection.getColor().toString() + "\n" +
                "   n=" + n + "\n" +
                '}' + "\n";
    }
}