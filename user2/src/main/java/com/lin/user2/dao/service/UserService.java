package com.lin.user2.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.common.pojo.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linSheng
 * @since 2023-08-27
 */
public interface UserService extends IService<User> {

    //获取list
    List<User>  getUserList();

    //获取单个
    User getUser(String id);
}
