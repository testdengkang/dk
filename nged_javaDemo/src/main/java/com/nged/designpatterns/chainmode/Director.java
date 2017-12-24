package com.nged.designpatterns.chainmode;

/**
 * 主任审批
 */
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
            if(leaveRequest.getDays()<3){
                System.out.println(this.name+"主任审批通过！");
            }else{
                System.out.println("请假超过3天,需要上一级审批！");
                if(this.nextLeader!=null){
                   this.nextLeader.handleRequest(leaveRequest);
                }

            }
    }
}
