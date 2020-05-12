package cn.com.djin.ssm.controller;

import cn.com.djin.ssm.entity.Authority;
import cn.com.djin.ssm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 *   权限菜单控制器层
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController<Authority>{

    //登陆后去到平台首页，同时带着权限菜单数据
    @RequestMapping("/toIndex")
    public String toIndex(HttpSession session, Model model){
        try {
            //1.从session容器中取到登陆的用户数据
            User loginUser = (User) session.getAttribute("loginUser");
            //2.根据角色id查询此用户拥有的权限菜单数据
            List<Map<String, Object>> dataList = authorityService.findAuthorityByLogin(loginUser);
            //3.将查询出来的数据放在容器中，在jsp页面中显示出来
            model.addAttribute("dataList",dataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/jsp/index.jsp";  //转发到平台首页
    }

    /**
     *   根据角色id查询其所有的权限数据
     * @param roleId  角色id
     * @return  角色拥有的所有权限数据
     * @throws Exception
     */
    @RequestMapping("/loadAuthoritiesByRoleId")
    public @ResponseBody List<Authority> loadAuthoritiesByRoleId(Integer roleId){
        try {
            return authorityService.findAuthoritiesByRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
