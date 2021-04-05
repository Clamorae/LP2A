import java.awt.*;

public class Main{

    public static void main(String[]args){
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