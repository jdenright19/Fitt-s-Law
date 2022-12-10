import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class redCirclePanel3 extends JPanel {
    private JPanel redCirclePanel4;
    private int numChoices;
    private double x;
    private double y;

    private double randomizer;

    private int numTrials;

    private String id;
    private double randomizer2;
    private int width;

    private boolean isPresent;

    private boolean isPresent2;
    public redCirclePanel3()
    {
        numChoices = 10;
        isPresent = true;
        x = 100;
        y = 100;
        width = 20;
        randomizer = 0;
        randomizer2 = 0;

    }
    public void setChoices ( int num)
    {
        numChoices = num;
        isPresent = false;

    }
    public void setTrials(int num){
        numTrials = num;
    }

    public void setId(String id){
        this.id = id;
    }

    public void paint (Graphics g) {
        randomizer = Math.random() * (100 - 0) + 0;

        if ((int) randomizer % 2 != 0) {
            isPresent = true;
            isPresent2 = true;
        }
        else
        {
            isPresent = false;
        }

        for (int i = 0; i < numChoices; i++)
        {
            Graphics2D ga = (Graphics2D) g;
            if (isPresent == true)
            {
                ga.setPaint(Color.red);
                x = Math.random() * (600 - 0) + 0;
                y = Math.random() * (600 - 0) + 0;
                g.drawOval((int) x,(int) y, width, width);
                ga.fillOval((int) x,(int) y, width, width);
                isPresent = false;
            }
            else
            {
                randomizer2 = Math.random() * (100 - 0) + 0;
                if ((int) randomizer2 % 2 != 0)
                {
                    ga.setPaint(Color.blue);
                    x = Math.random() * (600 - 0) + 0;
                    y = Math.random() * (600 - 0) + 0;
                    g.drawOval((int) x,(int) y, width, width);
                    ga.fillOval((int) x,(int) y, width, width);
                }
                else
                {
                    ga.setPaint(Color.red);
                    x = Math.random() * (600 - 0) + 0;
                    y = Math.random() * (600 - 0) + 0;
                    g.drawRect((int) x,(int) y, width, width);
                    ga.fillRect((int) x,(int) y, width, width);
                }

            }

        }
    }
    public void stop()
    {
        System.out.println("Stop");

    }
    public void begin()
    {
        JFrame f = new JFrame("Red Circle amongst blue circles and red Squares");
        f.getContentPane().add(new redCirclePanel3());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame f = new JFrame("Red Circle amongst red squares and blue circles");
        f.getContentPane().add(new redCirclePanel3());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public boolean isPresent2()
    {
        return isPresent2;
    }
}
