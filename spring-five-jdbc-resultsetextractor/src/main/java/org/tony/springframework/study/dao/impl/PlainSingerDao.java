package org.tony.springframework.study.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.dao.impl.extractor.SingerWithDetailExtractor;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
public class PlainSingerDao implements SingerDao, InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        String sql = "select s.id,s.first_name,s.last_name,s.brith_date" +
                ",a.id as album_id,a.title,a.release_date from t_singer s" +
                " left join t_album a on s.id = a.singer_id";
        return namedParameterJdbcTemplate.query(sql, new SingerWithDetailExtractor());
    }

    @Override
    public List<Singer> findAll() {
        return namedParameterJdbcTemplate.query("select * from t_singer", new RowMapper<Singer>() {
            @Nullable
            @Override
            public Singer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Singer singer = new Singer();
                singer.setId(rs.getLong("id"));
                singer.setLastName(rs.getString("last_name"));
                singer.setFirstName(rs.getString("first_name"));
                singer.setBrithDate(rs.getDate("brith_date"));
                return singer;
            }
        });
    }

    @Override
    public List<Album> findAllAlbum() {
        return namedParameterJdbcTemplate.query("select * from t_album", new RowMapper<Album>() {
            @Nullable
            @Override
            public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
                Album album = new Album();
                album.setId(rs.getLong("id"));
                album.setTitle(rs.getString("title"));
                album.setSingerId(rs.getLong("singer_id"));
                album.setReleaseDate(rs.getDate("release_date"));
                return album;
            }
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null) {
            logger.error("Problem is null namedParameterJdbcTemplate in SingerDao");
            throw new BeanCreationException("Problem is null namedParameterJdbcTemplate in SingerDao");
        }
    }
}
