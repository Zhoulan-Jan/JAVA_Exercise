import java.sql.*;
import java.util.*;

public class DAO {
    private Connection con;
    public DAO()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //加载驱动
            String conStr="jdbc:mysql://localhost:3306/java12?characterEncoding=utf8&amp;useSSL=false; DatabaseName=java12";
            //配置连接字符串
            String user="root";
            //配置用户名
            String password="root";
            //配置用户的访问密码
            con=DriverManager.getConnection(conStr,user,password);
            //创建数据库连接对象
        }
        catch (ClassNotFoundException e) {//捕捉处理驱动类未找到异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //精确查找
    //根据家具的名称来得到家具的全部信息
    public Furniture findStuBySno(String sno)
    {
        Furniture fur=null;
        try{
            PreparedStatement ps=con.prepareStatement("select id, name, price, num, dates,style from Furnitures where name = ?");
            ps.setString(1, sno);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt(1);
                String name=rs.getString(2);
                int price=rs.getInt(3);
                int num=rs.getInt(4);
                String  dates=rs.getString(5);
                String  style=rs.getString(6);
                fur=new Furniture(id,name,price,num,dates,style);
            }
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fur;
    }
    
    //模糊查找
    //根据传入的风格
    public ArrayList<Furniture> findStuByStyle(String sstyle)
    {
        ArrayList<Furniture> result=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            String strSQL="select * from Furnitures where style like '%"+sstyle+"%';";
            ResultSet rs=st.executeQuery(strSQL);
            while(rs.next())
            {
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int price=rs.getInt(3);
                int num=rs.getInt(4);
                String  dates=rs.getString(5);
                String  style=rs.getString(6);
                Furniture fur=new Furniture(id ,name,  price, num,  dates, style);
                result.add(fur);
            }
            st.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public void add(Furniture fur)
    {
        try{
            PreparedStatement ps=con.prepareStatement("insert into Furnitures( name, price, num,dates, style) values (?,?,?,?,?);");
            //创建SQL语句执行对象
            ps.setString(1, fur.getName());
            ps.setInt(2,(fur.getPrice()));
            ps.setInt(3,(fur.getNum()));
            ps.setString(4, fur.getDates());
            ps.setString(5,fur.getStyle());

            ps.execute();
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void del(String sname)
    {
        try{
            PreparedStatement ps=con.prepareStatement("delete from Furnitures where name=?");
            //创建SQL语句执行对象
            ps.setString(1, sname);
            ps.execute();
            ps.close();

            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update(Furniture fur)
    {
        try{
            PreparedStatement ps=con.prepareStatement("update furnitures set price = ?,num =?, style =? where name = ?");
            //创建SQL语句执行对象
            ps.setInt(1,fur.getPrice());
            ps.setInt(2, fur.getNum());
            ps.setString(3,fur.getStyle());
            ps.setString(4, fur.getName());
            ps.execute();
            ps.close();
            //关闭SQL语句执行对象
            //con.close();
            //关闭数据库连接对象
        }
        catch (SQLException e) {//捕捉处理数据连接或者操作异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

