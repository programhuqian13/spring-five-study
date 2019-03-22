package org.tony.springframework.study.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 实体数据库中表的映射实体类
 * @Version 1.0
 * @Date 2019/3/14
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate.entity
 */
@Entity
@Table(name = "singer")
public class Singer implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private int version;

    private Set<Album> albums = new HashSet<>();

    @ManyToMany  //声明一个多对多的关系
    @JoinTable(name = "singer_instrument",joinColumns = @JoinColumn(name = "SINGER_ID"),
    inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    private Set<Instrument> instruments = new HashSet<>();

    //进行一对多的关联
    //mappedBy:mappedBy属性指示提供关联的Album类中的属性(即，由FK Album SINGER表中的外键定义链接)。
    //cascade:cascade属性表示更新操作应该级联到子操作
    //orphanRemoval:orphanRemoval属性意味着更新albums之后，应该从数据库中删除集合中不再存在的条目
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
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

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", version=" + version +
                '}';
    }
}
