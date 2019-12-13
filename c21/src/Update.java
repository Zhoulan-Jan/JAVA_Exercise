import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Update {
    //根据家具名称修改 价格 日期 风格
    public static void update(String namex, int pricex, int numx, String datesx, String stylex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                //创建数据库连接
                connection = DB.getConnection();
                String sql = "update furnitures set price = ?,num = ? ,dates = ?, style = ? where name = ?";
                //操作命令对象执行sql语句，返回结果集resultSet  resultSet类似List<map<String,Object>> String 指表头
                preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setInt(1,pricex);
                preparedStatement.setInt(2,numx);
                preparedStatement.setString(3,datesx);
                preparedStatement.setString(4,stylex);
                preparedStatement.setString(5,namex);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("modify success");
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
