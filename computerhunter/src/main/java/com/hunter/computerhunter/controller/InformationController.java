package com.hunter.computerhunter.controller;

import  com.hunter.computerhunter.entity.Information;
import  com.hunter.computerhunter.repository.InformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@Controller
//@ResponseBody
public class InformationController {


    @Autowired
    private InformationRepository informationRepository;

    //查询所有信息
    /*@GetMapping(value = "/information")
    public List<Information> informationList(){
        logger.info("InformationList");
        return informationRepository.findAll();

    }*/

    @GetMapping(value = "/information3")
    public  String host3(){
        return "管理员编辑";
    }

    //添加一个信息、表单验证
    @PostMapping(value = "/addinformation")
    @ResponseBody
    public Information informationAdd(@Valid Information information, BindingResult bindingResult){
        //Information information = new Information();
//        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//        }
        information.setTitle(information.getTitle());
        information.setContent(information.getContent());
        information.setTime(information.getTime());
        information.setVisitetimes(information.getVisitetimes());
        information.setSource(information.getSource());

        return informationRepository.save(information);
    }

    //添加一个信息、表单验证
//    @PostMapping(value = "/addinformation")
//    public Information informationAdd(
//                                      @RequestParam("title") String title,
//                                      @RequestParam("content") String content,
//                                      @RequestParam("time") Date time,
//                                      @RequestParam("source") String source,
//                                      @RequestParam("visitetimes") Integer visitetime){
//        //Information information = new Information();
////        if(bindingResult.hasErrors()){
////            System.out.println(bindingResult.getFieldError().getDefaultMessage());
////            return null;
////        }
//        Information information = new Information();
//        information.setTitle(title);
//        information.setContent(content);
//        information.setTime(time);
//        information.setVisitetimes(visitetime);
//        information.setSource(source);
//
//
//        return informationRepository.save(information);
//    }





    //通过id查询一条信息
  /*\\  @GetMapping(value = "/information/{id}")
    public Information informationFindOne(@PathVariable("id") Integer id){
        return informationRepository.findById(id).orElse(null);

    }*/


//    @RequestMapping(value = "/information", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }

    @GetMapping(value = "/information1")
    public  String host1(){
        return "热点资讯";
    }
    //通过名字查询一条信息
    //@GetMapping( "/information/{title}")
    @RequestMapping("/information")
    @ResponseBody
    public Information informationFindOne(String title){
        return informationRepository.findBytitle(title);

    }/**/

    @GetMapping(value = "/information2")
    public  String host2(){
        return "详细热点";
    }

//    @RequestMapping("/information")
//    @ResponseBody
//    public Information informationFindOne(String title){
//        return informationRepository.findBytitle(title);
//
//    }/**/





    //更新
    /*@PutMapping(value = "/information/{id}")
    public Information informationUpdate(@PathVariable("id") Integer id,
                                  @RequestParam("title") String title,
                                  @RequestParam("content") String content,
                                  @RequestParam("time") Date time,
                                  @RequestParam("source") String source,
                                  @RequestParam("visitetimes") Integer visitetime){
        Information information = new Information();
        information.setTitle(title);
        information.setContent(content);
        information.setTime(time);
        information.setVisitetimes(visitetime);
        information.setSource(source);
        return informationRepository.save(information);
    }*/

    //删除
    @DeleteMapping(value = "/information/{id}")
    public void informationDelete(@PathVariable("id") Integer id){
        informationRepository.deleteById(id);
    }
}
