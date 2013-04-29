package cn.edu.ccdx.student.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download {
	/**
	 * @param response 相应客户端对象
	 * @param fileName 下载文件的名称
	 * @param filePath 下载文件的路径
	 * @param old 
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean download(HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath);//
		System.out.println("--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
			
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
			    response.setHeader("Content-disposition", "attachment;filename="+old);
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}
	public static boolean download1(HttpServletRequest request,HttpServletResponse response,String fileName,String filePath,String old) throws Exception{
		boolean flag = false;
		File file = new File(filePath);//
		System.out.println("--file_path:--"+filePath+"\\"+fileName);
		if(file.exists()){
				String agent=request.getHeader("User-Agent");
				//String type="";
				
			    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			    byte[] buffer = new byte[1];
			    response.reset();
			    response.setCharacterEncoding("UTF-8");
			    response.setContentType("application/x-rar-compressed");
			    if(agent.indexOf("MSIE 7")>0){
			    	old=URLEncoder.encode(old, "UTF-8").replace("+", "%20").length()>100?URLEncoder.encode(old, "UTF-8").replace("+", "%20").substring(0,100)+"."+old.substring(old.lastIndexOf(".")+1):URLEncoder.encode(old, "UTF-8").replace("+", "%20");
				    response.setHeader("Content-disposition", "attachment;filename="+old);}
				else if(agent.indexOf("Firefox")>0){
					response.setHeader("Content-disposition", "attachment;filename*="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}else{
					response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(old, "utf-8").replace("+", "%20"));
				}
			    OutputStream os = response.getOutputStream();
			    while(bis.read(buffer) > 0){
			     os.write(buffer);
			    }
			    bis.close();
			    os.close();
			    flag = true;
		}
		return flag;
	}
	
}
