package cn.edu.ccdx.student.service.impl;


import cn.edu.ccdx.student.dao.CommonDAO;

public class CommonServiceImpl {

	  CommonDAO commonDao;
	  
	
	public void setCommonDao(CommonDAO commonDao) {
		this.commonDao = commonDao;
	}

	public static boolean isNotNullOrEmpty(String s){
		if (null==s){
			return false;
		}
		if (s.trim().equals("")){
			return false;
		}
		return true;
	} 
	
	public static int parseInt(String s){
		int i = -1;
		try{
			i = Integer.parseInt(s);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return i;
	}
}
