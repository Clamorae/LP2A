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

    public void tatakae(int dice){
        if(this.currentSection.getType().equals("Home")){
            if(dice == 6){
                this.currentSection = this.currentSection.next;
                this.n = 0;
                dice = 0;
            }
        }else {
            while (dice != 0){
                switch (canTatakae(this.currentSection.getCases()[n+1],this.currentSection, this.color)) {
                    case "Won":
                        //do stuff
                        break;
                    case "Yes":
                        //do other stuff
                        break;
                    case "No":
                        //do more stuff
                        break;
                }
                dice--;
            }
        }


    }

    private String canTatakae(Case nextCase, Section currentSection, Color color){
        if(nextCase == null){
            if(currentSection.nextLadder == null){
                return "Won";
            }else if(currentSection.next.getColor().equals(color)){
                currentSection = currentSection.nextLadder;
            }else{
                currentSection = currentSection.next;
            }
        }
        if(nextCase.getHorses()[0]==null || nextCase.getHorses()[1]==null){
            return "Yes";
        }else{
            return "No";
        }
    }
}