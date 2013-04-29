package cn.edu.ccdx.student.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.PropertyResourceBundle;

public class CopyFile {

	/**
	 * @param file1 复制的元样本
	 * @param file2 复制的新文件
	 * @see 将file1复制到指定路径的file2
	 * @return boolean
	 */
	public static boolean copy(String file1,String file2){
		try {
			File file_in = new File(file1);
			File file_out = new File(file2);
			FileInputStream in1 = new FileInputStream(file_in);
			FileOutputStream out1 = new FileOutputStream(file_out);
			byte[] bytes = new byte[1024];
			int c;
			while((c=in1.read(bytes))!=-1){
				out1.write(bytes,0,c);
			}
			in1.close();
			out1.close();
			
		} catch (Exception e) {
			System.out.println("Error!");
			return false;
		}
		return true;
	}
	/*
	public static void main(String[] args){
		CopyFile.copy("D:/aa.jpg","E:/hello_backup.jpg");
	}*/
	
	
	
	/**
	 * getEmailServiceIp
	 * @return EmailServiceIp
	 */
	public static String getMailServiceIp(){
		String mailAddress = "";
		PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("front_upload_folder");
		mailAddress = res.getString("addr");
		return mailAddress;
	}

}
