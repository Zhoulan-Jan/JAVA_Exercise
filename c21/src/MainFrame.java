import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends Frame implements ActionListener {
    public JButton find = new JButton("查询");
    public JButton add = new JButton("增加");
    public JButton delete = new JButton("删除");
    public JButton uppdate = new JButton("更新");
    public JTable table;
    public JScrollPane panel;
    //控件放置
    public MainFrame() {
        setTitle("家具管理系统");
        setSize(800,800);
        setLayout(null);

        find.setSize(80,50);
        find.setLocation(60,60);
        find.addActionListener(this);
        this.add(find);

        add.setSize(80,50);
        add.setLocation(160,60);
        add.addActionListener(this);
        this.add(add);

        delete.setSize(80,50);
        delete.setLocation(260,60);
        delete.addActionListener(this);
        this.add(delete);

        uppdate.setSize(80,50);
        uppdate.setLocation(360,60);
        uppdate.addActionListener(this);
        this.add(uppdate);

        //initTable();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    //初始化表格
    public void TableShow() {
        String[][] value = Show.show();
        String[] columnName = {"编号","名称","价格","数量","日期","风格"};
        table = new JTable(value, columnName);
        panel = new JScrollPane(table);
        panel.setSize(600,600);
        panel.setLocation(60,120);
        this.add(panel);
    }

    //
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("增加")) {
            Add.add("梳妆凳",500,50,"18-12-05","欧式风格");
            Add.add("衣柜",600,20,"19-03-05","地中海风格");
            Add.add("茶几",200,5,"18-11-06","现代前卫风格");
            Add.add("儿童床",3000,18,"18-12-11","古典风格");
            Add.add("书桌",550,60,"19-01-05","欧式风格");
            Add.add("床",550,60,"19-01-05","欧式风格");
            TableShow();
        } else if (e.getActionCommand().equals("删除")) {
            Delete.delete("沙发");
            Delete.delete("茶几");
            TableShow();
        } else if (e.getActionCommand().equals("查询")) {
            Find.findByName("床");
            Find.findByName("茶几");
            Find.findById(102);
            Find.findByNum(200);
            Find.findByPrice(5500);
            Find.findByStyle("北欧风格");
        } else if (e.getActionCommand().equals("更新")) {
            Update.update("床",100,50,"2019-03-03","ss风格");
            TableShow();
        }
    }



}
