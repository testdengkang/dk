package com.core.config;

import com.alibaba.druid.util.DruidPasswordCallback;

import com.core.utils.SecurityUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * 数据库密码回调解密
 * 
 * @author cgy
 * @version 2016年5月20日 下午3:18:25
 */
@SuppressWarnings("serial")
public class DBPasswordCallback extends DruidPasswordCallback {
	private static final byte[] key = { 9, -1, 0, 5, 39, 8, 6, 19 };

	public void setProperties(Properties properties) {
		super.setProperties(properties);
		String pwd = properties.getProperty("password");
		if (StringUtils.isNotBlank(pwd)) {
			try {
				String password = SecurityUtil.decryptDes(pwd, key);
				setPassword(password.toCharArray());
			} catch (Exception e) {
				setPassword(pwd.toCharArray());
			}
		} else {
			setPassword("".toCharArray());
		}
	}

	// 请使用该方法加密后，把密文写入classpath:/config/jdbc.properties
	public static void main(String[] args) {
		String encrypt = SecurityUtil.encryptDes("11111", key);
		System.out.println(encrypt);
		System.out.println( SecurityUtil.decryptDes(encrypt, key));
	}
}
