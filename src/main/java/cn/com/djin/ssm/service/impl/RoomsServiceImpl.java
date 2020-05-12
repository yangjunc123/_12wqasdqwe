package cn.com.djin.ssm.service.impl;

import cn.com.djin.ssm.entity.Rooms;
import cn.com.djin.ssm.service.RoomsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *   客房业务层实现类
 */
@Service
@Transactional(readOnly = false)
public class RoomsServiceImpl extends BaseServiceImpl<Rooms> implements RoomsService {
}
