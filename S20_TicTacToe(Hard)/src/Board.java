/**
 * class Board
 * -initializes the board
 * -checks the board for an empty spot
 * -checks if there is a winner
 */
public class Board {
    /**
     * sets up the empty board
     */
    String [] xo = {" ", " ", " "," ", " ", " ", " ", " ", " "};
    /**
     * stores how many moves were played
     */
    int count= 0;

    /**
     * gets the board
     * @return
     */
    public  String[] getBoard()
    {
        return xo;
    }

    /**
     * changes The spot on the board
     * @param player
     * @param index
     */
    public  void changexo (String player, int index)
    {
        if (index < 9)
        {
            xo[index] = player;
        }
    }

    /**
     * prints the board
     */
     public void printBoard()
    {
        System.out.println(xo[0] + "  |" + xo[1] + "  |" +xo[2]);
        System.out.println("-----------");
        System.out.println(xo[3] + "  |" + xo[4] + "  |" +xo[5]);
        System.out.println("-----------");
        System.out.println(xo[6] + "  |" + xo[7] + "  |" +xo[8]);
    }


    /**
     * cehcks if move is a valid move
     * @param move
     * @return
     */
    public boolean checkSpot(int move)
    {
        String [] temp = getBoard();
        if(move >= 0 && move <9)
        {
            if (temp[move].compareTo(" ") == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * checks if there is a winner
     * @param player
     * @return
     */
    public int checkWin(String player)
    {
        count++;
        String board[] = getBoard();

        // checks vertical wins
        for(int i=0; i < 3; i++)
        {
            if(board[i].compareTo(player) == 0 && board[i+3].compareTo(player) ==0 && board[i+6].compareTo(player) ==0)
            {
                return 1;
            }
        }
        // checks horizontal wins
        for(int i=0; i<7; i+=3)
        {
            if(board[i].compareTo(player) == 0 && board[i+1].compareTo(player) ==0 && board[i+2].compareTo(player) ==0)
            {
                return 1;
            }
        }
        //checks diagonal top left to bottom right
        if(board[0].compareTo(player) ==0 && board[4].compareTo(player) ==0 && board[8].compareTo(player) ==0)
        {
            return 1;
        }
        //checks diagonal top right to bottom left
        else if(board[2].compareTo(player) ==0 && board[4].compareTo(player) ==0 && board[6].compareTo(player) ==0)
        {
            return 1;
        }
        //checks if it's a tie
        else if(count ==9)
        {
            return 0;
        }
        return -1;
    }
}
