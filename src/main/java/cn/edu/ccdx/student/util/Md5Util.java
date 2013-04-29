package cn.edu.ccdx.student.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lin
 * 
 */
public class Md5Util {

	public static String getMD5Pwd(String pwd) {
		String ret = null;
		try {
			byte[] b = pwd.getBytes();

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(b);
			ret = toHex(md5.digest());
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		return ret;
	}

	private static String toHex(byte[] digest) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			//Integer.toHexString(): 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
			buf.append(Integer.toHexString((int) digest[i] & 0x00ff));
		}

		return buf.toString();
	}
}
