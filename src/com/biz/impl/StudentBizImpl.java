package com.biz.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.IStudentBiz;
import com.connection.ConnectionPoolManager;
import com.dao.IStudentDao;
import com.dao.impl.StudentDaoImpl;
import com.vo.Classes;
import com.vo.Student;

public class StudentBizImpl implements IStudentBiz {

	private IStudentDao sdao = new StudentDaoImpl();
	@Override
	public List<Student> listStudents(Student stu,Classes classes) {
		List<Student> slist = null;
		try {
			slist = sdao.listStudents(stu,classes);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}
	@Override
	public void removeStudent(Student stu) {
		try {
			ConnectionPoolManager.beginTransaction();
			 sdao.removeStudent(stu);
			 ConnectionPoolManager.commitTransaction();
		} catch (Exception e) {
			try {
				ConnectionPoolManager.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Override
	public Student getStudentByStuId(Student stu) {
		Student student = new Student();
		try {
			
			student = sdao.getStudentByStuId(stu);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return student;
	}
	
	@Override
	public List<Classes> findClasses() {
		List<Classes> clist = null;
		try {
			
			clist = sdao.findClasses();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return clist;
	}
	@Override
	public void updateStudent(Student stu) {
		try {
			ConnectionPoolManager.beginTransaction();
			 sdao.updateStudent(stu);
			 ConnectionPoolManager.commitTransaction();
		} catch (Exception e) {
			try {
				ConnectionPoolManager.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public void saveStudent(Student stu) {
		try {
			ConnectionPoolManager.beginTransaction();
			 sdao.saveStudent(stu);
			 ConnectionPoolManager.commitTransaction();
		} catch (Exception e) {
			try {
				ConnectionPoolManager.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	@Override
	public boolean existStuName(String stuName) {
		boolean bl = false;
		try {
			
			bl = sdao.existStuName(stuName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return bl;
	}
	
	
}
