package cn.com.djin.ssm.controller;

import cn.com.djin.ssm.entity.InRoomInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *   入住信息的控制器层
 */
@Controller
@RequestMapping("/inRoomInfo")
public class InRoomInfoController extends BaseController<InRoomInfo>{
}
