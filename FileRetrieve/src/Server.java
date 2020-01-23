import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Class: Server (taken from textbook)
 * creates the server GUI and connection
 */
public class Server extends JFrame {
    /**
     * saves the file name or file path
     */
    private  String newMessage = "";
    /**
     * stores file paths
     */
    private final String fileName = "oral_exam2" + File.separator + "28-13_FileRetrieve_Easy"+ File.separator + "src" +File.separator;
    /**
     * Private JTextField for user
     */
    private JTextField enterField; // inputs message from user
    /**
     *  private JTextArea for display for information
     */
    private JTextArea displayArea; // display information to user
    /**
     * Private Object variable that stores the output stream from the server
     */
    private ObjectOutputStream output; // output stream to client
    /**
     * Private Object variable that stores input stream from the server
     */
    private ObjectInputStream input; // input stream from client
    /**
     * Private Variable that saves message from server
     */
    private ServerSocket server; // server socket
    /**
     * Private string that saves server
     */
    private Socket connection; // connection to client
    /**
     * stores socket that communicates with server
     */
    private int counter = 1; // counter of number of connections
    /**
     * Client Constructor initializes GUI and server
     * @param host
     */
    private boolean first = true;


    /**
     * Server Constructor initializes GUI and server
     */
    // set up GUI
    public Server() {
        super("Server");

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to client
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
    // set up and run server
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Name: connectToServer
     * Type: void
     * Function: connect to server
     */
    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
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
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * Name: proccessConnection
     * Type: void
     * Function: process connection with server
     * @throws IOException
     */
    // process connection with client
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // send connection successful message
        String messageSaved;
        // enable enterField so server user can send messages
        setTextFieldEditable(true);

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                messageSaved = message.replaceAll("CLIENT>>> ","");
                newMessage = fileName + messageSaved;
                System.out.println(newMessage);
                newMessage = fileReadIn(newMessage);

                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * Name: closeConnection
     * Type: void
     * Function: close streams and socket
     */
    // close streams and socket
    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
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
    // send message to client
    private void sendData(String message) {
        if(!newMessage.equals(""))
        {
            message = newMessage;

            newMessage= "";
        }
        System.out.println(message);
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
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
                        displayArea.append(messageToDisplay); // append message
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

    /**
     * Name: fileReadIn
     * Type: String
     * Function: read's in file and returns the contents of the file
     * @param name
     * @return string
     */
    private String fileReadIn(String name)
    {
        String content = "";
        File file = new File(name);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                content = content + " " + data + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            content = "File doesn't exist";
        }
        return content;
    }
}
