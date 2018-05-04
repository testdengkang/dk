package com.nged.designpatterns.factorymode;

public class MysqlDB implements DataDB {
    @Override
    public String sayName() {
        return "This is mysql";
    }
}
