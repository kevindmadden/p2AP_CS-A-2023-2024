package chess.game.game;


public class Main {
    public static void main(String[] args) {
        Board.setInitialBoard();

        Start start = new Start();
        while (true) {
            start.start();
            if(!hasWon(start)) {
                Board.displayBoard();
                if(start.getCounter()%2==0) System.out.println("\nPLAYER 2 HAS WON\n");
                else System.out.println("\nPLAYER 1 HAS WON\n");
                break;
            }
        }
    }

    private static boolean hasWon(Start start) {
        return !((start.getCounter()%2==0 && start.getPlayer1().getMoves().size()==0) || (start.getCounter()%2==1 && start.getPlayer2().getMoves().size()==0));
    }
}