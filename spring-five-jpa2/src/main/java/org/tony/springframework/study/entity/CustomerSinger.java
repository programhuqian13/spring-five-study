package org.tony.springframework.study.entity;

import java.io.Serializable;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.entity
 */
public class CustomerSinger implements Serializable {

    private String firstName;

    private String lastName;

    private String lastestAlbum;

    public CustomerSinger(String firstName, String lastName, String lastestAlbum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastestAlbum = lastestAlbum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastestAlbum() {
        return lastestAlbum;
    }

    public void setLastestAlbum(String lastestAlbum) {
        this.lastestAlbum = lastestAlbum;
    }

    @Override
    public String toString() {
        return "CustomerSinger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastestAlbum='" + lastestAlbum + '\'' +
                '}';
    }
}
