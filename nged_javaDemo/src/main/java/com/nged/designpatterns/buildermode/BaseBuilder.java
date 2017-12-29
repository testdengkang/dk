package com.nged.designpatterns.buildermode;

public class BaseBuilder implements Builder {
    private ProjectTeam projectTeam = new ProjectTeam();

    @Override
    public ProjectTeam getProjectTeam() {
        return this.projectTeam;
    }

    @Override
    public void buildTeam(String producer, String developManager, String otherDeveloper) {
        projectTeam.setProducter(producer);
        projectTeam.setDevloperManager(developManager);
        projectTeam.setDveloperA(otherDeveloper);
    }


}
