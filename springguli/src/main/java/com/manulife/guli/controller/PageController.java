package com.manulife.guli.controller;

import com.manulife.guli.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {
private Logger logger= LoggerFactory.getLogger(PageController.class);
    @RequestMapping("hello")
    public  String hello(Model model){
        model.addAttribute("username","java2008");
        User user=new User(12,"马大哈",new Date());
        model.addAttribute("user",user);
        model.addAttribute("money",100000);

        List<User>  list=new ArrayList<>();
        list.add(new User(18,"杨打哈",new Date()));
        list.add(new User(28,"赵打哈",new Date()));
        model.addAttribute("list",list);
        logger.info(user.toString());
        logger.info("你好：{}，我的入职日期:{}",user.getName(),user.getEntityDate());
        return "hello";
    }
}
