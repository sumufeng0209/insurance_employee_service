package org.java.service.impl;

import org.java.dao.EmployeeMapper;
import org.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> map = new HashMap<>();
        //根据用户名查询对象
        Map<String, Object> emp = employeeMapper.findEmployeeByUsername(username);
        if(emp==null){
            //代表用户不存在
            map.put("msg","用户名不存在");
            map.put("status",false);
        }else{
            //判断用户是否锁定
            if(emp.get("emp_isLock").toString().equals("1")){
                map.put("msg","该账户已被锁定");
                map.put("status",false);
            }else if(emp.get("emp_password").toString().equals(password)){
                //查询该员工的所有角色
                List<Map<String, Object>> roles = employeeMapper.findRolesByEmpId(emp.get("emp_id").toString());
                emp.put("roles",roles);
                //查询该员工的所有权限
                List<String> permissions = new ArrayList<>();
                for(Map<String,Object> role : roles){
                    List<String> permissionsList = findPermissionByRoleId(role.get("role_id").toString());
                    permissions.addAll(permissionsList);
                }
                emp.put("permissions",permissions);
                map.put("msg","登陆成功");
                map.put("status",true);
                map.put("emp",emp);

                //修改最后一次登陆时间
                employeeMapper.updateEmployeeLastLoginTimeByUsername(username);
            }else{
                map.put("msg","密码错误");
                map.put("status",false);
            }
        }
        return map;
    }

    @Override
    public List<String> findPermissionByRoleId(String role_id) {
        return employeeMapper.findPermissionByRoleId(role_id);
    }
}
