package cn.com.djin.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   页面跳转的控制器
 */
@Controller
@RequestMapping("/model")
public class ModelController {

    /*//去到管理平台首页
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/static/html/index.html";
    }*/

    //去到入住信息查询页面
    @RequestMapping("/toShowInRoomInfo")
    public String toShowInRoomInfo(){
        return "/static/html/inRoomInfo/showInRoomInfo.html";
    }

    //去到入住信息添加页面
    @RequestMapping("/toSaveInRoomInfo")
    public String toSaveInRoomInfo(){
        return "/static/html/inRoomInfo/saveInRoomInfo.html";
    }

    //去到订单显示页面
    @RequestMapping("/toShowOrders")
    public String toShowOrders(){
        return "/static/html/orders/showOrders.html";
    }

    //去到支付的页面
    @RequestMapping("/toOrdersPay")
    public String toOrdersPay(){
        return "/WEB-INF/jsp/alipay/ordersPay.jsp";
    }

    //支付回调失败去到异常页面
    @RequestMapping("/toErrorPay")
    public String toErrorPay(){
        return "/static/html/error/errorPay.html";
    }

    //去到消费记录页面
    @RequestMapping("/toShowRoomSale")
    public String toShowRoomSale(){
        return "/static/html/roomSale/showRoomSale.html";
    }

    //去到会员查询页面
    @RequestMapping("/toShowVip")
    public String toShowVip(){
        return "/static/html/vip/showVip.html";
    }

    //去到会员添加页面
    @RequestMapping("/toSaveVip")
    public String toSaveVip(){
        return "/static/html/vip/saveVip.html";
    }

    //去到客房显示页面
    @RequestMapping("/toShowRooms")
    public String toShowRooms(){
        return "/static/html/rooms/showRooms.html";
    }

    //去到房型显示页面
    @RequestMapping("/toShowRoomType")
    public String toShowRoomType(){
        return "/static/html/roomType/showRoomType.html";
    }

    //去到登陆页面
    /*@RequestMapping("/loginUI")
    public String loginUI(){
        return "/static/html/login/login.html";
    }*/

    //去到角色信息查询页面
    @RequestMapping("/toShowRole")
    public String toShowRole(){
        return "/static/html/role/showRole.html";
    }

    //去到系统用户显示页面
    @RequestMapping("/toShowUser")
    public String toShowUser(){
        return "/static/html/user/showUser.html";
    }

    //去到添加系统用户页面
    @RequestMapping("/toSaveUser")
    public String toSaveUser(){
        return "/static/html/user/saveUser.html";
    }

    //去到添加系统用户页面
    @RequestMapping("/toShowdbi")
    public String toShowdbi(){
        return "/static/html/dbi/showdbi.html";
    }
}
