package cn.com.lee.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 @author MT
 @date 2019年9月15日 
*/
@Component
public class FileUploadService {
	
	private static String pathRoot ="/upload/images/";
	/**
	 * 文件上传
	 * @param request
	 * @param dataBuf
	 * @param picName
	 * @return  返回文件的全路径
	 */
	public static String upload(HttpServletRequest request, byte[] dataBuf, String path1, String picName) {
		String url = "";
		String path = request.getSession().getServletContext().getRealPath(path1);
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        //先判断文件是否存在
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 生成日期二级目录
        String childFileDirName = sdf.format(new Date());
        try {
        	
            File dir = new File(path);
            if (!dir.exists()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(dir,picName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(dataBuf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        url = getFileUrl(request)+pathRoot+"/"+picName;
		return url;
	}

	private static String getFileUrl(HttpServletRequest request) {
		// http协议
		String scheme = request.getScheme();// http
		// 服务器域名
		String serverName = request.getServerName();// localhost
		// 服务器端口
		int serverPort = request.getServerPort();// 
		// 项目名
		String contextPath = request.getContextPath();
		String url = scheme + "://" + serverName + ":" + serverPort + contextPath;
		return url;
	}

}
