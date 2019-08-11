package com.jason.jason_ssm.dao;

import com.jason.jason_ssm.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IPermissionDao {

   @Select("select * from permission where  id in (select permissionid from role_permission where roleid =#{roleid})")
   @Results(
           {@Result(column = "id",property = "id"),
                   @Result(column = "permissionName",property = "permissionName"),
                   @Result(column = "url",property = "url"),
                  // @Result(column = "id",property = "roles",javaType = java.util.List.class,many=@Many(select = "com.jason.jason_ssm.dao.IRolesDao.findRolesByPermissionId")),
}
   )
   List<Permission> findPermissionsByRoleId(    String roleid);
    @Select("select * from PERMISSION")
    @Results(
            {@Result(column = "id",property = "id"),
                    @Result(column = "permissionName",property = "permissionName"),
                    @Result(column = "url",property = "url"),
                   // @Result(column = "id",property = "roles",javaType = java.util.List.class,many=@Many(select = "com.jason.jason_ssm.dao.IRolesDao.findRolesByPermissionId")),
            }
    )
    List<Permission> findAll();
    @Insert("insert into permission(permissionName,url) values (#{permissionName},#{url})")
    void save(Permission p);
    @Select("select * from permission where id not in (select permissionId from role_permission    where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleid);
}
