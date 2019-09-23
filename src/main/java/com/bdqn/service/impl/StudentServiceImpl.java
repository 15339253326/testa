package com.bdqn.service.impl;

import com.bdqn.dao.StudentsMapper;
import com.bdqn.pojo.Student;
import com.bdqn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentsMapper studentsMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Student getStudent(String stuNo) {
        return studentsMapper.getStudent(stuNo);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Student> getStudent_List() {
        return studentsMapper.getStudent_List();
    }

    @Override
    public int deleteStudent(String stuNo) {
        return studentsMapper.deleteStudent(stuNo);
    }
    @Override
    public int addStudent(Student student) {
        return studentsMapper.addStudent(student);
    }
    @Override
    public int updateStudent(Student student) {
        return studentsMapper.updateStudent(student);
    }
}
