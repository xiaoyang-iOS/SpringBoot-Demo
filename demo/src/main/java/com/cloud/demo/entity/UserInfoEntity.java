package com.cloud.demo.entity;


public class UserInfoEntity {
    public Long id;
    private String uname;
    private String upassword;
    private Long myfen;
    private String mykey;
    private String createtime;
    private String logintime;
    private String mysign;
    private String photo;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }



    public String getMysign() {
        return mysign;
    }

    public void setMysign(String mysign) {
        this.mysign = mysign;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserInfoEntity [createtime=" + createtime + ", id=" + id + ", logintime=" + logintime + ", myfen="
                + myfen + ", mykey=" + mykey + ", mysign=" + mysign + ", photo=" + photo + ", uname=" + uname
                + ", upassword=" + upassword + "]";
    }

   
    
    
    


    

    

    
}