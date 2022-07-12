package com.yitsd.pojo;

/**
 * @ClassName User
 * @Date 2022/7/11 21:34
 */
public class User {

    private String uname;
    private String pwd;

    public User() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
