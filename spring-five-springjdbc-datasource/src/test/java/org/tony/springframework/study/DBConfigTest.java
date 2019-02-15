package org.tony.springframework.study;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tony.springframework.study.annotation.DBConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 测试dataSource
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study
 */
public class DBConfigTest {

    private static Logger logger = LoggerFactory.getLogger(DBConfigTest.class);

    @Test
    public void xmlOneTest() throws SQLException {
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-datasource-context.xml");
        genericXmlApplicationContext.refresh();

        DataSource dataSource = (DataSource) genericXmlApplicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);

        genericXmlApplicationContext.close();
    }

    @Test
    public void xmlTwoTest() throws SQLException {
        GenericXmlApplicationContext genericXmlApplicationContext
                = new GenericXmlApplicationContext();
        genericXmlApplicationContext.load("classpath:spring/app-datasource2-context.xml");
        genericXmlApplicationContext.refresh();

        DataSource dataSource = (DataSource) genericXmlApplicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);

        genericXmlApplicationContext.close();
    }

    @Test
    public void annotationTest() throws SQLException {
        GenericApplicationContext genericApplicationContext
                = new AnnotationConfigApplicationContext(DBConfig.class);
        DataSource dataSource = (DataSource) genericApplicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        testDataSource(dataSource);
        genericApplicationContext.close();
    }

    private void testDataSource(DataSource dataSource) throws SQLException {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int mockVal = resultSet.getInt(1);
                Assert.assertTrue(mockVal == 1);
            }
            statement.close();
        } catch (SQLException e) {
            logger.debug("Something unExpected happened.", e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }


    }

}
