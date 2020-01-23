import java.util.Scanner;

/**
 * class: HumanPlayer
 * allows human player to make a move
 */
public class HumanPlayer extends Player{
    /**
     * stores player symbol
     */
    private String playerSymbol;
    /**
     * stores the board
     */
    private Board board;

    /**
     *
     * @param playerSymbol
     * @param board
     */
    public HumanPlayer(String playerSymbol, Board board)
    {
        this.playerSymbol = playerSymbol;
        this.board=board;
    }

    /**
     * overiden from Player class to let human player make move
     * @return
     */
    @Override
    public int makeMove() {
        boolean ValidMove = false;
        while(ValidMove == false)
        {
            int spot = userInput();
            //checks if spot is taken, if not board set move ends
            // else enter in another spot
            if (board.checkSpot(spot))
            {
                board.changexo(playerSymbol, spot);
                board.printBoard();
                ValidMove = true;
            }
            else
            {
                System.out.println("Wrong input");
            }
        }
        return board.checkWin(playerSymbol);
    }

    /**
     * lets user input a move
     * @return
     */
    public int userInput()
    {
        System.out.print("Enter spot you would like play: ");
        Scanner input = new Scanner(System.in);
        int spot = input.nextInt();
        return spot;
    }

    /**
     * overiden from Player class
     * gets human player symbol
     * @return
     */
    @Override
    public String getPlayerSymbol() {
        return playerSymbol;
    }

    /**
     * overiden from Player class
     * lets user set symbol
     * @param input
     */
    @Override
    public void setPlayerSymbol(String input) {
        playerSymbol = input;
    }
}

