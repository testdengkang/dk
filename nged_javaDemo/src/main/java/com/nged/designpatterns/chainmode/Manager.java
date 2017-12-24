package com.nged.designpatterns.chainmode;

public class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if ((leaveRequest.getDays() >= 3) && (leaveRequest.getDays() < 10)) {
            System.out.println(this.name + "��������ͨ����");
        } else {
            System.out.println("��ٳ���10�죬��Ҫ�ܾ���������");

            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
