package com.joker.jokerswagger2.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(tags = "swagger测试Controller")
public class HelloController {

    @ApiOperation("人间失格")
    @GetMapping("/world")
    public String world(){
        return "我于昨夜死去，去时心如止水、我于今早重生，来时心怀暖阳";
    }


    @ApiOperation("太华")
    @PostMapping("/taiHua")
    public String taiHua(){
        return "既御鲲鹏而厌江离、又乘扶摇以上青云.";
    }


    @GetMapping("/yuWen")
    @ApiOperation("驭文")
    public String yuWen(){
        return "驭文之首术、谋篇之大端";
    }

}
