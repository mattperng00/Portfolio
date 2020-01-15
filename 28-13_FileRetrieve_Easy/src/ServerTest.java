import javax.swing.*;

/**
 * Class: ServerTest
 * runs program
 */
public class ServerTest {
    public static void main(String[] args) {
        Server application = new Server(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}
