package org.tony.springframework.study.entity;

import org.joda.time.DateTime;

import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/3/20
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.study.entity
 */
public class Singer {

    private String firstName;

    private String lastName;

    private DateTime birthDate;

    private URL personalSite;

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

    public URL getPersonalSite() {
        return personalSite;
    }

    public void setPersonalSite(URL personalSite) {
        this.personalSite = personalSite;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("{FirstName: %s,LastName: %s,BrithDate: %s,Site: %s}",
                firstName, lastName, simpleDateFormat.format(birthDate.toDate()), personalSite);
    }
}
