import java.awt.*;

public class Case {
    private String type;
    private Horse[] horses;
    private int X;
    private int Y;

    Case (String type, int X, int Y){
        this.type=type;
        this.X=X;
        this.Y=Y;
        this.horses = new Horse[2];
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Horse[] getHorses() {
        return horses;
    }

    public void setHorses(Horse[] horses) {
        this.horses = horses;
    }
}



