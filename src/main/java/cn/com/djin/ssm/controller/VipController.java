package cn.com.djin.ssm.controller;

import cn.com.djin.ssm.entity.Vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   会员控制器层
 */
@Controller
@RequestMapping("/vip")
public class VipController extends BaseController<Vip> {
}
