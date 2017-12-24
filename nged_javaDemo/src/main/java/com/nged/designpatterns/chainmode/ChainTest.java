package com.nged.designpatterns.chainmode;

public class ChainTest {
    public static void main(String[] args) {
        LeaveRequest   request        = new LeaveRequest("王尼玛", 2, "世界那么大，我想去看看！");
        GeneralManager generalManager = new GeneralManager("大佬");
        Manager        manager        = new Manager("刘铁柱");
        Director       director       = new Director("张全蛋");

        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);
        director.handleRequest(request);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
