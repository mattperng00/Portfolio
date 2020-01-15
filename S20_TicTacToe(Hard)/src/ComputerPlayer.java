import java.util.Random;

/**
 * Class ComputerPlayer;
 * gives the bot the option to move and set symbol
 */
public class ComputerPlayer extends Player {
    /**
     * stores player symbol
     */
    private String computerSymbol;
    /**
     * stores the board
     */
    private Board board;

    /**
     * construcor that initializes private variables
     * @param computerSymbol
     * @param board
     */
    public ComputerPlayer(String computerSymbol,Board board)
    {
        this.computerSymbol = computerSymbol;
        this.board=board;
    }

    /**
     * overriden from class Player
     * lets computer player randomly move to a spot
     * @return
     */
    @Override
    public int makeMove() {
        boolean incorrect = true;
        while(incorrect) {

            Random rand = new Random();
            int randMove = rand.nextInt((8 - 0) + 1) + 0;
            //checks if spot is taken, if not board set move ends
            // else find another random value
            if (board.checkSpot(randMove))
            {
                board.changexo(computerSymbol, randMove);
                board.printBoard();
                incorrect = false;
            }
        }
        return board.checkWin(computerSymbol);
    }

    /**
     * overriden from class Player
     * reutnrs the computer symbol
     * @return
     */
    @Override
    public String getPlayerSymbol() {
        return computerSymbol;
    }

    /**
     * sets the computer symbol
     * @param x
     */
    @Override
    public void setPlayerSymbol(String x) {
        computerSymbol = x;
    }
}

