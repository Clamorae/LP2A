import java.util.Arrays;

public class Case {
    private Object type;//this class is used for each case in the game board, it contain it's position, the number of horses on it and it's type
    private Horse[] horses;
    private int X;
    private int Y;

    Case (Ctype type, int X, int Y){
        this.type=type;
        this.X=X;
        this.Y=Y;
        this.horses = new Horse[2];
    }

    public Object getType() {//All the methods (except the last one) in this class are classical getter and setter
        return type;
    }

    public void setType(Ctype type) {
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
    public String toString() {//this methods override the toString method to create a method which will return a string with the case's information
        return "Case{" + "\n" +
                "   type='" + type + '\'' + "\n" +
                "   horses=" + Arrays.toString(horses) + "\n" +
                "   X=" + X + "\n" +
                "   Y=" + Y + "\n" +
                '}' +  "\n";
    }
}



