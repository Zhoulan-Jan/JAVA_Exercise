import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddOrUpdateFrame extends JFrame implements ActionListener{

    JLabel numLa,nameLa,sexLa,ageLa,deptLa;
    JTextField numTxt,nameTxt,ageTxt,numText,sexTxt;
    JComboBox deptCom;
    JButton bt;
    MainFrame main;//定义主窗口

    public AddOrUpdateFrame(String type,Furniture fur,MainFrame main)
    {
        this.setSize(300,400);
        this.setLayout(null);
        numLa=new JLabel("名称");
        numLa.setSize(60, 30);
        numLa.setLocation(30, 30);
        this.add(numLa);
        numTxt=new JTextField();
        numTxt.setSize(120, 30);
        numTxt.setLocation(100, 30);
        this.add(numTxt);
        nameLa=new JLabel("价格");
        nameLa.setSize(60, 30);
        nameLa.setLocation(30, 80);
        this.add(nameLa);
        nameTxt=new JTextField();
        nameTxt.setSize(120, 30);
        nameTxt.setLocation(100, 80);
        this.add(nameTxt);
        sexLa=new JLabel("数量");
        sexLa.setSize(60, 30);
        sexLa.setLocation(30, 130);
        this.add(sexLa);
        numText=new JTextField();
        numText.setSize(120, 30);
        numText.setLocation(100, 130);
        this.add(numText);
        ageLa=new JLabel("日期");
        ageLa.setSize(60, 30);
        ageLa.setLocation(30, 180);
        this.add(ageLa);
        ageTxt=new JTextField();
        ageTxt.setSize(120, 30);
        ageTxt.setLocation(100, 180);
        this.add(ageTxt);
        deptLa=new JLabel("风格");
        deptLa.setSize(60, 30);
        deptLa.setLocation(30, 230);
        this.add(deptLa);
        deptCom=new JComboBox();
        deptCom.setSize(120, 30);
        deptCom.setLocation(100, 230);
        deptCom.addItem("地中海风格");
        deptCom.addItem("古典风格");
        deptCom.addItem("欧式风格");
        deptCom.addItem("现代前卫风格");
        this.add(deptCom);
        if(type.equals("增加"))
        {
            this.setTitle("增加");
            bt=new JButton("增加");
            bt.setSize(60, 30);
            bt.setLocation(90,280);
        }
        else
        {
            this.setTitle("修改");
            bt=new JButton("修改");
            bt.setSize(60, 30);
            bt.setLocation(90,280);
            if(fur!=null)
            {
                numTxt.setText(fur.getName());
                numTxt.setEditable(false);
                nameTxt.setText(String.valueOf(fur.getPrice()));
                numText.setText(String.valueOf(fur.getNum()));
                ageTxt.setText(fur.getDates());
                deptCom.setSelectedItem(fur.getStyle());
            }
        }
        this.add(bt);
        bt.addActionListener(this);
        this.setVisible(true);
        this.main=main;
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        //Furniture dao=new Furniture();
        DAO dao=new DAO();
        String name=numTxt.getText();
        int price=Integer.parseInt(nameTxt.getText());
        int num=Integer.parseInt(numText.getText());

        String data=ageTxt.getText();
        String style =deptCom.getSelectedItem().toString();

        if(bt.getText().equals("修改"))
        {
            Furniture fur=new Furniture(name,price,num,data,style);
            dao.update(fur);
        }
        else
        {
            Furniture fur=new Furniture(name,price,num,data,style);
            dao.add(fur);
        }
        ArrayList list=dao.findStuByStyle("");
        main.initTable(list);
        this.dispose();
    }
}
