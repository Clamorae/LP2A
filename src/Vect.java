public class Vect {//this Class is use to create Vector, which is simple than using only coordinates
    public int x;
    public int y;

    public Vect(int x,int y){// we put two constructor here to avoid error
        this.x = x;
        this.y = y;
    }

    public Vect(){
        this.x = 0;
        this.y = 0;
    }

    public Vect times(int n){// a function which take an integer and return the vector multiplied by this integer
        int x = this.x * n;
        int y = this.y * n;
        return new Vect(x,y);
    }

    public Vect add(Vect n){//a function which take a vector, sum it with the actual vector and return the result as a vector
        int x = this.x + n.x;
        int y = this.y + n.y;
        return new Vect(x,y);
    }


}
