package com.tony.springframework.study.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/15
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate.entity
 */
@Entity
@Table(name = "Album")
public class Album implements Serializable {

    private Long id;

    private String title;

    private Date releaseDate;

    private int version;

    private Singer singer;

    @ManyToOne  //声明多对一的关系
    @JoinColumn(name = "SINGER_ID")  //定义外键的名称
    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", version=" + version +
                '}';
    }
}
