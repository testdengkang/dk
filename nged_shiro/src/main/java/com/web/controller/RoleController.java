package com.web.controller;

import com.web.common.ReturnMessage;
import com.web.common.StatusCodeUtils;
import com.web.model.TRole;
import com.web.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryAll")
    @ResponseBody
    @RequiresRoles("admin")
    public Object list( @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
                             @RequestParam(required = false, defaultValue = "10", value = "limit") int limit){
        List<TRole> roleList = roleService.queryAllRoles();
        //return new ReturnMessage(StatusCodeUtils.STATUS_SUCCESS,roleList);
        if(roleList==null&&roleList.size()<=0){
            return null;
        }
        Map data = new HashMap<String,List>();
       /* List<String[]> list = new ArrayList<>();
        for(int i=0;i<roleList.size();i++){
             list.add(roleList.get(i).toArray());
        }
        data.put("data",list);*/

        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String updateTime =  dtf.format(new Date());
       data.put("updateTime",updateTime);
       data.put("data",roleList);
        return data;
    }

}
