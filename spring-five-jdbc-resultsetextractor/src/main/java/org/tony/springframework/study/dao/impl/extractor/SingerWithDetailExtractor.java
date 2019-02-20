package org.tony.springframework.study.dao.impl.extractor;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.tony.springframework.study.entity.Album;
import org.tony.springframework.study.entity.Singer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 关联查询映射
 * @Version 1.0
 * @Date 2019/2/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.dao.impl
 */
public class SingerWithDetailExtractor implements ResultSetExtractor<List<Singer>> {

    @Nullable
    @Override
    public List<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Singer> map = new HashMap<>();
        Singer singer;
        while (rs.next()) {
            Long id = rs.getLong("id");
            singer = map.get("id");

            if (singer == null) {
                singer = new Singer();
                singer.setId(id);
                singer.setFirstName(rs.getString("first_name"));
                singer.setLastName(rs.getString("last_name"));
                singer.setBrithDate(rs.getDate("brith_date"));
                singer.setAlbums(new ArrayList<>());
                map.put(id, singer);
            }

            Long albumId = rs.getLong("album_id");
            if (albumId > 0) {
                Album album = new Album();
                album.setId(albumId);
                album.setSingerId(id);
                album.setReleaseDate(rs.getDate("release_date"));
                album.setTitle(rs.getString("title"));
                singer.addAlbum(album);
            }
        }
        return new ArrayList<>(map.values());
    }
}
