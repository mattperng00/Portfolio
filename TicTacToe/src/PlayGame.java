import java.util.Scanner;

/**
 * class PlayGame
 * it's the main menu of the game
 */
public class PlayGame {

    /**
     * stores the board
     */
    private Board board;

    /**
     * constructor calls WelcomeScreen()
     */
    public PlayGame()
    {
        WelcomeScreen();
    }

    /**
     * lets user input what type of chess game
     * 1 for human vs human
     * 2 for human vs computer
     * 3 for computer vs computer
     * 4 for quit
     */
    public void WelcomeScreen()
    {
        boolean x = true;
        while(x) {
            board = new Board();
            System.out.println("Welcome to Matt's TicTacToe");
            System.out.print("Enter 1 for 'player vs player' or 2 for 'computer vs player' or 3 for 'computer vs computer' or 4 to 'quit': ");
            Scanner opponent = new Scanner(System.in);
            int userInput = opponent.nextInt();


            if (userInput ==1)
            {
                humanVsHuman();
            }
            else if(userInput == 2)
            {

                humanVsComputer();
            }
            else if(userInput ==3)
            {
                computerVsComputer();
            }
            else if (userInput == 4)
            {
                x = false;
            }
            else
            {
                System.out.println("Wrong option");
            }
        }
    }

    /**
     * Lets human vs human play
     * creates two human players to Player object
     * while loop until a tie or a win
     */
    public void humanVsHuman()
    {
        boolean end = true;
        Player player1 = new HumanPlayer("O",board);
        Player player2 = new HumanPlayer("X",board);

        board.printBoard();
        while(end)
        {
            System.out.println("Player 1 Turn");
            int win = player1.makeMove();
            if(win == 1)
            {
                System.out.println("Player 1 wins!");
                end = false;
            }
            else if(win ==0)
            {
                System.out.println("TIE");
                end = false;
            }
            else
            {
                System.out.println("Player 2 Turn");
                win = player2.makeMove();
                if(win == 1)
                {
                    System.out.println("Player 2 wins!");
                    end = false;
                }
            }
        }
    }

    /**
     * Lets human vs computer play
     * creates one human players as a Player object
     * creaes one computer player as a Player object
     * while loop until a tie or a win
     */
    public void humanVsComputer()
    {
        boolean end = true;
        Player player = new HumanPlayer("O",board);
        Player ai = new ComputerPlayer("X",board);

        board.printBoard();
        while(end)
        {
            System.out.println("Player 1 Turn");
            //gets the move
            int win = player.makeMove();
            //checks for win
            if(win == 1)
            {
                System.out.println("Player 1 wins!");
                end = false;
            }
            //checks for tie
            else if(win ==0)
            {
                System.out.println("Tie!");
                end = false;
            }
            //player 2 tun
            else
            {
                System.out.println("Player 2 Turn");
                //make move
                win = ai.makeMove();
                //check for win
                if(win == 1)
                {
                    System.out.println("Player 2 wins!");
                    end = false;
                }
            }
        }


    }

    /**
     * Lets computer vs computer play
     * creaes two computer player as a Player object
     * while loop until a tie or a win
     */
    public void computerVsComputer()
    {
        boolean end = true;
        Player ai = new ComputerPlayer("O",board);
        Player ai2 = new ComputerPlayer("X",board);

        board.printBoard();
        while(end)
        {
            System.out.println("Computer1 Turn");
            int win = ai.makeMove();
            if(win == 1)
            {
                System.out.println("Computer1 wins!");
                end = false;
            }
            else if(win ==0)
            {
                System.out.println("Tie!");
                end = false;
            }
            else
            {
                System.out.println("Computer2 Turn");
                win = ai2.makeMove();
                if(win == 1)
                {
                    System.out.println("Computer2 wins!");
                    end = false;
                }
            }
        }
    }

}



