import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Add {
    //增加
    public static void  add(int num, String name, String price, String productDate, String style) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                //创建数据库连接
                connection = DB.getConnection();
                String sql = "insert into Furnitures(num, name, price, productDate, style) values (?,?,?,?,?);";
                //操作命令对象执行sql语句，返回结果集resultSet  resultSet类似List<map<String,Object>> String 指表头
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,num);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,price);
                preparedStatement.setString(4,productDate);
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
}
