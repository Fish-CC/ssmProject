package com.ssm.apps.controller;

import com.ssm.apps.domain.UserInfo;
import com.ssm.apps.service.UserService;
import com.ssm.apps.vo.RequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sys")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public RequestVo addUser(@RequestBody UserInfo userInfo){
        userService.save(userInfo);
        return RequestVo.ok();
    }

    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    @ResponseBody
    public RequestVo findUser(){
        List<UserInfo> list = userService.findUser();
        return RequestVo.ok(list);
    }

    @RequestMapping(value = "/findUserById/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public RequestVo findUserById(@PathVariable("userId") String userId){
        UserInfo userInfo = userService.selectUserById(userId);
        return RequestVo.ok(userInfo);
    }
}
