package com.nged.designpatterns.factorymode;

public class OracleDB implements DataDB {
    @Override
    public String sayName() {
        return "This is oracle";
    }
}
