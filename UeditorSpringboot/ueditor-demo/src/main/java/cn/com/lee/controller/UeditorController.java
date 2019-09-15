package cn.com.lee.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.zip.ZipEntry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.lee.common.ueditor.ActionEnter;

/**
 * 用于处理关于ueditor插件相关的请求
 * @author Guoqing
 * @date 2017-11-29
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorController {

	@RequestMapping(value = "/exec")
	@ResponseBody
	public String exec(HttpServletRequest request) throws UnsupportedEncodingException{ 
		request.setCharacterEncoding("utf-8");
		String rootPath = request.getRealPath("/");
		return new ActionEnter( request, rootPath ).exec();
	}
	@RequestMapping(value = "/url")
	public String getImageUrl(HttpServletRequest request) {
		
//		   String scheme = request.getScheme();//http
//		   String serverName = request.getServerName();//localhost
//		   int serverPort = request.getServerPort();//8080
//		   String contextPath = request.getContextPath();//项目名
//		   String url = scheme+"://"+serverName+":"+serverPort+contextPath;//http://127.0.0.1:8080/test
			

		   return request.getSession().getServletContext().getRealPath("/")+"===="+request.getRealPath(File.separator);
		
	}
	
	
}
