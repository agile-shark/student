package cn.edu.ccdx.student.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.sql.Clob;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	//将数据库中的大字符集转换为字符串
	public static String clobToString(Clob clob) {
		Reader is = null;
		String content = new String();
		try {
			if (clob != null) {
				is = clob.getCharacterStream();
				BufferedReader br = new BufferedReader(is);
				String s = br.readLine();
				while (s != null) {
					content += s;
					content += "\n";
					s = br.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	
	public static char[] clobToChars(Clob clob) {
		CharArrayWriter writer = new CharArrayWriter();
		InputStreamReader is = null;
		try {
			if (clob != null) {
				is = new InputStreamReader(clob.getAsciiStream());
				BufferedReader br = new BufferedReader(is);
				int read = 0;
				char[] c = new char[1024];
				while ((read = br.read(c)) > 0) {
					writer.write(c, 0, read);
				}
				c = null;
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toCharArray();
	}

	public static String blobToString(Blob blob) {
		StringBuilder buf = new StringBuilder();
		InputStreamReader is = null;
		if (blob != null) {
			try {
				is = new InputStreamReader(blob.getBinaryStream());
				BufferedReader br = new BufferedReader(is);
				int read = 0;
				char[] c = new char[1024];
				while ((read = br.read(c)) > 0) {
					buf.append(c, 0, read);
				}
				c = null;
				is.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buf.toString();
	}

	public static byte[] blobToBytes(Blob blob) {
		ByteArrayOutputStream baos = null;
		InputStream is = null;
		if (blob != null) {
			try {
				is = blob.getBinaryStream();
				baos = new ByteArrayOutputStream();
				int read = 0;
				byte[] b = new byte[1024];
				while ((read = is.read(b)) > 0) {
					baos.write(b, 0, read);
				}
				b = null;
				is.close();
				return baos.toByteArray();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Clob oracleStr2Clob(String str, Clob lob) throws Exception {
		Method methodToInvoke = lob.getClass().getMethod(
				"getCharacterOutputStream", (Class[]) null);
		Writer writer = (Writer) methodToInvoke.invoke(lob, (Object[]) null);
		writer.write(str);
		writer.close();
		return lob;
	}

	/**
	 * @param args 传入的字符串
	 * @see 判断给定的字符串是否为空
	 * @return boolean
	 */
	public static boolean validateNull(String args) {
		if (args == null || args.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param source 源字符串
	 * @param target 目标字符串
	 * 当source为空则返回target，否则直接返回target
	 * @return String
	 */
	public static String chanageNull(String source, String target) {
		if (source == null || source.length() == 0
				|| source.equalsIgnoreCase("null")) {
			return target;
		} else {
			return source;
		}
	}

	/**
	 * @param source 传入的元文件
	 * @see 将字符串转换为HTML格式
	 * @return String
	 */
	public static String HTMLChange(String source) {
		String changeStr = "";
		changeStr = source.replaceAll("&", "&amp;");
		changeStr = changeStr.replaceAll(" ", "&nbsp;");
		changeStr = changeStr.replaceAll("<", "&lt;");
		changeStr = changeStr.replaceAll(">", "&gt;");
		changeStr = changeStr.replaceAll("\r\n", "<br/>");
		// changeStr = changeStr.replaceAll("<br>", "");
		return changeStr;
	}

	

	/**
	 * @param _str 原始的字符串
	 * @param len 规定的字符串最大长度
	 * 截取字符串，使之能够适应规定的大小长度
	 * @return String
	 */
	public static String cutEucStr(String _str, int len) {
		String retStr = "";
		_str = _str.trim();
		try {
			if (_str != null && !"".equals(_str)) {
				if (_str.length() > len) {
					String temp = _str.substring(0, len);
					int blank_index = temp.lastIndexOf(" ");
					if (blank_index > 0) {
						retStr = _str.substring(0, blank_index) + "...";
					} else {
						retStr = temp + "...";
					}
				} else {
					retStr = _str;
				}
			}
		} catch (Exception ex) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * @param number 传入的初始值
	 * @see 将小于三位数的数字转换成 007、017等格式
	 * @return String
	 */
	public static String getMaxNumber(String number) {
		if (number.length() == 1)
			number = "00" + number;
		if (number.length() == 2)
			number = "0" + number;
		return number;
	}

	/**
	 * @param m 规定输出 * 的个数
	 * @see 打印*号
	 * @return String
	 */
	public static String printXing(int m) {
		String blank = "*";
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= m; i++) {
			sb.append(blank);
		}
		return sb.toString();
	}

	
	public static String constructSql(String sql, Object[] array) {
		String key = "\\?";
		Pattern p = Pattern.compile(key);
		Matcher m = p.matcher(sql);
		StringBuffer stringBuffer = new StringBuffer();
		int i = 0;
		boolean result = m.find();
		while (result) {
			m.appendReplacement(stringBuffer, array[i].toString());
			result = m.find();
			i++;
		}
		return String.valueOf(m.appendTail(stringBuffer));
	}

	/**
	 * @param str 用户给定的字符串
	 * @see 将给定的字符串转换为HTML形式
	 * @return String
	 */
	public static String toHtml(String str) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\n') {
				strBuffer.append("<br/>");
			} else {
				strBuffer.append(str.charAt(i));
			}
		}
		return strBuffer.toString();
	}

	
	public static String getExtension(String filename) {
		//extension：延长
		String defExt = "";
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	//和那个生成订单号的函数有关，它会调用该函数。该函数作用是：将新的字符串回写到指定的路径的文本中
	private static void writeSmsid(String path, String str) {
		File f = new File(path);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f));
			bw.write(str);
			bw.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (Exception e) {
			}
		}

	}

	/**
	 * @param path 读取指定路径的文件
	 * @return int
	 */
	public static int readSmsid(String path) {
		int id = 0;
		try {
			InputStream is = new FileInputStream(path);
			StringBuffer buffer = new StringBuffer();
			String line;
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				// buffer.append("\\n");
				line = reader.readLine();
			}
			id = Integer.parseInt(buffer.toString());
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * @param path 给定的路径，需要有一个文本文件，里面有一个默认值
	 * @see 取得系统时间，之后在后面加6位数，从文件中读出那个数，如果占两位，则会补充加的那6个0 ，即变为
	 * 		4个0，后面写上读出的数字。运行之后，会将文件中的数加一再回写回去。
	 * @return String
	 */
	public static String getSmsId(String path) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		String id1 = formatter.format(new Date());
		int id2 = readSmsid(path);
		//DecimalFormat 是 NumberFormat 的一个具体子类，用于格式化十进制数字。
		DecimalFormat df = new DecimalFormat("000000");
		String end = df.format(id2);
		int new_id = id2 + 1;
		//String.valueOf():表示将不是字符串的转换为字符串
		writeSmsid(path, String.valueOf(new_id));
		return id1 + end;
	}
	
}
