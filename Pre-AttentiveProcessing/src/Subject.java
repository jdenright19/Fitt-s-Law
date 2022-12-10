import javax.swing.*;
import java.awt.event.*;

public class Subject extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField subID;
    private JSpinner numChoice;
    private JTextField numTrials;
    private String id;
    private int choice;
    private int trials;



    public Subject() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        numChoice.setModel(new SpinnerNumberModel(2,2,10,1));
    }

    private void onOK() {
        // add your code here
        id = subID.getText();
        choice = (int)numChoice.getValue();
        trials = Integer.parseInt(numTrials.getText());
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String getId() {
        return id;
    }

    public int getChoice() {
        return choice;
    }

    public int getTrials() {
        return trials;
    }

    public static void main(String[] args) {
        Subject dialog = new Subject();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
