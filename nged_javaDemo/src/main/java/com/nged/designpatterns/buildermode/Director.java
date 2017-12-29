package com.nged.designpatterns.buildermode;

public class Director {
    private Builder builder = new BaseBuilder();

    public ProjectTeam getTeam(String producer,String developManager,String otherDeveloper){
        builder.buildTeam(producer,developManager,otherDeveloper);
        return builder.getProjectTeam();
    }



    public static void main(String[] args){
        Director director = new Director();
        director.getTeam("zhangsan","tom","wangw");
    }


}
