package org.tony.springframework.propertyeditor.builtinpropertyeditor.custom;

/**
 * @Description 描述
 * @Version 1.0
 * @Date 2019/1/25
 * @ProjectName spring-five-study
 * @PackageName org.tony.springframework.propertyeditor.builtinpropertyeditor.custom
 */
public class FullName {

    private String firstName;

    private String lastName;

    public FullName(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String toString(){
        return "First name: " + firstName + " - Last name: " + lastName;
    }
}
