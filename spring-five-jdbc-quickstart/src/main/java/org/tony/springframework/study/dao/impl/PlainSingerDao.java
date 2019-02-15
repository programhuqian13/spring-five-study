package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description Singer操作实现类
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
public class PlainSingerDao implements SingerDao {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    /***
     * 加载数据库驱动器
     */
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Problem loading DB Driver!", e);
        }
    }

    /***
     * 创建数据库连接
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql:///spring-five-study?useSSL=true&serverTimezone=UTC",
                "root", "huqian");
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     */
    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Problem closing connection to the database!", e);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select * from t_singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBrithDate(resultSet.getDate("brith_date"));
                result.add(singer);
            }
        } catch (SQLException e) {
            logger.error("Problem when executing select", e);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        Connection connection = null;
        List<Singer> singers = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from t_singer where first_name like ?");
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setBrithDate(resultSet.getDate("brith_date"));
                singers.add(singer);
            }
        } catch (SQLException e) {
            logger.error("Problem when executing findByFirstName!",e);
        } finally {
            closeConnection(connection);
        }
        return singers;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        Connection connection = null;
        String firstName = "";
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select first_name from t_singer where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                firstName = resultSet.getString("first_name");
            }
            statement.close();
        } catch (SQLException e) {
            logger.error("Problem when executing findLastNameById!", e);
        } finally {
            closeConnection(connection);
        }
        return firstName;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            //添加返回主键
//            PreparedStatement statement = connection.prepareStatement(
//                    "insert into t_singer(id,first_name,last_name,brith_date) " +
//                            "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement = connection.prepareStatement(
                    "insert into t_singer(id,first_name,last_name,brith_date) " +
                            "VALUES (?,?,?,?)");
            statement.setLong(1, singer.getId());
            statement.setString(2, singer.getFirstName());
            statement.setString(3, singer.getLastName());
            statement.setDate(4, singer.getBrithDate());
            statement.execute();  //执行sql语句
//            ResultSet generatedKey = statement.getGeneratedKeys();
//            while (generatedKey.next()) {
//                System.out.println("当前添加的id：" + generatedKey.getLong(1));
//            }
            statement.close();  //关闭操作语句
        } catch (SQLException e) {
            logger.error("Problem when executing insert", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update t_singer set first_name=?,last_name=? where id=?");
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setLong(3, singer.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete FROM t_singer where id=?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            logger.error("Problem when executing delete!", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
