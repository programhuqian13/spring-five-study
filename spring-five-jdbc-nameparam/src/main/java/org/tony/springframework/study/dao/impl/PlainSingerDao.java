package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Singer操作实现类
 * @Version 1.0
 * @Date 2019/2/15
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
public class PlainSingerDao implements SingerDao, InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Singer> findAll() {
        return namedParameterJdbcTemplate.query("select * from t_singer",
                new BeanPropertyRowMapper<>(Singer.class));
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        logger.info("param firstName: {}", firstName);
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("firstName", firstName);
        //'%' :firstName '%' 之间一定要有空格
        return namedParameterJdbcTemplate.query(
                "select * from t_singer where first_name LIKE '%' :firstName '%'", namedParam,
                new BeanPropertyRowMapper<>(Singer.class));
    }

    @Override
    public String findLastNameById(Long id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        return namedParameterJdbcTemplate.queryForObject("select last_name from t_singer where id= :id", namedParam, String.class);
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", singer.getId());
        namedParam.put("firstName", singer.getFirstName());
        namedParam.put("lastName", singer.getLastName());
        namedParam.put("brithDate", singer.getBrithDate());
        namedParameterJdbcTemplate.update("insert into t_singer (id,first_name,last_name,brith_date) VALUES (:id,:firstName,:lastName,:brithDate)",
                namedParam);
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", singer.getId());
        namedParam.put("firstName", singer.getFirstName());
        namedParam.put("lastName", singer.getLastName());
        namedParam.put("brithDate", singer.getBrithDate());
        namedParameterJdbcTemplate.update("update t_singer set first_name = :firstName,last_name= :lastName,brith_date= :brithDate where id= :id",
                namedParam);
    }

    @Override
    public void delete(Long singerId) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", singerId);
        namedParameterJdbcTemplate.update("delete from t_singer where id= :id", namedParam);
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
        if (namedParameterJdbcTemplate == null) {
            logger.error("Null namedParameterJdbcTemplate in singerDao!");
            throw new BeanCreationException("Null namedParameterJdbcTemplate in singerDao!");
        }
    }
}
