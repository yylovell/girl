package com.yy.controller;

import com.yy.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;// 获取配置


    @GetMapping(value = "/hi")
    public String say(@RequestParam(value = "id", required = false,defaultValue = "120") Integer id) {
        //return girlProperties.getCupSize();
        return "id" + id;
    }
}
