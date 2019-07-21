package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 员工数据接口
 */
@Mapper
@Component
public interface EmployeeMapper {


    /**
     * 通过员工用户名查询员工账号信息和个人信息
     * @param username
     * @return
     */
    public Map<String,Object> findEmployeeByUsername(@Param("username") String username);


    /**
     * 根据员工用户名修改最后一次登陆时间
     * @param username
     */
    public void updateEmployeeLastLoginTimeByUsername(@Param("username")String username);

}
