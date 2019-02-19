package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.util.List;

/**
 * @Description Singer操作实现类
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
public class PlainSingerDao implements SingerDao, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        return jdbcTemplate.query("select * from t_singer",
                new BeanPropertyRowMapper<>(Singer.class));
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return jdbcTemplate.query(
                "select * from t_singer where first_name LIKE '" + firstName + "'",
                new BeanPropertyRowMapper<>(Singer.class));
    }

    @Override
    public String findLastNameById(Long id) {
        return jdbcTemplate.queryForObject("select last_name from t_singer where id=?",new Object[]{id},String.class);
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        jdbcTemplate.update("insert into t_singer (id,first_name,last_name,brith_date) VALUES (?,?,?,?)",
                new Object[]{singer.getId(),singer.getFirstName(),singer.getLastName(),singer.getBrithDate()});
    }

    @Override
    public void update(Singer singer) {
        jdbcTemplate.update("update t_singer set first_name = ?,last_name=?,brith_date=? where id=?",
                new Object[]{singer.getFirstName(),singer.getLastName(),singer.getBrithDate(),singer.getId()});
    }

    @Override
    public void delete(Long singerId) {
        jdbcTemplate.update("delete from t_singer where id=?",new Object[]{singerId});
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            logger.error("Null jdbcTemplate in singerDao!");
            throw new BeanCreationException("Null jdbcTemplate in singerDao!");
        }
    }
}
