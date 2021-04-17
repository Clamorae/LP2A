public class Vector {
    public int x;
    public int y;

    public Vector(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Vector(){
        this.x = 0;
        this.y = 0;
    }

    public Vector times(int n){
        int x = this.x * n;
        int y = this.y * n;
        return new Vector(x,y);
    }

    public Vector add(Vector n){
        int x = this.x + n.x;
        int y = this.y + n.y;
        return new Vector(x,y);
    }


}
