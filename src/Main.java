public class Main{
    public static void main(String[]args){
        GameBoard gb = new GameBoard();
        for(Player p :gb.getPlayers()){
            for(Horse h :p.getHorse()){
                gb.gui.addHorse(h);
            }
        }
    }

}

