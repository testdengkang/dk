package com.nged.enumdemo;

public enum ColorEnum {
    RED("红色","redColor"),
    BLACK("黑色","blackColor"),
    dd("222","noColor");

    private String colorName;
    private String des;
    private ColorEnum(String colorName,String des){
        this.colorName = colorName;
        this.des = des;
    }

    public String getColorName() {
        return colorName;
    }


    public String getDes() {
        return des;
    }


    /* @Override
        public String toString(){
            return this.colorName;
        }*/
    public static void main(String[] args){
        for(ColorEnum value:ColorEnum.values()){
            System.out.println(value.colorName+":"+value.des);
        }
    }
}

