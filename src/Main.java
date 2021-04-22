public class Main{
    public static void main(String[]args){
        GameBoard gb = new GameBoard();
        Gui gui = new Gui();
        for(Player p :gb.getPlayers()){
            for(Horse h :p.getHorse()){
                gui.addHorse(h);
            }
        }
        gui.addDice(gb);
        gui.log("Hello World !");
        gui.log("Au tour de bleu");


    }

}

