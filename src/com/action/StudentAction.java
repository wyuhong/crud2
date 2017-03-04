package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import com.biz.IStudentBiz;
import com.biz.impl.StudentBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vo.Classes;
import com.vo.Student;

@Namespace(value="/")
@ParentPackage(value="struts-default")
public class StudentAction extends ActionSupport {
	
	private IStudentBiz sbiz = new StudentBizImpl();
	private Student stu;
	private Classes classes;
	

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	//展示所有的学生
	@SuppressWarnings("unchecked")
	@Action(value="listStudents",results={@Result(name="success",location="/index.jsp")})
	public String listStudents(){
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		List<Student> slist = sbiz.listStudents(stu,classes);
		request.put("slist", slist);
		return "success";
	}
	
	//删除
	@Action(value="removeStudent",results={@Result(name="success",type="redirectAction",location="listStudents")})
	public String removeStudent(){
		sbiz.removeStudent(stu);
		return "success";
	}
	
	//修改途中
	@SuppressWarnings("unchecked")
	@Action(value="toupdateStudent",results={@Result(name="success",location="/update.jsp")})
	public	String toupdateStudent(){
		Student student = sbiz.getStudentByStuId(stu);
		List<Classes> clist = sbiz.findClasses();
		Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
		request.put("student", student);
		request.put("clist", clist);
		return "success";
		
	}
	//修改
	@Action(value="updateStudent",results={@Result(name="success",type="redirectAction",location="listStudents")})
	public String updateStudent(){
		sbiz.updateStudent(stu);
		return "success";
	}
	
	//增加信息
	@Action(value="saveStudent",results={@Result(name="success",type="redirectAction",location="listStudents")})
	public String saveStudent(){
		sbiz.saveStudent(stu);
		return "success";
	}


}
