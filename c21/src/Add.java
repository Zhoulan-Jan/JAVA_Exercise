import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add {
    //增加 //如果家具已存在，则需要增加家具的数量，而不是再新增一条记录
    public static void  add(String name, int price, int num, String dates, String style) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //先根据家具的名称搜索数据库 是否已有该家具
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id,num from Furnitures where name = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,name);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    //数据库中有该家具
                    int id = resultSet.getInt("id");
                    int nums = resultSet.getInt("num");
                    int x = nums+num; //nums是数据库已有的家具数量， num是新增的家具数量
                    sonMod(id,x);
                } else {
                    //无该家具
                    sonAdd(name,price,num,dates,style);
                }
            } finally {
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //新增子函数
    public static void sonAdd(String name, int price, int num, String dates, String style) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "insert into Furnitures( name, price, num,dates, style) values (?,?,?,?,?);";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,price);
                preparedStatement.setInt(3,num);
                preparedStatement.setString(4,dates);
                preparedStatement.setString(5,style);

                int rows = preparedStatement.executeUpdate(); //指示受影响的行数
                if (rows > 0) {
                    System.out.println("add success");
                }
            } finally {
                //释放资源 反向释放
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //子函数 修改数量
    public static void sonMod(int id, int num){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "update furnitures set num = ? where id = ?;";
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1,num);
                preparedStatement.setInt(2,id);

                int rows = preparedStatement.executeUpdate(); //指示受影响的行数
                if (rows > 0) {
                    System.out.println("mod num  success");
                }
            } finally {
                //释放资源 反向释放
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
