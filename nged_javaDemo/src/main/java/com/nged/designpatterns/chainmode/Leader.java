package com.nged.designpatterns.chainmode;

/**
 * �쵼
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public abstract void handleRequest(LeaveRequest leaveRequest);

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
