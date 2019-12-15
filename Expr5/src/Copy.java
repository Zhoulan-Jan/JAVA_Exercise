import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Copy extends Frame implements MouseListener {

    public JLabel label; //标签
    public JTextField text; //文本框
    public JButton button; //按钮

    public Copy() throws HeadlessException {
        setTitle("复制内容");
        setSize(320,560);
        this.setLayout(null);

        text = new JTextField("The Prisoner of Azkaban");
        text.setSize(160,80);
        text.setLocation(80,80);
        this.add(text);

        button = new JButton("复制");
        button.setSize(160,80);
        button.setLocation(80,240);
        this.add(button);

        label = new JLabel();
        label.setSize(160,80);
        label.setLocation(80,400);
        this.add(label);

        button.addMouseListener(this);
        setVisible(true);
    };

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //把文本框的内容复制到标签中
        //先得到文本框的内容
        String t = text.getText();
        //在标签中显示
        label.setText(t);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
