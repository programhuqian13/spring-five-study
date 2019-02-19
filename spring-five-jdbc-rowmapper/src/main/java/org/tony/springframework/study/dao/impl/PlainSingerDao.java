package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.dao.SingerMapper;
import org.tony.springframework.study.entity.Singer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
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
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null) {
            logger.error("Null NamedParameterJdbcTemplate Problem exception in SingerDao");
            throw new BeanCreationException("Null NamedParameterJdbcTemplate Problem exception in SingerDao");
        }
    }

    @Override
    public List<Singer> findAll() {
//        return namedParameterJdbcTemplate.query("select * from t_singer",
//                new SingerMapper());
        //也可以用如下的方法
        return namedParameterJdbcTemplate.query("select * from t_singer",
                (rs,rowNum) -> {
                    Singer singer = new Singer();
                    singer.setLastName(rs.getString("last_name"));
                    singer.setFirstName(rs.getString("first_name"));
                    singer.setId(rs.getLong("id"));
                    singer.setBrithDate(rs.getDate("brith_date"));
                    return singer;
                });
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("firstName", firstName);
        return namedParameterJdbcTemplate.query(
                "select * from t_singer where first_name like '%' :firstName '%'",
                namedParam, new SingerMapper());
    }

    @Override
    public String findFirstNameById(Long id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(
                "select first_name from t_singer where id= :id",
                namedParam,
                String.class);
    }

    @Override
    public void insert(Singer singer) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", singer.getId());
        namedParam.put("firstName", singer.getFirstName());
        namedParam.put("lastName", singer.getLastName());
        namedParam.put("brithDate", singer.getBrithDate());
        namedParameterJdbcTemplate.update(
                "insert into t_singer (id,first_name,last_name,brith_date) VALUES (:id, :firstName, :lastName, :brithDate)",
                namedParam);
    }

    @Override
    public void delete(Long id) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", id);
        namedParameterJdbcTemplate.update("delete from t_singer where id= :id",
                namedParam);
    }

    @Override
    public void update(Singer singer) {
        Map<String, Object> namedParam = new HashMap<>();
        namedParam.put("id", singer.getId());
        namedParam.put("firstName", singer.getFirstName());
        namedParam.put("lastName", singer.getLastName());
        namedParam.put("brithDate", singer.getBrithDate());
        namedParameterJdbcTemplate.update(
                "update t_singer set first_name= :firstName,last_name= :lastName,brith_date= :brithDate where id= :id",
                namedParam);
    }
}
