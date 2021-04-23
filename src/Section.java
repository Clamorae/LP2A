import java.awt.*;
import java.util.Arrays;

public class Section{//this class is where all the cases are set together and allow horses to travel around the whole game board
    private final String type;
    private final Color color;
    public Section next;
    public Section nextLadder;
    private Case[] cases;

    public Section(String type, Color color, Section next, Section nextLadder){
        // for each Color the constructor will create three sections : the ladder, the home, nad the normal by adding cases at the right position on the game board and by adding them into array
        //our Game board is a Linked list with no end : the end is the start so with that we have the same game board for all the players
        this.next = next;
        this.nextLadder = nextLadder;
        this.type = type;
        this.color = color;

        Vect origin;
        Vect x;
        Vect y;
        if (Color.GREEN.equals(color)) {
            origin = new Vect(198, 9);
            x = new Vect(0, 1);
            y = new Vect(-1, 0);
        } else if (Color.YELLOW.equals(color)) {
            origin = new Vect(402, 210);
            x = new Vect(-1, 0);
            y = new Vect(0, -1);
        } else if (Color.BLUE.equals(color)) {
            origin = new Vect(205, 410);
            x = new Vect(0, -1);
            y = new Vect(1, 0);
        } else {
            origin = new Vect(0, 212);
            x = new Vect(1, 0);
            y = new Vect(0, 1);
        }

        switch (type) {
            case "Home" -> {
                this.cases = new Case[4];
                int[] xPos = {25,112,25,112};
                int[] yPos = {86,86,174,174};
                Vect finalPos;
                for(int i = 0; i<4;i++){
                    finalPos = getPosition(origin, x, y,xPos[i], yPos[i]);
                    this.cases[i] = new Case(Ctype.HOME, finalPos.x, finalPos.y);
                }
            }
            case "Ladder" -> {
                this.cases = new Case[5];
                int[] yPos = {173,145,118-3,89-3,63-3};
                Vect finalPos;
                for (int i = 0; i < 5; i++) {
                    finalPos = getPosition(origin, x, y,200,yPos[i]);
                    this.cases[i] = new Case(Ctype.SAFE, finalPos.x, finalPos.y);
                }
            }
            case "Normal" -> {
                int[] xPos = {172,172,172,172,172,172,141,112,84,55,26,0,0};
                int[] yPos = {200,173,145,115,86,60,26,26,26,26,26,26,1};
                this.cases = new Case[13];
                Vect finalPos;
                for (int i = 0; i < 9; i++) {
                    finalPos = getPosition(origin, x, y,xPos[i], yPos[i]);
                    this.cases[i] = new Case(Ctype.NORMAL, finalPos.x, finalPos.y);
                }
                this.cases[1].setType(Ctype.SAFE);
                finalPos = getPosition(origin, x, y,xPos[9], yPos[9]);
                this.cases[9] = new Case(Ctype.SAFE, finalPos.x, finalPos.y);
                for (int i = 10; i < 13; i++) {
                    finalPos = getPosition(origin, x, y,xPos[i], yPos[i]);
                    this.cases[i] = new Case(Ctype.NORMAL, finalPos.x, finalPos.y);
                }
            }
        }
    }

    private Vect getPosition(Vect origin, Vect xVec, Vect yVec, int x, int y){
        Vect xToAdd = xVec.times(x);
        Vect yToAdd = yVec.times(y);
        return origin.add(xToAdd.add(yToAdd));
    }

    public Case[] getCases(){return this.cases;}

    public Color getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {//this methods override the toString method to create a method which will return a string with the case's information
        return "Section{" +
                "   type='" + type + '\'' + "\n" +
                "   color=" + color + "\n" +
                //"   next=" + next.getType() + " " + next.getColor() + "\n" +
                //"   nextLadder=" + nextLadder.getType() + " " + nextLadder.getColor() + "\n" +
                "   cases=" + Arrays.toString(cases) + "\n" +
                '}' + "\n";
    }
}


