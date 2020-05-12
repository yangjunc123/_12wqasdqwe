package cn.com.djin.ssm.service.impl;

import cn.com.djin.ssm.entity.Authority;
import cn.com.djin.ssm.entity.User;
import cn.com.djin.ssm.service.AuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   权限菜单业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class AuthorityServiceImpl extends BaseServiceImpl<Authority> implements AuthorityService {

    /**
     *   用户登陆后查询其拥有的权限菜单数据
     * @param loginUser  登陆的用户数据
     * @return  权限菜单集合
     * @throws Exception
     */
    @Override
    public List<Map<String, Object>> findAuthorityByLogin(User loginUser) throws Exception {
        //1.新建整个权限菜单的list集合
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        //2.根据用户中的角色id查询此用户拥有的一级菜单权限
        List<Authority> firstAuths = authorityMapper.selectAuthorityByRoleIdAndParent(loginUser.getRoleId(), 0);
        //3.通过循环分别组装每一个一级权限中的Map集合数据
        for (Authority firstAuth:firstAuths) {
            //3.1.新建一级权限中的Map集合
            Map<String,Object> firstMap = new HashMap<String, Object>();
            //3.2.首先装入一级权限的id和名称
            firstMap.put("firstAuthId",firstAuth.getId());
            firstMap.put("firstAuthName",firstAuth.getAuthorityName());
            //3.3.根据用户中的角色id和一级权限id作为二级权限parent的值查询其用户拥有的二级权限
            List<Authority> secondAuths = authorityMapper.selectAuthorityByRoleIdAndParent(loginUser.getRoleId(),firstAuth.getId());
            //3.4.将查询出的二级权限加入到一级权限中的Map集合
            firstMap.put("secondAuths",secondAuths);
            //3.5.将得到的一级权限中的Map集合装入到整个权限菜单的list集合中
            dataList.add(firstMap);
        }
        return dataList;
    }

    /**
     *   根据角色id查询其所有的权限数据
     * @param roleId  角色id
     * @return  角色拥有的所有权限数据
     * @throws Exception
     */
    @Override
    public List<Authority> findAuthoritiesByRoleId(Integer roleId) throws Exception {
        return authorityMapper.selectAuthoritiesByRoleId(roleId);
    }
}
