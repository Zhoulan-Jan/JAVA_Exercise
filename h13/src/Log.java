import javax.swing.*;
import java.util.Calendar;

public class Log extends JFrame {
    JLabel name = new JLabel("用户名");
    JLabel passwd = new JLabel("密码");
    JLabel sex = new JLabel("性别");
    JLabel qq = new JLabel("QQ号");
    JLabel email = new JLabel("邮件");

    JTextField nameT = new JTextField();
    JTextField passedT = new JTextField();
    JTextField sexT = new JTextField();
    JComboBox<String> sexC = new JComboBox<>();
    JTextField qqT = new JTextField();
    JTextField emailT = new JTextField();

    JButton log = new JButton("登录");
    JButton exit = new JButton("退出");

    public Log () {
        setSize(350,350);
        setTitle("登录界面");
        setLayout(null);

        name.setSize(100,50);
        name.setLocation(50,50);
        this.add(name);

        nameT.setSize(100,50);
        nameT.setLocation(200,50);
        this.add(nameT);

        sexC.setSize(100,50);
        sexC.setLocation(200,150);
        sexC.addItem("男");
        sexC.addItem("女");
        this.add(sexC);

        setVisible(true);

    }

    public static void main(String[] args) {
        Log log = new Log();
    }

}
