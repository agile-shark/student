package cn.edu.ccdx.student.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.edu.ccdx.student.model.Student;
import cn.edu.ccdx.student.service.StudentService;
import cn.edu.ccdx.student.util.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class StudentAction extends ActionSupport{

	private static final long serialVersionUID = 161441855327519610L;
	private final static Logger LOG = Logger.getLogger(StudentAction.class);
	
	//用于分页的封装类
	Pager pager = new Pager();
	
	//用于处理学生的业务逻辑
	StudentService studentService;
	
	//用于从前台和后台之间参数的传递
	Student student;
	
	//用于在全部删除的情况下
	int[] ids;
	
	
	/**
	 * @see 处理学生登录请求
	 * @return String
	 * @throws IOException 
	 */
	public String login() throws IOException {
		
		LOG.info("进入了StudentAction的login处理函数了！");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		//标准写法，学会（以后就这样写）
		if (null != id && null != pwd && !"".equals(id) && !"".equals(pwd)) {
			
			Student member = studentService.login(id, pwd);
			LOG.info("进入了StudentAction的login处理函数的if判断语句了！");
			if (null != member) {
				String studentName = member.getStudent_name();
				Map session = ActionContext.getContext().getSession();
				//放入到session中，到jsp中就可以直接从valueStack中进行取值
				session.put("student_name", studentName);
				session.put("member", member);
				
				return "toList";
			} else {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("<script type='text/javascript'>");
				response.getWriter().write("alert('账号或密码错误.');");
				response.getWriter().write("window.location.href='/index.jsp'");
				response.getWriter().write("</script>");
				response.getWriter().close();
				return "login";
			}
		}
		return "login";
	}
		
	
	/**
	 * @see 用于将学生信息显示
	 * @return String
	 */
	public String list(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//利用封装好的类将列表信息查询出来放好供使用
		request.setAttribute("list",studentService.list(pager));
		return "list";
	}
	
	/**
	 * @see 用于对学生信息的添加
	 * @return String
	 */
	public String add(){
		studentService.add(student);
		return "add";
	}
	
	/**
	 * 用于学生信息更新跳转到更新页面时传入的参数
	 * @return String
	 */
	public String toUpdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//Student stu=studentService.get(Integer.parseInt(request.getParameter("id")));
		//request.setAttribute("student", stu);	
		//利用域模型对象，进行接收和传递参数
		student=studentService.get(Integer.parseInt(request.getParameter("id")));
		return "toUpdate";
	}
	
	/**
	 * @see 用于对学生信息的更新
	 * @return String
	 */
	public String update(){
		studentService.update(student);
		
		return "update";
	}
	
	/**
	 * 用于对学生信息的删除
	 * @return String
	 */
	public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		studentService.delete(Integer.parseInt(request.getParameter("id")));
		return "update";
	}
	
	/**
	 * 用于对学生信息的全部删除
	 * @return String
	 */
	public String deleteAll(){
		//注意此处的ids与前台的name值一一对应，这就体现了struts2的优点，可以直接将值拿过来使用。
		for(int d :ids){
			studentService.delete(d);
		}
		
		return "update";
	}
	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
