package cn.com.lee;

import java.io.File;

/**
 @author MT
 @date 2019年9月15日 
*/
public class FileTest {
	public static void main(String[] args) {
		
		try {
			File dir = new File("D:\\Program Files\\apache-tomcat-8.0.50\\webapps\\ueditor-demo\\upload\\images\\20190915");
			
			if(!dir.exists()) {
				
				dir.mkdirs();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
