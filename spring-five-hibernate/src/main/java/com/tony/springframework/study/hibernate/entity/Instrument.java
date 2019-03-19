package com.tony.springframework.study.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/19
 * @ProjectName spring-five-study
 * @PackageName com.tony.springframework.study.hibernate.entity
 */
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

    private String instrumentId;

    @ManyToMany
    @JoinTable(name="singer_instrument",
    joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
    inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }

    private Set<Singer> singers = new HashSet<>();

    @Id
    @Column(name="Instrument_ID")
    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrumentId='" + instrumentId + '\'' +
                '}';
    }
}
