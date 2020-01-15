import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * class User_Interface:
 * sets up the GUI for arabic to Roman
 */
public class User_Interface {
    private JPanel p;
    private JFrame frame;
    private JTextField text1;
    private JTextField text2;
    private JLabel label;
    private JLabel label3;
    private String printTextArabic = "";
    private String printTextRoman = "";


    /**
     *constructor that calls the method that sets up the GUI
     */
    User_Interface()
    {
        openGui();

    }

    /**
     * sets up GUI interface. Creates 2 text boxes in a window and lets user input in both. Once
     * user inputs in one textbox, the convert keylistener method is called to check the input.
     */
    public  void openGui()
    {
        p = new JPanel();
        frame = new JFrame("Arabic and Roman number Converter");

        //setting frame size
        frame.setSize(500,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating label "Arabic" next to textbox for arabic numbers
        label = new JLabel("Arabic : ");

        p.add(label);
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(150,25));


        p.add(text1);


        //creating label "Roman" next to the textbox for roman numerals
        label = new JLabel("Roman :");
        p.add(label);
        text2 = new JTextField();
        text2.setPreferredSize(new Dimension(150,25));
        p.add(text2);

        label3 = new JLabel("");
        p.add(label3);
        //check's user input
        addKeyListenerArabic(text1,label3,text2);
        addKeyListenerRoman(text2,label3,text1);

        //adding to frame
        frame.add(p);

        //can't minimize or maximize window
        frame.setResizable(false);
        //shows everything
        frame.setVisible(true);

    }

    /**
     * This checks the Arabic text boxt for correct input and if it is
     * it will print the conversion into the roman text box
     * @param ArabicText
     * @param label
     * @param RomanText
     */
    public void addKeyListenerArabic(JTextField ArabicText,JLabel label, JTextField RomanText)
    {

        ArabicText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char userText = e.getKeyChar();

                Convert Arabic_To_Roman;
                label3.setText("");
                if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                {
                    printTextArabic = text1.getText();

                    if(printTextArabic.equals(""))
                    {
                        RomanText.setText("");
                    }
                    else
                    {
                        int correctInput= Integer.parseInt(printTextArabic);
                        if(correctInput <1 || correctInput > 3999)
                        {
                            label3.setText("range is 1-3999");
                        }
                        else
                        {
                            Arabic_To_Roman = new Convert(correctInput);
                            ArabicText.setEditable(true);

                            RomanText.setText("");
                            RomanText.setText(Arabic_To_Roman.Arabic_Roman());
                        }
                    }

                }
                else if(Character.isLetter(userText)) // if letter is used then can't edit textbox
                {
                    label.setText("arabic numbers only");
                    ArabicText.setEditable(false);
                }
                else
                {
                    printTextArabic = printTextArabic+userText;

                    int correctInput = Integer.parseInt(printTextArabic);
                    if(correctInput <1 || correctInput > 3999)
                    {
                        label3.setText("range is 1-3999");
                    }
                    else
                    {

                        Arabic_To_Roman = new Convert(correctInput);
                        ArabicText.setEditable(true);

                        RomanText.setText("");
                        RomanText.setText(Arabic_To_Roman.Arabic_Roman());
                    }
                }
            }
        });
    }


    /**
     * This method checks the user input in the roman text box. If the input is correct
     * convert and print it to the arabic text box.
     * @param RomanText
     * @param label
     * @param ArabicText
     */
    public void addKeyListenerRoman(JTextField RomanText,JLabel label,JTextField ArabicText)
    {
        RomanText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char userText = e.getKeyChar();
                Convert Roman_to_Arabic;

                if( userText == KeyEvent.VK_BACK_SPACE)
                {
                    ArabicText.setText("");
                    printTextRoman = text2.getText();

                    Roman_to_Arabic = new Convert(printTextRoman);
                    RomanText.setEditable(true);

                    String output = "";
                    if(Roman_to_Arabic.Roman_Arabic() >0 || Roman_to_Arabic.Roman_Arabic() >= 3999)
                    {
                        output = String.valueOf(Roman_to_Arabic.Roman_Arabic());
                    }
                    ArabicText.setText(output);

                }
                else if(Character.isLetter(userText))
                {
                    // resetting textbox to empty
                    ArabicText.setText("");
                    label3.setText("");
                    printTextRoman = printTextRoman + userText;
                    // calling my Convert for the Roman number
                    Roman_to_Arabic = new Convert(printTextRoman);
                    //sets my roman textbox to editable
                    RomanText.setEditable(true);
                    int ConvertedNum = Roman_to_Arabic.Roman_Arabic();
                    //checks if printTextRoman is greater than 0 and less than 3999
                    if(ConvertedNum >0 || ConvertedNum >= 3999)
                    {
                        Convert check = new Convert(ConvertedNum);
                        String ConvertedNumConvertedagain = check.Arabic_Roman(); //converts the arabic back to roman
                        // if the two strings equal then it's a correct input
                        if(ConvertedNumConvertedagain.equals(printTextRoman))
                        {
                            ArabicText.setText(String.valueOf(ConvertedNum));
                        }
                        else
                        {
                            label3.setText("invalid input");
                        }
                    }
                    else
                    {
                        label3.setText("invalid input");
                    }
                }
                else
                {
                    label.setText("Strings only");
                    RomanText.setEditable(false);
                }


            }
        });
    }

}
