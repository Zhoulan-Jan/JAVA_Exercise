import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame{

    public JPanel panel1;
    public JButton[] bts1;
    public JTextField txt;
    public JButton zero;
    public JButton point;
    public JButton add;
    public JButton equal;
    public JPanel panel2;
    public JButton[] bts2;

    public Calculator()
    {
        setSize(600,800);//设置窗口大小
        setTitle("计算器");//设置窗口标题
        setLayout(null); //取消窗口布局方式

        //文本框
        txt = new JTextField();
        txt.setSize(400,160);
        txt.setLocation(60,60);
        this.add(txt);

        //1
        panel1=new JPanel();
        panel1.setSize(320, 400); //大框框
        panel1.setLocation(60, 220); //大框框左上角的位置
        panel1.setLayout(new GridLayout(5,4));
        String[] strs1={"MC","MR","MS","M+",
                "👈","CE","C","+-",
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-"};
        bts1=new JButton[20];
        for(int i=0;i<bts1.length;i++)
        {
            bts1[i]=new JButton(strs1[i]);
            panel1.add(bts1[i]);
        }
        this.add(panel1);

        //2
        panel2=new JPanel();
        panel2.setSize(80, 320); //大框框
        panel2.setLocation(380, 220); //大框框左上角的位置
        panel2.setLayout(new GridLayout(4,1));
        String[] strs2={"M-","√","%","1/x"};
        bts2=new JButton[4];
        for(int i=0;i<bts2.length;i++)
        {
            bts2[i]=new JButton(strs2[i]);
            panel2.add(bts2[i]);
        }
        this.add(panel2);

        //0
        zero = new JButton("0");
        zero.setSize(160,80);
        zero.setLocation(60,620);
        this.add(zero);

        //.
        point = new JButton(".");
        point.setSize(80,80);
        point.setLocation(220,620);
        this.add(point);

        //+
        add = new JButton("+");
        add.setSize(80,80);
        add.setLocation(300,620);
        this.add(add);

        //=
        equal = new JButton("=");
        equal.setSize(80,160);
        equal.setLocation(380,540);
        this.add(equal);
        setVisible(true);//设置窗口可见
    }
}

