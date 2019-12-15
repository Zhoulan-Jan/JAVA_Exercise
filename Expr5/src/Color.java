import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Color extends Frame implements ActionListener {
    public JPanel panel;
    public JButton redB = new JButton("红色");
    public JButton greenB = new JButton("绿色");
    public JButton blueB = new JButton("蓝色");
    public JButton grayB = new JButton("灰色");

    public Color() throws HeadlessException {
        setTitle("改变颜色");
        setSize(480,330);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(redB);
        panel.add(greenB);
        panel.add(blueB);
        panel.add(grayB);

        this.add(panel,BorderLayout.PAGE_END);
        redB.addActionListener(this);
        greenB.addActionListener(this);
        blueB.addActionListener(this);
        grayB.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("红色")) {
            this.setBackground(java.awt.Color.RED);
        } else if (e.getActionCommand().equals("绿色")) {
            this.setBackground(java.awt.Color.GREEN);
        } else if (e.getActionCommand().equals("蓝色")) {
            this.setBackground(java.awt.Color.BLUE);
        } else if (e.getActionCommand().equals("灰色")) {
            this.setBackground(java.awt.Color.GRAY);
        }
    }
}
