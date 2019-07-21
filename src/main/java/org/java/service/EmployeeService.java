package org.java.service;
import java.util.*;

/**
 * 员工业务层接口
 * @author Haowen Tian
 */
public interface EmployeeService {


    /**
     * 员工登陆
     * @param username
     * @param password
     * @return
     */
    public Map<String,Object> login(String username,String password);

}
