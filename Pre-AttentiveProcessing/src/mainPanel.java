import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class mainPanel {
    private JPanel sdtPanel;
    private JButton startButton;
    private redCirclePanel redCirclePanel1;

    private redCirclePanel3 redCirclePanel4;

    private redSquarePanel redSquarePanel1;
    private JLabel hitLabel;
    private JLabel misslabel;
    private JLabel falabel;
    private JLabel crlabel;
    private JTextField txtSpeed;
    private JLabel Speed;
    private JLabel Subjectlbl;
    private JTextField SubjectTxt;
    private JButton startButton2;
    private JButton startButton3;
    private JPanel sdtPanel2;
    private JSlider slider1;
    private Timer timer;
    private int hit;

    private int numChoicesVal;
    private int miss;
    private int falseAlarm;

    private String experiment;

    private String subject;
    private boolean button1;

    private boolean button2;

    private boolean button3;

    private int timerVal;

    private int timerVal2;
    private String numChoicesTxt;
    private int numTimesCorrect;

    private int correctReject;
    private boolean isPresent3;

    public mainPanel() {
        button1 = false;
        button2 = false;
        button3 = false;
        timerVal = 150;
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numChoicesTxt = txtSpeed.getText();
                numChoicesVal = Integer.parseInt(numChoicesTxt);
                experiment = "Experiment 1";
                redCirclePanel1.begin(numChoicesVal);
                timer = new Timer(timerVal, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button1 = true;

                        //System.out.println(numChoicesTxt);
                        System.out.println("Done");
                        redCirclePanel1.stop();
                        timer.stop();
                        try {
                            feedback();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        subject = SubjectTxt.getText();
                    }
                });
                timer.start();
            }

        });
        startButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                redCirclePanel4.begin();
                timer = new Timer(timerVal, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button3 = true;
                        numChoicesTxt = txtSpeed.getText();
                        experiment = "Experiment 2";
                       // numChoicesVal = Integer.parseInt(numChoicesTxt);
                        System.out.println(numChoicesTxt);
                        System.out.println("Done");
                        redCirclePanel4.stop();
                        timer.stop();
                        try {
                            feedback();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        subject = SubjectTxt.getText();
                    }
                });
                timer.start();
            }
        });
        startButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                redSquarePanel1.begin();
                timer = new Timer(timerVal, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button2 = true;
                        numChoicesTxt = txtSpeed.getText();
                        experiment = "Experiment 3";
                       // numChoicesVal = Integer.parseInt(numChoicesTxt);
                        System.out.println(numChoicesTxt);
                        System.out.println("Done");
                        redSquarePanel1.stop();
                        timer.stop();
                        try {
                            feedback();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        subject = SubjectTxt.getText();
                    }
                });
                timer.start();
            }
        });
    }




    private void feedback() throws IOException {
        if (button1) {
            isPresent3 = redCirclePanel1.isPresent2();
            //button1 = false;
        }
        if (button3) {
            isPresent3 = redCirclePanel4.isPresent2();
            //button3 = false;
        }
        if (button2) {
            isPresent3 = redSquarePanel1.isPresent2();
            //button2 = false;
        }
        int input = JOptionPane.showConfirmDialog(null,
                "Did you see the shape?", "Select an Option...", JOptionPane.YES_NO_OPTION);

        if (isPresent3 == true){
            if(input ==JOptionPane.YES_OPTION) {
                falseAlarm++;
                timerVal += 25;
                numTimesCorrect = 0;
                System.out.println(numTimesCorrect);

            }
            else  {
                miss++;
                timerVal += 25;
                numTimesCorrect = 0;
                System.out.println(numTimesCorrect);
            }
        } else{
            if(input ==JOptionPane.YES_OPTION) {
                hit++;
                numTimesCorrect += 1;
                System.out.println(numTimesCorrect);
            }
            else  {
                correctReject++;
                numTimesCorrect += 1;
                System.out.println(numTimesCorrect);
            }
            if (numTimesCorrect == 10)
            {

                timerVal2 = timerVal;
                FileWriter fWriter = new FileWriter(
                        "C:/Users/turtl/IdeaProjects/Pre-AttentiveProcessing/src/data2.txt");
                fWriter.write(experiment);
                fWriter.write(subject);
                fWriter.write(timerVal);

                System.out.println(subject);
                System.out.println(experiment);
            }
        }

        hitLabel.setText(hit + " Hit");
        misslabel.setText(miss + " Miss");
        falabel.setText(falseAlarm + " False Alarm");
        crlabel.setText(correctReject + " Correct Reject");
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Signal Detection Theory");
        frame.setContentPane(new mainPanel().sdtPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static int numChoicesVal() {
        return numChoicesVal;
    }
}