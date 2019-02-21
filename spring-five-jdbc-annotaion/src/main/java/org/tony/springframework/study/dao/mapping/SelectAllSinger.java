package org.tony.springframework.study.dao.mapping;

import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.entity.Singer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.mapping
 */
public class SelectAllSinger extends MappingSqlQuery<Singer>{

    public SelectAllSinger(DataSource dataSource){
        super(dataSource,"select * from t_singer");
    }

    @Nullable
    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setBrithDate(rs.getDate("brith_date"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setLastName(rs.getString("last_name"));
        singer.setId(rs.getLong("id"));
        return singer;
    }
}
