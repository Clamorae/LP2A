import java.util.Arrays;

public class Case {//
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

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Case{" + "\n" +
                "   type='" + type + '\'' + "\n" +
                "   horses=" + Arrays.toString(horses) + "\n" +
                "   X=" + X + "\n" +
                "   Y=" + Y + "\n" +
                '}' +  "\n";
    }
}



