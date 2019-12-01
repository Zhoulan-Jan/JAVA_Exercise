import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import jdk.swing.interop.SwingInterOpUtils;

import javax.sql.DataSource;
import java.sql.*;

//使用两种方式连接方式，法二有两种方式完成
public class DBUtil {
        private static final String URL = "jdbc:mysql://localhost:3306/java12";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        //2.1静态代码块
        private static DataSource DATASOURCE = new MysqlDataSource();
        static {
            ((MysqlDataSource)DATASOURCE).setURL(URL);
            ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
            ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
        }

        //2.2单例
        private static DataSource DATASORCE2;

        private DBUtil() {}

        //1.DriverManager
    public static Connection getConnection() {
            Connection connection = null;
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } finally {
                    connection.close();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        //2.DataSource
        public static Connection getConnection2() {
            try {
                return DATASOURCE.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("数据库连接失败");
            }
        }


        //单例方式
        public static DataSource getDataSource() {
            if (DATASORCE2 == null) {
                DATASORCE2 = new MysqlDataSource();
                ((MysqlDataSource)DATASORCE2).setURL(URL);
                ((MysqlDataSource)DATASORCE2).setUser(USERNAME);
                ((MysqlDataSource)DATASORCE2).setPassword(PASSWORD);
            }
            return DATASORCE2;
        }

        //
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("关闭错误");
            }

    }

        public static void main(String[] args) {
            System.out.println(getConnection());
            System.out.println(getConnection2());
            System.out.println(getDataSource());
        }
}
