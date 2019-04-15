package com.hefa.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;


public class BadSqlInterceptor extends HandlerInterceptorAdapter {
	

	/***sql关键字***/
	private static final String[] SQL_KEY_WORD = { "and","exec","execute","insert","select","delete","update",
	"count","chr","mid","master","truncate"	,"char","declare","or","like","drop","alter"};
	/****拦截器，防止sql注入*****/
	/***特殊字符拦截***/
	//private static final String[] SPECIAL_SYMBOL = { "'", "*" , ";" , "--" , "<" , "/>"};
	/****拦截器，防止sql注入*****/
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String url = request.getRequestURL().toString();
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String param = request.getParameter(name);
			if( contains(SQL_KEY_WORD, param) ){
				JSONObject obj = new  JSONObject();
				obj.put("msg", "非法链接");
				obj.put("code", "9999");
				response.setHeader("Content-type", "text/html;charset=UTF-8"); 
				response.getWriter().write(obj.toString());
				return false;
			}
			/*if( exists(SPECIAL_SYMBOL, param) ){
				
				JSONObject obj = new  JSONObject();
				obj.put("msg", "非法链接");
				obj.put("code", "9999");
				response.setHeader("Content-type", "text/html;charset=UTF-8"); 
				response.getWriter().write(obj.toString());
				return false;
			}*/
			
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	private static boolean contains(String[] strs,String str){
		for(String s : strs){
			if(str.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean exists(String[] strs,String str){
		for(String s : strs){
			if(str.contains(s)){
				return true ;
			}
		}
		return false;
	}
}
