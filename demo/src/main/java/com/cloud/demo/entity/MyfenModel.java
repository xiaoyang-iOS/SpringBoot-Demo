package com.cloud.demo.entity;
public class MyfenModel{
    private String mykey;
    private String myfen;

    public String getMykey() {
        return mykey;
    }

    public void setMykey(String mykey) {
        this.mykey = mykey;
    }

    public String getMyfen() {
        return myfen;
    }

    public void setMyfen(String myfen) {
        this.myfen = myfen;
    }

    @Override
    public String toString() {
        return "MyfenModel [myfen=" + myfen + ", mykey=" + mykey + "]";
    }
    
}