import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Find {
    //无法使用函数重载，因为参数类型和参数个数都一样

    //根据家具的编号
    public static void findById(int idx) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id, name, price, num, dates,style from Furnitures where id = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,idx);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    {   //找到的情况
                        do {
                            int id = resultSet.getInt("id"); //推荐字符串类型
                            String name = resultSet.getString("name");
                            int price = resultSet.getInt("price");
                            int num = resultSet.getInt("num");
                            String dates = resultSet.getString("dates");
                            String style = resultSet.getString("style");
                            System.out.printf("id = %d, name = %s, price = %d, num = %d, dates = %s, style = %s",
                                    id,name,price,num,dates,style);
                            System.out.println();
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
    }

    //根据家具的名称来得到家具的全部信息
    public static void findByName(String namex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id, name, price, num, dates,style from Furnitures where name = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,namex);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                     {   //找到的情况
                        do {
                            int id = resultSet.getInt("id"); //推荐字符串类型
                            String name = resultSet.getString("name");
                            int price = resultSet.getInt("price");
                            int num = resultSet.getInt("num");
                            String dates = resultSet.getString("dates");
                            String style = resultSet.getString("style");
                            System.out.printf("id = %d, name = %s, price = %d, num = %d, dates = %s, style = %s",
                                    id,name,price,num,dates,style);
                            System.out.println();
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
    }

    //根据家具的价格
    public static void findByPrice(int pricex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id, name, price, num, dates,style from Furnitures where price = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,pricex);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    {   //找到的情况
                        do {
                            int id = resultSet.getInt("id"); //推荐字符串类型
                            String name = resultSet.getString("name");
                            int price = resultSet.getInt("price");
                            int num = resultSet.getInt("num");
                            String dates = resultSet.getString("dates");
                            String style = resultSet.getString("style");
                            System.out.printf("id = %d, name = %s, price = %d, num = %d, dates = %s, style = %s",
                                    id,name,price,num,dates,style);
                            System.out.println();
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
    }


    //根据家具的风格
    public static void findByStyle(String stylex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id, name, price, num, dates,style from Furnitures where style = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,stylex);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    {   //找到的情况
                        do {
                            int id = resultSet.getInt("id"); //推荐字符串类型
                            String name = resultSet.getString("name");
                            int price = resultSet.getInt("price");
                            int num = resultSet.getInt("num");
                            String dates = resultSet.getString("dates");
                            String style = resultSet.getString("style");
                            System.out.printf("id = %d, name = %s, price = %d, num = %d, dates = %s, style = %s",
                                    id,name,price,num,dates,style);
                            System.out.println();
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
    }

    //根据家具的数量
    public static void findByNum(int numx) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            try{
                connection = DB.getConnection();
                String sql = "select id, name, price, num, dates,style from Furnitures where num = ?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,numx);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    {   //找到的情况
                        do {
                            int id = resultSet.getInt("id"); //推荐字符串类型
                            String name = resultSet.getString("name");
                            int price = resultSet.getInt("price");
                            int num = resultSet.getInt("num");
                            String dates = resultSet.getString("dates");
                            String style = resultSet.getString("style");
                            System.out.printf("id = %d, name = %s, price = %d, num = %d, dates = %s, style = %s",
                                    id,name,price,num,dates,style);
                            System.out.println();
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
    }

}
