package com.hunter.computerhunter.controller;

import com.hunter.computerhunter.dao.userDao;
import com.hunter.computerhunter.entity.administratorEntity;
import com.hunter.computerhunter.entity.userEntity;
import com.hunter.computerhunter.repository.administratorController;
import com.hunter.computerhunter.repository.loginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        String msg;
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
                    System.out.println("hhh");
                    userDao.save(userEntity);
                    System.out.println("kkk");
                    msg = "login";
                    System.out.println(msg);
                }else{
                    msg = "kong";
                }
            }else{
                msg = "password2wrong";
            }
        }else{
            msg = "default";
        }
        return msg;
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
            if (email.indexOf("@") == -1){
                return "notEmail";
            }
            userEntity userEntity = loginController.findByEmail(email);
            if (userEntity != null){
                if (email.equals(userEntity.getEmail())){
                    msg = "occupied";
                }
                else{
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
            if (phoneNumber.length() != 11){
                return "notPhone";
            }
            userEntity userEntity = loginController.findByPhonenumber(phoneNumber);
            if (userEntity != null){
                if (phoneNumber.equals(userEntity.getPhonenumber())){
                    msg = "occupied";
                }
                else{
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
            administratorEntity administratorEntity = administratorController.findByAccount(account);
            if (administratorEntity != null){
                if (account.equals(administratorEntity.getAccount())){
                    return "ok!";
                }
            }else{
                userEntity userEntity = loginController.findByEmailOrPhonenumber(account,account);
                if(userEntity != null){
                    if (account.equals(userEntity.getEmail()) || account.equals(userEntity.getPhonenumber())){
                        msg = "ok!";
                    }else{
                        msg = "wrong!";
                    }
                }
            }
        }
        return msg;
    }

    @RequestMapping("/regPass")
    @ResponseBody
    public String regPass(String password){
        if (password != null){
            if (password.length() < 6){
                return "noEnough";
            }else{
                return "enough";
            }
        }else{
            return "noEnough";
        }
    }
}