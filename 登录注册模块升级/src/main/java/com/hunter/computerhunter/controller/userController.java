package com.hunter.computerhunter.controller;


import com.hunter.computerhunter.dao.userDao;
import com.hunter.computerhunter.entity.administratorEntity;
import com.hunter.computerhunter.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hello")
public class userController {
    @Autowired
    private userDao userDao;

    @Autowired
    private loginController loginController;

    @Autowired
    private administratorController administratorController;
    //register页面
    @RequestMapping(value = {"/register.html","/register"})
    public String register(){
        return "register";
    }

    //load页面
    @RequestMapping(value = {"/load.html","/load"})
    public String load(){
        return "load";
    }

    //主页页面
    @RequestMapping(value = {"/home","/home.html"})
    public String home(){
        return "home";
    }

    //管理员主页
    @RequestMapping(value = {"/administratorHome","/administratorHome.html"})
    public String administratorHome(){
        return "administratorHome";
    }

    //注册实现
    @RequestMapping("/successGo")
    @ResponseBody
    public String register(String name,String email,String phoneNumber,String password,String password2){
        userEntity userEntity1 = loginController.findByEmailOrPhonenumber(email,phoneNumber);
        if(userEntity1 == null){
            if (password.equals(password2)){
                if(name!=""&&email!=""&&phoneNumber!=""&&password!=""){
                    System.out.println("name:" + name + ",email:" + email + ",phoneNumber:" + phoneNumber + ",password:" + password + ",password2:" + password2);
                    userEntity userEntity = new userEntity();
                    userEntity.setEmail(email);
                    userEntity.setPassword(password);
                    userEntity.setPhonenumber(phoneNumber);
                    userEntity.setUsername(name);
                    userDao.save(userEntity);
                    return "load";
                }else{
                    return "kong";
                }
            }else{
                return "password2wrong";
            }
        }else{
            return "default";
        }

    }

    //登录实现
    @RequestMapping("/goHome")
    @ResponseBody
    public String load(String account,String password){
        administratorEntity administratorEntity = administratorController.findByAccount(account);
        if (administratorEntity != null){
            if (password.equals(administratorEntity.getAdpassword())){
                System.out.println("password = " + administratorEntity.getAdpassword());
                return "administratorHome";
            }
        }else{
            userEntity userEntity = loginController.findByEmailOrPhonenumber(account,account);
            if (userEntity != null){
                if (password.equals(userEntity.getPassword())){
                    return "home";
                }else{
                    return "wrong";
                }
            }else{
                return "wrong";
            }
        }
        return "register";
    }

    @RequestMapping("/regEmail")
    @ResponseBody
    public String reg(String email){
        String msg = "";
        if (email != ""){
            userEntity userEntity = loginController.findByEmail(email);
            if (userEntity != null){
                if (email.equals(userEntity.getEmail())){
                    msg = "occupied";
                }else{
                    msg = "ok";
                }
            }
        }else {
            msg = "kong";
        }
        return msg;
    }

    @RequestMapping("/regPhone")
    @ResponseBody
    public String reg2(String phoneNumber){
        String msg = "";
        if (phoneNumber != ""){
            userEntity userEntity = loginController.findByEmail(phoneNumber);
            if (userEntity != null){
                if (phoneNumber.equals(userEntity.getPhonenumber())){
                    msg = "occupied";
                }else{
                    msg = "ok";
                }
            }
        }else {
            msg = "kong";
        }
        return msg;
    }

    @RequestMapping("/a")
    @ResponseBody
    public String ajax3(String account) {
        String msg = "wrong!";
        if (account != null){
            userEntity userEntity = loginController.findByEmailOrPhonenumber(account,account);
            if(userEntity != null){
                if (account.equals(userEntity.getEmail()) || account.equals(userEntity.getPhonenumber())){
                    msg = "ok!";
                }else{
                    msg = "wrong!";
                }
            }
        }
        return msg;
    }

}
