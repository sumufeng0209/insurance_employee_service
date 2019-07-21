package org.java.web;

import org.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    /**
     * 登陆
     * @param session
     * @param username
     * @param password
     * @return
     */
    @PostMapping("login")
    public String login(HttpSession session,String username,String password){
        Map<String, Object> result = employeeService.login(username, password);
        Boolean status = (Boolean) result.get("status");
        if(status){
            //登陆成功
            //跳转到主页面
            session.setAttribute("emp",result.get("emp"));
            return "redirect:http://localhost:9000/gateway/employee/showIndex";
        }else{
            //登陆失败，跳转到登陆页面
            return "login";
        }
    }


    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping("showIndex")
    public String showIndex(){
        return "index";
    }


    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:http://localhost:9000/gateway/employee/forwardLogin";
    }

}
