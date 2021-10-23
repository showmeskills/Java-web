package com.example.javawebday13.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private Date dob;

    public User() {
    }

    public User(String name, int age, Date dob) {
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    public String getBirStr(){
        if(this.dob != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return sdf.format(this.dob);
        }else{
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(dob, user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dob);
    }
}
