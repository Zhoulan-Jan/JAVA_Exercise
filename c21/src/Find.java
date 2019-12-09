import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Find {
    //根据家具的名称来得到家具的全部信息
    public static void find(String namex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                //创建数据库连接
                connection = DB.getConnection();
                //根据数据库连接创建命令对象statement
                //preparedStatement = connection.createStatement();
                String sql = "select num, name, price, productDate, style from Furnitures where name = ?;";
                //操作命令对象执行sql语句，返回结果集resultSet 只有一条记录
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,namex);
                resultSet = preparedStatement.executeQuery();
                //assert preparedStatement != null;
                while (resultSet.next()) {
                    int num = resultSet.getInt("num"); //推荐字符串类型
                    String name = resultSet.getString("name");
                    String price = resultSet.getString("price");
                    String productDate = resultSet.getString("productDate");
                    String style = resultSet.getString("style");
                    System.out.printf("id = %s, name = %s, price = %s, productDate = %s, style = %s", num, name, price, productDate, style);
                    System.out.println();
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
