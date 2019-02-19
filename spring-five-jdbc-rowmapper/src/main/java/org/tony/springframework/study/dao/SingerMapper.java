package org.tony.springframework.study.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.entity.Singer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/19
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao
 */
public class SingerMapper implements RowMapper<Singer>{

    @Nullable
    @Override
    public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setBrithDate(rs.getDate("brith_date"));
        singer.setLastName(rs.getString("last_name"));
        return singer;
    }
}
