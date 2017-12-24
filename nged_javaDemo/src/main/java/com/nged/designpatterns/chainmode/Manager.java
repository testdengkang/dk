package com.nged.designpatterns.chainmode;

public class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if ((leaveRequest.getDays() >= 3) && (leaveRequest.getDays() < 10)) {
            System.out.println(this.name + "经理审批通过！");
        } else {
            System.out.println("请假超过10天，需要总经理审批！");

            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
