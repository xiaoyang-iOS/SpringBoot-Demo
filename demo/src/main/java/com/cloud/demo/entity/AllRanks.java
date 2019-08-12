package com.cloud.demo.entity;

public class AllRanks{
    private String uname;
    private Long myfen;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getMyfen() {
        return myfen;
    }

    public void setMyfen(Long myfen) {
        this.myfen = myfen;
    }

    @Override
    public String toString() {
        return "AllRanks [myfen=" + myfen + ", uname=" + uname + "]";
    }
    
}