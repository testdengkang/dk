package com.nged.designpatterns.chainmode;

public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if ((leaveRequest.getDays() >= 10) && (leaveRequest.getDays() < 30)) {
            System.out.println(this.name + "总经理审批通过！");
        } else {
            System.out.println("请假超过30天，总经理审批不通过！");
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
