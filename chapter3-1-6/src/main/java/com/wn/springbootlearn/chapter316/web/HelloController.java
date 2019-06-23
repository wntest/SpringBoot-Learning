package com.wn.springbootlearn.chapter316.web;

import com.wn.springbootlearn.chapter316.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/index")
    public String index(ModelMap model) {
        // 加入一个属性，用来从模板中读取
        model.addAttribute("host", "http://www.baidu.com/");
        // return 模板文件的名称， 对应 src/main/resources/templates/index.html
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String hello() throws Exception {
        throw new Exception("返回错误");
    }

    @RequestMapping(path = "/json")
    public String json() throws MyException {
        throw new MyException("返回错误2");
    }
}
