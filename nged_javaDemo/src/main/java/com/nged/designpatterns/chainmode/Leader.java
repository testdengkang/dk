package com.nged.designpatterns.chainmode;

/**
 * ¡Ïµº
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
