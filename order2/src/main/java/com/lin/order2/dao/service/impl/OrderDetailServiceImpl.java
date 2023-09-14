package com.lin.order2.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.common.pojo.OrderDetail;
import com.lin.order2.dao.mapper.OrderDetailMapper;
import com.lin.order2.dao.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linSheng
 * @since 2023-08-28
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}
