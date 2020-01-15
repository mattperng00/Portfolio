import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class: Client (taken from textbook)
 * creates the server GUI and connection
 */
public class Client extends JFrame {
    /**
     * Private JTextField for user
     */
    private JTextField enterField; // enters information from user
    /**
     *  private JTextArea for display for information
     */
    private JTextArea displayArea; // display information to user
    /**
     * Private Object variable that stores the output stream from the server
     */
    private ObjectOutputStream output; // output stream to server
    /**
     * Private Object variable that stores input stream from the server
     */
    private ObjectInputStream input; // input stream from server
    /**
     * Private Variable that saves message from server
     */
    private String message = ""; // message from server
    /**
     * Private string that saves server
     */
    private String chatServer; // host server for this application
    /**
     * stores socket that communicates with server
     */
    private Socket client; // socket to communicate with server

    /**
     * Client Constructor initializes GUI and server
     * @param host
     */
    // initialize fileserver and set up GUI
    public Client(String host) {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        sendData(event.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * Name: runClient
     * Type: void
     * Function: connect to server and process messages from server
     */
    // connect to server and process messages from server
    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * Name: connectToServer
     * Type: void
     * Function: connect to server
     */
    // connect to server
    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }

    /**
     * Name: getStreams
     * Type: void
     * Function: get streams to send and receive data
     * @throws IOException
     */
    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * Name: proccessConnection
     * Type: void
     * Function: process connection with server
     * @throws IOException
     */
    // process connection with server
    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * Name: closeConnection
     * Type: void
     * Function: close streams and socket
     */
    // close streams and socket
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Name: sendData
     * Type: void
     * Function: sends messages to server
     * @param message
     */
    // send message to server
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject("CLIENT>>> " + message);
            output.flush(); // flush data to output
            displayMessage("\nCLIENT>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * Name: displayMessage
     * Type: void
     * Function: displays messages in displayArea
     * @param messageToDisplay
     */
    // manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    /**
     * Name: setTextFieldEditable
     * Type: void
     * Function: manipulates enterField in the event-dispatch thread
     * @param editable
     */
    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }

}
