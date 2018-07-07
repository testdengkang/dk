package com.web.controller;

import com.web.common.ReturnMessage;
import com.web.common.StatusCodeUtils;
import com.web.model.TRole;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Object list( @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
                             @RequestParam(required = false, defaultValue = "10", value = "limit") int limit){
        List<TRole> roleList = roleService.queryAllRoles();
        return new ReturnMessage(StatusCodeUtils.STATUS_SUCCESS,roleList);
    }

}
