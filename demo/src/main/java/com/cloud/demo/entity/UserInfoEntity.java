package com.cloud.demo.entity;


public class UserInfoEntity {
    public Long id;
    private String uname;
    private String upassword;
    private Long myfen;
    private String mykey;
    private String create_time;
    private String last_login_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public Long getMyfen() {
        return myfen;
    }

    public void setMyfen(Long myfen) {
        this.myfen = myfen;
    }

    public String getMykey() {
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    @Override
    public String toString() {
        return "UserInfoEntity [create_time=" + create_time + ", id=" + id + ", last_login_time=" + last_login_time
                + ", myfen=" + myfen + ", mykey=" + mykey + ", uname=" + uname + ", upassword=" + upassword + "]";
    }
    
    
    


    

    

    
}