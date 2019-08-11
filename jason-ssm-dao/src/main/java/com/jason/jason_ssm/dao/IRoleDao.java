package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleid from users_role where userId=#{userid})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IPermissionDao.findPermissionsByRoleId")),
            //@Result(column = "id",property = "users",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IUsersDao.findUsersByRoleId"))

    })
    List<Role> findRolesByUserId(String userid);



    @Select("select * from role where roleid in (select roleid from ROLE_PERMISSION where PERMISSIONID=#{permissionid})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IPermissionDao.findPermissionsByRoleId")),
           // @Result(column = "id",property = "users",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IUsersDao.findUsersByRoleId"))

    })
    List<Role> findRolesByPermissionId(String permissionid);

    @Select("select * from role")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IPermissionDao.findPermissionsByRoleId")),
           // @Result(column = "id",property = "users",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IUsersDao.findUsersByRoleId"))

    })
    List<Role> findAll() throws Exception;
    @Insert("insert into role(roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id not in( select roleId from users_role where userId=#{id})")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IPermissionDao.findPermissionsByRoleId")),
            // @Result(column = "id",property = "users",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IUsersDao.findUsersByRoleId"))

    })
    List<Role> findOtherRole(String id);

     @Select("select * from role where id=#{roleid}")
     @Results({
             @Result(column = "id",property = "id"),
             @Result(column = "roleName",property = "roleName"),
             @Result(column = "roleDesc",property = "roleDesc"),
             @Result(column = "id",property = "permissions",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IPermissionDao.findPermissionsByRoleId")),
             // @Result(column = "id",property = "users",javaType = java.util.List.class,many = @Many(select = "com.jason.jason_ssm.dao.IUsersDao.findUsersByRoleId"))

     })
    Role findById(String roleid);



    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String
            permissionId);
}
