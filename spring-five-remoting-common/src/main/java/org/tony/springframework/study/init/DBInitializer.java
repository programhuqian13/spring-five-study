package org.tony.springframework.study.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tony.springframework.study.dao.SingerDao;
import org.tony.springframework.study.entity.Singer;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/4/12
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.init
 */
@Service
public class DBInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBInitializer.class);

    @Autowired
    private SingerDao singerDao;

    @PostConstruct
    public void initDB() {
        LOGGER.info("Starting datatbase initializer......");
        Singer singer = new Singer();
        singer.setFirstName("tony");
        singer.setLastName("Hu");
        singer.setBirthDate(new Date((new GregorianCalendar(1992, 5, 11)).getTime().getTime()));
        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("aaaas");
        singer.setLastName("Hu");
        singer.setBirthDate(new Date((new GregorianCalendar(1991, 8, 11)).getTime().getTime()));
        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("bbbb");
        singer.setLastName("Xie");
        singer.setBirthDate(new Date((new GregorianCalendar(1986, 9, 12)).getTime().getTime()));
        singerDao.save(singer);

        LOGGER.info("Ending datatbase initializer......");
    }

}
