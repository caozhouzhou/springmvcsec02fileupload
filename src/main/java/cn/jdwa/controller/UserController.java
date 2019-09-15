package cn.jdwa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by czz on 2019/9/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testFileUpload01")
    public String testFileUpload01(){
        System.out.println("testFileUpload01 ... ... ...");
        return "success";
    }
}
