package cn.com.djin.ssm.service;

import cn.com.djin.ssm.entity.Authority;
import cn.com.djin.ssm.entity.User;

import java.util.List;
import java.util.Map;

/**
 *   权限菜单的业务层接口
 */
public interface AuthorityService extends BaseService<Authority> {

    /**
     *   用户登陆后查询其拥有的权限菜单数据
     * @param loginUser  登陆的用户数据
     * @return  权限菜单集合
     * @throws Exception
     */
    List<Map<String,Object>> findAuthorityByLogin(User loginUser) throws Exception;

    /**
     *   根据角色id查询其所有的权限数据
     * @param roleId  角色id
     * @return  角色拥有的所有权限数据
     * @throws Exception
     */
    List<Authority> findAuthoritiesByRoleId(Integer roleId) throws Exception;

}
