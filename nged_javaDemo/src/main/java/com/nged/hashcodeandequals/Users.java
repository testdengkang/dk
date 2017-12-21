package com.nged.hashcodeandequals;

public class Users {
    private String uname;

    private int uage;

    public Users(int uage,String uname){
        this.uage = uage;
        this.uname = uname;
    }

    @Override
    public String toString(){
      return this.uname+"--"+this.uage;
    }

    @Override
    public int hashCode(){
        return this.uage+this.uname.hashCode();
    }
    @Override
    public boolean equals(Object object){
        if(this==object){
            return true;
        }
        Users newUser = (Users)object;
        if(this.uname.equals(newUser.uname)&&this.uage==newUser.uage){
            return true;
        }
        return false;
    }



    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }
}
