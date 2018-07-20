package com.wsy.mvc.entity

/**
 * Created by IntelliJ IDEA.
 * User: wsy
 * Date: 2018-07-19
 * Time: 15:00
 */
class User {
    Integer id;
    String username
    String password
    Integer age
    String phone
    String gender
    String address
    String email


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
