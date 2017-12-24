package com.nged.designpatterns.chainmode;

public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if ((leaveRequest.getDays() >= 10) && (leaveRequest.getDays() < 30)) {
            System.out.println(this.name + "�ܾ�������ͨ����");
        } else {
            System.out.println("��ٳ���30�죬�ܾ���������ͨ����");
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
