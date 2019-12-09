import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
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

                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("success");
                }
            } finally {
                //释放资源 反向释放
                DB.close(connection,preparedStatement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询
    public static void find() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            try{
                //创建数据库连接
                connection = DB.getConnection();
                //根据数据库连接创建命令对象statement
                statement = connection.createStatement();
                String sql = "select num, name, price, productDate, style from Furnitures;";
                //String sql = "insert into Furnitures (num, name, price, productDate, style) values (3,'锅','15','18-25','古典风格')";
                //操作命令对象执行sql语句，返回结果集resultSet  resultSet类似List<map<String,Object>> String 指表头
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int num = resultSet.getInt("num"); //推荐字符串类型
                    String name = resultSet.getString("name");
                    String price = resultSet.getString("price");
                    String productDate = resultSet.getString("productDate");
                    String style = resultSet.getString("style");
                    System.out.printf("id = %s, name = %s, price = %s ", num, name, price);
                    System.out.println();
                }
            } finally {
                //释放资源 反向释放
                DB.close(connection,statement,resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        add(1,"衣柜","800","18-02-11","地中海风格");
        add(2,"沙发","8800","18-02-12","现代简约风格");
        add(3,"桌子","300","18-02-14","现代前卫风格");
        add(4,"床","9900","18-02-16","古典风格");
        add(5,"茶几","600","18-02-17","地中海风格");
        add(6,"台灯","100","18-02-18","古典风格");
        find();
    }
}
