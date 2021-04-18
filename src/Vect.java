public class Vect {
    public int x;
    public int y;

    public Vect(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Vect(){
        this.x = 0;
        this.y = 0;
    }

    public Vect times(int n){
        int x = this.x * n;
        int y = this.y * n;
        return new Vect(x,y);
    }

    public Vect add(Vect n){
        int x = this.x + n.x;
        int y = this.y + n.y;
        return new Vect(x,y);
    }


}
