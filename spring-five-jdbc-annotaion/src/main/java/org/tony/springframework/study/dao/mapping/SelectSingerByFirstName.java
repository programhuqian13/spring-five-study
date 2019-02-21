package org.tony.springframework.study.dao.mapping;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.entity.Singer;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.mapping
 */
public class SelectSingerByFirstName extends MappingSqlQuery<Singer> {

    public SelectSingerByFirstName(DataSource dataSource){
        super(dataSource,"select * from t_singer where first_name like '%' :firstName '%'");
        //使用declareParameter设置sql查询的参数
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
    }

    @Nullable
    @Override
    protected Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Singer singer = new Singer();
        singer.setId(rs.getLong("id"));
        singer.setLastName(rs.getString("last_name"));
        singer.setFirstName(rs.getString("first_name"));
        singer.setBrithDate(rs.getDate("brith_date"));
        return singer;
    }
}
