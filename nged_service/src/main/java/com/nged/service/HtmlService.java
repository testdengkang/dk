package com.nged.service;

import com.nged.entity.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


@Service("htmlService")
public class HtmlService {
	//@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	public void all(String msg) throws IOException, TemplateException {
		Map<String,User> rootMap = new HashMap<String ,User>();
		process("file.ftl",rootMap);
		
	}
	public void process(String templateName,Map map) throws IOException, TemplateException {
		Configuration cf = freeMarkerConfigurer.getConfiguration();
		Template template = cf.getTemplate(templateName);
		File file = new File("d:/file.html");
		User user = new User();
		user.setUserName("hehe");
		user.setAge(30);
		map.put("user", user);
		Writer out = new OutputStreamWriter(
				new FileOutputStream(file),"UTF-8");
		template.process(map, out);
		IOUtils.closeQuietly(out);
		
	}
	
}
