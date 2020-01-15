import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * this class sets up the Frame for the program
 */
public class Ball_Frame extends JFrame {

    /**
     * constructor for the class
     * sets up frame for the GUI
     * @param x
     */
    public Ball_Frame(int x)
    {

        setTitle("Bouncy Balls");
        setSize(x,x);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ExecutorService executeService = Executors.newCachedThreadPool();
        Ball_GUI ball = new Ball_GUI(100,100,x,600);
        executeService.execute(ball);
        add(ball);
    }
}
