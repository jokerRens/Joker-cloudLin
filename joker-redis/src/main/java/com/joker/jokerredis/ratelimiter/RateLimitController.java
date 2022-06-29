package com.joker.jokerredis.ratelimiter;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * HelloController
 *
 * @author joker
 * @version 1.0
 * 2022/6/28 14:54
 **/

@RestController
public class RateLimitController {

    @GetMapping("/hello1")
    @RateLimiter(time = 20,count = 3,limitType = LimitType.IP)
    public String hello(){
        return "hello>>>"+new Date();
    }


    public static void main(String[] args) {
        String expressionStr = "1 + 2";
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expressionStr);
        Object value = exp.getValue();
        System.out.println(value.toString());
    }
}
