package com.shua1.webframework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
		String val = "";
		try {
			val = URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Cookie cookie = new Cookie(name, val);
		if ((domain != null) && (!("".equals(domain)))) {
			cookie.setDomain(domain);
		}
		cookie.setPath("/");
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static String removeCookie(HttpServletRequest request, HttpServletResponse response, String name,
			String domain) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie == null) {
			return "fail";
		}
		System.out.println("old coolie {" + cookie.getName() + " ," + cookie.getValue() + "," + cookie.getPath() + ","
				+ cookie.getDomain() + "}");
		Cookie newcookie = new Cookie(name, cookie.getValue());
		if ((domain != null) && (!("".equals(domain)))) {
			newcookie.setDomain(domain);
		}
		newcookie.setPath("/");
		newcookie.setMaxAge(0);
		response.addCookie(newcookie);
		return cookie.getValue();
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			System.out.println("old coolie {" + cookie.getName() + " ," + cookie.getValue() + "," + cookie.getPath()
					+ "," + cookie.getDomain() + "}");
			return cookie;
		}
		return null;
	}

	public static String getCookieValByName(HttpServletRequest request, String name) {
		Map cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			System.out.println("old coolie {" + cookie.getName() + " ," + cookie.getValue() + "," + cookie.getPath()
					+ "," + cookie.getDomain() + "}");
			String val = cookie.getValue();
			try {
				return URLDecoder.decode(val, "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();

				return cookie.getValue();
			}
		}
		return null;
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map cookieMap = new HashMap();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
}
