package cn.com.djin.ssm.mapper;

import cn.com.djin.ssm.entity.Authority;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *   权限的Mapper代理对象
 */
public interface AuthorityMapper extends BaseMapper<Authority>{

    /**
     *   根据角色id和parent查询多个权限菜单数据
     * @param roleId  角色id
     * @param parent  字段parent参数
     * @return  权限菜单集合
     * @throws Exception
     */
    List<Authority> selectAuthorityByRoleIdAndParent(@Param("roleId") Integer roleId, @Param("parent") Integer parent) throws Exception;

    /**
     *   根据角色id查询其所有的权限数据
     * @param roleId  角色id
     * @return  角色拥有的所有权限数据
     * @throws Exception
     *  这里使用的为mybatis的注解方式查询（一些简单的没有动态条件的查询，不是Base系列中的基础查询，不能在BaseMapper中写，只能在自己的Mapper中写）
     *  此种方式若返回实体封装类对象，则封装类中的属性名要与表中字段名一致
     *  此种方式在开发中用得非常少，还是以Mapper.xml的方式去写为主
     *  这种方式的sql在Mapper.xml中均可以去写
     *  当使用注解的方式查询数据返回封装类对象数据时要保证表的字段名与实体封装类的属性名一致，
     *  若不一致时，则需要给查询出来的数据列明取一个别名（此别名要与实体封装类中的属性名一致）
     */
    @Select("SELECT id,authority_name as authorityName,authority_url as authorityUrl,parent from authority where id in(SELECT auth_id from role_auth where role_id=#{roleId})")
    List<Authority> selectAuthoritiesByRoleId(Integer roleId) throws Exception;
}