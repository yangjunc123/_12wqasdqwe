package cn.com.djin.ssm.service.impl;

import cn.com.djin.ssm.entity.Authority;
import cn.com.djin.ssm.entity.Roles;
import cn.com.djin.ssm.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 *   角色业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoleServiceImpl extends BaseServiceImpl<Roles> implements RoleService {

    //重写根据条件分页查询的方法
    @Override
    public Map<String, Object> findPageByPramas(Integer page, Integer limit, Roles roles) throws Exception {
        //1.调用父类的分页查询得到map分页集合数据
        Map<String, Object> dataMap =  super.findPageByPramas(page, limit, roles);
        //2.取到分页的集合数据中的角色集合list
        List<Roles> rolesList = (List<Roles>) dataMap.get("data");
        //3.通过循环查询出每一个角色拥有的一级权限数据
        for (Roles role:rolesList) {
            //3.1.根据角色id和parent的值查询出此角色拥有的一级权限
            List<Authority> authorityList = authorityMapper.selectAuthorityByRoleIdAndParent(role.getId(),0);
            //3.2.定义字符串缓冲工具类
            StringBuffer sb = new StringBuffer();
            //3.3.通过循环取出每一个权限的名称拼接组装到sb中
            for (Authority authority:authorityList) {
                sb.append(authority.getAuthorityName()+",");
            }
            //3.4.将字符串最后一位逗号去掉
            String authNames = sb.substring(0,sb.length()-1).toString();
            //3.5.将获取到的此角色的一级权限名称字符串设置进去
            role.setAuthNames(authNames);
        }
        return dataMap;
    }
}
