package com.jis.util;

import java.util.Date;

import javax.servlet.http.HttpSession;

public class Token {
	public static final String TOKEN="token";
	/**
	 * ��������
	 * @param session
	 * @return
	 */
	public static String createToken(HttpSession session){
		String token=new String(new Date().getTime()+"");
		//������д��session
		session.setAttribute(TOKEN, token);
		return token;
	}
}
