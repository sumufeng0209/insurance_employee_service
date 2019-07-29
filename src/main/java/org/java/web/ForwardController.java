package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import javax.servlet.http.HttpSession;

/**
 * @author Haowen Tian
 */
@Controller
public class ForwardController {


    /**
     * 转发到登陆页面
     * @return
     */
    @RequestMapping("forwardLogin")
    public String forwardLogin(HttpSession session){
        Map<String,Object> emp = (Map<String, Object>) session.getAttribute("emp");
        if(emp==null){
            //用户没登陆就跳转到登陆页面
            return "login";
        }else{
            //已登陆就跳转到主页面
            return "redirect:http://localhost:9000/gateway/employee/showIndex";
        }
    }

}
