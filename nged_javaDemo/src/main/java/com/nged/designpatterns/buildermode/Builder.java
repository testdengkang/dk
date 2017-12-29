package com.nged.designpatterns.buildermode;

/**
 * @Author dengkang
 * 接口封装构建最终结果的步骤方法及获取结果的方法
 * 组建一个开发团队 第一步产品 第二步开发管理 第三步其他开发成员
 */
public interface Builder {

      ProjectTeam getProjectTeam();

      void buildTeam(String producer,String developManager,String otherDeveloper);
}
