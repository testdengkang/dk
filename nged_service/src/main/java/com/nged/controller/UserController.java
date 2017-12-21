package com.nged.controller;

import com.nged.entity.User;
import com.nged.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Api("用户接口")
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
//	@Autowired
//	private HtmlService htmlService;
	@ApiOperation(value="showUser",notes = "用户列表")
	@PostMapping("/showUser")
    @ResponseBody
	public ModelAndView toIndex(@ApiParam(name="id",value = "int") int id){
		ModelAndView m = new ModelAndView();
		User user = this.userService.getUserById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", user.getUserName());
		map.put("age", user.getAge());
		m.addObject("user", map);
//		m.setViewName("file");
		m.setViewName("showUser");
//		return "file";
		return m;
	}
//	@RequestMapping("/create")
//	@ResponseBody
//	public ReturnBase all(HttpServletRequest request,HttpServletResponse response){
//		ReturnBase returnStatus = new ReturnBase();
//		String msg = request.getParameter("msg");
//		 System.out.println("*********msg***" + msg);  
//	        try {  
//	            this.htmlService.all(msg);  
//	            returnStatus.setSuccess(true);  
//	            returnStatus.setMsg("成功!");  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	            returnStatus.setSuccess(false);  
//	            returnStatus.setMsg(e.getMessage());  
//	        }  
//	        return returnStatus; 
//	}
}
