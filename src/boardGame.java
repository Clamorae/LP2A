import java.lang.Math;

public class boardGame {
	Lcase RStart;
	Lcase YStart;
	Lcase BStart;
	Lcase GStart;
	int dice;
	
	boardGame(Lcase r, Lcase y, Lcase b, Lcase g){
		this.RStart=r;
		this.BStart=b;
		this.GStart=g;
		this.YStart=y;
		this.dice=0;
	}
	
	private static int rollDice(){
		int value= (int)(Math.random()*0+6);
		return value;
	}
}
