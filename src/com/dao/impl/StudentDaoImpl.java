package com.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dao.IStudentDao;
import com.dbutils.TxQueryRunner;
import com.vo.Classes;
import com.vo.Student;

public class StudentDaoImpl implements IStudentDao {
	private TxQueryRunner qr = new TxQueryRunner();
	@Override
	public List<Student> listStudents(Student stu,Classes classes) {
		List<Student> slist = null;
		try {
			slist = qr.query("select s.stuName,s.stuId,c.className from student s inner join classes c on s.classId=c.classId order by stuId", new BeanListHandler<>(Student.class));
		} catch (Exception e) {//"select s.stuName,s.stuId,c.clsName from student s inner join classes c on s.clsId=c.clsId order by stuId"
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return slist;
	}
	@Override
	public void removeStudent(Student stu) {
		try {
			qr.update("delete from student where stuId=?", new Object[]{stu.getStuId()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	//通过ID查找要修改的学生信息
		@Override
		public Student getStudentByStuId(Student stu) {
			Student student = new Student();
			try {
				student = qr.query("select * from student where stuId=?", new BeanHandler<>(Student.class), new Object[]{stu.getStuId()});
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
				clist = qr.query("select * from classes ", new BeanListHandler<>(Classes.class));
			} catch (Exception e) {//"select s.stuName,s.stuId,c.clsName from student s inner join classes c on s.clsId=c.clsId order by stuId"
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
			return clist;
		}
	
	//修改学生信息
	@Override
	public void updateStudent(Student stu) {
		try {
			qr.update("update student set stuName=?,classId=? where stuId=?", new Object[]{stu.getStuName(),stu.getClassId(),stu.getStuId()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	
	@Override
	public void saveStudent(Student stu) {
		try {
			qr.update("insert into student values(?,?,?)", new Object[]{stu.getStuId(),stu.getStuName(),stu.getClassId()});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
	@Override
	public boolean existStuName(String stuName) {
		boolean bl= false;
		try {
			Number number = (Number)qr.query("select count(*) from student where stuName=?",new ScalarHandler(),new Object[]{stuName});
			if(number.intValue()>0){
				bl=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		return bl;
	}
	
	
}
