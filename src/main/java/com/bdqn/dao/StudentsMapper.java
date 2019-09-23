package com.bdqn.dao;

import com.bdqn.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentsMapper {
     Student getStudent(String stuNo);
     List<Student> getStudent_List();
     int deleteStudent(String stuNo);
     int addStudent(Student student);
     int updateStudent(Student student);
}
