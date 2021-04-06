import java.awt.*;
import java.util.Random;

public class GameBoard {
    private final Random dice = new Random();
    Player Player;
    Section Section;

    public void initialize(){
        int x = 6;
        int y;
        int i=0;

        Case[] Case = new Case[13];
        for (y=0;y<6;y++){
            Case[i]=new Case(0,x,y);
        }
        y++;
        for (x=6;x>=0;x--){
            if (x==2){
                Case[i]=new Case(1,x,y);
            }else{
                Case[i]=new Case(0,x,y);
            }
            i++;
        }
        y++;
        Case[i]=new Case(0,x,y);
        Section blueSection= new Section("blueCase", Color.blue,Case);

        i=0;
        y++;
        for (x=0;x<6;x++){
            Case[i]=new Case(0,x,y);
            i++;
        }
        x++;
        for (y=9;y<15;y++){
            if (y==12){
                Case[i]=new Case(1,x,y);
            }else{
                Case[i]=new Case(0,x,y);
            }
            i++;
        }
        x++;
        Case[i]=new Case(0,x,y);
        Section redSection= new Section("redCase",Color.red,Case);

        i=0;
        x++;
        for (y=14;y>8;y--){
            Case[i]=new Case(0,x,y);
            i++;
        }
        y--;
        for (x=9;x<15;x++){
            if (x==12){
                Case[i]=new Case(1,x,y);
            }else{
                Case[i]=new Case(0,x,y);
            }
            i++;
        }
        y--;
        Case[i]=new Case(0,x,y);
        Section greenSection= new Section("greenCase",Color.green,Case);

        i=0;
        y--;
        for (x=14;x>8;x--){
            Case[i]=new Case(0,x,y);
            i++;
        }
        x--;
        for (y=5;y>=0;y--){
            if (y==2){
                Case[i]=new Case(1,x,y);
            }else{
                Case[i]=new Case(0,x,y);
            }
            i++;
        }
        x--;
        Case[i]=new Case(0,x,y);
        Section yellowSection= new Section("yellowCase",Color.yellow,Case);

        Case[] Ladder = new Case[6];
        x=7;
        for (y=1;y<7;y++){
            Ladder[i]=new Case(3,x,y);
        }
        Section blueLadder = new Section("blueLadder",Color.blue,Ladder);

        i=0;
        for (y=14;y>7;y--){
            Ladder[i]=new Case(3,x,y);
        }
        Section greenLadder = new Section("greenLadder",Color.green,Ladder);

        i=0;
        y=7;
        for (x=1;x<7;x++){
            Ladder[i]=new Case(3,x,y);
        }
        Section redLadder = new Section("redLadder",Color.red,Ladder);

        for (x=14;x>7;x--){
            Ladder[i]=new Case(3,x,y);
        }
        Section yellowLadder = new Section("yellowLadder",Color.yellow,Ladder);

        Case[] Home = new Case[4];
        Home[1]=new Case(4,2,2);
        Home[2]=new Case(4,4,2);
        Home[3]=new Case(4,4,4);
        Home[4]=new Case(4,2,4);
        Section blueHome = new Section("blueHome",Color.blue,Home);

        Home[1]=new Case(4,2,10);
        Home[2]=new Case(4,4,10);
        Home[3]=new Case(4,4,12);
        Home[4]=new Case(4,2,12);
        Section redHome = new Section("redHome",Color.red,Home);

        Home[1]=new Case(4,10,10);
        Home[2]=new Case(4,12,10);
        Home[3]=new Case(4,12,12);
        Home[4]=new Case(4,10,12);
        Section greenHome = new Section("greenHome",Color.blue.green,Home);

        Home[1]=new Case(4,10,2);
        Home[2]=new Case(4,12,2);
        Home[3]=new Case(4,12,4);
        Home[4]=new Case(4,10,4);
        Section yellowHome = new Section("yellowHome",Color.yellow,Home);

        yellowHome.next=yellowSection;
        blueHome.next=blueSection;
        redHome.next=redSection;
        greenHome.next=greenSection;
        yellowSection.next=blueSection;
        yellowSection.nextLadder=blueLadder;
        blueSection.next=redSection;
        blueSection.nextLadder=redLadder;
        redSection.next=greenSection;
        redSection.nextLadder=greenLadder;
        greenSection.next=yellowSection;
        greenSection.nextLadder=yellowLadder;


    }
}
