package cn.edu.ccdx.student.service;

import java.util.List;

import cn.edu.ccdx.student.model.Student;
import cn.edu.ccdx.student.util.Pager;

public interface StudentService {
	
	public Student login(String id, String pwd);
	public List<Student> list(Pager pager);
	public Integer add(Student student);
	public void update(Student student);
	public void delete(int id);
	public Student get(int id);
	
}
