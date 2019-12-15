import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Information extends Frame implements ActionListener, WindowListener {

    public JLabel nameL= new JLabel("姓名：");
    public JLabel sexL= new JLabel("性别：");
    public JLabel ageL = new JLabel("年龄：");

    public JButton okB = new JButton("OK");
    public JButton clearB = new JButton("CLEAR");

    public JTextField naT = new JTextField();
    public JTextField seT = new JTextField();
    public JTextField agT = new JTextField();

    //滚动面板
    public JScrollPane show = new JScrollPane();
    public JTextArea tx = new JTextArea();

    public Information() throws HeadlessException {
        setTitle("显示信息");
        setSize(540,780);
        setLayout(null);

        nameL.setSize(120,60);
        nameL.setLocation(60,60);
        sexL.setSize(120,60);
        sexL.setLocation(60,180);
        ageL.setSize(120,60);
        ageL.setLocation(60,300);
        this.add(nameL);
        this.add(sexL);
        this.add(ageL);

        naT.setSize(240,60);
        naT.setLocation(240,60);
        seT.setSize(240,60);
        seT.setLocation(240,180);
        agT.setSize(240,60);
        agT.setLocation(240,300);
        this.add(naT);
        this.add(seT);
        this.add(agT);

        okB.setSize(120,60);
        okB.setLocation(120,420);
        clearB.setSize(120,60);
        clearB.setLocation(300,420);
        this.add(okB);
        this.add(clearB);

        show.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        show.setSize(420,180);
        show.setLocation(60,540);
        tx.setSize(410,170);
        tx.setLocation(70,550);

        this.add(show);
        show.setViewportView(tx);
        okB.addActionListener(this);
        clearB.addActionListener(this);
        //this.setDropTarget(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            //获取三个text上的文字
            String name = naT.getText();
            String sex = seT.getText();
            String age = agT.getText();
            //在面板上输出
            tx.append("姓名：" + name + "\n");
            tx.append("性别：" + sex + "\n");
            tx.append("年龄：" + age + "\n");
        } else if (e.getActionCommand().equals("CLEAR")) {
            naT.setText(null);
            seT.setText(null);
            agT.setText(null);
            //naT.remove(this); //不可行
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
