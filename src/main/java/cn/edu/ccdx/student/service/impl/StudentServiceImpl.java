package cn.edu.ccdx.student.service.impl;

import java.util.List;

import cn.edu.ccdx.student.model.Student;
import cn.edu.ccdx.student.service.StudentService;
import cn.edu.ccdx.student.util.Pager;
public class StudentServiceImpl extends CommonServiceImpl implements StudentService {

	@SuppressWarnings("unchecked")
	public List<Student> list(Pager pager) {
		List<Student> list=(List<Student>)this.commonDao.pageMySql("select * from student order by student_id desc", pager, Student.class);
		return list;
	}

	public Integer add(Student student) {
		Integer i=(Integer)this.commonDao.save(student);
		return i;
	}

	public void delete(int id) {
		this.commonDao.delete(Student.class, id);
		
	}

	public void update(Student student) {
		this.commonDao.update(student);
	}

	public Student get(int id) {
		
		return (Student)this.commonDao.get(Student.class, id);
	}

	public Student login(String id, String pwd) {
		
		String sql="select * from student where student_name='"+id+"' and student_pwd='"+pwd+"'";
		Student result = null;
		try{
			result=(Student)this.commonDao.get(sql, Student.class);
		}catch(Exception e){}
		return result;
	}

}
