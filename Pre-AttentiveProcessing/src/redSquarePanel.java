import javax.swing.*;
import java.awt.*;
import java.awt.*;
import javax.swing.*;
import java.lang.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Scanner;
import java.lang.Thread;
import javax.swing.Timer;
public class redSquarePanel extends JPanel {
    private JPanel redSquarePanel1;
    private int numChoices;
    private double x;
    private double y;

    private double randomizer;
    private int width;

    private boolean isPresent;
    private boolean isPresent2;

    public redSquarePanel()
    {
        numChoices = 10;
        isPresent = true;
        x = 100;
        y = 100;
        width = 20;
        randomizer = 0;

    }
    public void setChoices ( int num)
    {
        numChoices = num;
        isPresent = false;

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
                g.drawRect((int) x,(int) y, width, width);
                ga.fillRect((int) x,(int) y, width, width);
                isPresent = false;
            }
            else
            {

                ga.setPaint(Color.red);
                x = Math.random() * (600 - 0) + 0;
                y = Math.random() * (600 - 0) + 0;
                g.drawOval((int) x,(int) y, width, width);
                ga.fillOval((int) x,(int) y, width, width);
            }

        }
    }
    public void stop()
    {
        System.out.println("Stop");

    }
    public void begin(int p)
    {
        numChoices = p;
        JFrame f = new JFrame("Red Square amongst red circles");
        f.getContentPane().add(new redSquarePanel());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        JFrame f = new JFrame("Red square amongst red circles");
        f.getContentPane().add(new redSquarePanel());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public boolean isPresent2() {
        return isPresent2;
    }
}