import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature extends JFrame implements ActionListener{
    //定义窗口包含的控件
    public JButton celsiusB;
    public JButton fahrenheitB;
    public JTextField celsiusT;
    public JTextField fahrenheitT;

    public Temperature() {
        setTitle("温度转换");
        setSize(560,320);
        this.setLayout(null); //取消窗口的布局方式
        //设计两个按钮
        celsiusB = new JButton("摄氏温度");
        fahrenheitB = new JButton("华氏温度");
        celsiusB.setSize(160,80);
        celsiusB.setLocation(80,80);
        fahrenheitB.setSize(160,80);
        fahrenheitB.setLocation(320,80);
        this.add(celsiusB);
        this.add(fahrenheitB);
        //设计两个文本框输入温度
        celsiusT = new JTextField();
        fahrenheitT = new JTextField();
        celsiusT.setSize(160,40);
        celsiusT.setLocation(80,200);
        fahrenheitT.setSize(160,40);
        fahrenheitT.setLocation(320,200);
        this.add(celsiusT);
        this.add(fahrenheitT);
        //为按钮增加监听事件
        celsiusB.addActionListener(this);
        fahrenheitB.addActionListener(this);
        //窗口设置可见
        setVisible(true);
    }

    //自定义监听事件
    @Override
    public void actionPerformed(ActionEvent e) {
        //哪个按钮按了 获取对面文本上的数字 转化输出
        //获取到按钮上的文本
        if (e.getActionCommand().equals("摄氏温度")) {
            //再获取华氏温度文本上的数字
            String f = fahrenheitT.getText();
            double fNum = Double.parseDouble(f);//将字符串转为数字
            //将该数字转换为摄氏温度
            double cNum = (fNum - 32) * (5.0/9);
            //输出到摄氏温度文本框下
            celsiusT.setText(String.valueOf(cNum));
        } else if (e.getActionCommand().equals("华氏温度")) {
            double cNum = Double.parseDouble(celsiusT.getText());
            double fNum = (9.0/5) * cNum + 32;
            fahrenheitT.setText(String.valueOf(fNum));
        }
    }
}
