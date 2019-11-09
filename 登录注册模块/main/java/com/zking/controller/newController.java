package com.zking.controller;

import com.zking.dao.newUserDao;
import com.zking.entity.newUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/hello/*")
public class newController {
    @Autowired
    private newUserDao userDao;

    @Autowired
    private signinController signinController;
    //load页面
    @RequestMapping("/load")
    private String load(){
        return "load";
    }

    //register页面
    @RequestMapping("/register")
    private String register(){
        return "register";
    }

    //主页面
    @RequestMapping("/goHome")
    public String home(){
        return "home";
    }

    //注册实现
    @RequestMapping("/successGo")
    public String register(HttpServletRequest request){
        String username = request.getParameter("name");
        String emailbox = request.getParameter("email");
        String phonenum = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        newUserEntity userEntity = new newUserEntity();
        userEntity.setEmail(emailbox);
        userEntity.setPassword(password);
        userEntity.setPhonenumber(phonenum);
        userEntity.setUsername(username);
        userDao.save(userEntity);
        return "load";
    }

    //登录实现
    @RequestMapping("/signin")
    private String load(HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        newUserEntity userEntity =signinController.findByEmailOrPhonenumber(account,account);
        if(password.equals(userEntity.getPassword())){
            return "home";
        }
        return "register";
    }
}
