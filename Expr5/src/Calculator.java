import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    public JPanel panel1;
    public JButton[] bts1;
    public JTextArea txt;
    public JButton clear;

    public Calculator()
    {
        setSize(300,400);//设置窗口大小
        setTitle("计算器");//设置窗口标题
        setLayout(null); //取消窗口布局方式

        //文本框
        txt = new JTextArea();
        txt.setSize(180,80);
        txt.setLocation(30,30);
        this.add(txt);

        //1
        panel1=new JPanel();
        panel1.setSize(180, 200); //大框框
        panel1.setLocation(30, 110); //大框框左上角的位置
        panel1.setLayout(new GridLayout(4,4));
        String[] strs1={
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+"};
        bts1=new JButton[16];
        for(int i = 0; i < bts1.length; i++)
        {
            bts1[i]=new JButton(strs1[i]);
            panel1.add(bts1[i]);
            bts1[i].addActionListener(this);
        }
        this.add(panel1);

        //清空按键
        clear = new JButton("CLEAR");
        clear.setSize(180,50);
        clear.setLocation(30,310);
        this.add(clear);
        clear.addActionListener(this);
        setVisible(true);//设置窗口可见
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("=")) {
            //为 = 的时候开始运算
            //获取面板上的字符串
            String formula = txt.getText();
            //分解，得到两个操作数和一个运算符 split
            String[] operands = formula.split("\\+|-|\\*|/");  //正则表达式很重要啊
            //将字符串操作数转换为double类型的操作数
            System.out.println(operands[0]);
            System.out.println(operands[1]);
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            System.out.println(op1);
            System.out.println(op2);
            //根据运算符 计算出结果
            double res = 0.0;
            if (formula.contains("+")) {
                res = op1 + op2;
            } else if (formula.contains("-")) {
                res = op1 - op2;
            } else if (formula.contains("*")) {
                res = op1 * op2;
            } else if (formula.contains("/")) {
                res = op1 / op2;
            }
            //将结果附加显示的面板上
            txt.append(" = " + String.valueOf(res));
        } else if (e.getActionCommand().equals("CLEAR")){
            txt.setText(null);
        } else {
            //将字母显示在面板上
            txt.append(e.getActionCommand());
        }
    }
}
