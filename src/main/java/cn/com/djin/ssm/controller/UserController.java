package cn.com.djin.ssm.controller;

import cn.com.djin.ssm.entity.User;
import cn.com.djin.ssm.utils.MD5;
import cn.com.djin.ssm.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *   用户控制器层
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    //获取验证码
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response, HttpSession session){
        try {
            //1.获取到随机验证码
            String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
            //2.将生成的随机验证码（转为小写）放在session容器中保存起来
            session.setAttribute("verifyCode",verifyCode.toLowerCase());
            //3.将此随机验证码响应到页面中（将验证码输出图片到页面中）
            VerifyCodeUtils.outputImage(200,35,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //进行验证码验证
    @RequestMapping("/verifyCheck")
    public @ResponseBody String verifyCheck(String yzm,HttpSession session){
        //1.取出之前的存入到session中的验证码（已经转为小写）
        String verifyCode = (String) session.getAttribute("verifyCode");
        //2.将用户输入的验证码与生成的进行比较
        if(yzm.toLowerCase().equals(verifyCode)){  //将用户输入的转为小写与之前生成的进行比较
            return "success";  //验证码验证成功
        }else {
            return "fail";
        }
    }

    @RequestMapping("/loginUser")
    public @ResponseBody String loginUser(User loginJsonUser,HttpSession session){
        //将用户输入的密码（123456）进行MD5加密（e10adc3949ba59abbe56e057f20f883e），再到数据库进行条件查询登陆
        loginJsonUser.setPwd(MD5.md5crypt(loginJsonUser.getPwd()));
        try {
            //调用根据条件查询单个用户数据
            User loginUser = baseService.findObjectByPramas(loginJsonUser);
            if(loginUser!=null){  //登陆成功
                //登陆成功将用户数据装入到session容器中
                session.setAttribute("loginUser",loginUser);
                return "success";
            }else {  //登陆失败
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";  //异常
        }
    }

    //用户退出
    @RequestMapping("/exitUser")
    public @ResponseBody String exitUser(HttpSession session){
        try {
            //1.将session容器中的用户数据删除掉
            session.removeAttribute("loginUser");
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    //重写父类BaseController中的添加方法，
    //此方法可以不用写访问路径，直接使用父类方法的访问路径
    //也可以不用对其进行响应数据的JSON化，直接使用父类方法的配置JSON化
    //如果非要加上这些配置则必须与父类一致（闲了没事做非要加）
   // @RequestMapping("/save")
    @Override
    public /*@ResponseBody*/ String save(User user) {
        //给添加的用户数据进行加密
        user.setPwd(MD5.md5crypt(user.getPwd()));
        return super.save(user);
    }
}
