import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Creates a ball and moves it
 */
public class Ball_GUI extends JPanel implements Runnable{
    /**
     * stores the x and y coordinates
     */
    private int x,y;
    /**
     * stores the width of the frame
     */
    private final int xLim;
    private final int yLim;
    /**
     * boolean for stopping or starting the program
     */
    private boolean stop = true;

    private boolean endx = false;

    private boolean endy = false;

    /**
     * constructor
     * @param x x coordinate
     * @param y y coodrinate
     * @param xLim x limit of box
     */
    Ball_GUI(int x, int y,int xLim, int yLim)
    {
        this.x=x;
        this.y=y;
        this.xLim=xLim-70;
        this.yLim = yLim-100;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(stop)
                {
                    stop =false;
                }
                else
                {
                    stop = true;
                }
            }
        });

    }


    /**
     * moves the ball by changes x and y
     */
    public void moveBall() {


        if(!stop)
        {
            // move right
            if (x != xLim && !endx) {
                x++;
                if( y!= yLim && !endy)
                {
                    y++;
                    if(y==xLim)
                    {
                        endy=true;
                    }
                }
                if(x==xLim)
                {
                    endx = true;
                }
            }
            //move left
            else
            {
                x--;
                if(y!=0)
                {
                    y--;
                    if(y==0)
                    {
                        endy=false;
                    }
                }
                if(x==0)
                {
                    endx = false;
                }
            }
            System.out.println(y);
            repaint();
        }


    }

    /**
     * intializes the ball and repaints it
     */
    @Override
    public void paint(Graphics ball)
    {
        super.paint(ball);
        ball.setColor(Color.BLUE);
        ball.fillOval(x,y,50,50);

    }

    /**
     * try's to run the moveBall method
     * and sleeps the Thread
     */
    @Override
    public void run()
    {

        while(true)
        {

            try
            {
                moveBall();
                Thread.sleep(5);
            }
            catch (Exception e)
            {
                System.out.println("wrong");
            }
        }


    }

}
