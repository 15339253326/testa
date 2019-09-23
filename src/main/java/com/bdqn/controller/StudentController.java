package com.bdqn.controller;

import com.bdqn.pojo.Student;
import com.bdqn.service.StudentService;
import com.bdqn.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisTemplate redisTemplate;

    //测试Git 提交数据
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /*@RequestParam("stuNo") String stuNo*/
    @RequestMapping(value = "getStudent", method = RequestMethod.POST)
    public String getStudent() {
        Map<String,Object> m = new HashMap<>();
        m.put("userID","S100101");
        String tokKey = TokenManager.createJavaWebToken(m);
        System.out.println(tokKey);
        redisTemplate.opsForValue().set("S100101", tokKey);
//        studentService.getStudent_List();
        Map<String,Object> getM = TokenManager.parserJavaWebToken(tokKey);
        System.out.println(getM.get("userID"));
        return "index";
    }


}
