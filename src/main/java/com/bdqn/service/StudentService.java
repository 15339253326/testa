package com.bdqn.service;

import com.bdqn.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    Student getStudent(String stuNo);
    List<Student> getStudent_List();
    int deleteStudent(String stuNo);
    int addStudent(Student student);
    int updateStudent(Student student);
}
