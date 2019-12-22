import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Show {
    //根据数据库内容显示在表格上
    public static String[][] show() {
        String[][] value  = new String[60][6];
        int i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select * from Furnitures;";
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    {   //找到的情况
                        do {
                            //放在字符串数组里
                            value[i][0] = String.valueOf(resultSet.getInt("id"));
                            value[i][1] =resultSet.getString("name");
                            value[i][2] = String.valueOf(resultSet.getInt("price"));
                            value[i][3] = String.valueOf(resultSet.getInt("num"));
                            value[i][4] = resultSet.getString("dates");
                            value[i][5] = resultSet.getString("style");
                            i++;
                        } while (resultSet.next());
                    }
                } else {
                    System.out.println("查找失败");
                }
            } finally {
                //释放资源 反向释放
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
