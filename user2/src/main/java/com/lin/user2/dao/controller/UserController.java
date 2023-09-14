package com.lin.user2.dao.controller;

import com.lin.common.Result;
import com.lin.common.pojo.User;
import com.lin.common.utils.IpUtils;
import com.lin.user2.dao.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @Value("${server.port}")
    private int port;

    @GetMapping("/getPort")
    public String getPort() {
        String ipAddr = IpUtils.getIpAddr();
        String ipAndPort = "hello "+ipAddr + ":" + port;
        System.out.println("ip:"+ipAddr+",调用了本服务，本端口：" + port );
        return ipAndPort;
    }

    @GetMapping("/get")
    public Result get() {
        String ipAddr = IpUtils.getIpAddr();
        List<User> userList = userService.getUserList();
        System.out.println("ip:"+ipAddr+",调用了本服务，本端口：" + port + "，返回结果：" + userList);
        return new Result("userList", userList);
    }

    //获取IP地址

    @GetMapping("/get/{id}")
    public Result getId(@PathVariable String id)  {
        String ipAddr = IpUtils.getIpAddr();
        User user = userService.getUser(id);
        System.out.println("ip:"+ipAddr+",调用了本服务，本端口：" + port + "，返回结果：" + user);
        return new Result("user", user);
    }
}
