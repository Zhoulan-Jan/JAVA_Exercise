import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ron extends Frame implements ActionListener {
    public JPanel panel1;
    public JPanel panel2;

    public Ron() {
        setTitle("荣恩");
        setSize(240,120);
        //框架设置为边界布局
        setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        //面板设置为边界框架
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
//        for (int i = 1; i < 4; i++) {
//            panel1.add(new JButton("按按" + i));
//            panel2.add(new JButton("钮钮" + i));
//        }
        JButton A = new JButton("A");
        JButton B = new JButton("B");
        JButton C = new JButton("C");
        JButton D = new JButton("D");
        JButton E = new JButton("E");
        JButton F = new JButton("F");
        panel1.add(A, BorderLayout.LINE_START);
        panel1.add(B,BorderLayout.CENTER);
        panel1.add(C,BorderLayout.LINE_END);

        panel2.add(D, BorderLayout.LINE_START);
        panel2.add(E,BorderLayout.CENTER);
        panel2.add(F,BorderLayout.LINE_END);

        A.addActionListener(this);
        B.addActionListener(this);
        C.addActionListener(this);
        D.addActionListener(this);
        E.addActionListener(this);
        F.addActionListener(this);

        this.add(panel1,BorderLayout.PAGE_START);
        this.add(panel2,BorderLayout.PAGE_END);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
