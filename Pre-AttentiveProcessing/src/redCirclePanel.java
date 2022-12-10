import javax.swing.*;
import java.awt.*;
import java.lang.*;
import javax.swing.Timer;

public class redCirclePanel extends JPanel {
    private JPanel redCirclePanel1;
    private JTextField subjectTxt;
    private JLabel SubjectLbl;
    private JLabel DistractorsLbl;
    private int numChoices;
    private double x;
    private double y;

    private int trialsSoFar;
    private String id;
    private int numTrials;

    private Timer timer;
    private double randomizer;
    private int width;


    private boolean isPresent;
    private boolean isPresent2;


    public redCirclePanel() {
        numChoices = 10;
        isPresent = true;
        x = 100;
        y = 100;
        width = 20;
        randomizer = 0;
        isPresent2 = false;

    }

    public void paint(Graphics g)
    {
        randomizer = Math.random() * (100 - 0) + 0;

        if ((int) randomizer % 2 != 0) {
            isPresent = true;
            isPresent2 = true;
        } else {
            isPresent = false;
        }

        for (int i = 0; i < numChoices; i++) {
            Graphics2D ga = (Graphics2D) g;
            if (isPresent == true) {
                ga.setPaint(Color.red);
                x = Math.random() * (600 - 0) + 0;
                y = Math.random() * (600 - 0) + 0;
                g.drawOval((int) x, (int) y, width, width);
                ga.fillOval((int) x, (int) y, width, width);
                isPresent = false;
            } else {

                ga.setPaint(Color.blue);
                x = Math.random() * (600 - 0) + 0;
                y = Math.random() * (600 - 0) + 0;
                g.drawOval((int) x, (int) y, width, width);
                ga.fillOval((int) x, (int) y, width, width);
            }

        }
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
    public void stop()
    {
        System.out.println("Stop");
        dispose();
    }

    private void dispose() {
        redCirclePanel1.setVisible(false);
    }

    public void begin(int numChoicesVal)
    {
        JFrame f = new JFrame("Red Circle amongst blue circles");
        f.getContentPane().add(new redCirclePanel());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        JFrame f = new JFrame("Red Circle amongst blue circles");
        f.getContentPane().add(new redCirclePanel());
        f.setSize(700, 700);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public boolean isPresent2() {
        return isPresent2;
    }

}

