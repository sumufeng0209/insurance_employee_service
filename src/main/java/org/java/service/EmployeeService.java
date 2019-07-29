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


    /**
     * 通过角色编号查询角色权限代码
     * @param role_id
     * @return
     */
    public List<String> findPermissionByRoleId(String role_id);

}
