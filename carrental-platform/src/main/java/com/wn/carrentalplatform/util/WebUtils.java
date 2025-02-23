package com.wn.carrentalplatform.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * web的工具类
 * @author LJH
 *
 */
public class WebUtils {

	public static ServletRequestAttributes getServletRequestAttributes() {
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}

	/**
	 * 得到当前线程的请求对象
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttributes.getRequest();
	}

	/**
	 * 得到当前线程的响应对象
	 */
	public static HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse) getServletRequestAttributes().getResponse();
	}

	/**
	 * 得到session对象
	 */
	public static HttpSession getHttpSession() {
		return getHttpServletRequest().getSession();
	}

	/**
	 * 得到servletContext对象
	 */
	public static String getServletContext() {
		return getHttpServletRequest().getServletPath();
	}


}
