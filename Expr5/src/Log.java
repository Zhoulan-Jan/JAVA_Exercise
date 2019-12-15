import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Log extends Frame implements ActionListener {
    public JTextArea show = new JTextArea();
    public JButton okB = new JButton("OK");
    public JButton cancleB = new JButton("CANCLE");
    public JButton exitB = new JButton("EXIT");

    public Log() {
        setSize(800,560);
        setLayout(null);

        show.setSize(480,280);
        show.setLocation(160,40);

        okB.setSize(160,80);
        okB.setLocation(80,400);

        cancleB.setSize(160,80);
        cancleB.setLocation(320,400);

        exitB.setSize(160,80);
        exitB.setLocation(560,400);
        this.add(show);
        this.add(okB);
        this.add(cancleB);
        this.add(exitB);
        okB.addActionListener(this);
        cancleB.addActionListener(this);
        exitB.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            show.append(e.getActionCommand() + "\n");
        } else if (e.getActionCommand().equals("CANCLE")) {
            show.append(e.getActionCommand() + "\n");
        } else if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
        }
    }
}
