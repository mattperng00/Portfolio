import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //max x 435,max y 410

        Ball_GUI ball = new Ball_GUI(250,250,600,600);
        ExecutorService executeService = Executors.newCachedThreadPool();
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Bouncy Balls");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        executeService.execute(ball);
        frame.add(ball);

    }
}
