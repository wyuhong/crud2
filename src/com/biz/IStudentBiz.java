package com.biz;

import java.util.List;

import com.vo.Classes;
import com.vo.Student;

public interface IStudentBiz {

	List<Student> listStudents(Student stu,Classes classes);

	void removeStudent(Student stu);
	
		Student getStudentByStuId(Student stu);

		List<Classes> findClasses();

	void updateStudent(Student stu);

	

	void saveStudent(Student stu);

	boolean existStuName(String stuName);

}
