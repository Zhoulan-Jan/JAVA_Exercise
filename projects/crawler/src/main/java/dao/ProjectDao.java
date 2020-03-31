package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ProjectDao {
    //把一个 project 对象保存到数据库中
    public void save(Project project) {
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造 preparedStatement 拼接 sql 语句
        PreparedStatement preparedStatement = null;
        String sql = "insert into project_table values(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getUrl());
            preparedStatement.setString(3, project.getDescription());
            preparedStatement.setInt(4, project.getStarCnt());
            preparedStatement.setInt(5, project.getForkCnt());
            preparedStatement.setInt(6, project.getIssuesCnt());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            preparedStatement.setString(7, simpleDateFormat.format(System.currentTimeMillis()));
            //3.执行 SQL 语句，完成数据库插入操作
            int ret = preparedStatement.executeUpdate();
            if (ret != 1) {
                System.out.println("数据库执行插入出错");
            }
            System.out.println("数据插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement, null);
        }
    }
}
