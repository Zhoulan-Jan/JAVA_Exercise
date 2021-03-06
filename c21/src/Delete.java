import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Delete {
    //根据家具名称删除家具
    public static void delete(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                //创建数据库连接
                connection = DB.getConnection();
                String sql = "delete from furnitures where name = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,name);
                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("delete success");
                } else {
                    System.out.println("未找到该物品");
                }
                //查询得到数据库所有信息

            } finally {
                //释放资源 反向释放
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
