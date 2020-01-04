import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class MainFrame extends JFrame implements ActionListener
{
    JLabel numLa,nameLa;
    JTextField numTxt,nameTxt;
    JButton numFBt,nameFBt,addBt,delBt,upBt;
    JTable table;
    JScrollPane panel;

    public MainFrame()
    {
        //JFrame DengLu = new JFrame("欢迎使用家具管理系统");
        //设置关闭窗口时的默认操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口位置
        this.setLocation(200, 200);
        //设置窗口大小
        this.setSize(400, 300);
        //设置窗体为空
        this.setLayout(null);
        //插入密码按键
        JLabel passLa = new JLabel("密  码");
        passLa.setSize(80, 60);
        passLa.setLocation(60, 70);
        //插入用户名按键
        JLabel userLa = new JLabel("用户名");
        userLa.setSize(80, 60);
        userLa.setLocation(60, 20);
        //添加密码和用户名
        this.add(userLa);
        this.add(passLa);
        //设置文本域
        JTextField userText = new JTextField(30);
        JTextField passText = new JPasswordField(30);
        userText.setLocation(130, 30);
        userText.setSize(150, 30);
        passText.setLocation(130, 80);
        passText.setSize(150, 30);
        //添加文本域
        this.add(userText);
        this.add(passText);
        //添加登陆和退出按钮
        JButton sureBut = new JButton("确认");
        JButton returnBut = new JButton("返回");
        sureBut.setLocation(60, 170);
        returnBut.setLocation(240, 170);
        sureBut.setSize(60, 40);
        returnBut.setSize(60, 40);
        //添加按钮
        this.add(sureBut);
        this.add(returnBut);
        //显示顶级容器
        this.setVisible(true);
        returnBut.addActionListener(e -> {
            userText.setText("");
            passText.setText("");
        });
        sureBut.addActionListener(e -> {
            String user=userText.getText();
            String pass=passText.getText();
            if (user.equals("111") && pass.equals("111"))
            {
                this.setSize(800,600);
                this.setTitle("家具管理系统");
                this.getContentPane().removeAll();
                this.setLayout(null);
                numLa=new JLabel("名称");
                numLa.setSize(60, 30);
                numLa.setLocation(30,30);
                this.add(numLa);
                numTxt=new JTextField();
                numTxt.setSize(150, 30);
                numTxt.setLocation(90,30);
                this.add(numTxt);
                numFBt=new JButton("名称查找");
                numFBt.setSize(90, 30);
                numFBt.setLocation(280,30);
                numFBt.addActionListener(this);
                this.add(numFBt);

                nameLa=new JLabel("风格");
                nameLa.setSize(60, 30);
                nameLa.setLocation(410,30);
                this.add(nameLa);
                nameTxt=new JTextField();
                nameTxt.setSize(150, 30);
                nameTxt.setLocation(470,30);
                this.add(nameTxt);
                nameFBt=new JButton("风格查找");
                nameFBt.setSize(90, 30);
                nameFBt.setLocation(660,30);
                nameFBt.addActionListener(this);
                this.add(nameFBt);

                addBt=new JButton("增加");
                addBt.setSize(60, 30);
                addBt.setLocation(30,90);
                addBt.addActionListener(this);
                this.add(addBt);
                delBt=new JButton("删除");
                delBt.setSize(60, 30);
                delBt.setLocation(120,90);
                delBt.addActionListener(this);
                this.add(delBt);
                upBt=new JButton("修改");
                upBt.setSize(60, 30);
                upBt.setLocation(210,90);
                upBt.addActionListener(this);
                this.add(upBt);

                DAO dao=new DAO();
                ArrayList list=dao.findStuByStyle("");
                initTable(list);
                this.setVisible(true);
            }
        });
    }

    //初始化表格的方法
    public void initTable(ArrayList<Furniture> furs)
    {
        if((furs!=null)||(furs.size()!=0))
        {
            if(panel!=null)
            {
                this.remove(panel);
            }
            String[] columnNames = { "编号", "名称", "价格", "数量", "日期" ,"风格"};
            String[][] values = new String[furs.size()][6];
            for (int i = 0; i < furs.size(); i++) {
                Furniture stu = (Furniture) furs.get(i);
                values[i][0] = String.valueOf(stu.getId());
                values[i][1] = stu.getName();
                values[i][2] = String.valueOf(stu.getPrice());
                values[i][3] = String.valueOf(stu.getNum());
                values[i][4] = stu.getDates();
                values[i][5] = stu.getStyle();
            }
            table = new JTable(values, columnNames);
            panel = new JScrollPane(table);
            panel.setSize(750, 400);
            panel.setLocation(20, 150);
            this.add(panel);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        if(bt.getText().equals("风格查找"))
        {
            DAO dao=new DAO();
            ArrayList list=dao.findStuByStyle(nameTxt.getText().trim());
            initTable(list);
        }
        else
        {
            if(bt.getText().equals("名称查找"))
            {
                DAO dao=new DAO();
                ArrayList list=new ArrayList();
                Furniture stu=dao.findStuBySno(numTxt.getText().trim());
                if(stu!=null)
                {
                    list.add(stu);
                }
                initTable(list);
            }
            else
            {
                if(bt.getText().equals("删除"))
                {
                    if(table.getSelectedRow()==-1)
                    {
                        JOptionPane.showMessageDialog(this, "请选中要删除的家具名称");
                    }
                    else
                    {
                        DAO dao = new DAO();
                        dao.del(table.getValueAt(table.getSelectedRow(),1).toString());
                        ArrayList list = dao.findStuByStyle("");
                        initTable(list);
                    }
                }
                else
                {
                    if(bt.getText().equals("修改"))
                    {
                        if(table.getSelectedRow()==-1)
                        {
                            JOptionPane.showMessageDialog(this, "请选中要修改的家具名称");
                        }
                        else
                        {
                            int row = table.getSelectedRow();
                            String id = table.getValueAt(row, 0).toString();
                            String name = table.getValueAt(row, 1).toString();
                            int  price =  Integer.parseInt(table.getValueAt(row, 2)
                                    .toString());
                            int num = Integer.parseInt(table.getValueAt(row, 3)
                                    .toString());
                            String dates = table.getValueAt(row, 4).toString();
                            String style = table.getValueAt(row, 4).toString();
                            Furniture fur = new Furniture(name,price ,num,dates,style);
                            AddOrUpdateFrame newFrame = new AddOrUpdateFrame(
                                    "修改", fur, this);
                        }
                    }
                    else
                    {
                        AddOrUpdateFrame newFrame=new AddOrUpdateFrame("增加",null,this);
                    }
                }
            }
        }
    }
}
