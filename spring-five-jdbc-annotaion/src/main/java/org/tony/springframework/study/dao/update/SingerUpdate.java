package org.tony.springframework.study.dao.update;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.update
 */
public class SingerUpdate extends SqlUpdate {

    public SingerUpdate(DataSource dataSource) {
        super(dataSource, "update t_singer set first_name= :firstName ," +
                "last_name= :lastName , brith_date= :brithDate where id= :id");
        super.declareParameter(new SqlParameter("firstName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("lastName", Types.VARCHAR));
        super.declareParameter(new SqlParameter("brithDate", Types.DATE));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }

}
