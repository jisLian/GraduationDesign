package com.jis.util;

import java.util.Date;

import javax.servlet.http.HttpSession;

public class Token {
	public static final String TOKEN="token";
	/**
	 * 创建令牌
	 * @param session
	 * @return
	 */
	public static String createToken(HttpSession session){
		String token=new String(new Date().getTime()+"");
		//将令牌写入session
		session.setAttribute(TOKEN, token);
		return token;
	}
}
