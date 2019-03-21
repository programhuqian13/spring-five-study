package org.tony.springframework.study.validator.customervalidate;

import org.joda.time.DateTime;
import org.tony.springframework.study.validator.Gender;
import org.tony.springframework.study.validator.Genre;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.tony.springframework.study.validator.customervalidate.CheckSingerCountry;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/21
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.validator
 */
@CheckSingerCountry
public class Singer {

    @NotNull  //不能为空
    @Size(min = 2, max = 60) //设置字符串长度
    private String firstName;

    private String lastName;

    private DateTime birthDate;

    public boolean isCountrySinger() {
        return genre == Genre.COUNTRY;
    }

    @NotNull
    private Genre genre;

    private Gender gender;

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

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
