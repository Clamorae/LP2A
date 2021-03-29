
public class spot {
	int color;
	vect position;
	int special;
	//0=home, 1=normal, 2=star, 3=ladder, 4=stack, 5=star-stack
	
	spot(int col, vect pos, int special){
		this.color=col;
		this.position=pos;
		this.special=special;
	}
	
	spot(){
		this.color=1;
		this.position=null;
		this.special=1;
	}
}
